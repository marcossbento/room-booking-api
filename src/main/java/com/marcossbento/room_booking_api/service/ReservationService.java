package com.marcossbento.room_booking_api.service;

import com.marcossbento.room_booking_api.dto.ReservationDTO;
import com.marcossbento.room_booking_api.exception.ReservationConflictException;
import com.marcossbento.room_booking_api.exception.ResourceNotFoundException;
import com.marcossbento.room_booking_api.mapper.ReservationMapper;
import com.marcossbento.room_booking_api.model.Reservation;
import com.marcossbento.room_booking_api.model.Room;
import com.marcossbento.room_booking_api.repository.ReservationRepository;
import com.marcossbento.room_booking_api.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.reservationMapper = reservationMapper;
    }

    public Reservation createReservation(ReservationDTO reservationDTO) {
        Room room = roomRepository.findById(reservationDTO.roomId())
                .orElseThrow(() -> new ResourceNotFoundException("Quarto não encontrado com o id: " +reservationDTO.roomId()));
        List<Reservation> conflicts = reservationRepository.findByRoomAndEndAfterAndStartBefore(room,reservationDTO.start(), reservationDTO.end());

        if (!conflicts.isEmpty()) {
            throw new ReservationConflictException("Já existe uma reserva com horários conflitantes à essa") ;
        }

        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        reservation.setRoom(room);

        return reservationRepository.save(reservation);
    }
}

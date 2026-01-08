package com.marcossbento.room_booking_api.controller;

import com.marcossbento.room_booking_api.dto.ReservationDTO;
import com.marcossbento.room_booking_api.mapper.ReservationMapper;
import com.marcossbento.room_booking_api.model.Reservation;
import com.marcossbento.room_booking_api.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    public ReservationController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @PostMapping()
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation savedReservation = reservationService.createReservation(reservationDTO);

        ReservationDTO savedReservationDTO = reservationMapper.toDTO(savedReservation);

        return new ResponseEntity<>(savedReservationDTO,HttpStatus.CREATED);
    }
}

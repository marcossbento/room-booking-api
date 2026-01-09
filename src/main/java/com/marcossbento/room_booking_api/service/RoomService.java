package com.marcossbento.room_booking_api.service;

import com.marcossbento.room_booking_api.dto.RoomDTO;
import com.marcossbento.room_booking_api.mapper.RoomMapper;
import com.marcossbento.room_booking_api.model.Room;
import com.marcossbento.room_booking_api.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public Room createRoom(RoomDTO roomDTO) {
        Room room = roomMapper.toEntity(roomDTO);

        return roomRepository.save(room);
    }
}

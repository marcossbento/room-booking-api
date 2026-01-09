package com.marcossbento.room_booking_api.controller;

import com.marcossbento.room_booking_api.dto.RoomDTO;
import com.marcossbento.room_booking_api.mapper.RoomMapper;
import com.marcossbento.room_booking_api.model.Room;
import com.marcossbento.room_booking_api.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;
    private final RoomMapper roomMapper;

    public RoomController(RoomService roomService, RoomMapper roomMapper) {
        this.roomService = roomService;
        this.roomMapper = roomMapper;
    }

    @PostMapping
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO) {
        Room savedRoom = roomService.createRoom(roomDTO);

        RoomDTO savedRoomDTO = roomMapper.toDTO(savedRoom);

        return new ResponseEntity<>(savedRoomDTO, HttpStatus.CREATED);
    }
}

package com.marcossbento.room_booking_api.mapper;

import com.marcossbento.room_booking_api.dto.RoomDTO;
import com.marcossbento.room_booking_api.model.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    public RoomDTO toDTO(Room room);

    public Room toEntity(RoomDTO roomDTO);
}

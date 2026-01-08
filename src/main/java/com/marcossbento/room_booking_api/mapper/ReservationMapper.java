package com.marcossbento.room_booking_api.mapper;

import com.marcossbento.room_booking_api.dto.ReservationDTO;
import com.marcossbento.room_booking_api.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    @Mapping(source = "room.id", target = "roomId")
    ReservationDTO toDTO(Reservation reservation);

    @Mapping(target = "room", ignore = true)
    Reservation toEntity(ReservationDTO reservationDTO);
}

package com.marcossbento.room_booking_api.repository;

import com.marcossbento.room_booking_api.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

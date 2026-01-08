package com.marcossbento.room_booking_api.repository;

import com.marcossbento.room_booking_api.model.Reservation;
import com.marcossbento.room_booking_api.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByRoomAndEndAfterAndStartBefore(Room room, LocalDateTime start, LocalDateTime end);
}

package com.marcossbento.room_booking_api.dto;

import java.time.LocalDateTime;

public record ReservationDTO(LocalDateTime start, LocalDateTime end, Long roomId) {
}

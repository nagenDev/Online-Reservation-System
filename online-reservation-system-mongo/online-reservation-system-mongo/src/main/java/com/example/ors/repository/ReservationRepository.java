package com.example.ors.repository;

import com.example.ors.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
    Optional<Reservation> findByPnrNumber(String pnrNumber);
}

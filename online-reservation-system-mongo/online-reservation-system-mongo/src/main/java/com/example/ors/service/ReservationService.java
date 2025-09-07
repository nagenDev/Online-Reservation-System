package com.example.ors.service;

import com.example.ors.dto.ReservationRequest;
import com.example.ors.exception.ApiException;
import com.example.ors.model.Reservation;
import com.example.ors.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HexFormat;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final SecureRandom random = new SecureRandom();

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(ReservationRequest req, String userId) {
        Reservation r = new Reservation();
        r.setPassengerName(req.getPassengerName());
        r.setTrainNumber(req.getTrainNumber());
        r.setTrainName(req.getTrainName());
        r.setClassType(req.getClassType());
        r.setDateOfJourney(req.getDateOfJourney());
        r.setFromStation(req.getFromStation());
        r.setToStation(req.getToStation());
        r.setUserId(userId);
        r.setPnrNumber(generatePnr());
        return reservationRepository.save(r);
    }

    public Reservation getByPnr(String pnr) {
        return reservationRepository.findByPnrNumber(pnr)
                .orElseThrow(() -> new ApiException("Reservation not found"));
    }

    public List<Reservation> listAll() {
        return reservationRepository.findAll();
    }

    public Reservation cancelByPnr(String pnr, boolean ok) {
        Reservation r = getByPnr(pnr);
        if (!ok) {
            // Return existing reservation info without cancel
            return r;
        }
        r.setStatus(Reservation.Status.CANCELLED);
        return reservationRepository.save(r);
    }

    private String generatePnr() {
        byte[] bytes = new byte[6];
        random.nextBytes(bytes);
        return HexFormat.of().formatHex(bytes).toUpperCase();
    }
}

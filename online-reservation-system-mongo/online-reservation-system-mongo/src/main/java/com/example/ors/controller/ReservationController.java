//package com.example.ors.controller;
//
//import com.example.ors.dto.CancelResponse;
//import com.example.ors.dto.ReservationRequest;
//import com.example.ors.model.Reservation;
//import com.example.ors.service.ReservationService;
//import jakarta.validation.Valid;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/reservations")
//public class ReservationController {
//
//    private final ReservationService reservationService;
//
//    public ReservationController(ReservationService reservationService) {
//        this.reservationService = reservationService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Reservation> create(@Valid @RequestBody ReservationRequest req,
//                                              @AuthenticationPrincipal User principal) {
//        String userId = principal != null ? principal.getUsername() : "anonymous";
//        return ResponseEntity.ok(reservationService.createReservation(req, userId));
//    }
//
//    @GetMapping("/{pnr}")
//    public ResponseEntity<Reservation> getByPnr(@PathVariable String pnr) {
//        return ResponseEntity.ok(reservationService.getByPnr(pnr));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Reservation>> list() {
//        return ResponseEntity.ok(reservationService.listAll());
//    }
//
//    @DeleteMapping("/{pnr}")
//    public ResponseEntity<CancelResponse> cancel(@PathVariable String pnr,
//                                                 @RequestParam(defaultValue = "false") boolean ok) {
//        Reservation beforeOrAfter = reservationService.cancelByPnr(pnr, ok);
//        boolean canceled = ok && beforeOrAfter.getStatus() == Reservation.Status.CANCELLED;
//        return ResponseEntity.ok(new CancelResponse(canceled, beforeOrAfter));
//    }
//}


package com.example.ors.controller;

import com.example.ors.dto.CancelResponse;
import com.example.ors.dto.ReservationRequest;
import com.example.ors.model.Reservation;
import com.example.ors.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> create(@Valid @RequestBody ReservationRequest req,
                                              @AuthenticationPrincipal User principal) {
        String userId = principal != null ? principal.getUsername() : "anonymous";
        return ResponseEntity.ok(reservationService.createReservation(req, userId));
    }

    @GetMapping("/{pnr}")
    public ResponseEntity<Reservation> getByPnr(@PathVariable("pnr") String pnr) {
        return ResponseEntity.ok(reservationService.getByPnr(pnr));
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> list() {
        return ResponseEntity.ok(reservationService.listAll());
    }

    @DeleteMapping("/{pnr}")
    public ResponseEntity<CancelResponse> cancel(@PathVariable("pnr") String pnr,
                                                 @RequestParam(name = "ok", defaultValue = "false") boolean ok) {
        Reservation beforeOrAfter = reservationService.cancelByPnr(pnr, ok);
        boolean canceled = ok && beforeOrAfter.getStatus() == Reservation.Status.CANCELLED;
        return ResponseEntity.ok(new CancelResponse(canceled, beforeOrAfter));
    }
}

package com.example.ors.dto;

import com.example.ors.model.Reservation;

public class CancelResponse {
    private boolean canceled;
    private Reservation reservation;

    public CancelResponse(boolean canceled, Reservation reservation) {
        this.canceled = canceled;
        this.reservation = reservation;
    }

    public boolean isCanceled() { return canceled; }
    public void setCanceled(boolean canceled) { this.canceled = canceled; }
    public Reservation getReservation() { return reservation; }
    public void setReservation(Reservation reservation) { this.reservation = reservation; }
}

package com.example.ors.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Document(collection = "reservations")
public class Reservation {

    @Id
    private String id;

    @NotBlank
    private String pnrNumber;

    @NotBlank
    private String passengerName;

    @NotBlank
    private String trainNumber;

    @NotBlank
    private String trainName;

    @NotBlank
    private String classType;

    @Future
    private LocalDate dateOfJourney;

    @NotBlank
    private String fromStation;

    @NotBlank
    private String toStation;

    private String userId;

    private Status status = Status.ACTIVE;

    public enum Status { ACTIVE, CANCELLED }

    public Reservation() {}

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPnrNumber() { return pnrNumber; }
    public void setPnrNumber(String pnrNumber) { this.pnrNumber = pnrNumber; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public String getTrainNumber() { return trainNumber; }
    public void setTrainNumber(String trainNumber) { this.trainNumber = trainNumber; }

    public String getTrainName() { return trainName; }
    public void setTrainName(String trainName) { this.trainName = trainName; }

    public String getClassType() { return classType; }
    public void setClassType(String classType) { this.classType = classType; }

    public LocalDate getDateOfJourney() { return dateOfJourney; }
    public void setDateOfJourney(LocalDate dateOfJourney) { this.dateOfJourney = dateOfJourney; }

    public String getFromStation() { return fromStation; }
    public void setFromStation(String fromStation) { this.fromStation = fromStation; }

    public String getToStation() { return toStation; }
    public void setToStation(String toStation) { this.toStation = toStation; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}

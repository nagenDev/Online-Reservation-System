package com.example.ors.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class ReservationRequest {
    @NotBlank private String passengerName;
    @NotBlank private String trainNumber;
    @NotBlank private String trainName;
    @NotBlank private String classType;
    @Future private LocalDate dateOfJourney;
    @NotBlank private String fromStation;
    @NotBlank private String toStation;

    public String getPassengerName(){return passengerName;}
    public void setPassengerName(String v){this.passengerName=v;}
    public String getTrainNumber(){return trainNumber;}
    public void setTrainNumber(String v){this.trainNumber=v;}
    public String getTrainName(){return trainName;}
    public void setTrainName(String v){this.trainName=v;}
    public String getClassType(){return classType;}
    public void setClassType(String v){this.classType=v;}
    public LocalDate getDateOfJourney(){return dateOfJourney;}
    public void setDateOfJourney(LocalDate v){this.dateOfJourney=v;}
    public String getFromStation(){return fromStation;}
    public void setFromStation(String v){this.fromStation=v;}
    public String getToStation(){return toStation;}
    public void setToStation(String v){this.toStation=v;}
}

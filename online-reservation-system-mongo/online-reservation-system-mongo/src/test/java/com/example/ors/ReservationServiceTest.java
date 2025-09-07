package com.example.ors;

import com.example.ors.dto.ReservationRequest;
import com.example.ors.model.Reservation;
import com.example.ors.repository.ReservationRepository;
import com.example.ors.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationServiceTest {

    @Test
    void createReservation_generatesPNR() {
        ReservationRepository repo = Mockito.mock(ReservationRepository.class);
        Mockito.when(repo.save(Mockito.any())).thenAnswer(inv -> inv.getArgument(0));
        ReservationService service = new ReservationService(repo);

        ReservationRequest req = new ReservationRequest();
        req.setPassengerName("Alex");
        req.setTrainNumber("12345");
        req.setTrainName("Express");
        req.setClassType("Sleeper");
        req.setDateOfJourney(LocalDate.now().plusDays(2));
        req.setFromStation("NYC");
        req.setToStation("BOS");

        Reservation r = service.createReservation(req, "alex");
        assertNotNull(r.getPnrNumber());
        assertEquals(12, r.getPnrNumber().length());
    }
}

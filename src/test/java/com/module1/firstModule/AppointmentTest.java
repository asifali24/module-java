package com.module1.firstModule;


import com.module1.firstModule.entities.Appointment;
import com.module1.firstModule.entities.Dr;
import com.module1.firstModule.entities.PatientEntity;
import com.module1.firstModule.services.AppointmentServ;
import com.module1.firstModule.services.DrServ;
import com.module1.firstModule.services.PatientServ;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {
    @Autowired
    AppointmentServ appointmentServ;

    @Autowired
    PatientServ patientServ;

    @Autowired
    DrServ drServ;



    @Test
    void createAppointment(){

        String drName = "TestDr-app";
        String email = "email@email.com";

        Dr newDr = drServ.createDr(drName,email);


        String name = "Test-app";
        int age = 22;
        String reason ="for treatment ";

        PatientEntity creaPat = patientServ.createPatient(name,age,reason);

        Appointment newApp = appointmentServ.createAppoint(LocalDateTime.of(2026,10,22,0,0,0) ,reason, newDr.getId(), creaPat.getId());

        System.out.println(newApp);

        drServ.DeleteDr(newDr.getId());


    }
}

package com.module1.firstModule;


import com.module1.firstModule.entities.PatientEntity;
import com.module1.firstModule.services.PatientServ;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Patient {

    @Autowired
    PatientServ patientServ;

    @Test
    public void createPatientTest(){
        String name = "Test";
        int age = 22;
        String reason ="for treatment ";

        PatientEntity creaPat = patientServ.createPatient(name,age,reason);

        System.out.println(creaPat);


        for(int i=0 ; i< 51; i++){
            patientServ.createPatient(
                    name+String.valueOf(i),
                    age+i,
                    reason+String.valueOf(i)
            );
        }
//        return creaPat;
    }


}

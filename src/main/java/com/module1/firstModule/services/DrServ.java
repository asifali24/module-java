package com.module1.firstModule.services;


import com.module1.firstModule.entities.Dr;
import com.module1.firstModule.repository.DrRepository;
import org.springframework.stereotype.Service;

@Service
public class DrServ {
    private final DrRepository drRepository;

    public DrServ(DrRepository drRepository) {
        this.drRepository = drRepository;
    }

    public Dr createDr(String name, String email){
        Dr newDr = Dr.builder()
                .name(name)
                .email(email)
                .build();

        return  drRepository.save(newDr);
    }


    public void DeleteDr(Long id){
        drRepository.findById(id).orElseThrow();
        drRepository.deleteById(id);
    }
}

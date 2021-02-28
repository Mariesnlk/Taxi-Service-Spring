package com.mariia.syne.taxi_service.service;

import com.mariia.syne.taxi_service.model.Auto;
import com.mariia.syne.taxi_service.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoService {

    public static final String STATUS_ACTIVE = "ACTIVE";

    @Autowired
    private AutoRepository autoRepository;


    public List<Auto> getAllAutos() {

        List<Auto> autos = new ArrayList<>();
        autoRepository.findAll().forEach(autos::add);
        return autos;
    }

    public Auto getAuto(Integer id) {
        return autoRepository.findById(id).orElse(null);
    }

    public void addAuto(Auto auto) {

        autoRepository.save(auto);
    }

    public void updateAuto(Auto auto, Integer id) {

        autoRepository.save(auto);
    }

    public void deleteAuto(Integer id) {
        autoRepository.deleteById(id);
    }

    public List<Auto> getActiveAutos() {
        List<Auto> autos = getAllAutos();
        List<Auto> activeAutos = new ArrayList<>();
        for (Auto auto : autos) {
            if (STATUS_ACTIVE.equals(auto.getStatus())) {
                activeAutos.add(auto);
            }
        }
        return activeAutos;
    }
}


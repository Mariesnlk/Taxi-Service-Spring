package com.mariia.syne.taxi_service.controller.rest;

import com.mariia.syne.taxi_service.model.Auto;
import com.mariia.syne.taxi_service.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("autos")
public class AutoRestController {

    /*
    GET     /autos
    GET     /autos/1
    POST    /autos
    PUT     /autos/1
    DELETE  /autos/1
    */

    @Autowired
    private AutoService autoService;

    @GetMapping
    public List<Auto> getAllAutos() {

        return autoService.getAllAutos();
    }

    @GetMapping("/active")
    public List<Auto> getActiveAutos() {

        return autoService.getActiveAutos();
    }

    @GetMapping("/{id}")
    public Auto getAuto(@PathVariable Integer id) {

        return autoService.getAuto(id);
    }

    @PostMapping
    public void addAuto(@RequestBody Auto auto) {

        autoService.addAuto(auto);
    }

    @PutMapping("/{id}")
    public void updateAuto(@RequestBody Auto auto, @PathVariable Integer id) {

        autoService.updateAuto(auto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAuto(@PathVariable Integer id) {

        autoService.deleteAuto(id);
    }

//    @GetMapping("/init")
//    public void generateOrders() {
//
//        orderService.initTable();
//    }
}


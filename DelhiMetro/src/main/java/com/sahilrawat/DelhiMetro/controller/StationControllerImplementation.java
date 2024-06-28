package com.sahilrawat.DelhiMetro.controller;

import com.sahilrawat.DelhiMetro.model.Station;
import com.sahilrawat.DelhiMetro.service.GetAllStations;
import com.sahilrawat.DelhiMetro.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin({"*"})
public class StationControllerImplementation implements StationController {

    @Autowired
    StationService stationService;
    @Override
    @PostMapping("/add")
    public Station addStation(Station station) {
        return stationService.addStation(station);
    }

    @Override
    @GetMapping("/allStations")
    public ArrayList<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @Override
    @GetMapping("/shortestRoute")
    public ArrayList<Station> findShortestRoute(@RequestParam int src, @RequestParam int dest) {
        return stationService.findShortestRoute(src, dest);
    }

    @Override
    @GetMapping("/station")
    public Station getStationById(@PathVariable int id) {
        return stationService.getStationById(id);
    }

    @Override
    @GetMapping("/stationId")
    public int getStationIdByName(String name) {
        return stationService.getStationIdByName(name);
    }

//    @GetMapping("/load")
//    public void load() {
//        stationService.saveAll(GetAllStations.getStations());
//    }

//    @GetMapping("/print")
//    public void printd() {
//        new GetAllStations().doit();
//    }
}

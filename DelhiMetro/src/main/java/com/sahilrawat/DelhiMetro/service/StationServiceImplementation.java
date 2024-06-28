package com.sahilrawat.DelhiMetro.service;

import com.sahilrawat.DelhiMetro.model.Station;
import com.sahilrawat.DelhiMetro.repository.StationRepo;
import org.apache.logging.log4j.util.PropertySource;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;

import static org.apache.coyote.http11.Constants.a;

@Service
public class StationServiceImplementation implements StationService{

    @Autowired
    StationRepo stationRepo;
    public ArrayList<Station> all = null;

    @Override
    public void saveAll(ArrayList<Station> arrayList) {
        stationRepo.saveAll(arrayList);
    }
    @Override
    public Station addStation(Station station) {
        return stationRepo.save(station);
    }

    @Override
    public ArrayList<Station> getAllStations() {
        if (all != null)    return all;
        all = (ArrayList<Station>) stationRepo.findAll();
        HashSet<String> set = new HashSet<>();
        ArrayList<Station> newAll = new ArrayList<>();
        for (Station station : all) {
            if (!set.contains(station.getName())) {
                set.add(station.getName());
                newAll.add(station);
            }
        }
        set.clear();
        newAll.sort(Comparator.comparing(Station::getName));
        all = new ArrayList<>(newAll);
        return all;
    }

    @Override
    public ArrayList<Station> findShortestRoute(int source, int destination) {

        ArrayList<Integer> path = ShortestRoute.find(source, destination);
        ArrayList<Station> stationPath = new ArrayList<>(path.stream().map(this::getStationById).toList());
        return stationPath;
    }

    @Override
    public Station getStationById(int id) {
        Optional<Station> optional = stationRepo.findById(id);
        if (optional.isEmpty()) {
            System.out.println("not found");
        }
        return optional.orElse(null);
    }

    @Override
    public int getStationIdByName(String name) {
        return stationRepo.findByName(name).getId();
    }

    @Override
    public int calculateTime() {
        return 0;
    }

    @Override
    public int calculateCost() {
        return 0;
    }
}

package com.sahilrawat.DelhiMetro.service;

import com.sahilrawat.DelhiMetro.model.Station;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface StationService {

    public void saveAll(ArrayList<Station> arrayList);
    Station addStation(Station station);
    ArrayList<Station> getAllStations();
    ArrayList<Station> findShortestRoute(int src, int dest);
    Station getStationById(int id);
    int getStationIdByName(String name);
    int calculateTime();
    int calculateCost();
}

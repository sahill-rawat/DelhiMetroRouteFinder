package com.sahilrawat.DelhiMetro.controller;

import com.sahilrawat.DelhiMetro.model.Station;

import java.util.ArrayList;

public interface StationController {
    Station addStation(Station station);
    ArrayList<Station> getAllStations();
    ArrayList<Station> findShortestRoute(int src, int dest);
    Station getStationById(int id);
    int getStationIdByName(String name);
}

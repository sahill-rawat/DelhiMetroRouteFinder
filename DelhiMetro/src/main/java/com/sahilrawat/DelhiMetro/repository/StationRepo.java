package com.sahilrawat.DelhiMetro.repository;

import com.sahilrawat.DelhiMetro.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StationRepo extends JpaRepository<Station, Integer> {
    Station findByName(String name);
}

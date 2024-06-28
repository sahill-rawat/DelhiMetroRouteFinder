package com.sahilrawat.DelhiMetro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Data
@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Station {

    @Id
    private int id;
    private String name;
    private String line;
}

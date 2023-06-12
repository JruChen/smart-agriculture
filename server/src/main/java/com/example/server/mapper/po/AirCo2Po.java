package com.example.server.mapper.po;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.grammars.hql.HqlParser;

import java.time.LocalDateTime;

@Entity
@Table(name = "air_co2")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirCo2Po {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;

    private LocalDateTime time;


}

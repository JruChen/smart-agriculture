package com.example.server.mapper.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "soil_humidity")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SoilHumidityPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer value;

    private LocalDateTime time;
}

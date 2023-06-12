package com.example.server.mapper.po;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "basic_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasicInfoPo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "yield")
    private Integer yield;

    @Column(name = "area")
    private Double area;

    @Column(name = "dan")
    private Double dan;

    @Column(name = "lin")
    private Double lin;

    @Column(name = "jia")
    private Double jia;
}

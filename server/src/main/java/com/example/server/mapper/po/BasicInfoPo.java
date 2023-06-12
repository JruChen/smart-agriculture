package com.example.server.mapper.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

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
    private Double yield;

    @Column(name = "area")
    private Double area;

    @Column(name = "dan")
    private Double dan;

    @Column(name = "lin")
    private Double lin;

    @Column(name = "jia")
    private Double jia;
}

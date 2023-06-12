package com.example.server.mapper;

import com.example.server.mapper.po.SoilHumidityPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilHumidityPoMapper extends JpaRepository<SoilHumidityPo, Long> {
}

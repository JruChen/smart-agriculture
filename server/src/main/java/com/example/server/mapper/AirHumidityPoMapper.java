package com.example.server.mapper;

import com.example.server.mapper.po.AirHumidityPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirHumidityPoMapper extends JpaRepository<AirHumidityPo, Long> {
}

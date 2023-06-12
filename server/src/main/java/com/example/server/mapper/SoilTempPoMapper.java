package com.example.server.mapper;

import com.example.server.mapper.po.SoilTempPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilTempPoMapper extends JpaRepository<SoilTempPo, Long> {
}

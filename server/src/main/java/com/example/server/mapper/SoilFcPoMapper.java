package com.example.server.mapper;

import com.example.server.mapper.po.SoilFcPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilFcPoMapper extends JpaRepository<SoilFcPo, Long> {
}

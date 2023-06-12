package com.example.server.mapper;

import com.example.server.mapper.po.SoilPhPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilPhPoMapper extends JpaRepository<SoilPhPo, Long> {
}

package com.example.server.mapper;

import com.example.server.mapper.po.AirTempPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirTempPoMapper extends JpaRepository<AirTempPo, Long> {
}

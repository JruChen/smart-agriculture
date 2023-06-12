package com.example.server.mapper;

import com.example.server.mapper.po.AirCo2Po;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCo2PoMapper extends JpaRepository<AirCo2Po, Long> {
}

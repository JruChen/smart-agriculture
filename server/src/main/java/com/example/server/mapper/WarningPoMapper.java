package com.example.server.mapper;

import com.example.server.mapper.po.WarningPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarningPoMapper extends JpaRepository<WarningPo, Long> {
}

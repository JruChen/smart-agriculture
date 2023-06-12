package com.example.server.mapper;

import com.example.server.mapper.po.BasicInfoPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicInfoPoMapper extends JpaRepository<BasicInfoPo, Long> {

}

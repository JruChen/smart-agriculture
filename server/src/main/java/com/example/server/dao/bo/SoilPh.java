package com.example.server.dao.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoilPh {

    @Builder
    public SoilPh(Long id, Double value, LocalDateTime time){
        this.id = id;
        this.value = value;
        this.time = time;
    }

    @Getter
    private Long id;

    @Getter
    private Double value;

    @Getter
    private LocalDateTime time;
}

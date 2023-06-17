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
public class Warning {
    @Builder
    public Warning(Long id,String type, Double value, LocalDateTime time){
        this.id = id;
        this.type = type;
        this.value = value;
        this.time = time;
    }

    @Getter
    private Long id;

    @Getter
    private String type;

    @Getter
    private Double value;

    @Getter
    private LocalDateTime time;
}

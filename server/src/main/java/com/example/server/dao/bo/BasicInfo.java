package com.example.server.dao.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicInfo {

    @Builder
    public BasicInfo(Long id, String name, Double yield, Double area, Double dan, Double lin, Double jia){
        this.id = id;
        this.name = name;
        this.yield = yield;
        this.area = area;
        this.dan = dan;
        this.lin = lin;
        this.jia = jia;
    }

    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private Double yield;

    @Getter
    private Double area;

    @Getter
    private Double dan;

    @Getter
    private Double lin;

    @Getter
    private Double jia;

}

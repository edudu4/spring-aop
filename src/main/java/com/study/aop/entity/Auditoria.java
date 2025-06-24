package com.study.aop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Auditoria {
    private String ip;
    private String city;
    private String country;

    @Override
    public String toString() {
        return "Auditoria: {" +
                "ip='" + ip + '\'' +
                ", cidade='" + city + '\'' +
                ", pais='" + country + '\'' +
                '}';
    }
}

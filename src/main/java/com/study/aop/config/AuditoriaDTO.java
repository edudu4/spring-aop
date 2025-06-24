package com.study.aop.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditoriaDTO {
    private String ip;
    private String city;
    private String country;

    @Override
    public String toString() {
        return "AuditoriaDTO{" +
                "ip='" + ip + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

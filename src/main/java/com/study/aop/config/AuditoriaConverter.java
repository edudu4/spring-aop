package com.study.aop.config;

import com.study.aop.entity.Auditoria;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

@Converter
@Component
public class AuditoriaConverter implements AttributeConverter<Auditoria, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Auditoria auditoria) {
        try {
            return objectMapper.writeValueAsString(new AuditoriaDTO(auditoria.getIp(), auditoria.getCity(), auditoria.getCountry()));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao serializar auditoria", e);
        }
    }

    @Override
    public Auditoria convertToEntityAttribute(String json) {
        try {
            if (json.startsWith("\"{")) {
                json = objectMapper.readValue(json, String.class);
            }
            return objectMapper.readValue(json, Auditoria.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao desserializar auditoria", e);
        }
    }

    public AuditoriaDTO convertJsonToDTO(String json) {
        try {
            return objectMapper.readValue(json, AuditoriaDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao desserializar auditoria", e);
        }
    }

}

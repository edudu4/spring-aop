package com.study.aop.entity;

import com.study.aop.config.AuditoriaConverter;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String sexo;
    @Convert(converter = AuditoriaConverter.class)
    @Column(columnDefinition = "json")
    private Auditoria auditoria;

    @Override
    public String toString() {
        return "Pessoa: {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                ", auditoria=" + auditoria +
                '}';
    }
}

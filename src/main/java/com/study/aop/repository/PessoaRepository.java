package com.study.aop.repository;

import com.study.aop.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByNome(String nome);

    @Query(value = """
            SELECT p FROM Pessoa p WHERE p.sexo = ?1 AND p.idade >= 18
            """)
    List<Pessoa> buscaPessoaPorSexoMaiorDeIdade(String sexo);
}

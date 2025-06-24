package com.study.aop.service;

import com.study.aop.config.AuditoriaDTO;
import com.study.aop.entity.Auditoria;
import com.study.aop.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.study.aop.entity.Pessoa;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final AuditoriaDTO auditoria;

    public List<Pessoa> getAll(){
        return pessoaRepository.findAll();
    }
    public Pessoa getById(Long id){
        return pessoaRepository.findById(id).orElse(null);
    }
    @Transactional
    public Pessoa save(Pessoa pessoa){
        pessoa.setAuditoria(new Auditoria(auditoria.getIp(), auditoria.getCity(), auditoria.getCountry()));
        return pessoaRepository.save(pessoa);
    }
    @Transactional
    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }
}

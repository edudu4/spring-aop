package com.study.aop.controller;

import com.study.aop.entity.Pessoa;
import com.study.aop.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        return ResponseEntity.ok(pessoaService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.getById(id));
    }
    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.save(pessoa));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

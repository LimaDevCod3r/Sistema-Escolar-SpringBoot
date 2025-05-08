package com.SistemaEscolar.controllers;

import com.SistemaEscolar.models.Aluno;
import com.SistemaEscolar.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlunoController {

    @Autowired
    private AlunoService service;


    @PostMapping("/aluno")
    public ResponseEntity<Aluno> cadastar(@RequestBody Aluno aluno) {
        Aluno alunoCriado = service.cadastrar(aluno);
        return ResponseEntity.status(201).body(alunoCriado);
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<Aluno>> buscarTodos() {
        List<Aluno> alunos = service.buscarTodos();
        return ResponseEntity.ok(alunos);
    }
}

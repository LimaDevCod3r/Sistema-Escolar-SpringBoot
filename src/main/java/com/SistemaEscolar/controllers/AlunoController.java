package com.SistemaEscolar.controllers;

import com.SistemaEscolar.dtos.AlunoDTO;
import com.SistemaEscolar.services.AlunoService;
import jakarta.validation.Valid;
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
    public ResponseEntity<AlunoDTO> cadastar(@Valid @RequestBody AlunoDTO aluno) {
        AlunoDTO alunoCriado = service.cadastrar(aluno);
        return ResponseEntity.status(201).body(alunoCriado);
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<AlunoDTO>> buscarTodos() {
        List<AlunoDTO> alunos = service.buscarTodos();
        return ResponseEntity.ok(alunos);
    }
}

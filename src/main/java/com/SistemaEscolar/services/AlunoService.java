package com.SistemaEscolar.services;

import com.SistemaEscolar.models.Aluno;
import com.SistemaEscolar.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;


    public Aluno cadastrar(Aluno aluno) {
        return repository.save(aluno);
    }


    public List<Aluno> buscarTodos() {
        return repository.findAll();
    }
}

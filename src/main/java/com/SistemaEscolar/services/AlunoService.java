package com.SistemaEscolar.services;

import com.SistemaEscolar.dtos.AlunoDTO;
import com.SistemaEscolar.models.Aluno;
import com.SistemaEscolar.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.SistemaEscolar.mapper.DozerMapper.mapObject;
import static com.SistemaEscolar.mapper.DozerMapper.mapList;


import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;


    public AlunoDTO cadastrar(AlunoDTO aluno) {

        // Converte o DTO de entrada para a entidade JPA usando o DozerMapper
        var alunoEntity = mapObject(aluno, Aluno.class);

        // Salva a entidade no banco de dados com o JPA repository
        var alunoSalvo = repository.save(alunoEntity);

        // Converte a entidade salva (com ID e datas preenchidas) de volta para DTO
        return mapObject(alunoSalvo, AlunoDTO.class);
    }


    public List<AlunoDTO> buscarTodos() {

        // Recupera todas as entidades Aluno do banco de dados
        var alunosEntities = repository.findAll();

        // Converte a lista de entidades para uma lista de DTOs com DozerMapper
        return mapList(alunosEntities, AlunoDTO.class);
    }
}

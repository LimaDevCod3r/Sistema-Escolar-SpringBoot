package com.SistemaEscolar.repositories;


import com.SistemaEscolar.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
}

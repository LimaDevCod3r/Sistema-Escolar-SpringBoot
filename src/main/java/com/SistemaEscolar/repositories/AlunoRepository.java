package com.SistemaEscolar.repositories;


import com.SistemaEscolar.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, String> {

    Optional<Aluno> findByCpf(String cpf);
}

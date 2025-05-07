package com.SistemaEscolar.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private String id;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Column(length = 100)
    private String sobrenome;

    @Column(unique = true, length = 14)
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    private String cpf;

    private LocalDateTime dataNascimento;

    @Column(length = 15)
    private String telefone;

    @Email(message = "E-mail inválido")
    private String email;

    @Column(length = 100, nullable = true)
    private String nomeDaMae;

    @Column(length = 100, nullable = true)
    private String nomeDoPai;

    @Column(length = 100, nullable = true)
    private String endereco;

    @Column(updatable = false)
    private LocalDateTime dataDeCadastro;

    private LocalDateTime dataDeAtualizacao;

    // Definindo callbacks para preencher datas automaticamente
    @PrePersist
    public void aoCriar() {
        this.dataDeCadastro = LocalDateTime.now();
        this.dataDeAtualizacao = LocalDateTime.now();
    }

    @PreUpdate
    public void aoAtualizar() {
        this.dataDeAtualizacao = LocalDateTime.now();
    }
}

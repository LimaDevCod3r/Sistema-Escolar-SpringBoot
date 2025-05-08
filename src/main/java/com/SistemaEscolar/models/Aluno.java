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

    @Column(unique = true, length = 11, nullable = false)
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos")
    @NotNull(message = "O CPF é obrigatório")
    private String cpf;

    @Column(nullable = false)
    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDateTime dataNascimento;

    @Column(length = 15)
    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter 10 ou 11 dígitos")
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Genero genero;

    @Column(length = 100)
    @Email(message = "E-mail inválido")
    private String email;

    @Column(length = 100)
    private String nomeDaMae;

    @Column(length = 100)
    private String nomeDoPai;

    @Column(length = 9)
    @Pattern(regexp = "\\d{8}", message = "CEP deve conter 8 dígitos numéricos")
    private String cep;

    @Column(length = 100)
    private String cidade;

    @Column(length = 2)
    @Size(min = 2, max = 2, message = "Estado deve conter a sigla com 2 letras (ex: SP, RJ)")
    private String estado;


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

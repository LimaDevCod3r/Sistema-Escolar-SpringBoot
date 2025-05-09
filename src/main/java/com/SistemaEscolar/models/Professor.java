package com.SistemaEscolar.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private String id;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "O sobrenome é obrigatório")
    private String sobrenome;

    @ManyToMany
    @JoinTable(
            name = "professor_especializacao",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "especializacao_id")
    )
    private List<Especializacao> especializacoes = new ArrayList<>();

    @Column(unique = true, length = 11, nullable = false)
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos")
    @NotNull(message = "O CPF é obrigatório")
    private String cpf;

    @Column(nullable = false)
    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Genero genero;

    @Column(length = 15)
    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter 10 ou 11 dígitos")
    private String telefone;

    @Column(updatable = false)
    private LocalDateTime dataDeCadastro;

    private LocalDateTime dataDeAtualizacao;

    @PrePersist
    public void aoCriar() {
        this.dataDeCadastro = LocalDateTime.now();
        this.dataDeAtualizacao = LocalDateTime.now();
    }

    @PreUpdate
    public void aoAtualizar() {
        this.dataDeAtualizacao = LocalDateTime.now();
    }

    public boolean isMaiorDeIdade() {
        if (this.dataNascimento == null) return false;

        return this.dataNascimento.plusYears(18).isBefore(LocalDate.now()) ||
                this.dataNascimento.plusYears(18).isEqual(LocalDate.now());
    }
}

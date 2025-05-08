package com.SistemaEscolar.dtos;

import com.SistemaEscolar.models.Genero;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoDTO {
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100)
    private String nome;

    @Size(max = 100)
    @NotBlank(message = "O sobrenome é obrigatório")
    private String sobrenome;

    @NotNull(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos")
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDateTime dataNascimento;

    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter 10 ou 11 dígitos")
    @Size(max = 15)
    private String telefone;

    private Genero genero;

    @Email(message = "E-mail inválido")
    @Size(max = 100)
    private String email;

    @Size(max = 100)
    private String nomeDaMae;

    @Size(max = 100)
    private String nomeDoPai;

    @Pattern(regexp = "\\d{8}", message = "CEP deve conter 8 dígitos numéricos")
    private String cep;

    @Size(max = 100)
    private String cidade;

    @Size(min = 2, max = 2, message = "Estado deve conter a sigla com 2 letras (ex: SP, RJ)")
    private String estado;
}

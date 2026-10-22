package br.com.fatec.ninjas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name="ninja")
@Valid // @Valid: usado para implementar todas as outras validações
public class Ninja {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Schema(
            description = "Identificador único do ninja",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id_ninja;

    @Column (name = "nome_ninja", nullable=false)
    @NotBlank(message = "O nome é obrigatório.")
    @Size (min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres.")
    @Schema(
            description = "Nome completo do ninja",
            example = "Naruto Uzumaki"
    )
    private String nome;

    @Column (name = "cpf_ninja", nullable=false, unique=true)
    @NotBlank(message = "O CPF é obrigatório.")
    @CPF
    @Schema(
            description = "CPF do ninja (***Valido)",
            example = "XXX.XXX.XXX-XX"
    )
    private String cpf;

    @Column (name = "email_ninja", nullable=false, unique=true)
    @NotBlank(message = "O e-mail é obrigatório.")
    @Email (message = "E-mail inválido (email@email.com)")
    @Schema(
            description = "E-mail do ninja (***Valido)",
            example = "naruto@konoha.com"
    )
    private String email;
}

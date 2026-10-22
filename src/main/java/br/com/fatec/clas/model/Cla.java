package br.com.fatec.clas.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cla")
@Valid
public class Cla {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id_cla;

    @Column(name = "nome_cla", nullable=false)
    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres.")
    @Schema(example = "Uzumaki")
    private String nome;

    @Column (name = "descricao_cla", nullable=false, unique=true)
    @NotBlank(message = "A descrição é obrigatória.")
    @Size(min = 3, max = 150, message = "Descrição deve ter entre 3 e 150 caracteres.")
    @Schema(example = "Clã conhecido pela vitalidade")
    private String descricao;

    @Column (name = "habilidade_cla", nullable=false, unique=true)
    @NotBlank(message = "A habilidade é obrigatória.")
    @Size(min = 3, max = 30, message = "Habilidade deve ter entre 3 e 30 caracteres.")
    @Schema(example = "Selamento")
    private String habilidade;

    @Column (name = "linhagem_sanguinea", nullable=false, unique=true)
    @NotBlank(message = "A linhagem sanguínea é obrigatória.")
    @Size(min = 3, max = 20, message = "A linhagem sangínea deve ter entre 3 e 20 caracteres.")
    @Schema(example = "Uzumaki")
    private String linhagemSanguinea;

    @Column (name = "tracos_geneticos", nullable=false, unique=true)
    @NotBlank(message = "Os traços genéticos são obrigatórios.")
    @Size(min = 3, max = 30, message = "Os traços genéticos devem ter entre 3 e 30 caracteres.")
    @Schema(example = "Cabelos ruivos")
    private String tracosGeneticos;
}

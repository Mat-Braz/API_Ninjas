package br.com.fatec.ninjas.controller;

import br.com.fatec.ninjas.model.Ninja;
import br.com.fatec.ninjas.service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(
  name = "Ninjas",
  description = "Gerenciamento de Ninjas"
)
@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @Operation(
      summary = "Cadastrar Ninjas",
      description = "Permite cadastrar um novo ninja no sistema, recebendo suas informações por meio do corpo da requisição e armazenando os dados no banco de dados."
    )

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Ninja cadastrado com sucesso!",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos para cadastro",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno no servidor",
                    content = @Content
            ),
    })

    @PostMapping
    public Ninja cadastrarNinja(@Valid @RequestBody Ninja ninja){
        return ninjaService.cadastrarNinja(ninja);
    }

    @GetMapping
    public List<Ninja> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // PathVariable: converta o valor inserido na URL e armazene na variável ID
    @GetMapping("/id/{id}")
    public Optional<Ninja> pesquisarNinja(
            @Parameter(
                    description = "ID do ninja que deseja consultar",
                    example = "1",
                    required = true
            )
            @PathVariable Long id){
        return ninjaService.pesquisarNinja(id);
    }

    @GetMapping("/nome/{nome}")
    public Ninja pesquisarNinjaPorNome(@PathVariable String nome){
        return ninjaService.pesquisarNinjaPorNome(nome);
    }

    @GetMapping("/partenome/{nome}")
    public List<Ninja> pesquisarNinjaPorParteDoNome(@PathVariable String nome){
        return ninjaService.pesquisarNinjaPorParteDoNome(nome);
    }

    @PutMapping("/{id}")
    public Ninja atualizarNinja(@PathVariable Long id, @Valid @RequestBody Ninja ninja){
        return ninjaService.atualizarNinja(id, ninja);
    }

    @DeleteMapping("/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }

}

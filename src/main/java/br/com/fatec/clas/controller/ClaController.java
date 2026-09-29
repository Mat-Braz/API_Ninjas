package br.com.fatec.clas.controller;

import br.com.fatec.clas.model.Cla;
import br.com.fatec.clas.service.ClaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clas")
public class ClaController {

    @Autowired
    private ClaService claService;

    //Cadastrar clã
    @PostMapping
    public Cla cadastrarCla(@Valid @RequestBody Cla cla){
        return claService.cadastrarCla(cla);
    }

    //Listar todos os clãs
    @GetMapping
    public List<Cla> listarClas(){
        return claService.listarClas();
    }

    //Pesquisar clã pelo ID
    @GetMapping("/id/{id}")
    public Optional<Cla> pesquisarCla(@PathVariable Long id){
        return claService.pesquisarCla(id);
    }

    //Pesquisar clã pelo nome
    @GetMapping("/nome/{nome}")
    public Cla pesquisarClaPorNome(@PathVariable String nome){
        return claService.pesquisarClaPorNome(nome);
    }

    //Pesquisar clã por parte da descrição
    @GetMapping("/partedescricao/{descricao}")
    public List<Cla> pesquisarClaPorParteDaDescricao(@PathVariable String descricao){
        return claService.pesquisarClaPorParteDaDescricao(descricao);
    }

    //Atualizar clã pelo ID
    @PutMapping("/{id}")
    public Cla atualizarCla(@PathVariable Long id, @Valid @RequestBody Cla cla){
        return claService.atualizarCla(id, cla);
    }

    //Excluir clã pelo ID
    @DeleteMapping("/{id}")
    public void deletarCla(@PathVariable Long id){
        claService.deletarCla(id);
    }
}

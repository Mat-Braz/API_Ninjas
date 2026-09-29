package br.com.fatec.clas.service;

import br.com.fatec.clas.model.Cla;
import br.com.fatec.clas.repository.ClaRepository;
import br.com.fatec.ninjas.model.Ninja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaService {

    @Autowired
    private ClaRepository claRepository;

    //Cadastrar Clã
    public Cla cadastrarCla(Cla cla){
        return claRepository.save(cla);
    }

    //Listar todos os clãs
    public List<Cla> listarClas() {
        return claRepository.findAll();
    }

    //Pesquisar clã pelo ID
    public Optional<Cla> pesquisarCla (Long id){
        return claRepository.findById(id);
    }

    //Pesquisar clã pelo nome
    public Cla pesquisarClaPorNome (String nome) {
        return claRepository.findByNomeIgnoreCase(nome);
    }

    //Pesquisar clã por parte da descrição
    public List<Cla> pesquisarClaPorParteDaDescricao (String descricao) {
        return claRepository.findByDescricaoContainingIgnoreCase(descricao);
    }

    //Atualizar clã pelo ID
    public Cla atualizarCla (Long id, Cla claAtualizado) {
        Optional<Cla> claCadastrado = claRepository.findById(id);

        if(claCadastrado.isPresent()){
            Cla cla = claCadastrado.get();

            cla.setNome(claAtualizado.getNome());
            cla.setDescricao(claAtualizado.getDescricao());
            cla.setHabilidade(claAtualizado.getHabilidade());
            cla.setLinhagemSanguinea(claAtualizado.getLinhagemSanguinea());
            cla.setTracosGeneticos(claAtualizado.getTracosGeneticos());

            return claRepository.save(cla);
        }
        return null;
    }

    //Excluir clã pelo ID
    public void deletarCla (Long id) {
        claRepository.deleteById(id);
    }
}

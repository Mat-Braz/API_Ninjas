package br.com.fatec.ninjas.service;

import br.com.fatec.ninjas.model.Ninja;
import br.com.fatec.ninjas.repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    // Anotação que indica que injetamos uma dependência. Nesse caso, a Repository com os seus métodos
    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninja cadastrarNinja(Ninja ninja) {
        ninja.setId_ninja(null);
        return ninjaRepository.save(ninja);
    }

    public List<Ninja> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Optional: O valor pode existir ou não. Trata a exceção do nulo.
    public Optional<Ninja> pesquisarNinja(Long id) {
        return Optional.of(ninjaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Ninja não encontrado")));
    }

    public Ninja pesquisarNinjaPorNome(String nome) {
        Ninja encontrado = ninjaRepository.findByNome(nome);
        if (encontrado == null)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Ninja não encontrado");
        return encontrado;
    }

    public List<Ninja> pesquisarNinjaPorParteDoNome (String nome) {
        return ninjaRepository.findByNomeContaining(nome);
    }

    public Ninja atualizarNinja (Long id, Ninja ninjaAtualizado) {
        Optional<Ninja> ninjaCadastrado = ninjaRepository.findById(id);

        if(ninjaCadastrado.isPresent()){
            Ninja ninja = ninjaCadastrado.get();

            ninja.setNome(ninjaAtualizado.getNome());
            ninja.setCpf(ninjaAtualizado.getCpf());
            ninja.setEmail(ninjaAtualizado.getEmail());

            return ninjaRepository.save(ninja);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Ninja não encontrado");
    }

    public void deletarNinja(Long id) {
        ninjaRepository.delete(ninjaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Ninja não encontrado")));
    }
}

package br.com.fatec.clas.repository;

import br.com.fatec.clas.model.Cla;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClaRepository extends JpaRepository<Cla, Long> {
    //Buscar clã pelo id
    Optional<Cla> findById(Long id);

    //Buscar clã pelo nome
    Cla findByNomeIgnoreCase(String nome);

    //Buscar clã por parte do descrição
    List<Cla> findByDescricaoContainingIgnoreCase(String descricao);
}

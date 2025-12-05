package br.com.spring_fundamentals.repository;

import br.com.spring_fundamentals.entities.EnderecoEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EnderecoRepository extends JpaRepository<EnderecoEntities, Integer> {
    List<EnderecoEntities> findByCep(String cep);
    List<EnderecoEntities> findByBairro(String bairro);
    List<EnderecoEntities> findByIdTipoEndereco_IdTipoEndereco(Integer tipoEnderecoId);
}

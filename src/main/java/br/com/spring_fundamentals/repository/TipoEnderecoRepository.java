package br.com.spring_fundamentals.repository;

import br.com.spring_fundamentals.entities.TipoEnderecoEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEnderecoRepository extends JpaRepository<TipoEnderecoEntities, Integer> {
}

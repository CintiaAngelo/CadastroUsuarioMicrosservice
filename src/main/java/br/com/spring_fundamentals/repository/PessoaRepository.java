package br.com.spring_fundamentals.repository;

import br.com.spring_fundamentals.entities.PessoaEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntities, Integer> {
}


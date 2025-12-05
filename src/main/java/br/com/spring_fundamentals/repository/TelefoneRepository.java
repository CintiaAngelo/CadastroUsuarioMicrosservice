package br.com.spring_fundamentals.repository;

import br.com.spring_fundamentals.entities.TelefoneEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<TelefoneEntities, Integer> {
}

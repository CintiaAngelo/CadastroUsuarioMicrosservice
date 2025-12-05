package br.com.spring_fundamentals.repository;

import br.com.spring_fundamentals.entities.EmailEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailEntities, Integer> {
}

package br.com.spring_fundamentals.repository;

import br.com.spring_fundamentals.entities.UsuarioEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UsuarioRepository extends JpaRepository <UsuarioEntities, Integer> {

    List<UsuarioEntities> findAllByNomeusuarioContainingIgnoreCase(String nomeusuario);

}

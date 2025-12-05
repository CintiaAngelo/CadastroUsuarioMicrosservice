package br.com.spring_fundamentals.repository;

import br.com.spring_fundamentals.entities.PessoaEnderecoEntities;
import br.com.spring_fundamentals.entities.PessoaEnderecoId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PessoaEnderecoRepository extends JpaRepository<PessoaEnderecoEntities, PessoaEnderecoId> {

    List<PessoaEnderecoEntities> findByPessoa_Id(Integer pessoaId);

    List<PessoaEnderecoEntities> findByEndereco_Id(Integer enderecoId);

    List<PessoaEnderecoEntities> findByTipoEndereco_IdTipoEndereco(Integer tipoEnderecoId);

}

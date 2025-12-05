package br.com.spring_fundamentals.mapper;

import br.com.spring_fundamentals.dto.PessoaEnderecoDTO;
import br.com.spring_fundamentals.entities.*;

public class PessoaEnderecoMapper {

    public static PessoaEnderecoDTO toDTO(PessoaEnderecoEntities entity) {
        PessoaEnderecoDTO dto = new PessoaEnderecoDTO();
        dto.setPessoaId(entity.getPessoa().getId());
        dto.setEnderecoId(entity.getEndereco().getId());
        dto.setTipoEnderecoId(entity.getTipoEndereco().getIdTipoEndereco());
        return dto;
    }

    public static PessoaEnderecoEntities toEntity(PessoaEnderecoDTO dto) {
        PessoaEnderecoEntities entity = new PessoaEnderecoEntities();

        PessoaEnderecoId id = new PessoaEnderecoId();
        id.setIdPessoa(dto.getPessoaId());
        id.setIdEndereco(dto.getEnderecoId());
        entity.setId(id);

        PessoaEntities pessoa = new PessoaEntities();
        pessoa.setId(dto.getPessoaId());
        entity.setPessoa(pessoa);

        EnderecoEntities endereco = new EnderecoEntities();
        endereco.setId(dto.getEnderecoId());
        entity.setEndereco(endereco);

        TipoEnderecoEntities tipo = new TipoEnderecoEntities();
        tipo.setIdTipoEndereco(dto.getTipoEnderecoId());
        entity.setTipoEndereco(tipo);

        return entity;
    }
}

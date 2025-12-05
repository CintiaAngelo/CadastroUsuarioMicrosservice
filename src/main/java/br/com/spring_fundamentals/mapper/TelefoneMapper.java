package br.com.spring_fundamentals.mapper;

import br.com.spring_fundamentals.dto.TelefoneDTO;
import br.com.spring_fundamentals.entities.PessoaEntities;
import br.com.spring_fundamentals.entities.TelefoneEntities;

public class TelefoneMapper {

    public static TelefoneDTO toDTO(TelefoneEntities entity) {
        TelefoneDTO dto = new TelefoneDTO();
        dto.setId(entity.getId());
        dto.setTelefone(entity.getTelefone());
        dto.setIdPessoa(entity.getIdPessoa().getId());
        return dto;
    }

    public static TelefoneEntities toEntity(TelefoneDTO dto, PessoaEntities pessoa) {
        TelefoneEntities entity = new TelefoneEntities();
        entity.setId(dto.getId());
        entity.setTelefone(dto.getTelefone());
        entity.setIdPessoa(pessoa);
        return entity;
    }
}

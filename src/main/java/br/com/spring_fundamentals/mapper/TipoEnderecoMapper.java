package br.com.spring_fundamentals.mapper;

import br.com.spring_fundamentals.dto.TipoEnderecoDTO;
import br.com.spring_fundamentals.entities.TipoEnderecoEntities;

public class TipoEnderecoMapper {
    public static TipoEnderecoDTO toDTO(TipoEnderecoEntities entity) {
        TipoEnderecoDTO dto = new TipoEnderecoDTO();
        dto.setId(entity.getIdTipoEndereco());
        dto.setTipo(entity.getTipo());
        return dto;
    }

    public static TipoEnderecoEntities toEntity(TipoEnderecoDTO dto) {
        TipoEnderecoEntities entity = new TipoEnderecoEntities();
        entity.setIdTipoEndereco(dto.getId());
        entity.setTipo(dto.getTipo());
        return entity;
    }
}

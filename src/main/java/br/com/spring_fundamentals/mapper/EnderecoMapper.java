package br.com.spring_fundamentals.mapper;

import br.com.spring_fundamentals.dto.EnderecoDTO;
import br.com.spring_fundamentals.entities.EnderecoEntities;

public class EnderecoMapper {
    public static EnderecoDTO toDTO(EnderecoEntities entity) {
        EnderecoDTO dto = new EnderecoDTO();
        dto.setId(entity.getId());
        dto.setRua(entity.getRua());
        dto.setNumero(entity.getNumero());
        dto.setComplemento(entity.getComplemento());
        dto.setCep(entity.getCep());
        dto.setBairro(entity.getBairro());
        dto.setTipoEnderecoId(entity.getIdTipoEndereco().getIdTipoEndereco());
        return dto;
    }

    public static EnderecoEntities toEntity(EnderecoDTO dto) {
        EnderecoEntities entity = new EnderecoEntities();
        entity.setId(dto.getId());
        entity.setRua(dto.getRua());
        entity.setNumero(dto.getNumero());
        entity.setComplemento(dto.getComplemento());
        entity.setCep(dto.getCep());
        entity.setBairro(dto.getBairro());
        return entity;
    }
}

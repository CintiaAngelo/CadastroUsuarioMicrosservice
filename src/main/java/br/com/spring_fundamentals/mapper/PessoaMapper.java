package br.com.spring_fundamentals.mapper;

import br.com.spring_fundamentals.dto.PessoaDTO;
import br.com.spring_fundamentals.entities.PessoaEntities;

public class PessoaMapper {

    public static PessoaDTO toDTO(PessoaEntities entity) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setSobrenome(entity.getSobrenome());
        dto.setCpf(entity.getCpf());
        dto.setDataNascimento(entity.getDataNascimento());
        return dto;
    }


    public static PessoaEntities toEntity(PessoaDTO dto) {
        PessoaEntities entity = new PessoaEntities();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setSobrenome(dto.getSobrenome());
        entity.setCpf(dto.getCpf());
        entity.setDataNascimento(dto.getDataNascimento());
        return entity;
    }
}

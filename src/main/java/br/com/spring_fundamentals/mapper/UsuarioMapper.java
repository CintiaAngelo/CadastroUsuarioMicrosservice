package br.com.spring_fundamentals.mapper;

import br.com.spring_fundamentals.dto.UsuarioDTO;
import br.com.spring_fundamentals.dto.UsuarioSemSenhaDTO;
import br.com.spring_fundamentals.entities.PessoaEntities;
import br.com.spring_fundamentals.entities.UsuarioEntities;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(UsuarioEntities entity) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entity.getId_usuario());
        dto.setNomeusuario(entity.getNomeusuario());
        dto.setSenha(entity.getSenha());
        dto.setPessoaId(entity.getPessoa().getId());
        return dto;
    }

    public static UsuarioSemSenhaDTO toSemSenhaDTO(UsuarioEntities entity) {
        return UsuarioSemSenhaDTO.fromEntity(entity);
    }


    public static UsuarioEntities toEntity(UsuarioDTO dto) {
        UsuarioEntities entity = new UsuarioEntities();
        entity.setId_usuario(dto.getId());
        entity.setNomeusuario(dto.getNomeusuario());
        entity.setSenha(dto.getSenha());

        PessoaEntities pessoa = new PessoaEntities();
        pessoa.setId(dto.getPessoaId());
        entity.setPessoa(pessoa);

        return entity;
    }
}

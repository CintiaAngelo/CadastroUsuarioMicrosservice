package br.com.spring_fundamentals.dto;

import br.com.spring_fundamentals.entities.UsuarioEntities;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioSemSenhaDTO {
    private Integer id;
    private String nomeusuario;
    private Integer pessoaId;

    public static UsuarioSemSenhaDTO fromEntity(UsuarioEntities entity) {
        UsuarioSemSenhaDTO dto = new UsuarioSemSenhaDTO();
        dto.setId(entity.getId_usuario());
        dto.setNomeusuario(entity.getNomeusuario());
        dto.setPessoaId(entity.getPessoa().getId());
        return dto;
    }
}

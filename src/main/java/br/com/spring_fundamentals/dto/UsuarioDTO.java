package br.com.spring_fundamentals.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Integer id;
    private String nomeusuario;
    private String senha;
    private Integer pessoaId;
}

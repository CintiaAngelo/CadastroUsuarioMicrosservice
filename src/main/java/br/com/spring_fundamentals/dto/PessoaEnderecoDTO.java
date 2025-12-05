package br.com.spring_fundamentals.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaEnderecoDTO {
    private Integer pessoaId;
    private Integer enderecoId;
    private Integer tipoEnderecoId;
}

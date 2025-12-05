package br.com.spring_fundamentals.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
    private Integer id;
    private String rua;
    private Integer numero;
    private String complemento;
    private String cep;
    private String bairro;
    private Integer tipoEnderecoId;
}

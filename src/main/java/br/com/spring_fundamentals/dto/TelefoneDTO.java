package br.com.spring_fundamentals.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneDTO {
    private Integer id;
    private String telefone;
    private Integer idPessoa;
}

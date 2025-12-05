package br.com.spring_fundamentals.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDTO {
    private Integer id;
    private String email;
    private Integer idPessoa;
}

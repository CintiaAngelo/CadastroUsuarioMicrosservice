package br.com.spring_fundamentals.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class PessoaDTO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private Date dataNascimento;

}

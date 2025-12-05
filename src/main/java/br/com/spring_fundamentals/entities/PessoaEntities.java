package br.com.spring_fundamentals.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "pessoa")
public class PessoaEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Integer id;

    @JsonProperty("nome")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @JsonProperty("sobrenome")
    @Column(name = "sobrenome", length = 100)
    private String sobrenome;

    @JsonProperty("cpf")
    @Column(name = "cpf", nullable = false, length = 100, unique = true)
    private String cpf;

    @JsonProperty("data_nascimento")
    @Column(name = "data_nascimento")
    private Date dataNascimento;


}

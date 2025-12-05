package br.com.spring_fundamentals.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "email")
public class EmailEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_email")
    private Integer id;

    @JsonProperty("email")
    @Column(name = "email", nullable = false, length = 250)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaEntities idPessoa;




}

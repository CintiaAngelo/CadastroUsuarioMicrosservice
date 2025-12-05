package br.com.spring_fundamentals.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "telefone")
public class TelefoneEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    private Integer id;

    @Column(name = "telefone", nullable = false, length = 150)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaEntities idPessoa;
}

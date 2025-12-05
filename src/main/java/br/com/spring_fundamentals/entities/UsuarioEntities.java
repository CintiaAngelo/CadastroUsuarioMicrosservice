package br.com.spring_fundamentals.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "usuarios")
public class UsuarioEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id_usuario;

    //posso usar a config abaixo para configurar tudo no banco
    //@Column(name = "nomeusuario", nullable = false, length = 100, unique = true, updatable = false)
    @JsonProperty("nomeusuario")
    @Column(name = "nomeusuario", nullable = false, length = 100)
    private String nomeusuario;

    @JsonProperty("senha")
    @Column(name = "senha")
    private String senha;

    @OneToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaEntities pessoa;


}

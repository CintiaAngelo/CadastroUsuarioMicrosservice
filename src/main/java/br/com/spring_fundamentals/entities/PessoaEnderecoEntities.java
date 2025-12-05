package br.com.spring_fundamentals.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "pessoa_endereco")
public class PessoaEnderecoEntities {

    @EmbeddedId
    private PessoaEnderecoId id = new PessoaEnderecoId();

    @ManyToOne
    @MapsId("idPessoa")
    @JoinColumn(name = "id_pessoa")
    private PessoaEntities pessoa;

    @ManyToOne
    @MapsId("idEndereco")
    @JoinColumn(name = "id_endereco")
    private EnderecoEntities endereco;

    @ManyToOne
    @JoinColumn(name = "id_tipo_endereco")
    private TipoEnderecoEntities tipoEndereco;
}


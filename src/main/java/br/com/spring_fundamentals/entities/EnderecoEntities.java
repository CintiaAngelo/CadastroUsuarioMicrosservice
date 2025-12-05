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
@Table(name = "endereco")
public class EnderecoEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer id;

    @JsonProperty("rua")
    @Column(name = "rua", nullable = false, length = 250)
    private String rua;

    @JsonProperty("numero")
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @JsonProperty("complemento")
    @Column(name = "complemento", length = 150)
    private String complemento;

    @JsonProperty("cep")
    @Column(name = "cep", nullable = false, length = 20)
    private String cep;

    @JsonProperty("bairro")
    @Column(name = "bairro", length = 150)
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "id_tipo_endereco", nullable = false)
    private TipoEnderecoEntities idTipoEndereco;
}

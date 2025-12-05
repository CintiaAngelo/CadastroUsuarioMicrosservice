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
@Table(name = "tipoEndereco")
public class TipoEnderecoEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_endereco")
    private Integer idTipoEndereco;

    @JsonProperty("tipo")
    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;



}
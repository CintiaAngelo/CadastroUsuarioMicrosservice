package br.com.spring_fundamentals.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PessoaEnderecoId implements Serializable {
    private Integer idPessoa;
    private Integer idEndereco;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaEnderecoId that)) return false;
        return Objects.equals(idPessoa, that.idPessoa) && Objects.equals(idEndereco, that.idEndereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, idEndereco);
    }
}

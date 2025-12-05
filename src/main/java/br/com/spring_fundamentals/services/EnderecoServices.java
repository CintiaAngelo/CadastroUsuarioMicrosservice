package br.com.spring_fundamentals.services;

import br.com.spring_fundamentals.dto.EnderecoDTO;
import br.com.spring_fundamentals.entities.EnderecoEntities;
import br.com.spring_fundamentals.entities.TipoEnderecoEntities;
import br.com.spring_fundamentals.mapper.EnderecoMapper;
import br.com.spring_fundamentals.repository.EnderecoRepository;
import br.com.spring_fundamentals.repository.TipoEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServices {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private TipoEnderecoRepository tipoEnderecoRepository;

    public List<EnderecoDTO> findAll() {
        return enderecoRepository.findAll().stream()
                .map(EnderecoMapper::toDTO)
                .toList();
    }

    public EnderecoDTO save(EnderecoDTO dto) {
        EnderecoEntities entity = EnderecoMapper.toEntity(dto);

        // Recupera TipoEndereco do banco
        TipoEnderecoEntities tipo = tipoEnderecoRepository
                .findById(dto.getTipoEnderecoId())
                .orElseThrow(() -> new RuntimeException("TipoEndereco não encontrado"));
        entity.setIdTipoEndereco(tipo);

        EnderecoEntities saved = enderecoRepository.save(entity);
        return EnderecoMapper.toDTO(saved);
    }

    public void delete(Integer id) {
        enderecoRepository.deleteById(id);
    }
}

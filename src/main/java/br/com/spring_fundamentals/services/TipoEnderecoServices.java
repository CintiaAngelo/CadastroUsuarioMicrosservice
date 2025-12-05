package br.com.spring_fundamentals.services;

import br.com.spring_fundamentals.dto.TipoEnderecoDTO;
import br.com.spring_fundamentals.entities.TipoEnderecoEntities;
import br.com.spring_fundamentals.mapper.TipoEnderecoMapper;
import br.com.spring_fundamentals.repository.TipoEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEnderecoServices {

    @Autowired
    private TipoEnderecoRepository repository;

    public List<TipoEnderecoDTO> findAll() {
        return repository.findAll().stream()
                .map(TipoEnderecoMapper::toDTO)
                .toList();
    }

    public TipoEnderecoDTO save(TipoEnderecoDTO dto) {
        TipoEnderecoEntities entity = TipoEnderecoMapper.toEntity(dto);
        TipoEnderecoEntities saved = repository.save(entity);
        return TipoEnderecoMapper.toDTO(saved);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

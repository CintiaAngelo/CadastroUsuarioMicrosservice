package br.com.spring_fundamentals.services;

import br.com.spring_fundamentals.dto.TelefoneDTO;
import br.com.spring_fundamentals.entities.PessoaEntities;
import br.com.spring_fundamentals.entities.TelefoneEntities;
import br.com.spring_fundamentals.mapper.TelefoneMapper;
import br.com.spring_fundamentals.repository.PessoaRepository;
import br.com.spring_fundamentals.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneServices {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<TelefoneDTO> findAll() {
        return telefoneRepository.findAll()
                .stream()
                .map(TelefoneMapper::toDTO)
                .toList();
    }

    public TelefoneDTO findById(Integer id) {
        return telefoneRepository.findById(id)
                .map(TelefoneMapper::toDTO)
                .orElse(null);
    }

    public TelefoneDTO save(TelefoneDTO dto) {
        PessoaEntities pessoa = pessoaRepository.findById(dto.getIdPessoa())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada: " + dto.getIdPessoa()));

        TelefoneEntities entity = TelefoneMapper.toEntity(dto, pessoa);

        TelefoneEntities saved = telefoneRepository.save(entity);
        return TelefoneMapper.toDTO(saved);
    }

    public void delete(Integer id) {
        telefoneRepository.deleteById(id);
    }
}

package br.com.spring_fundamentals.services;

import br.com.spring_fundamentals.dto.EmailDTO;
import br.com.spring_fundamentals.entities.EmailEntities;
import br.com.spring_fundamentals.entities.PessoaEntities;
import br.com.spring_fundamentals.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import br.com.spring_fundamentals.dto.PessoaDTO;
import br.com.spring_fundamentals.mapper.PessoaMapper;


@Service
public class PessoaServices {

    @Autowired
    private PessoaRepository pessoaRepository;

    public EmailEntities toEntity(EmailDTO dto) {
        EmailEntities entity = new EmailEntities();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());

        PessoaEntities pessoa = pessoaRepository.findById(dto.getIdPessoa())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada: " + dto.getIdPessoa()));
        entity.setIdPessoa(pessoa);

        return entity;
    }


    public List<PessoaDTO> findAll() {
        return pessoaRepository.findAll()
                .stream()
                .map(PessoaMapper::toDTO)
                .toList();
    }

    public PessoaDTO findById(Integer id) {
        return pessoaRepository.findById(id)
                .map(PessoaMapper::toDTO)
                .orElse(null);
    }

    public PessoaDTO save(PessoaDTO dto) {
        PessoaEntities entity = PessoaMapper.toEntity(dto);
        PessoaEntities saved = pessoaRepository.save(entity);
        return PessoaMapper.toDTO(saved);
    }

    public void delete(Integer id) {
        pessoaRepository.deleteById(id);
    }
}

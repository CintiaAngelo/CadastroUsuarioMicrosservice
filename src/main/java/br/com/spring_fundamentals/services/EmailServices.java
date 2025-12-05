package br.com.spring_fundamentals.services;

import br.com.spring_fundamentals.dto.EmailDTO;
import br.com.spring_fundamentals.entities.EmailEntities;
import br.com.spring_fundamentals.entities.PessoaEntities;
import br.com.spring_fundamentals.mapper.EmailMapper;
import br.com.spring_fundamentals.repository.EmailRepository;
import br.com.spring_fundamentals.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmailServices {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public EmailDTO save(EmailDTO dto) {
        PessoaEntities pessoa = pessoaRepository.findById(dto.getIdPessoa())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada: " + dto.getIdPessoa()));

        EmailEntities email = new EmailEntities();
        email.setEmail(dto.getEmail());
        email.setIdPessoa(pessoa);

            pessoaRepository.save(pessoa);

            return EmailMapper.toDTO(email);
    }

    public List<EmailDTO> findAll() {
        return emailRepository.findAll()
                .stream()
                .map(EmailMapper::toDTO)
                .toList();
    }

    public EmailDTO findById(Integer id) {
        return emailRepository.findById(id)
                .map(EmailMapper::toDTO)
                .orElse(null);
    }


    public void delete(Integer id) {
        emailRepository.deleteById(id);
    }
}


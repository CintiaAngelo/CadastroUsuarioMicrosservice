package br.com.spring_fundamentals.services;

import br.com.spring_fundamentals.dto.PessoaEnderecoDTO;
import br.com.spring_fundamentals.entities.PessoaEnderecoEntities;
import br.com.spring_fundamentals.entities.PessoaEnderecoId;
import br.com.spring_fundamentals.mapper.PessoaEnderecoMapper;
import br.com.spring_fundamentals.repository.PessoaEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaEnderecoServices {

    @Autowired
    private PessoaEnderecoRepository pessoaEnderecoRepository;

    public List<PessoaEnderecoDTO> findAll() {
        return pessoaEnderecoRepository.findAll().stream()
                .map(PessoaEnderecoMapper::toDTO)
                .toList();
    }

    public PessoaEnderecoDTO save(PessoaEnderecoDTO dto) {
        PessoaEnderecoEntities entity = PessoaEnderecoMapper.toEntity(dto);
        PessoaEnderecoEntities saved = pessoaEnderecoRepository.save(entity);
        return PessoaEnderecoMapper.toDTO(saved);
    }

    public PessoaEnderecoDTO findById(PessoaEnderecoId id) {
        return pessoaEnderecoRepository.findById(id)
                .map(PessoaEnderecoMapper::toDTO)
                .orElse(null);
    }

    public List<PessoaEnderecoDTO> findByPessoaId(Integer pessoaId) {
        return pessoaEnderecoRepository.findByPessoa_Id(pessoaId)
                .stream()
                .map(PessoaEnderecoMapper::toDTO)
                .toList();
    }

    public List<PessoaEnderecoDTO> findByEnderecoId(Integer enderecoId) {
        return pessoaEnderecoRepository.findByEndereco_Id(enderecoId)
                .stream()
                .map(PessoaEnderecoMapper::toDTO)
                .toList();
    }

    public List<PessoaEnderecoDTO> findByTipoEnderecoId(Integer tipoEnderecoId) {
        return pessoaEnderecoRepository.findByTipoEndereco_IdTipoEndereco(tipoEnderecoId)
                .stream()
                .map(PessoaEnderecoMapper::toDTO)
                .toList();
    }


    public void delete(PessoaEnderecoId id) {
        pessoaEnderecoRepository.deleteById(id);
    }
}

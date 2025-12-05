package br.com.spring_fundamentals.services;

import br.com.spring_fundamentals.dto.UsuarioDTO;
import br.com.spring_fundamentals.dto.UsuarioSemSenhaDTO;
import br.com.spring_fundamentals.entities.UsuarioEntities;
import br.com.spring_fundamentals.mapper.UsuarioMapper;
import br.com.spring_fundamentals.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServices {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioSemSenhaDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toSemSenhaDTO)
                .toList();
    }


    public UsuarioDTO save(UsuarioDTO dto) {
        UsuarioEntities entity = UsuarioMapper.toEntity(dto);
        UsuarioEntities saved = usuarioRepository.save(entity);
        return UsuarioMapper.toDTO(saved);
    }


    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }


    // Para leitura (GET)
    public UsuarioSemSenhaDTO findById(Integer id) {
        return usuarioRepository.findById(id)
                .map(UsuarioMapper::toSemSenhaDTO)
                .orElse(null);
    }

    // Para escrita (PATCH/PUT/POST)
    public UsuarioDTO findUsuarioDTOById(Integer id) {
        return usuarioRepository.findById(id)
                .map(UsuarioMapper::toDTO)
                .orElse(null);
    }

}

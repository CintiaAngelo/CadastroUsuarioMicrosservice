package br.com.spring_fundamentals.mapper;

import br.com.spring_fundamentals.dto.EmailDTO;
import br.com.spring_fundamentals.entities.EmailEntities;
import br.com.spring_fundamentals.entities.PessoaEntities;

public class EmailMapper {

        public static EmailDTO toDTO(EmailEntities entity) {
            EmailDTO dto = new EmailDTO();
            dto.setId(entity.getId());
            dto.setEmail(entity.getEmail());
            dto.setIdPessoa(entity.getIdPessoa().getId());
            return dto;
        }

        public static EmailEntities toEntity(EmailDTO dto) {
            EmailEntities entity = new EmailEntities();
            entity.setId(dto.getId());
            entity.setEmail(dto.getEmail());

            PessoaEntities pessoa = new PessoaEntities();
            pessoa.setId(dto.getIdPessoa());
            entity.setIdPessoa(pessoa);

            return entity;
        }
    }



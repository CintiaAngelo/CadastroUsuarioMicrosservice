package br.com.spring_fundamentals.controller;

import br.com.spring_fundamentals.dto.PessoaEnderecoDTO;
import br.com.spring_fundamentals.entities.PessoaEnderecoId;
import br.com.spring_fundamentals.services.PessoaEnderecoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pessoa-endereco")
public class PessoaEnderecoController {

    @Autowired
    private PessoaEnderecoServices service;

    @GetMapping("/all")
    public List<PessoaEnderecoDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{pessoaId}/{enderecoId}")
    public ResponseEntity<PessoaEnderecoDTO> findById(@PathVariable Integer pessoaId, @PathVariable Integer enderecoId) {
        PessoaEnderecoId id = new PessoaEnderecoId();
        id.setIdPessoa(pessoaId);
        id.setIdEndereco(enderecoId);

        PessoaEnderecoDTO dto = service.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PessoaEnderecoDTO> save(@RequestBody PessoaEnderecoDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping
    public ResponseEntity<PessoaEnderecoDTO> update(@RequestBody PessoaEnderecoDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{pessoaId}/{enderecoId}")
    public void delete(@PathVariable Integer pessoaId, @PathVariable Integer enderecoId) {
        PessoaEnderecoId id = new PessoaEnderecoId();
        id.setIdPessoa(pessoaId);
        id.setIdEndereco(enderecoId);
        service.delete(id);
    }

    @PatchMapping("/{pessoaId}/{enderecoId}")
    public ResponseEntity<PessoaEnderecoDTO> patch(@PathVariable Integer pessoaId,
                                                   @PathVariable Integer enderecoId,
                                                   @RequestBody Map<String, Object> updates) {
        PessoaEnderecoId id = new PessoaEnderecoId();
        id.setIdPessoa(pessoaId);
        id.setIdEndereco(enderecoId);

        PessoaEnderecoDTO dto = service.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();

        updates.forEach((key, value) -> {
            if ("tipoEnderecoId".equals(key)) dto.setTipoEnderecoId((Integer) value);
        });

        return ResponseEntity.ok(service.save(dto));
    }

    // Todos os endereços de uma pessoa
    @GetMapping("/pessoa/{pessoaId}")
    public List<PessoaEnderecoDTO> findByPessoa(@PathVariable Integer pessoaId) {
        return service.findByPessoaId(pessoaId);
    }

    // Todas as pessoas de um endereço
    @GetMapping("/endereco/{enderecoId}")
    public List<PessoaEnderecoDTO> findByEndereco(@PathVariable Integer enderecoId) {
        return service.findByEnderecoId(enderecoId);
    }

    // Todos os registros de um tipo de endereço
    @GetMapping("/tipo/{tipoEnderecoId}")
    public List<PessoaEnderecoDTO> findByTipoEndereco(@PathVariable Integer tipoEnderecoId) {
        return service.findByTipoEnderecoId(tipoEnderecoId);
    }
}

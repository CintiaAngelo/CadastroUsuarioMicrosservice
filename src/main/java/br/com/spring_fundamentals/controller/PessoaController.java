package br.com.spring_fundamentals.controller;

import br.com.spring_fundamentals.dto.PessoaDTO;
import br.com.spring_fundamentals.services.PessoaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaServices pessoaServices;

    @GetMapping("/all")
    public List<PessoaDTO> findAll() {
        return pessoaServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Integer id) {
        PessoaDTO dto = pessoaServices.findById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> save(@RequestBody PessoaDTO pessoa) {
        if (pessoa.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(pessoaServices.save(pessoa));
    }

    @PutMapping
    public ResponseEntity<PessoaDTO> update(@RequestBody PessoaDTO pessoa) {
        if (pessoa.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(pessoaServices.save(pessoa));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        pessoaServices.delete(id);
    }
}

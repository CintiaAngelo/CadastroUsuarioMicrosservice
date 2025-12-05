package br.com.spring_fundamentals.controller;

import br.com.spring_fundamentals.dto.TipoEnderecoDTO;
import br.com.spring_fundamentals.services.TipoEnderecoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-endereco")
public class TipoEnderecoController {

    @Autowired
    private TipoEnderecoServices service;

    @GetMapping("/all")
    public List<TipoEnderecoDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<TipoEnderecoDTO> save(@RequestBody TipoEnderecoDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

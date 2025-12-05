package br.com.spring_fundamentals.controller;

import br.com.spring_fundamentals.dto.TelefoneDTO;
import br.com.spring_fundamentals.services.TelefoneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

    @Autowired
    private TelefoneServices telefoneServices;

    @GetMapping("/all")
    public List<TelefoneDTO> findAll() {
        return telefoneServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDTO> findById(@PathVariable Integer id) {
        TelefoneDTO dto = telefoneServices.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TelefoneDTO> save(@RequestBody TelefoneDTO dto) {
        if (dto.getId() != null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(telefoneServices.save(dto));
    }

    @PutMapping
    public ResponseEntity<TelefoneDTO> update(@RequestBody TelefoneDTO dto) {
        if (dto.getId() == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(telefoneServices.save(dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        telefoneServices.delete(id);
    }
}

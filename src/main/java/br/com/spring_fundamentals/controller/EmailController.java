package br.com.spring_fundamentals.controller;

import br.com.spring_fundamentals.dto.EmailDTO;
import br.com.spring_fundamentals.services.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailServices emailServices;

    @GetMapping("/all")
    public List<EmailDTO> findAll() {
        return emailServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailDTO> findById(@PathVariable Integer id) {
        EmailDTO dto = emailServices.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EmailDTO> save(@RequestBody EmailDTO dto) {
        if (dto.getId() != null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(emailServices.save(dto));
    }

    @PutMapping
    public ResponseEntity<EmailDTO> update(@RequestBody EmailDTO dto) {
        if (dto.getId() == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(emailServices.save(dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmailDTO> patch(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        EmailDTO dto = emailServices.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();

        updates.forEach((key, value) -> {
            if (key.equals("email")) dto.setEmail((String) value);
            if (key.equals("pessoaId")) dto.setIdPessoa((Integer) value);
        });

        return ResponseEntity.ok(emailServices.save(dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        emailServices.delete(id);
    }
}

package br.com.spring_fundamentals.controller;

import br.com.spring_fundamentals.dto.EnderecoDTO;
import br.com.spring_fundamentals.services.EnderecoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoServices enderecoServices;

    @GetMapping("/all")
    public List<EnderecoDTO> findAll() {
        return enderecoServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable Integer id) {
        return enderecoServices.findAll().stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> save(@RequestBody EnderecoDTO dto) {
        if (dto.getId() != null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(enderecoServices.save(dto));
    }

    @PutMapping
    public ResponseEntity<EnderecoDTO> update(@RequestBody EnderecoDTO dto) {
        if (dto.getId() == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(enderecoServices.save(dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EnderecoDTO> patch(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        EnderecoDTO dto = enderecoServices.findAll().stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (dto == null) return ResponseEntity.notFound().build();

        updates.forEach((key, value) -> {
            switch (key) {
                case "rua" -> dto.setRua((String) value);
                case "numero" -> dto.setNumero((Integer) value);
                case "complemento" -> dto.setComplemento((String) value);
                case "cep" -> dto.setCep((String) value);
                case "bairro" -> dto.setBairro((String) value);
                case "tipoEnderecoId" -> dto.setTipoEnderecoId((Integer) value);
            }
        });

        return ResponseEntity.ok(enderecoServices.save(dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        enderecoServices.delete(id);
    }
}

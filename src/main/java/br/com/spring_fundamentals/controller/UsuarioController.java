package br.com.spring_fundamentals.controller;

import br.com.spring_fundamentals.dto.UsuarioDTO;
import br.com.spring_fundamentals.dto.UsuarioSemSenhaDTO;
import br.com.spring_fundamentals.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServices userServices;

    @GetMapping("/all")
    public List<UsuarioSemSenhaDTO> findAll() {
        return userServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioSemSenhaDTO> findById(@PathVariable Integer id) {
        UsuarioSemSenhaDTO dto = userServices.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    // PATCH para atualização
    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioDTO> patchUsuario(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        UsuarioDTO userdto = userServices.findUsuarioDTOById(id);
        if (userdto == null) return ResponseEntity.notFound().build();

        updates.forEach((key, value) -> {
            switch (key) {
                case "nomeusuario" -> userdto.setNomeusuario((String) value);
                case "senha" -> userdto.setSenha((String) value);
            }
        });

        UsuarioDTO updated = userServices.save(userdto);
        return ResponseEntity.ok(updated);
    }



    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioDTO user) {
        if (user.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userServices.save(user));
    }



    @PutMapping
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO user) {
        if (user.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userServices.save(user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userServices.delete(id);
    }
}

package com.solarum.controller;
import com.solarum.model.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@RestController
@RequestMapping(path = "/api/v1/usuario")
public class usuarioController {
    @Autowired
    private com.solarum.Service.usuarioService usuarioService;
    @GetMapping
    public List<usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }
    @PostMapping
    public usuario createUsuario(@RequestBody usuario usuario) {
        return usuarioService.createUsuario(usuario);        
    }
    @DeleteMapping("/usuario/{id}")
    public void deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteUsuario(id);
    }
}

package com.solarum.controller;
import com.solarum.model.tipoUsuario;
import com.solarum.Service.tipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping(path = "/api/v1/tipoUsuario")
public class tipoUsuarioController {
    @Autowired
    private tipoUsuarioService UsuarioService;
    //private com.solarum.Service.tipoUsuarioService UsuarioService;
    @GetMapping
    public List<tipoUsuario> getAllTipoUsuarios() {
        return UsuarioService.getAllTipoUsuarios();
    }
    @PostMapping
    public void saveOrUpdate(@RequestBody tipoUsuario tipoUsuario) {
        UsuarioService.saveOrUpdate(tipoUsuario);
    }
    @DeleteMapping("/{id}")
    public void deleteTipoUsuario(@PathVariable Integer id) {
      UsuarioService.deleteUsuario(id);
    }
}

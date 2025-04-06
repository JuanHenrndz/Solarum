package com.solarum.controller;
import com.solarum.model.validacion;
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
@RequestMapping(path = "/api/v1/validacion")
public class validacionController {
    @Autowired
    private com.solarum.Service.validacionService validacionService;
    @GetMapping
    public List<validacion> getAllValidaciones() {
        return validacionService.getAllValidaciones();
    }
    @PostMapping
    public void saveOrUpdate(@RequestBody validacion validacion) {
        validacionService.saveOrUpdate(validacion);
    }
    @DeleteMapping("/{id}")
    public void deleteValidacion(@PathVariable Integer id) {
        validacionService.delete(id);
    }
}

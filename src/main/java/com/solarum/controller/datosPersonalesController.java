package com.solarum.controller;
import com.solarum.model.datosPersonales;
import com.solarum.Service.datosPersonalesService;
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
@RequestMapping(path = "/api/v1/datosPersonales")
public class datosPersonalesController {
    @Autowired
    private datosPersonalesService datosPersonalesService;
    @GetMapping
    public List<datosPersonales> getAllDatosPersonales() {
        return datosPersonalesService.getAllDatosPersonales();
    }
    @PostMapping
    public void saveOrUpdate(@RequestBody datosPersonales datosPersonales) {
        datosPersonalesService.saveOrUpdate(datosPersonales);
    }
    @DeleteMapping("/{id}")
    public void deleteDatosPersonales(@PathVariable Integer id) {
        datosPersonalesService.delete(id);
    }
}

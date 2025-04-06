package com.solarum.controller;
import com.solarum.model.consumoEnergia;
import com.solarum.Service.consumoEnergiaService;
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
@RequestMapping(path = "/api/v1/consumoEnergia")
public class consumoEnergiaController {
    @Autowired
    private consumoEnergiaService consumoEnergiaService;
    @GetMapping
    public List<consumoEnergia> getAllConsumoEnergia() {
        return consumoEnergiaService.getAllConsumoEnergias();
    }
    @PostMapping
    public void saveOrUpdate(@RequestBody consumoEnergia consumoEnergia) {
        consumoEnergiaService.saveOrUpdate(consumoEnergia);
    }
    @DeleteMapping("/{id}")
    public void deleteConsumoEnergia(@PathVariable Integer id) {
        consumoEnergiaService.delete(id);
    }
}

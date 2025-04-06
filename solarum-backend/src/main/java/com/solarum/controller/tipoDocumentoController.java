package com.solarum.controller;
import com.solarum.model.tipoDocumento;
import com.solarum.Service.tipoDocumentoService;
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
@RequestMapping(path = "/api/v1/tipoDocumento")
public class tipoDocumentoController {
    @Autowired
    private tipoDocumentoService tipoDocumentoService;
    @GetMapping
    public List<tipoDocumento> getAllTipoDocumentos() {
        return tipoDocumentoService.getAllTipoDocumentos();
    }
    @PostMapping
    public void saveOrUpdate(@RequestBody tipoDocumento tipoDocumento) {
        tipoDocumentoService.saveOrUpdate(tipoDocumento);
    }
    @DeleteMapping("/{id}")
    public void deleteTipoDocumento(@PathVariable Integer id) {
        tipoDocumentoService.delete(id);
    }
}

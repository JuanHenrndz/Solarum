package com.solarum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "Bienvenido a la API de Solarum. Los endpoints disponibles son:\n" +
               "- /api/v1/usuario\n" +
               "- /api/v1/datosPersonales\n" +
               "- /api/v1/tipoUsuario\n" +
               "- /api/v1/tipoDocumento\n" +
               "- /api/v1/consumoEnergia\n" +
               "- /api/v1/validacion";
    }
} 
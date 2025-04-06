package com.solarum.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Data;
@Entity
@Table(name = "tipodocumento")
@Data
public class tipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )//agregado para probar por error de postman
    @Column(name = "idtipodocumento")
    private Integer idTipoDocumento;
    @Column(name = "nombre_tipo_documento")
    private String nombreTipoDocumento;
}


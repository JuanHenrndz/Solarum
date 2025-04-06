package com.solarum.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Data;
@Data
@Entity
// @Table(name = "datosPersonales", schema = "solarum")
@Table(name = "datospersonales")
public class datosPersonales {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddatos_personales")
    private Integer idDatosPersonales;
    @Column(name = "nombre_completo")
    private String nombre_Completo;
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @ManyToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    private usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idtipodocumento", referencedColumnName = "idtipodocumento")
    private tipoDocumento tipoDocumento;
}

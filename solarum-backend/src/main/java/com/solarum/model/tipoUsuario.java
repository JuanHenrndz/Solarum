package com.solarum.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Data;
@Data
@Entity
// @Table(name = "tipousuario", schema = "solarum")
@Table(name = "tipousuario")
public class tipoUsuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//agregado para probar por error de postman
  @Column(name = "idtipousuario")
  private Integer idTipoUsuario;
  @Column(name = "nombre_tipo_usuario")
  private String nombreTipoUsuario;
  @Column(name = "estado_tipo_usuario")
  private Boolean estadoTipoUsuario;
}

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
// @Table(name = "validacion", schema = "solarum")
@Table(name = "validacion")
public class validacion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idvalidacion")
  private Integer idValidacion;
  @Column(name = "confirmacion")
  private Boolean confirmacion;
  @ManyToOne
  @JoinColumn(name = "idtipousuario", referencedColumnName = "idtipousuario")
  private tipoUsuario tipoUsuario;
  @ManyToOne
  @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
  private usuario usuario;
}

package com.solarum.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Data;
@Data
@Entity
// @Table(name = "usuario", schema = "solarum")
@Table(name = "usuario")
public class usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idusuario;
  private String email;
  private String pass_user;
  private Boolean estado_user;
}

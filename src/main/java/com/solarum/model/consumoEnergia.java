package com.solarum.model;
import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Table(name = "consumoenergia")
@Data
public class consumoEnergia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idconsumo_energia")
    private Integer idConsumoEnergia;
    @Column(name = "consumo_mensual_kw")
    private BigDecimal consumoMensualKw;
    @Column(name = "paneles_requeridos")
    private Integer panelesRequeridos;
    @ManyToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    private usuario usuario;
}

package com.solarum.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.solarum.model.consumoEnergia;
@Repository
public interface consumoEnergiaRepo extends JpaRepository<consumoEnergia, Integer> {
}

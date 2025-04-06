package com.solarum.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.solarum.model.datosPersonales;
@Repository
public interface datosPersonalesRepo extends JpaRepository<datosPersonales, Integer> {
}

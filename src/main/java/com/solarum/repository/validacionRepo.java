package com.solarum.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.solarum.model.validacion;
@Repository
public interface validacionRepo extends JpaRepository<validacion, Integer> {
}

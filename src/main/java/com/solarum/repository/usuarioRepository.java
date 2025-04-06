package com.solarum.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.solarum.model.usuario;
@Repository
public interface usuarioRepository extends JpaRepository<usuario, Integer> {
}

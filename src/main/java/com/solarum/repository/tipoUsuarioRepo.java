package com.solarum.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.solarum.model.tipoUsuario;
@Repository
public interface tipoUsuarioRepo extends JpaRepository<tipoUsuario, Integer> {
}

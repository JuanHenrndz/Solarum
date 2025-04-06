package com.solarum.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.solarum.model.tipoDocumento;
@Repository
public interface tipoDocumentoRepo extends JpaRepository<tipoDocumento, Integer> {
}

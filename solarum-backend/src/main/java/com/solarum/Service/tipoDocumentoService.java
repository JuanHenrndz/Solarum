package com.solarum.Service;
import org.springframework.stereotype.Service;
import com.solarum.model.tipoDocumento;
import com.solarum.repository.tipoDocumentoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
@Service
public class tipoDocumentoService {
  @Autowired
  private tipoDocumentoRepo tipoDocumentoRepository;
  public List<tipoDocumento> getAllTipoDocumentos() {
    return tipoDocumentoRepository.findAll();
  }
  public Optional<tipoDocumento> getAllTipoDocumentoById(Integer id) {
    return tipoDocumentoRepository.findById(id);
  }
  public void saveOrUpdate(tipoDocumento tipoDocumento) {
    tipoDocumentoRepository.save(tipoDocumento);
  }
  public void delete(Integer id) {
    tipoDocumentoRepository.deleteById(id);
  }
  public tipoDocumento saveTipoDocumento(tipoDocumento tipoDocumento) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveTipoDocumento'");
  }
}

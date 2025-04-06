package com.solarum.Service;
import org.springframework.stereotype.Service;
import com.solarum.model.validacion;
import com.solarum.repository.validacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import java.lang.Integer;
@Service
public class validacionService {
  @Autowired
  private validacionRepo validacionRepository;
  public List<validacion> getAllValidaciones() {
    return validacionRepository.findAll();
  }
  public Optional<validacion> getValidacionById(Integer id) {
    return validacionRepository.findById(id);
  }
  public void saveOrUpdate(validacion validacion) {
    validacionRepository.save(validacion);
  }
  public void deletevalidacion(Integer id) {
    validacionRepository.deleteById(id);
  }
  public validacion saveUsuario(validacion validacion) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveUsuario'");
  }
  public void delete(Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }
}

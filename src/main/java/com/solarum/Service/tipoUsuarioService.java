package com.solarum.Service;
import org.springframework.stereotype.Service;
import com.solarum.model.tipoUsuario;
import com.solarum.repository.tipoUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
@Service
public class tipoUsuarioService {
  @Autowired
  private tipoUsuarioRepo tipoUsuarioRepository;
  public List<tipoUsuario> getAllTipoUsuarios() {
    return tipoUsuarioRepository.findAll();
  }
  public Optional<tipoUsuario> getTipoUsuarioById(Integer id) {
    return tipoUsuarioRepository.findById(id);
  }
  public void saveOrUpdate(tipoUsuario tipoUsuario) {
    tipoUsuarioRepository.save(tipoUsuario);
  }
  public void delete(Integer id) {
    tipoUsuarioRepository.deleteById(id);
  }
  public void deleteUsuario(Integer id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteUsuario'");
  }
}

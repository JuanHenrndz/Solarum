package com.solarum.Service;
import org.springframework.stereotype.Service;
import com.solarum.model.datosPersonales;
import com.solarum.repository.datosPersonalesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
@Service
public class datosPersonalesService {
  @Autowired
  private datosPersonalesRepo datosPersonalesRepository;
  public List<datosPersonales> getAllDatosPersonales() {
    return datosPersonalesRepository.findAll();
  }
  public Optional<datosPersonales> getDatosPersonalesById(Integer id) {
    return datosPersonalesRepository.findById(id);
  }
  public void saveOrUpdate(datosPersonales datosPersonales) {
    datosPersonalesRepository.save(datosPersonales);
  }
  public void delete(Integer id) {
    datosPersonalesRepository.deleteById(id);
  }
  public datosPersonales saveDatosPersonales(datosPersonales datosPersonales) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveDatosPersonales'");
  }
}

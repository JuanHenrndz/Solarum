package com.solarum.Service;
import org.springframework.stereotype.Service;
import com.solarum.model.consumoEnergia;
import com.solarum.repository.consumoEnergiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
@Service
public class consumoEnergiaService {
  @Autowired
  private consumoEnergiaRepo consumoEnergiaRepository;
  public List<consumoEnergia> getAllConsumoEnergias() {
    return consumoEnergiaRepository.findAll();
  }
  public Optional<consumoEnergia> getConsumoEnergiaById(Integer id) {
    return consumoEnergiaRepository.findById(id);
  }
  public void saveOrUpdate(consumoEnergia consumoEnergia) {
    consumoEnergiaRepository.save(consumoEnergia);
  }
  public void delete(Integer id) {
    consumoEnergiaRepository.deleteById(id);
  }
  public consumoEnergia saveConsumoEnergia(consumoEnergia consumoEnergia) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'saveConsumoEnergia'");
  }
}

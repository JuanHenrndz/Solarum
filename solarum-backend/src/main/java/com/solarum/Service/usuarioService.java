package com.solarum.Service;
import org.springframework.stereotype.Service;
//import com.solarum.model.tipoUsuario;
import com.solarum.model.usuario;
import com.solarum.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class usuarioService {
    @Autowired
    private usuarioRepository usuarioRepository;
    public List<usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
    public void deleteUsuario(Integer id) {
      usuarioRepository.deleteById(id);
    } 
    public usuario createUsuario(usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}

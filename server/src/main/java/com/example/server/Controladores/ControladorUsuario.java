package com.example.server.Controladores;
import com.example.server.Modelos.Usuario;
import com.example.server.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
//-----------
public class ControladorUsuario {
    @Autowired
    private RepositorioUsuario miRepositorioUsuario;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crear")
    public Usuario create(@RequestBody Usuario infoUsuario) {
        infoUsuario.setCedula(infoUsuario.getCedula());
        return this.miRepositorioUsuario.save(infoUsuario);
    }
    //------------
    @GetMapping("/listar")
    public List<Usuario> index() {
        return this.miRepositorioUsuario.findAll();
    }
    //--------------------
    @GetMapping("/mostrar/{id}")
    public Usuario show(@PathVariable String id) {
        Usuario UsuarioActual = this.miRepositorioUsuario.findById(id).orElseThrow(RuntimeException::new);
        return UsuarioActual;
    }
    //---------------------
    @PutMapping("/actualizar/{id}")
    public Usuario update(@PathVariable String id, @RequestBody Usuario infoUsuario) {
        Usuario UsuarioActual = this.miRepositorioUsuario.findById(id).orElseThrow(RuntimeException::new);
        if (UsuarioActual != null) {
            UsuarioActual.setCedula(infoUsuario.getCedula());
            UsuarioActual.setNombre(infoUsuario.getNombre());
            UsuarioActual.setEmail(infoUsuario.getEmail());
            UsuarioActual.setAnoNacimiento(infoUsuario.getAnoNacimiento());
            return this.miRepositorioUsuario.save(UsuarioActual);
        } else {
            return null;
        }
    }
    //--------------
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable String id) {
        Usuario UsuarioActual = this.miRepositorioUsuario
                .findById(id)
                .orElseThrow(RuntimeException::new);
        if (UsuarioActual != null) {
            this.miRepositorioUsuario.delete(UsuarioActual);
        }
    }
}

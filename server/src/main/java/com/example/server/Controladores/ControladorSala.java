package com.example.server.Controladores;
import com.example.server.Modelos.Sala;
import com.example.server.Repositorios.RepositorioSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
@RequestMapping("/salas")
//-----------
public class ControladorSala {
    @Autowired
    private RepositorioSala miRepositorioSala;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crear")
    public Sala create(@RequestBody Sala infoSala) {
        infoSala.setNombre(infoSala.getNombre());
        return this.miRepositorioSala.save(infoSala);
    }

    //------------
    @GetMapping("/listar")
    public List<Sala> index() {
        return this.miRepositorioSala.findAll();
    }
    //--------------------
    @GetMapping("/mostrar/{id}")
    public Sala show(@PathVariable String id) {
        Sala SalaActual = this.miRepositorioSala.findById(id).orElseThrow(RuntimeException::new);
        return SalaActual;
    }
    //---------------------
    @PutMapping("/actualizar/{id}")
    public Sala update(@PathVariable String id, @RequestBody Sala infoSala) {
        Sala SalaActual = this.miRepositorioSala.findById(id).orElseThrow(RuntimeException::new);
        if (SalaActual != null) {
            SalaActual.setNombre(infoSala.getNombre());
            SalaActual.setEfectosEspeciales(infoSala.getEfectosEspeciales());
            return this.miRepositorioSala.save(SalaActual);
        } else {
            return null;
        }
    }
    //--------------
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable String id) {
        Sala SalaActual = this.miRepositorioSala
                .findById(id)
                .orElseThrow(RuntimeException::new);
        if (SalaActual != null) {
            this.miRepositorioSala.delete(SalaActual);
        }
    }
}


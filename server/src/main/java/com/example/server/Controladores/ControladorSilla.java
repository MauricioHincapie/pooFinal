package com.example.server.Controladores;

import com.example.server.Modelos.Pelicula;
import com.example.server.Modelos.Silla;
import com.example.server.Modelos.Sala;

import com.example.server.Repositorios.RepositorioSilla;
import com.example.server.Repositorios.RepositorioSala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
@RequestMapping("/sillas")
//-----------
public class ControladorSilla {
    @Autowired
    private RepositorioSilla miRepositorioSilla;

    @Autowired
    private RepositorioSala miRepositorioSala;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crear/sala/{id_Sala}")
    public Silla create(@RequestBody Silla infoSilla,@PathVariable String id_Sala) {

        Sala salaActual=this.miRepositorioSala.findById(id_Sala).orElseThrow(RuntimeException::new);

        infoSilla.setLetra(infoSilla.getLetra());
        infoSilla.setSala(salaActual);
        return this.miRepositorioSilla.save(infoSilla);
    }
//--------------------------------------------------------------------------------------
    @GetMapping("/listar")
    public List<Silla> index() {
        return this.miRepositorioSilla.findAll();
    }
//---------------------------------------------------------------------------------------
    @GetMapping("/mostrar/{id}")
    public Silla show(@PathVariable String id) {
        Silla SillaActual = this.miRepositorioSilla.findById(id).orElseThrow(RuntimeException::new);
        return SillaActual;
    }
//--------------------------------------------------------------------------------------
    @PutMapping("/actualizar/{id}/sala/{id_Sala}")
    public Silla update(@PathVariable String id, @RequestBody Silla infoSilla,
                        @PathVariable String id_Sala) {
        Silla SillaActual = this.miRepositorioSilla.findById(id).orElseThrow(RuntimeException::new);
        if (SillaActual != null) {
            Sala salaActual=this.miRepositorioSala.findById(id_Sala).orElseThrow(RuntimeException::new);

            SillaActual.setLetra(infoSilla.getLetra());
            SillaActual.setNumero(infoSilla.getNumero());
            SillaActual.setSala(salaActual);

            return this.miRepositorioSilla.save(SillaActual);
        } else {
            return null;
        }
    }
    //--------------
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable String id) {
        Silla SillaActual = this.miRepositorioSilla
                .findById(id)
                .orElseThrow(RuntimeException::new);
        if (SillaActual != null) {
            this.miRepositorioSilla.delete(SillaActual);
        }
    }
}



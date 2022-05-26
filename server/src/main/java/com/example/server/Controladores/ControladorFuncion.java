package com.example.server.Controladores;
import com.example.server.Modelos.Funcion;
import com.example.server.Modelos.Pelicula;
import com.example.server.Modelos.Sala;

import com.example.server.Repositorios.RepositorioFuncion;
import com.example.server.Repositorios.RepositorioPelicula;
import com.example.server.Repositorios.RepositorioSala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
@RequestMapping("/funciones")
//-----------
public class ControladorFuncion {
    @Autowired
    private RepositorioFuncion miRepositorioFuncion;
    @Autowired
    private RepositorioSala miRepositorioSala;
    @Autowired
    private RepositorioPelicula miRepositorioPelicula;

//---------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crear/pelicula/{id_Pelicula}/sala/{id_Sala}")
    public Funcion create(@RequestBody Funcion infoFuncion, @PathVariable String id_Pelicula, @PathVariable String id_Sala) {

        Pelicula peliculaActual=this.miRepositorioPelicula.findById(id_Pelicula).orElseThrow(RuntimeException::new);
        Sala salaActual=this.miRepositorioSala.findById(id_Sala).orElseThrow(RuntimeException::new);

        infoFuncion.setHora(infoFuncion.getHora());
        infoFuncion.setPelicula(peliculaActual);
        infoFuncion.setSala(salaActual);

        return this.miRepositorioFuncion.save(infoFuncion);
    }
//------------
    @GetMapping("/listar")
    public List<Funcion> index() {
        return this.miRepositorioFuncion.findAll();
    }
//--------------------
    @GetMapping("/mostrar/{id}")
    public Funcion show(@PathVariable String id) {
        Funcion FuncionActual = this.miRepositorioFuncion.findById(id).orElseThrow(RuntimeException::new);
        return FuncionActual;
    }
//---------------------
    @PutMapping("/actualizar/{id}/pelicula/{id_Pelicula}/sala/{id_Sala}")
    public Funcion update(@PathVariable String id, @RequestBody Funcion infoFuncion,
                          @PathVariable String id_Pelicula, @PathVariable String id_Sala) {

        Funcion FuncionActual = this.miRepositorioFuncion.findById(id).orElseThrow(RuntimeException::new);
        if (FuncionActual != null) {
            Pelicula peliculaActual=this.miRepositorioPelicula.findById(id_Pelicula).orElseThrow(RuntimeException::new);
            Sala salaActual=this.miRepositorioSala.findById(id_Sala).orElseThrow(RuntimeException::new);

            FuncionActual.setHora(infoFuncion.getHora());
            FuncionActual.setDia(infoFuncion.getDia());
            FuncionActual.setMes(infoFuncion.getMes());
            FuncionActual.setAno(infoFuncion.getAno());
            FuncionActual.setSala(salaActual);
            FuncionActual.setPelicula(peliculaActual);

            return this.miRepositorioFuncion.save(FuncionActual);
        } else {
            return null;
        }
    }
//--------------
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable String id) {
        Funcion FuncionActual = this.miRepositorioFuncion
                .findById(id)
                .orElseThrow(RuntimeException::new);
        if (FuncionActual != null) {
            this.miRepositorioFuncion.delete(FuncionActual);
        }
    }
}


package com.example.server.Controladores;
import com.example.server.Modelos.Pelicula;
import com.example.server.Repositorios.RepositorioPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
@RequestMapping("/peliculas")
//-----------
public class ControladorPelicula {
    @Autowired
    private RepositorioPelicula miRepositorioPelicula;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crear")
    public Pelicula create(@RequestBody Pelicula infoPelicula) {
        infoPelicula.setNombre(infoPelicula.getNombre());
        return this.miRepositorioPelicula.save(infoPelicula);
    }

    //------------
    @GetMapping("/listar")
    public List<Pelicula> index() {
        return this.miRepositorioPelicula.findAll();
    }


    //--------------------
    @GetMapping("/mostrar/{id}")
    public Pelicula show(@PathVariable String id) {
        Pelicula PeliculaActual = this.miRepositorioPelicula.findById(id).orElseThrow(RuntimeException::new);
        return PeliculaActual;
    }

    //---------------------
    @PutMapping("/actualizar/{id}")
    public Pelicula update(@PathVariable String id, @RequestBody Pelicula infoPelicula) {
        Pelicula PeliculaActual = this.miRepositorioPelicula.findById(id).orElseThrow(RuntimeException::new);
        if (PeliculaActual != null) {
            PeliculaActual.setNombre(infoPelicula.getNombre());
            PeliculaActual.setAno(infoPelicula.getAno());
            PeliculaActual.setTipo(infoPelicula.getTipo());
            return this.miRepositorioPelicula.save(PeliculaActual);
        } else {
            return null;
        }
    }

    //--------------
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable String id) {
        Pelicula PeliculaActual = this.miRepositorioPelicula
                .findById(id)
                .orElseThrow(RuntimeException::new);
        if (PeliculaActual != null) {
            this.miRepositorioPelicula.delete(PeliculaActual);
        }
    }
}

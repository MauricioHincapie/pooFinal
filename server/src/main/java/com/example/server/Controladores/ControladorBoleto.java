package com.example.server.Controladores;
import com.example.server.Modelos.*;

import com.example.server.Repositorios.RepositorioBoleto;
import com.example.server.Repositorios.RepositorioUsuario;
import com.example.server.Repositorios.RepositorioFuncion;
import com.example.server.Repositorios.RepositorioSilla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
@RequestMapping("/boletos")
//-----------
public class ControladorBoleto {
    @Autowired
    private RepositorioBoleto miRepositorioBoleto;

    @Autowired
    private RepositorioUsuario miRepositorioUsuario;

    @Autowired
    private RepositorioFuncion miRepositorioFuncion;

    @Autowired
    private RepositorioSilla miRepositorioSilla;

//-----------------------------------------------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crear/usuario/{id_Usuario}/funcion/{id_Funcion}/silla/{id_silla}")

    public Boleto create(@RequestBody Boleto infoBoleto, @PathVariable String id_Usuario,
                         @PathVariable String id_Funcion, @PathVariable String id_silla ) {

        Usuario usuarioActual=this.miRepositorioUsuario.findById(id_Usuario).orElseThrow(RuntimeException::new);
        Funcion funcionActual=this.miRepositorioFuncion.findById(id_Funcion).orElseThrow(RuntimeException::new);
        Silla   sillaActual  =this.miRepositorioSilla.findById(id_silla).orElseThrow(RuntimeException::new);

        infoBoleto.setValor(infoBoleto.getValor());
        infoBoleto.setUsuario(usuarioActual);
        infoBoleto.setFuncion(funcionActual);
        infoBoleto.setSilla(sillaActual);

        return this.miRepositorioBoleto.save(infoBoleto);
    }

    //-----------------------------------------------------------------------------
    @GetMapping("/listar")
    public List<Boleto> index() {
        return this.miRepositorioBoleto.findAll();
    }
    //---------------------------------------------------------------------------------
    @GetMapping("/mostrar/{id}")
    public Boleto show(@PathVariable String id) {
        Boleto BoletoActual = this.miRepositorioBoleto.findById(id).orElseThrow(RuntimeException::new);
        return BoletoActual;
    }
    //-------------------------------------------------------------------------------------
    @PutMapping("/actualizar/{id}/usuario/{id_Usuario}/funcion/{id_Funcion}/silla/{id_silla}")
    public Boleto update(@PathVariable String id, @RequestBody Boleto infoBoleto, @PathVariable String id_Usuario,
                         @PathVariable String id_Funcion, @PathVariable String id_silla ) {

        Boleto BoletoActual = this.miRepositorioBoleto.findById(id).orElseThrow(RuntimeException::new);
        if (BoletoActual != null) {
            Usuario usuarioActual=this.miRepositorioUsuario.findById(id_Usuario).orElseThrow(RuntimeException::new);
            Funcion funcionActual=this.miRepositorioFuncion.findById(id_Funcion).orElseThrow(RuntimeException::new);
            Silla   sillaActual  =this.miRepositorioSilla.findById(id_silla).orElseThrow(RuntimeException::new);


            BoletoActual.setValor(infoBoleto.getValor());
            BoletoActual.setTipo(infoBoleto.getTipo());
            BoletoActual.setUsuario(usuarioActual);
            BoletoActual.setFuncion(funcionActual);
            BoletoActual.setSilla(sillaActual);

            return this.miRepositorioBoleto.save(BoletoActual);
        } else {
            return null;
        }
    }
    //--------------
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable String id) {
        Boleto BoletoActual = this.miRepositorioBoleto
                .findById(id)
                .orElseThrow(RuntimeException::new);
        if (BoletoActual != null) {
            this.miRepositorioBoleto.delete(BoletoActual);
        }
    }
}


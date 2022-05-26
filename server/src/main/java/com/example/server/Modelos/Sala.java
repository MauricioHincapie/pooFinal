package com.example.server.Modelos;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class Sala {
    @Id
    private String _id;
    private String Nombre;
    private boolean EfectosEspeciales;
     //----------------------
    public Sala(String Nombre, boolean EfectosEspeciales) {
        this.Nombre = Nombre;
        this.EfectosEspeciales = EfectosEspeciales;
    }
    //------------------------
    public String get_id() {  return _id; }
    //----------------------------
    public String getNombre() { return Nombre; }
    //-------------------------------
    public void setNombre(String Nombre) { this.Nombre = Nombre;}
    //---------------------------
    public boolean getEfectosEspeciales() {  return EfectosEspeciales; }
    //----------------------------
    public void setEfectosEspeciaLE(boolean EfectosEspeciales) { this.EfectosEspeciales = EfectosEspeciales; }
  }
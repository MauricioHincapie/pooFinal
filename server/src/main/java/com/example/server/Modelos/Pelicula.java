package com.example.server.Modelos;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class Pelicula {
    @Id
    private String _id;
    private String Nombre;
    private int Ano;
    private String Tipo;
//----------------------
    public Pelicula(String Nombre, int Ano, String Tipo) {
        this.Nombre = Nombre;
        this.Ano = Ano;
        this.Tipo = Tipo;
    }
//------------------------
    public String get_id() {  return _id; }
//----------------------------
    public String getNombre() { return Nombre; }
//-------------------------------
    public void setNombre(String Nombre) { this.Nombre = Nombre;}
//---------------------------
    public int getAno() {  return Ano; }
//----------------------------
    public void setAno(int Ano) { this.Ano = Ano; }
//-------------------------------
    public String getTipo() { return Tipo; }
//---------------------------------
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
}
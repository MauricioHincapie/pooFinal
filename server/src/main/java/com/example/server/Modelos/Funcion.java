package com.example.server.Modelos;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class Funcion {
    @Id
    private String _id;
    private int  Hora;
    private int Dia;
    private int Mes;
    private int Ano;

    @DBRef
    private Pelicula pelicula;

    @DBRef
    private Sala sala;

    //----------------------
    public Funcion (int Hora, int Dia, int Mes,int Ano) {
        this.Hora = Hora;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Ano = Ano;
    }
    //------------------------
    public String get_id() {  return _id; }
    //----------------------------
    public int getHora() { return Hora; }
    //-------------------------------
    public void setHora(int Hora) { this.Hora = Hora;}
    //---------------------------
    public int getDia() {  return Dia; }
    //----------------------------
    public void setDia(int Dia) { this.Dia = Dia; }
    //-------------------------------
    public int getMes() { return Mes; }
    //---------------------------------
    public void setMes(int Mes) { this.Mes = Mes;}
    //-------------------------------
    public int getAno() { return Ano; }
    //---------------------------------
    public void setAno(int Ano) {this.Ano = Ano; }
    //------------
    public Pelicula getPelicula(){ return pelicula; }
    //---------------
    public void setPelicula(Pelicula pelicula){ this.pelicula = pelicula; }
    //------------------
    public Sala getSala(){ return sala; }
    //--------------------
    public  void  setSala(Sala sala){ this.sala = sala;}
}

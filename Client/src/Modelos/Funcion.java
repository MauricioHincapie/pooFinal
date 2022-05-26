package Modelos;

import java.util.LinkedList;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

public class Funcion {    
    String _id;
    int Hora;
    int Dia;
    int Mes;
    int Ano;
    LinkedList<Boleto> MisBoletos;
    Pelicula MiPelicula;
    Sala MiSala;

//----------------------------------------------
    public Funcion(int Hora,int Dia, int Mes,int Ano) {
        this.Hora = Hora;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Ano = Ano;
    }
//-------------------------------------------------
    public Funcion() {}
 //---------------------------------------------------   
    public String getId() { return _id;}
//--------------------------------------------------------
    public void setId(String _id) {this._id= _id;}
 //---------------------------------------------------   
    public Pelicula getMiPelicula() { return MiPelicula;}
//--------------------------------------------------------
    public void setMiSala(Pelicula MiPelicula) {this.MiPelicula= MiPelicula;}
//---------------------------------------------------   
    public Sala getMiSala() { return MiSala;}
//--------------------------------------------------------
    public void setMiSala(Sala MiSala) {this.MiSala= MiSala;}

//---------------------------------------------------   
    public LinkedList<Boleto> getMisBoletos() { return MisBoletos;}
//--------------------------------------------------------
    public void setMisBoletos(LinkedList<Boleto> MisBoletos) 
    {this.MisBoletos = MisBoletos;}
//------------------------------------------------------
    public double getHora() { return Hora;}
//--------------------------------------------------------
    public void setHora(int Hora) {this.Hora= Hora;}
//------------------------------------------------------
    public int getDia() { return Dia;}
//--------------------------------------------------------
    public void setDia(int Dia) {this.Dia= Dia;}
//------------------------------------------------------
    public int getMes() { return Mes;}
//--------------------------------------------------------
    public void setMes(int Mes) {this.Mes= Mes;}
//------------------------------------------------------
   public int getAno() { return Ano;}
//--------------------------------------------------------
    public void setAno(int Ano) {this.Ano= Ano;}
//------------------------------------------------------

    public JSONObject toJSON() {
        JSONObject respuesta = new JSONObject();
        respuesta.put("Hora", this.getHora());
        respuesta.put("Dia", this.getDia());       
        respuesta.put("Hora", this.getMes());
        respuesta.put("Dia", this.getAno());       

        return respuesta;
    }    
}

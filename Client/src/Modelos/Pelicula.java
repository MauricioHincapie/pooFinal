package Modelos;

import java.util.LinkedList;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

public class Pelicula {    
    String _id;
    String Nombre;
    int Ano;
    String Tipo;
    LinkedList<Funcion> MisFunciones;

//----------------------------------------------
    public Pelicula(String Nombre, int Ano, String Tipo) {
        this.Nombre = Nombre;
        this.Ano = Ano;
        this.Tipo = Tipo;
    }
//-------------------------------------------------
    public Pelicula() {}
 //---------------------------------------------------   
    public String getId() { return _id;}
//--------------------------------------------------------
    public void setId(String _id) {this._id= _id;}
//---------------------------------------------------   
    public LinkedList<Funcion> getMisFunciones() { return MisFunciones;}
//--------------------------------------------------------
    public void setMisFunciones(LinkedList<Funcion> MisFunciones) 
    {this.MisFunciones= MisFunciones;}
//------------------------------------------------------
    public String getNombre() { return Nombre;}
//--------------------------------------------------------
    public void setNombre(String Nombre) {this.Nombre= Nombre;}
//------------------------------------------------------
    public int getAno() { return Ano;}
//--------------------------------------------------------
    public void setAno(int Ano) {this.Ano= Ano;}
//------------------------------------------------------
    public String getTipo() { return Tipo;}
//--------------------------------------------------------
    public void setTipo(String Tipo) {this.Tipo= Tipo;}
//------------------------------------------------------
    public JSONObject toJSON() {
        JSONObject respuesta = new JSONObject();
        respuesta.put("Nombre", this.getNombre());
        respuesta.put("Ano", this.getAno());
        respuesta.put("Tipo", this.getTipo());       
        return respuesta;
    }    
}

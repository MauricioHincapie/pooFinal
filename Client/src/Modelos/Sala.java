package Modelos;

import java.util.LinkedList;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

public class Sala {    
    String _id;
    String Nombre;
    boolean EfectosEspeciales;
    LinkedList<Funcion> MisFunciones;
    LinkedList<Silla> MisSillas;

//----------------------------------------------
    public Sala(String Nombre, boolean EfectosEspeciales) {
        this.Nombre = Nombre;
        this.EfectosEspeciales = EfectosEspeciales;
    }
//-------------------------------------------------
    public Sala() {}
 //---------------------------------------------------   
    public String getId() { return _id;}
//--------------------------------------------------------
    public void setId(String _id) {this._id= _id;}
//---------------------------------------------------   
    public LinkedList<Funcion> getMisFunciones() { return MisFunciones;}
//--------------------------------------------------------
    public void setMisFunciones(LinkedList<Funcion> MisFunciones) 
    {this.MisFunciones= MisFunciones;}    
//---------------------------------------------------   
    public LinkedList<Silla> getMisSillas() { return MisSillas;}
//--------------------------------------------------------
    public void setMisSillas(LinkedList<Silla> MisSillas) 
    {this.MisSillas= MisSillas;}    
//------------------------------------------------------
    public String getNombre() { return Nombre;}
//--------------------------------------------------------
    public void setNombre(String Nombre) {this.Nombre= Nombre;}
//------------------------------------------------------
    public boolean getEfectosEspeciales() { return EfectosEspeciales;}
//--------------------------------------------------------
    public void setEfectosEspeciales(boolean EfectosEspeciales) {
        this.EfectosEspeciales= EfectosEspeciales;}
//------------------------------------------------------
    public JSONObject toJSON() {
        JSONObject respuesta = new JSONObject();
        respuesta.put("Nombre", this.getNombre());
        respuesta.put("EfectosEspeciales", this.getEfectosEspeciales());       
        return respuesta;
    }    
}

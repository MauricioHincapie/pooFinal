package Modelos;

import java.util.LinkedList;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

public class Usuario {    
    String _id;
    String Nombre;
    String Cedula;
    String Email;
    int AnoNacimiento;
    LinkedList<Boleto> MisBoletos;
//----------------------------------------------
    public Usuario(String Nombre,String Cedula,String Email,int AnoNacimiento) {
        this.Nombre = Nombre;
        this.Cedula=Cedula;
        this.Email=Email;
        this.AnoNacimiento = AnoNacimiento;
    }
//-------------------------------------------------
    public Usuario() {}
 //---------------------------------------------------   
    public String getId() { return _id;}
//--------------------------------------------------------
    public void setId(String _id) {this._id= _id;}
//---------------------------------------------------   
    public LinkedList<Boleto> getMisBoletos() { return MisBoletos;}
//--------------------------------------------------------
    public void setMisBoletos(LinkedList<Boleto> MisBoletos) 
    {this.MisBoletos= MisBoletos;}
//------------------------------------------------------
    public String getNombre() { return Nombre;}
//--------------------------------------------------------
    public void setNombre(String Nombre) {this.Nombre= Nombre;}
//---------------------------------------------------------------------
    public String getCedula() { return Cedula;}
//--------------------------------------------------------
    public void setCedula(String Cedula) {this.Cedula= Cedula;}
    //------------------------------------------------------------
    public String getEmail() { return Email;}
//--------------------------------------------------------
    public void setEmail(String Email) {this.Email= Email;}
//------------------------------------------------------
    public int getAnoNacimiento() { return AnoNacimiento;}
//--------------------------------------------------------
    public void setAnoNacimiento(int AnoNacimiento) {
        this.AnoNacimiento= AnoNacimiento;}
//------------------------------------------------------
    public JSONObject toJSON() {
        JSONObject respuesta = new JSONObject();
        respuesta.put("Nombre", this.getNombre());
        respuesta.put("Cedula", this.getCedula());
        respuesta.put("Email", this.getEmail());
        respuesta.put("AnoNacimiento", this.getAnoNacimiento());       
        return respuesta;
    }    
}

package Modelos;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

public class Boleto {    
    String _id;
    double Valor;
    String Tipo;
    Funcion MiFuncion;
    Silla MiSilla;
//----------------------------------------------
    public Boleto(double Valor, String Tipo) {
        this.Valor = Valor;
        this.Tipo = Tipo;
    }
//-------------------------------------------------
    public Boleto() {}
 //---------------------------------------------------   
    public String getId() { return _id;}
//--------------------------------------------------------
    public void setId(String _id) {this._id= _id;}
 //---------------------------------------------------   
    public Funcion getMiFuncion() { return MiFuncion;}
//--------------------------------------------------------
    public void setMiFuncion(Funcion MiFuncion) {this.MiFuncion= MiFuncion;}
 //---------------------------------------------------   
    public Silla getMiSilla() { return MiSilla;}
//--------------------------------------------------------
    public void setMiSilla(Silla MiSilla) {this.MiSilla= MiSilla;}

//------------------------------------------------------
    public double getValor() { return Valor;}
//--------------------------------------------------------
    public void setValor(double Valor) {this.Valor= Valor;}
//------------------------------------------------------
    public String getTipo() { return Tipo;}
//--------------------------------------------------------
    public void setTipo(String Tipo) {this.Tipo= Tipo;}
//------------------------------------------------------
    public JSONObject toJSON() {
        JSONObject respuesta = new JSONObject();
        respuesta.put("Valor", this.getValor());
        respuesta.put("Tipo", this.getTipo());       
        return respuesta;
    }    
}

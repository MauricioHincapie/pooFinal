package Modelos;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

public class Silla {    
    String _id;
    String Letra;
    int Numero;
    Boleto MiBoleto;
    Sala MiSala;
//----------------------------------------------
    public Silla(String Letra, int Numero) {
        this.Letra = Letra;
        this.Numero = Numero;
    }
//-------------------------------------------------
    public Silla() {}
 //---------------------------------------------------   
    public String getId() { return _id;}
//--------------------------------------------------------
    public void setId(String _id) {this._id= _id;}
 //---------------------------------------------------   
    public Boleto getMiBoleto() { return MiBoleto;}
//--------------------------------------------------------
    public void setBoleto(Boleto MiBoleto) {this.MiBoleto = MiBoleto;}
//---------------------------------------------------   
    public Sala getMiSala(){ return MiSala;}
//--------------------------------------------------------
    public void setSala(Sala MiSala) {this.MiSala = MiSala;}


//------------------------------------------------------
    public String getLetra() { return Letra;}
//--------------------------------------------------------
    public void setLetra(String Letra) {this.Letra= Letra;}
//------------------------------------------------------
    public int getNumero() { return Numero;}
//--------------------------------------------------------
    public void setNumero(int Numero) {
        this.Numero= Numero;}
//------------------------------------------------------
    public JSONObject toJSON() {
        JSONObject respuesta = new JSONObject();
        respuesta.put("Letra", this.getLetra());
        respuesta.put("Numero", this.getNumero());       
        return respuesta;
    }    
}

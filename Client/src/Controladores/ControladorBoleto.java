
package Controladores;

import Modelos.Boleto;
import Servicios.Servicios;
import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ControladorBoleto {
    Servicios miServicio;
    String subUrl;
//--------------------------------------------------------------
    public ControladorBoleto(String server, String subUrl) {
        this.miServicio = new Servicios(server);
        this.subUrl = subUrl;
    }
//-------------------------------------------------------------
    public Boleto crear(Boleto nuevoBoleto) {
        Boleto respuesta = new Boleto();
        try {
            String resultado = this.miServicio.POST(this.subUrl, nuevoBoleto.toJSON());
            respuesta = procesarJson(resultado);
        } catch (Exception e) {
            System.out.println("Error " + e);
            respuesta = null;
        }
        return respuesta;
    }
//-*------------------------------------------------
    public Boleto buscarPorCedula(String cedula) {
        Boleto respuesta = new Boleto();
        try {
            String endPoint = this.subUrl + "/cedula/" + cedula;
            String resultado = this.miServicio.GET(endPoint);
            respuesta = procesarJson(resultado);
        } catch (Exception e) {
            System.out.println("Error " + e);
            respuesta = null;
        }
        return respuesta;
    }
//------------------------------------------------------------------
    public void eliminar(String id) {
        String endPoint = this.subUrl + "/" + id;
        this.miServicio.DELETE(endPoint);
    }
//--------------------------------------------------------------
    public Boleto procesarJson(String jsonString) {
        Boleto nuevoBoleto = new Boleto();
        try {
            JSONParser parser = new JSONParser();
            JSONObject BoletoJSON = (JSONObject) parser.parse(jsonString);
            nuevoBoleto=reArmar(BoletoJSON);
        } catch (Exception e) {
            nuevoBoleto = null;
        }
        return nuevoBoleto;
    }
//---------------------------------------------------------------------
    public Boleto reArmar(JSONObject objetoJson) {
        Boleto nuevoBoleto=new Boleto();
        nuevoBoleto.setId((String) objetoJson.get("_id"));
        nuevoBoleto.setValor((double) objetoJson.get("Valor"));
        nuevoBoleto.setTipo((String) objetoJson.get("Tipo"));
        return nuevoBoleto;
    }
//----------------------------------------------------------------------------------
    public LinkedList<Boleto> listar() {
        LinkedList<Boleto> respuesta = new LinkedList<>();
        try {
            String endPoint = this.subUrl;
            String resultado = this.miServicio.GET(endPoint);
            JSONParser parser = new JSONParser();
            JSONArray BoletosJSON = (JSONArray) parser.parse(resultado);
            for (Object actual : BoletosJSON) {
                JSONObject BoletoJSON= (JSONObject) actual;
                Boleto nuevoBoleto=new Boleto();
                nuevoBoleto=reArmar(BoletoJSON);
                respuesta.add(nuevoBoleto);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
            respuesta = null;
        }
        return respuesta;
    }
//----------------------------------------------------------------------    
    public Boleto actualizar(Boleto actualizado){
        Boleto respuesta=new Boleto();
        try {
            String endPoint=this.subUrl+"/"+actualizado.getId();
            String resultado = this.miServicio.PUT(endPoint,actualizado.toJSON());
            respuesta = procesarJson(resultado);
        } catch (Exception e) {
            System.out.println("Error " + e);
            respuesta = null;
        }
        return respuesta;
    }
}
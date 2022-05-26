
package Controladores;

import Modelos.Silla;
import Servicios.Servicios;
import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ControladorSilla {
    Servicios miServicio;
    String subUrl;
//--------------------------------------------------------------
    public ControladorSilla(String server, String subUrl) {
        this.miServicio = new Servicios(server);
        this.subUrl = subUrl;
    }
//-------------------------------------------------------------
    public Silla crear(Silla nuevoSilla) {
        Silla respuesta = new Silla();
        try {
            String resultado = this.miServicio.POST(this.subUrl, nuevoSilla.toJSON());
            respuesta = procesarJson(resultado);
        } catch (Exception e) {
            System.out.println("Error " + e);
            respuesta = null;
        }
        return respuesta;
    }
//-*------------------------------------------------
    public Silla buscarPorCedula(String cedula) {
        Silla respuesta = new Silla();
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
    public Silla procesarJson(String jsonString) {
        Silla nuevoSilla = new Silla();
        try {
            JSONParser parser = new JSONParser();
            JSONObject SillaJSON = (JSONObject) parser.parse(jsonString);
            nuevoSilla=reArmar(SillaJSON);
        } catch (Exception e) {
            nuevoSilla = null;
        }
        return nuevoSilla;
    }
//---------------------------------------------------------------------
    public Silla reArmar(JSONObject objetoJson) {
        Silla nuevoSilla=new Silla();
        nuevoSilla.setId((String) objetoJson.get("_id"));
        nuevoSilla.setLetra((String) objetoJson.get("Letra"));
        nuevoSilla.setNumero((int) objetoJson.get("Numero"));
        return nuevoSilla;
    }
//----------------------------------------------------------------------------------
    public LinkedList<Silla> listar() {
        LinkedList<Silla> respuesta = new LinkedList<>();
        try {
            String endPoint = this.subUrl;
            String resultado = this.miServicio.GET(endPoint);
            JSONParser parser = new JSONParser();
            JSONArray SillasJSON = (JSONArray) parser.parse(resultado);
            for (Object actual : SillasJSON) {
                JSONObject SillaJSON= (JSONObject) actual;
                Silla nuevoSilla=new Silla();
                nuevoSilla=reArmar(SillaJSON);
                respuesta.add(nuevoSilla);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
            respuesta = null;
        }
        return respuesta;
    }
//----------------------------------------------------------------------    
    public Silla actualizar(Silla actualizado){
        Silla respuesta=new Silla();
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

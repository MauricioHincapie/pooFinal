
package Controladores;

import Modelos.Sala;
import Servicios.Servicios;
import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ControladorSala {
    Servicios miServicio;
    String subUrl;
//--------------------------------------------------------------
    public ControladorSala(String server, String subUrl) {
        this.miServicio = new Servicios(server);
        this.subUrl = subUrl;
    }
//-------------------------------------------------------------
    public Sala crear(Sala nuevoSala) {
        Sala respuesta = new Sala();
        try {
            String resultado = this.miServicio.POST(this.subUrl, nuevoSala.toJSON());
            respuesta = procesarJson(resultado);
        } catch (Exception e) {
            System.out.println("Error " + e);
            respuesta = null;
        }
        return respuesta;
    }
//-*------------------------------------------------
    public Sala buscarPorCedula(String cedula) {
        Sala respuesta = new Sala();
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
    public Sala procesarJson(String jsonString) {
        Sala nuevoSala = new Sala();
        try {
            JSONParser parser = new JSONParser();
            JSONObject SalaJSON = (JSONObject) parser.parse(jsonString);
            nuevoSala=reArmar(SalaJSON);
        } catch (Exception e) {
            nuevoSala = null;
        }
        return nuevoSala;
    }
//---------------------------------------------------------------------
    public Sala reArmar(JSONObject objetoJson) {
        Sala nuevoSala=new Sala();
        nuevoSala.setId((String) objetoJson.get("_id"));
        nuevoSala.setNombre((String) objetoJson.get("Nombre"));
        nuevoSala.setEfectosEspeciales((boolean) objetoJson.get("EfectosEspeciales"));
        return nuevoSala;
    }
//----------------------------------------------------------------------------------
    public LinkedList<Sala> listar() {
        LinkedList<Sala> respuesta = new LinkedList<>();
        try {
            String endPoint = this.subUrl;
            String resultado = this.miServicio.GET(endPoint);
            JSONParser parser = new JSONParser();
            JSONArray SalasJSON = (JSONArray) parser.parse(resultado);
            for (Object actual : SalasJSON) {
                JSONObject SalaJSON= (JSONObject) actual;
                Sala nuevoSala=new Sala();
                nuevoSala=reArmar(SalaJSON);
                respuesta.add(nuevoSala);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
            respuesta = null;
        }
        return respuesta;
    }
//----------------------------------------------------------------------    
    public Sala actualizar(Sala actualizado){
        Sala respuesta=new Sala();
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
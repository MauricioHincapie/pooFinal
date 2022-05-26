
package Controladores;

import Modelos.Funcion;
import Servicios.Servicios;
import java.util.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ControladorFuncion {
    Servicios miServicio;
    String subUrl;
//--------------------------------------------------------------
    public ControladorFuncion(String server, String subUrl) {
        this.miServicio = new Servicios(server);
        this.subUrl = subUrl;
    }
//-------------------------------------------------------------
    public Funcion crear(Funcion nuevoFuncion) {
        Funcion respuesta = new Funcion();
        try {
            String resultado = this.miServicio.POST(this.subUrl, nuevoFuncion.toJSON());
            respuesta = procesarJson(resultado);
        } catch (Exception e) {
            System.out.println("Error " + e);
            respuesta = null;
        }
        return respuesta;
    }
//-*------------------------------------------------
    public Funcion buscarPorCedula(String cedula) {
        Funcion respuesta = new Funcion();
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
    public Funcion procesarJson(String jsonString) {
        Funcion nuevoFuncion = new Funcion();
        try {
            JSONParser parser = new JSONParser();
            JSONObject FuncionJSON = (JSONObject) parser.parse(jsonString);
            nuevoFuncion=reArmar(FuncionJSON);
        } catch (Exception e) {
            nuevoFuncion = null;
        }
        return nuevoFuncion;
    }
//---------------------------------------------------------------------
    public Funcion reArmar(JSONObject objetoJson) {
        Funcion nuevoFuncion=new Funcion();
        nuevoFuncion.setId((String) objetoJson.get("_id"));
        nuevoFuncion.setHora((int) objetoJson.get("Hora"));
        nuevoFuncion.setDia((int) objetoJson.get("Dia"));
        nuevoFuncion.setMes((int) objetoJson.get("Mes"));
        nuevoFuncion.setAno((int) objetoJson.get("Ano"));
        return nuevoFuncion;
    }
//----------------------------------------------------------------------------------
    public LinkedList<Funcion> listar() {
        LinkedList<Funcion> respuesta = new LinkedList<>();
        try {
            String endPoint = this.subUrl;
            String resultado = this.miServicio.GET(endPoint);
            JSONParser parser = new JSONParser();
            JSONArray FuncionsJSON = (JSONArray) parser.parse(resultado);
            for (Object actual : FuncionsJSON) {
                JSONObject FuncionJSON= (JSONObject) actual;
                Funcion nuevoFuncion=new Funcion();
                nuevoFuncion=reArmar(FuncionJSON);
                respuesta.add(nuevoFuncion);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
            respuesta = null;
        }
        return respuesta;
    }
//----------------------------------------------------------------------    
    public Funcion actualizar(Funcion actualizado){
        Funcion respuesta=new Funcion();
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

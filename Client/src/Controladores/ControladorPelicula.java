package Controladores;

import Modelos.Pelicula;
import Servicios.Servicios;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//--------------------------------------------------------
public class ControladorPelicula {    
    Servicios miServicio;
    String subURL;
//-----------------------------------------------------------------------
    public ControladorPelicula(String server, String subURL) {
        this.miServicio= new Servicios(server);
        this.subURL=subURL;
    }
 //-------------------------------------------------------------------   
    public Pelicula crear(Pelicula nuevaPelicula){
        Pelicula respuesta= new Pelicula();       
        try {            
            String resultado=this.miServicio.POST(this.subURL, nuevaPelicula.toJSON());
            JSONParser parser = new JSONParser();           
            JSONObject PeliculaJSON=(JSONObject) parser.parse(resultado);
            respuesta.setId((String)PeliculaJSON.get("_id"));
            respuesta.setNombre((String)PeliculaJSON.get("Nombre"));
            respuesta.setAno((int)PeliculaJSON.get("Ano"));
            respuesta.setTipo((String)PeliculaJSON.get("Tipo"));           
        } catch (Exception e) {
            System.out.println("Error "+ e);
            respuesta=null;
        }
        return respuesta;
    }    
}

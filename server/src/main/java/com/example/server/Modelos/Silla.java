package com.example.server.Modelos;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class Silla {
    @Id
    private String _id;
    private String Letra;
    private int Numero;

    @DBRef
    private Sala sala;
    //----------------------
    public Silla(String Letra, int Numero) {
        this.Letra = Letra;
        this.Numero = Numero;
    }
    //------------------------
    public String get_id() {  return _id; }
    //----------------------------
    public String getLetra() { return Letra; }
    //-------------------------------
    public void setLetra(String Letra) { this.Letra = Letra;}
    //---------------------------
    public int Numero() {  return Numero; }
    //----------------------------
    public void setNumero(int Numero) { this.Numero = Numero; }
    //---------------------------
    public Sala getSala() {  return sala; }
    //----------------------------
    public void setSala(Sala sala) { this.sala = sala; }

}

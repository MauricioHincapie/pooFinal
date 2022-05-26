package com.example.server.Modelos;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class Boleto {
    @Id
    private String _id;
    private double Valor;
    private String Tipo;

    @DBRef
    Funcion funcion;

    @DBRef
    Usuario usuario;

    @DBRef
    Silla silla;


    //----------------------
    public Boleto(double Valor, String Tipo) {
        this.Valor = Valor;
        this.Tipo = Tipo;
    }
    //------------------------
    public String get_id() {  return _id; }
    //----------------------------
    public double getValor() { return Valor; }
    //-------------------------------
    public void setValor(double Valor) { this.Valor = Valor;}
    //---------------------------
    public String Tipo() {  return Tipo; }
    //----------------------------
    public void setTipo(String Tipo) { this.Tipo = Tipo; }
    //---------------------------
    public Funcion getFuncion() {  return funcion; }
    //----------------------------
    public void setFuncion(Funcion funcion) { this.funcion = funcion; }
    //---------------------------
    public Usuario getUsuario() {  return usuario; }
    //----------------------------
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    //---------------------------
    public Silla getSilla() {  return silla; }
    //----------------------------
    public void setSilla(Silla silla) { this.silla = silla; }

}

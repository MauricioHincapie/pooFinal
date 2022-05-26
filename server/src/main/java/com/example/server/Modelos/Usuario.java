package com.example.server.Modelos;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document()
public class Usuario {
    @Id
    private String _id;
    private String Cedula;
    private String Nombre;
    private String Email;
    private int AnoNacimiento;

    //----------------------
    public Usuario(String Cedula, String Nombre, String Email, int AnoNacimiento) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Email = Email;
        this.AnoNacimiento = AnoNacimiento;
    }
    //------------------------
    public String get_id() {  return _id; }
    //----------------------------
    public String getCedula() { return Cedula; }
    //-------------------------------
    public void setCedula(String Cedula) { this.Cedula = Cedula;}
    //---------------------------
    public String getNombre() {  return Nombre; }
    //----------------------------
    public void setNombre(String Nombre) { this.Nombre = Nombre; }
    //-------------------------------
    public String getEmail() { return Email; }
    //---------------------------------
    public void setEmail(String Email) {
        this.Email = Email;
    }
    //-----------------------
    public int getAnoNacimiento() { return AnoNacimiento; }
    //---------------------------------
    public void setAnoNacimiento(int AnoNacimiento) {
        this.AnoNacimiento = AnoNacimiento;
    }
}

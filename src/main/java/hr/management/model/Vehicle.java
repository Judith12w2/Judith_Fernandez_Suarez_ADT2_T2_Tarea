package hr.management.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicle {

    @JsonProperty("matricula")
    private String matricula;

    @JsonProperty("marca")
    private String marca;

    @JsonProperty("modelo")
    private String modelo;

    @JsonProperty("añoCompra")
    private int añoCompra;

    // Constructor por defecto
    public Vehicle() {
    }

    // Constructor parametrizado
    public Vehicle(String matricula, String marca, String modelo, int añoCompra) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.añoCompra = añoCompra;
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAñoCompra() {
        return añoCompra;
    }

    public void setAñoCompra(int añoCompra) {
        this.añoCompra = añoCompra;
    }
}

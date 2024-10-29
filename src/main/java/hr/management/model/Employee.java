package hr.management.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    @JsonProperty("dni")
    private String dni;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("matriculaVehiculo")
    private String matriculaVehiculo;

    @JsonProperty("añoContratado")
    private int añoContratado;

    // Constructor por defecto
    public Employee() {
    }

    // Constructor parametrizado
    public Employee(String dni, String nombre, String matriculaVehiculo, int añoContratado) {
        this.dni = dni;
        this.nombre = nombre;
        this.matriculaVehiculo = matriculaVehiculo;
        this.añoContratado = añoContratado;
    }

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatriculaVehiculo() {
        return matriculaVehiculo;
    }

    public void setMatriculaVehiculo(String matriculaVehiculo) {
        this.matriculaVehiculo = matriculaVehiculo;
    }

    public int getAñoContratado() {
        return añoContratado;
    }

    public void setAñoContratado(int añoContratado) {
        this.añoContratado = añoContratado;
    }

    // Implementación del método toString()
    @Override
    public String toString() {
        return "Employee{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", matriculaVehiculo='" + matriculaVehiculo + '\'' +
                ", añoContratado=" + añoContratado +
                '}';
    }
}

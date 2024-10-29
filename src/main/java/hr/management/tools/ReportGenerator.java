package hr.management.tools;

import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReportGenerator {
    public static void generateReport(ArrayList<Employee> employees, ArrayList<Vehicle> vehicles, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Informe de empleados con vehículos asignados\n");
            writer.write("===========================================\n");
            for (Employee employee : employees) {
                writer.write("Empleado:\n");
                writer.write("  DNI: " + employee.getDni() + "\n");
                writer.write("  Nombre: " + employee.getNombre() + "\n");
                writer.write("  Año Contratado: " + employee.getAñoContratado() + "\n");

                String matricula = employee.getMatriculaVehiculo();
                if (matricula != null) {
                    Vehicle vehicle = vehicles.stream()
                            .filter(v -> v.getMatricula().equals(matricula))
                            .findFirst()
                            .orElse(null);
                    if (vehicle != null) {
                        writer.write("  Vehículo:\n");
                        writer.write("    Marca: " + vehicle.getMarca() + "\n");
                        writer.write("    Modelo: " + vehicle.getModelo() + "\n");
                        writer.write("    Matrícula: " + vehicle.getMatricula() + "\n");
                        writer.write("    Año: " + vehicle.getAñoCompra() + "\n");
                    }
                }
                writer.write("===========================================\n");
            }
        }
    }

}

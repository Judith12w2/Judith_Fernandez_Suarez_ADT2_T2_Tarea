package hr.management.tools;

import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String employeesJsonPath = "./data/employees.json";
        String vehiclesJsonPath = "./data/vehicles.json";
        String newVehicleXmlPath = "./data/newVehicle1.xml";
        String reportPath = "./data/informe.txt";

        try {
            // Cargar datos de empleados y vehículos desde JSON
            ArrayList<Employee> employees = JsonManager.loadEmployeesFromJson(employeesJsonPath);
            ArrayList<Vehicle> vehicles = JsonManager.loadVehiclesFromJson(vehiclesJsonPath);

            // Añadir un vehículo desde el archivo XML
            Vehicle newVehicle = XMLManager.readVehicleFromXml(newVehicleXmlPath);
            vehicles.add(newVehicle);
            System.out.println("Nuevo vehículo añadido desde XML: " + newVehicle);

            // Asignar el nuevo vehículo al empleado con DNI 87654321B
            EmployeeManager employeeManager = new EmployeeManager(employees, vehicles);
            boolean assigned = employeeManager.assignVehicleToEmployee("87654321B", newVehicle.getMatricula());
            if (assigned) {
                System.out.println("Vehículo asignado correctamente al empleado con DNI 87654321B.");
            } else {
                System.out.println("No se pudo asignar el vehículo.");
            }

            // Desasignar el vehículo del empleado Walter Smith
            boolean unassigned = employeeManager.unassignVehicleFromEmployee("23456789C");
            if (unassigned) {
                System.out.println("Vehículo desasignado correctamente del empleado Walter Smith.");
            } else {
                System.out.println("No se pudo desasignar el vehículo del empleado Walter Smith.");
            }

            // Generar un informe en formato TXT
            ReportGenerator.generateReport(employees, vehicles, reportPath);
            System.out.println("Informe generado exitosamente en 'data/informe.txt'.");

            // Imprimir todos los empleados
            System.out.println("Lista de empleados:");
            employeeManager.printAllEmployees();

            // Guardar los datos actualizados en los archivos JSON
            JsonManager.saveEmployeesToJson(employees, employeesJsonPath);
            JsonManager.saveVehiclesToJson(vehicles, vehiclesJsonPath);
            System.out.println("Datos actualizados guardados en archivos JSON.");

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

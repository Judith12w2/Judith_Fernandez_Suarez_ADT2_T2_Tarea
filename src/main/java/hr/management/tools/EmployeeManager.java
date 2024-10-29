package hr.management.tools;

import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.util.ArrayList;

public class EmployeeManager {
    private ArrayList<Employee> employees;
    private ArrayList<Vehicle> vehicles;

    public EmployeeManager(ArrayList<Employee> employees, ArrayList<Vehicle> vehicles) {
        this.employees = employees;
        this.vehicles = vehicles;
    }

    public boolean assignVehicleToEmployee(String dni, String matricula) {
        for (Employee employee : employees) {
            if (employee.getDni().equals(dni)) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.getMatricula().equals(matricula)) {
                        employee.setMatriculaVehiculo(matricula);
                        return true;
                    }
                }
            }
        }
        return false; // No se pudo asignar
    }

    public boolean unassignVehicleFromEmployee(String dni) {
        for (Employee employee : employees) {
            if (employee.getDni().equals(dni)) {
                employee.setMatriculaVehiculo(null);
                return true;
            }
        }
        return false; // No se pudo desasignar
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

package hr.management.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hr.management.model.Employee;
import hr.management.model.Vehicle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonManager {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    // Cargar empleados desde JSON
    public static ArrayList<Employee> loadEmployeesFromJson(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Employee.class));
    }

    // Guardar empleados en JSON
    public static void saveEmployeesToJson(ArrayList<Employee> employees, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), employees);
    }

    // Cargar vehículos desde JSON
    public static ArrayList<Vehicle> loadVehiclesFromJson(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Vehicle.class));
    }

    // Guardar vehículos en JSON
    public static void saveVehiclesToJson(ArrayList<Vehicle> vehicles, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), vehicles);
    }
}

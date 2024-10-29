package hr.management.tools;

import hr.management.model.Vehicle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class XMLManager {
    public static ArrayList<Vehicle> loadVehiclesFromXml(String filePath) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        File xmlFile = new File(filePath);

        // Verificar si el archivo existe
        if (!xmlFile.exists()) {
            System.out.println("Error: El archivo no se encuentra en la ruta especificada: " + filePath);
            return vehicles; // Devuelve una lista vacía si el archivo no se encuentra
        }

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("vehicle");
            for (int i = 0; i < nList.getLength(); i++) {
                Element element = (Element) nList.item(i);
                String brand = element.getElementsByTagName("brand").item(0).getTextContent();
                String model = element.getElementsByTagName("model").item(0).getTextContent();
                String plate = element.getElementsByTagName("plate").item(0).getTextContent();
                int year = Integer.parseInt(element.getElementsByTagName("yearBought").item(0).getTextContent());

                Vehicle vehicle = new Vehicle(brand, model, plate, year);
                vehicles.add(vehicle);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones
        }
        return vehicles;
    }

    public static Vehicle readVehicleFromXml(String filePath) {
        File xmlFile = new File(filePath);
        Vehicle vehicle = null;

        // Verificar si el archivo existe
        if (!xmlFile.exists()) {
            System.out.println("Error: El archivo no se encuentra en la ruta especificada: " + filePath);
            return vehicle; // Devuelve null si el archivo no se encuentra
        }

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Suponiendo que solo hay un vehículo en newVehicle1.xml
            Element element = (Element) doc.getElementsByTagName("vehicle").item(0);
            String brand = element.getElementsByTagName("brand").item(0).getTextContent();
            String model = element.getElementsByTagName("model").item(0).getTextContent();
            String plate = element.getElementsByTagName("plate").item(0).getTextContent();
            int year = Integer.parseInt(element.getElementsByTagName("yearBought").item(0).getTextContent());

            vehicle = new Vehicle(brand, model, plate, year);
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones
        }
        return vehicle;
    }
}

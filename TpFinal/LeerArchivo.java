import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivo {

    public static void main(String[] args) {
        String pathFechas= "/home/tareas/Tp_algo1/fechas.csv";
        String pathVentas= "/home/tareas/Tp_algo1/ventas.csv";
        char delimiter = ','; 
        
        try {
            List<String[]> fechas = leeCSV(pathFechas, delimiter, true); 
            printData(fechas);
            List<String[]> ventas = leeCSV(pathVentas, delimiter, true); 
            printData(ventas);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (CSVFormatException e) {
            System.err.println("Error de formato en el archivo CSV: " + e.getMessage());
        }
    }


    public static List<String[]> leeCSV(String filePath, char delimiter, boolean hasHeader) throws IOException, CSVFormatException {
        List<String[]> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Si hay header, lo leemos y lo descartamos
            if (hasHeader) {
                String headerLine = br.readLine();
                if (headerLine == null) {
                    throw new CSVFormatException("El archivo está vacío.");
                }
            }

            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(String.valueOf(delimiter));
                if (fields.length == 0) {
                    throw new CSVFormatException("La línea " + lineNumber + " está vacía.");
                }
                dataList.add(fields);
                lineNumber++;
            }
        }

        return dataList;
    }

    public static void printData(List<String[]> data) {
        for (String[] row : data) {
            for (int i = 1; i < row.length; i++) { // Empezar desde el índice 1 en lugar de 0
                System.out.print(row[i] + "\t");
            }
            System.out.println();
        }
    }

    static class CSVFormatException extends Exception {
        public CSVFormatException(String message) {
            super(message);
        }
    }
}
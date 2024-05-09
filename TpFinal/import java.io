import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LeerArchivo {
    public static void main(String[] args) {
        try {
            // Especifica el nombre del archivo
            String nombreArchivo = "miarchivo.txt";
            
            // Crea un InputStream para leer el archivo
            InputStream inputStream = new FileInputStream(nombreArchivo);
            
            // Lee los datos del archivo en un buffer de 1Kb
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String texto = new String(buffer, 0, bytesRead);
                System.out.println(texto);
            }
            
            // Cierra el InputStream
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
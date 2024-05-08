import java.util.ArrayList;
import java.util.List;

public class ListAnalyzer {

    public static int contadorImpares(List<Integer> miLista) {
       int impares = 0;
       for (int numero : miLista) {
           if (numero % 2 != 0) {
              impares++;
           }
       }
       return impares;
    }

    public static List<Integer> numerosConsecutivos(List<Integer> miLista) {
       
        List<Integer> consecutivos = new ArrayList<>();
        for (int i = 0; i < miLista.size() - 1; i++) {
            if (miLista.get(i) + 1 == miLista.get(i + 1) ){
                consecutivos.add(miLista.get(i));
                consecutivos.add(miLista.get(i+1));
            }
        }
        return consecutivos;
    }

}

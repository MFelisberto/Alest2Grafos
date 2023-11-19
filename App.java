import java.util.Map;

public class App{
    public static void main(String[] args){

        EdgeWeightedDigraph grafo = new EdgeWeightedDigraph("casoEXEMPLO.txt");

        Map<String, Double> hydrogenNeededMap = grafo.hidrogenioToGoldDFS("hidrogenio");

        for (Map.Entry<String, Double> entry : hydrogenNeededMap.entrySet()) {
            String elemento = entry.getKey();
            double quantidadeHidrogenio = entry.getValue();
    
            System.out.println("Elemento: " + elemento + ", Hidrogênio necessário: " + quantidadeHidrogenio);
        }

        //System.out.println(grafo.toDot());
    
    }
}

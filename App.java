public class App{

    public static void main(String[] args){

        EdgeWeightedDigraph grafo = new EdgeWeightedDigraph("casoa5.txt");

        System.err.println(grafo.toDot());

    }
    
}

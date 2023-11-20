

public class App{
    public static void main(String[] args){

       EdgeWeightedDigraph grafo = new EdgeWeightedDigraph("casoEXEMPLO.txt");
       EdgeWeightedDigraph grafo1 = new EdgeWeightedDigraph("casoa5.txt");
       EdgeWeightedDigraph grafo2 = new EdgeWeightedDigraph("casoa20.txt");
       EdgeWeightedDigraph grafo3 = new EdgeWeightedDigraph("casoa40.txt");
       EdgeWeightedDigraph grafo4 = new EdgeWeightedDigraph("casoa60.txt");
       EdgeWeightedDigraph grafo5 = new EdgeWeightedDigraph("casoa80.txt");
       EdgeWeightedDigraph grafo6 = new EdgeWeightedDigraph("casoa120.txt");
       EdgeWeightedDigraph grafo7 = new EdgeWeightedDigraph("casoa180.txt");
       EdgeWeightedDigraph grafo8 = new EdgeWeightedDigraph("casoa240.txt");
       EdgeWeightedDigraph grafo9 = new EdgeWeightedDigraph("casoa280.txt");
       EdgeWeightedDigraph grafo10 = new EdgeWeightedDigraph("casoa320.txt");
       EdgeWeightedDigraph grafo11 = new EdgeWeightedDigraph("casoa360.txt");
       EdgeWeightedDigraph grafo12 = new EdgeWeightedDigraph("casoa400.txt");
    
       System.out.println("casoEXEMPLO.txt: " + grafo.hidrogenioToGold());
       System.out.println("casoa5.txt: " + grafo1.hidrogenioToGold());
       System.out.println("caso20.txt: " + grafo2.hidrogenioToGold());
       System.out.println("casoa40.txt: " + grafo3.hidrogenioToGold());
       System.out.println("casoa60.txt: " + grafo4.hidrogenioToGold());
       System.out.println("casoa80.txt: " + grafo5.hidrogenioToGold());
       System.out.println("casoa120.txt: " + grafo6.hidrogenioToGold());
       System.out.println("casoa180.txt: " + grafo7.hidrogenioToGold());
       System.out.println("casoa240.txt: " + grafo8.hidrogenioToGold());
       System.out.println("casoa280.txt: " + grafo9.hidrogenioToGold());
       System.out.println("casoa320.txt: " + grafo10.hidrogenioToGold());
       System.out.println("casoa360.txt: " + grafo11.hidrogenioToGold());
       System.out.println("casoa400.txt: " + grafo12.hidrogenioToGold());

    }
}

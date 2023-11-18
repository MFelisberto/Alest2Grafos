public class App{
    public static void main(String[] args){

        EdgeWeightedDigraph grafo = new EdgeWeightedDigraph("casoa5.txt");
        
        HidrogenioToGold aa= new HidrogenioToGold(grafo);
        
        double totalHydrogen = aa.calculateHidrogenioToGold();
        
        System.out.println(totalHydrogen);


    }
}

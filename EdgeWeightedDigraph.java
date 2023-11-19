import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class EdgeWeightedDigraph{

  protected static final String NEWLINE = System.getProperty("line.separator");
  protected Map<String, List<Edge>> graph;
  protected Set<String> vertices;
  protected int totalVertices;
  protected int totalEdges;

  public EdgeWeightedDigraph(){
    graph = new HashMap<>();
    vertices = new HashSet<>();
    totalVertices = totalEdges = 0;
  }

  public EdgeWeightedDigraph(String filename) {
    this();
    In in = new In(filename);
    String line;
    while ((line = in.readLine()) != null) {
      int controlador = 0;
      String[] edge = line.split(" ");
      String verticeOrigem = edge[edge.length - 1];
      String verticeDestino;
      int peso;
      while(!(edge[controlador].equals("->"))){
        verticeDestino = edge[controlador + 1];
        peso = Integer.parseInt(edge[controlador]);
        addEdge(verticeDestino, verticeOrigem, peso);
        controlador = controlador + 2;
      }
  
    }
    in.close();
  }

  public void addEdge(String v, String w, double weight) {
    Edge e = new Edge(v, w, weight);
    addToList(v, e);
    if(!vertices.contains(v)) {
      vertices.add(v);
      totalVertices++;
    }
    if(!vertices.contains(w)) {
      vertices.add(w);
      totalVertices++;
    }
    totalEdges += 2;
    totalEdges++;
  }

  public int getTotalVerts(){return totalVertices;}
  public int getTotalEdges(){return totalEdges;}
  public Set<String> getVerts(){return vertices;}

  public Iterable<Edge> getAdj(String v){
    List<Edge> res = graph.get(v);
    
    if(res == null){
     res = new LinkedList<>();
    }
    
    return res;
  }

  public Iterable<Edge> getEdges(){
    Set<Edge> ed = new HashSet<>();
    for(String v : getVerts().stream().sorted().toList()) {
      for (Edge e : getAdj(v)) {
        if (!ed.contains(e)) {
          ed.add(e);
        }
      }
    }
    return ed;
  }

  protected List<Edge> addToList(String v, Edge e) {
    List<Edge> list = graph.get(v);
    if (list == null)
      list = new LinkedList<>();
    list.add(e);
    graph.put(v, list);
    return list;
  }

  public Map<String, Double> hidrogenioToGold(){
    
    Set<String> caminho =  new HashSet<>();
    Map<String, Double> hydrogenNeeded = new HashMap<>();
    Queue<String> fila = new LinkedList<>();

    // Inicializa com hidrogênio
    for(Edge e : getAdj("hidrogenio")){
      hydrogenNeeded.put(e.getW(), e.getWeight());
      fila.add(e.getW());
      caminho.add(e.getW());
    }

    while(!fila.isEmpty()){
      
      String currentElement = fila.poll();

      for(Edge e : getAdj(currentElement)){
        double currentAmount = hydrogenNeeded.get(currentElement);
        double newAmount = e.getWeight() * currentAmount;

        // Adiciona ou acumula na quantidade existente
        hydrogenNeeded.put(e.getW(), hydrogenNeeded.getOrDefault(e.getW(), 0.0) + newAmount);

        // Adiciona à fila para processamento posterior
        fila.add(e.getW());
      }
    }

    return hydrogenNeeded;
  }

  public Map<String, Double> hidrogenioToGoldDFS(String v) {
    Map<String, Double> hydrogenNeeded = new HashMap<>();
    Set<String> marked = new HashSet<>();

    dfs(v, hydrogenNeeded, marked);

    return hydrogenNeeded;
}

private void dfs(String v, Map<String, Double> hydrogenNeeded, Set<String> marked) {
    marked.add(v);

    for (Edge e : getAdj(v)) {
        if (!marked.contains(e.getW())) {
            double currentAmount = hydrogenNeeded.getOrDefault(v, 1.0);  // Valor acumulado até o nó atual
            double newAmount = e.getWeight() * currentAmount;

            // Adiciona ou acumula na quantidade existente
            hydrogenNeeded.put(e.getW(), hydrogenNeeded.getOrDefault(e.getW(), 0.0) + newAmount);

            // Adiciona à fila para processamento posterior
            dfs(e.getW(), hydrogenNeeded, marked);
        }
    }
}



  public String toDot() {
    StringBuilder sb = new StringBuilder();
    sb.append("digraph {" + NEWLINE);
    sb.append("node [shape = circle];" + NEWLINE);
    for (Edge e : getEdges())
      sb.append(String.format("%s -> %s [label=\"%.3f\"]", e.getV(), e.getW(), e.getWeight()) + NEWLINE);
    sb.append("}" + NEWLINE);
    return sb.toString();
  }

}



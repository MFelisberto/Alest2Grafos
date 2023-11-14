public class EdgeWeightedDigraph extends EdgeWeightedGraph {

  public EdgeWeightedDigraph() {
    super();
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

  @Override
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

  @Override
  public String toDot() {
    StringBuilder sb = new StringBuilder();
    sb.append("digraph {" + NEWLINE);
    sb.append("rankdir = LR;" + NEWLINE);
    sb.append("node [shape = circle];" + NEWLINE);
    for (Edge e : getEdges())
      sb.append(String.format("%s -> %s [label=\"%.3f\"]", e.getV(), e.getW(), e.getWeight()) + NEWLINE);
    sb.append("}" + NEWLINE);
    return sb.toString();
  }
}

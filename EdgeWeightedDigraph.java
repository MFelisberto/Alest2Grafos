import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.math.BigInteger;

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
      long peso1;
      BigInteger peso;
      while(!(edge[controlador].equals("->"))){
        verticeDestino = edge[controlador + 1];
        peso1 = Integer.parseInt(edge[controlador]);
        peso = BigInteger.valueOf(peso1);
        addEdge(verticeDestino, verticeOrigem, peso);
        controlador = controlador + 2;
      }
  
    }
    in.close();
  }

  public void addEdge(String v, String w, BigInteger weight) {
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

  public BigInteger hidrogenioToGold(){
    Map<String,BigInteger> dic = new HashMap<>();
    BigInteger totalHidrogenios = calculateHidroNecssary("hidrogenio",dic);
    return totalHidrogenios;
  }

  private BigInteger calculateHidroNecssary(String elemento, Map<String,BigInteger> dic){
    
    BigInteger totalH = BigInteger.valueOf(0);

    if(dic.containsKey(elemento)) {
      return dic.get(elemento);
    }
    
    if(!elemento.equals("ouro"))
    {
      for(Edge e : this.getAdj(elemento)){
        BigInteger hidrogenios = e.getWeight().multiply(calculateHidroNecssary(e.getW(),dic));
        totalH = totalH.add(hidrogenios);
      }
    }
    else
    {
      return BigInteger.valueOf(1);
    }
    
    dic.put(elemento, totalH);
    return totalH;
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



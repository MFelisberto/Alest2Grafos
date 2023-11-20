import java.math.BigInteger;

public class Edge implements Comparable<Edge> {
  
  private String v;
  private String w;
  private BigInteger weight;

  public Edge(String v, String w, BigInteger weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public String getV() {
    return v;
  }

  public String getW() {
    return w;
  }

  public BigInteger getWeight() {
    return weight;
  }

  @Override
  public int compareTo(Edge other) {
    return this.weight.compareTo(other.weight);
  }

  @Override
  public String toString() {
    return v + "-" + w + " (" + weight + ")";
  }
}

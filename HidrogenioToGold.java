import java.util.*;

public class HidrogenioToGold {

    private EdgeWeightedDigraph graph;
    private String source;
    private String target;

    public HidrogenioToGold(EdgeWeightedDigraph graph) {
        this.graph = graph;
        this.source = "hidrogenio";
        this.target = "ouro";
    }

    public double calculateHidrogenioToGold() {
        // Inicializa as estruturas de dados para o DFS
        Set<String> visited = new HashSet<>();
        Map<String, Double> hydrogenCount = new HashMap<>();

        // Inicia a busca em profundidade a partir do vértice de origem
        dfs(source, target, visited, hydrogenCount, 1.0); // Inicia com 1 unidade de hidrogênio

        // Retorna a quantidade de hidrogênio necessária para formar uma unidade de ouro
        return hydrogenCount.getOrDefault(target, -1.0); // Retorna -1 se não houver caminho
    }

    private void dfs(String currentVertex, String targetVertex, Set<String> visited, Map<String, Double> hydrogenCount, double requiredAmount) {
        visited.add(currentVertex);

        // Verifica se o vértice atual é o vértice de destino
        if (currentVertex.equals(targetVertex)) {
            hydrogenCount.put(targetVertex, requiredAmount);
            return;
        }

        // Itera sobre as arestas adjacentes ao vértice atual
        for (Edge edge : graph.getAdj(currentVertex)) {
            String nextVertex = edge.getW();
            double requiredMultiplier = edge.getWeight();

            if (!visited.contains(nextVertex)) {
                // Obtém a quantidade necessária para a próxima etapa com base na aresta atual
                double nextRequiredAmount = requiredAmount * requiredMultiplier;

                // Realiza a busca em profundidade recursivamente
                dfs(nextVertex, targetVertex, visited, hydrogenCount, nextRequiredAmount);
            }
        }
    }
}

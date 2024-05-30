import java.util.Arrays;

public class DijkstraSearch {
    public void dijkstra(MyGraph graph, String startVertex) {
        int vertexCount = graph.getVertexCount();
        int[] distances = new int[vertexCount];
        boolean[] visited = new boolean[vertexCount];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[getVertexIndex(graph, startVertex)] = 0;

        for (int i = 0; i < vertexCount - 1; i++) {
            int u = minDistance(distances, visited, vertexCount);
            visited[u] = true;

            for (Edge edge : graph.getEdges()) {
                if (edge.getSource().equals(graph.getVertices()[u]) && !visited[getVertexIndex(graph, edge.getDestination())]) {
                    int v = getVertexIndex(graph, edge.getDestination());
                    int weight = edge.getWeight();
                    if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                        distances[v] = distances[u] + weight;
                    }
                }
            }
        }

        printSolution(distances, graph.getVertices(), vertexCount);
    }

    private int minDistance(int[] distances, boolean[] visited, int vertexCount) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < vertexCount; v++) {
            if (!visited[v] && distances[v] <= min) {
                min = distances[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private int getVertexIndex(MyGraph graph, String vertex) {
        for (int i = 0; i < graph.getVertexCount(); i++) {
            if (graph.getVertices()[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    private void printSolution(int[] distances, String[] vertices, int vertexCount) {
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < vertexCount; i++) {
            System.out.println(vertices[i] + "\t\t" + distances[i]);
        }
    }
}

public class DFS {
    public void dfs(MyGraph graph, String startVertex) {
        boolean[] visited = new boolean[graph.getVertexCount()];
        dfsUtil(graph, startVertex, visited);
        System.out.println();
    }

    private void dfsUtil(MyGraph graph, String vertex, boolean[] visited) {
        int vertexIndex = getVertexIndex(graph, vertex);
        if (visited[vertexIndex]) {
            return;
        }
        visited[vertexIndex] = true;
        System.out.print(vertex + " ");

        for (Edge edge : graph.getEdges()) {
            if (edge.getSource().equals(vertex) && !visited[getVertexIndex(graph, edge.getDestination())]) {
                dfsUtil(graph, edge.getDestination(), visited);
            }
        }
    }

    private int getVertexIndex(MyGraph graph, String vertex) {
        for (int i = 0; i < graph.getVertexCount(); i++) {
            if (graph.getVertices()[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }
}

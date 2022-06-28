import java.util.*;

/** A class for calling Dijkstra's algorithm.
 *  @author Koffman and Wolfgang
 */

public class DijkstrasAlgorithm {

  /** Dijkstra�s Shortest-Path algorithm.
      @param graph The weighted graph to be searched
      @param start The start vertex
      @param pred Output array to contain the predecessors
                  in the shortest path
      @param dist Output array to contain the distance
                  in the shortest path
   */
  public static void dijkstrasAlgorithm(MyGraph<Integer> graph,
                                        int start,
                                        int[] pred,
                                        double[] dist) {
    int numV = graph.getNumV();
    HashSet < Integer > vMinusS = new HashSet < Integer > (numV);
    // Initialize V�S.
    for (int i = 0; i < numV; i++) {
      if (i != start) {
        vMinusS.add(i);
      }
    }
    // Initialize pred and dist.
    for (int v : vMinusS) {
      pred[v] = start;
      dist[v] = graph.adjacencyMatrix[v][start];
    }

    // Main loop
    while (vMinusS.size() != 0) {
      // Find the value u in V�S with the smallest dist[u].
      double minDist = Double.POSITIVE_INFINITY;
      int u = -1;

      for (int v : vMinusS) {
        if (dist[v] < minDist) {
          minDist = dist[v];
          u = v;
        }
      }

      // Remove u from vMinusS.
      vMinusS.remove(u);

      // Update the distances.
      for (int v : vMinusS) {//u,v
        if (graph.adjacencyMatrix[u][v] >0) {
          double weight = graph.adjacencyMatrix[u][v];//u,v
          if (dist[u] + weight - graph.vertexList.get(u).getBoosting()  < dist[v]) {
            dist[v] = dist[u] + weight - graph.vertexList.get(u).getBoosting();
            pred[v] = u;
          }
        }
      }
    }
  }
}

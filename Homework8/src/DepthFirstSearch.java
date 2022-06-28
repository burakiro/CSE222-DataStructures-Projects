import java.util.*;

/** Class to implement the depth-first search algorithm.
*   @author Koffman and Wolfgang
* */

public class DepthFirstSearch {

  // Data Fields
  /** A reference to the graph being searched. */
  private MyGraph<Integer> graph;

  /** Array of parents in the depth-first search tree. */
  private int[] parent;

  /** Flag to indicate whether this vertex has been visited. */
  private boolean[] visited;

  /** The array that contains each vertex in discovery order. */
  private int[] discoveryOrder;

  /** The array that contains each vertex in finish order. */
  private int[] finishOrder;
  
  /** The array that contains each vertex in finish order. */
  private int[] res;

  /** The index that indicates the discovery order. */
  private int discoverIndex = 0;

  /** The index that indicates the finish order. */
  private int finishIndex = 0;

  // Constructors
  /** Construct the depth-first search of a Graph
      starting at vertex 0 and visiting the start vertices in
      ascending order.
   */
   public static void swap(int i1 ,int i2 , List<Edge> list){
    Edge ed1 = list.get(i1);
    Edge ed2 = list.get(i2);
    
    list.set(i1, ed2);
    list.set(i2, ed1);

 }
    
   
  public DepthFirstSearch(MyGraph<Integer> graph) {
    this.graph = graph;
    int n = graph.getNumV();
    res = new int[n];
    parent = new int[n];
    visited = new boolean[n];
    discoveryOrder = new int[n];
    finishOrder = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = -1;
    }
    for (int i = 0; i < n; i++) {
      if (!visited[i])
        depthFirstSearch(i);
    }
  }

  /** Construct the depth-first search of a Graph
      selecting the start vertices in the specified order.
      The first vertex visited is order[0].
      @param graph The graph
      @param order The array giving the order
                   in which the start vertices should be selected
   */
  public DepthFirstSearch(MyGraph<Integer> graph, int[] order) {
    // Same as constructor above except for the if statement.
  }

  /** Recursively depth-first search the graph
      starting at vertex current.
   */
  
  public int findMinIdx(int idx , List<Edge> list){
      int min = 999999;
      int minIdx = 0;
      
      int[] temp  = new int[list.size()];
      
      for(int i = 0;i< temp.length;i++)
          temp[i] = (int) list.get(i).getWeight();
      
      
      for(int j = 0; j<= idx; j++){
          for(int i = 0;  i < list.size();i++){
                if(temp[i] < min){
                    min = temp[i];
                    minIdx = i;
                }
            }
          if(j != idx){
              temp[minIdx] = 999999;
              min = 999999;
          }
      }
      
      return minIdx;
      
  }
  public int[] depthFirstSearch(int current) {
      
     if(discoverIndex >= discoveryOrder.length) return finishOrder;
    /* Mark the current vertex visited. */
    visited[current] = true;
    discoveryOrder[discoverIndex++] = current;
    /* Examine each vertex adjacent to the current vertex */
    Iterator < Edge > itr = graph.edgeIterator(current);
    
    
    
    
    List<Edge> list = new ArrayList<>();
      
      while (itr.hasNext()) {
          Edge edge = itr.next();
          list.add(edge);
          
      }
      for(int i = 0;i< list.size();i++){
          for(int j = i+1;j< list.size();j++){
              /*if(list.get(i).getWeight() > list.get(j).getWeight()){
                  swap(i, j, list);
              }*/
          }
      }
    
    for(int i = 0; i < list.size();i++) {
        
        int res = findMinIdx(i , list);
        
        
        int neighbor = list.get(res).getDest();
        /* Process a neighbor that has not been visited */

        if (!visited[neighbor]) {
            /* Insert (current, neighbor) into the depth-
               first search tree. */
            parent[neighbor] = current;
            /* Recursively apply the algorithm
               starting at neighbor. */
            depthFirstSearch(neighbor);
        }
    }
    /* Mark current finished. */
    
    res[finishIndex] = (int) graph.vertexList.get(current).getWeight();
    finishOrder[finishIndex++] = current;
    
    return res;
  }

  /**** BEGIN EXERCISE ****/
  /** Get the finish order
      @return finish order
   */
  public int[] getFinishOrder() {
    return finishOrder;
  }

  /**** END EXERCISE ****/

    static class ShortestPath {
        // A utility function to find the vertex with minimum distance value,
        // from the set of vertices not yet included in shortest path tree
        static final int V = 9;
        int minDistance(int dist[], Boolean sptSet[])
        {
            // Initialize min value
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < V; v++)
                if (sptSet[v] == false && dist[v] <= min) {
                    min = dist[v];
                    min_index = v;
                }

            return min_index;
        }

        // A utility function to print the constructed distance array
        void printSolution(int dist[])
        {
            //System.out.println("Vertex \t\t Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i + " \t\t " + dist[i]);
        }

        // Function that implements Dijkstra's single source shortest path
        // algorithm for a graph represented using adjacency matrix
        // representation
        int[] dijkstra(double graph[][], int src)
        {
            int dist[] = new int[V]; // The output array. dist[i] will hold
            // the shortest distance from src to i

            // sptSet[i] will true if vertex i is included in shortest
            // path tree or shortest distance from src to i is finalized
            Boolean sptSet[] = new Boolean[V];

            // Initialize all distances as INFINITE and stpSet[] as false
            for (int i = 0; i < V; i++) {
                dist[i] = Integer.MAX_VALUE;
                sptSet[i] = false;
            }

            // Distance of source vertex from itself is always 0
            dist[src] = 0;

            // Find shortest path for all vertices
            for (int count = 0; count < V - 1; count++) {
                // Pick the minimum distance vertex from the set of vertices
                // not yet processed. u is always equal to src in first
                // iteration.
                int u = minDistance(dist, sptSet);

                // Mark the picked vertex as processed
                sptSet[u] = true;

                // Update dist value of the adjacent vertices of the
                // picked vertex.
                for (int v = 0; v < V; v++)

                    // Update dist[v] only if is not in sptSet, there is an
                    // edge from u to v, and total weight of path from src to
                    // v through u is smaller than current value of dist[v]
                    if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                        dist[v] = (int) (dist[u] + graph[u][v]);
            }

            // print the constructed distance array
            //printSolution(dist);
            return dist;
        }

    }



        /**
         * Perform a breadth-first search of a graph.
         * post: The array parent will contain the predecessor
         * of each vertex in the breadth-first
         * search tree.
         *
         * @param graph The graph to be searched
         * @param start The start vertex
         * @return The array of parents
         */
        public static int[] breadthFirstSearch(MyGraph<Integer> graph, int start) {

            Queue<Integer> theQueue = new LinkedList<Integer>();
            int[] parent = new int[graph.getNumV()];

            for (int i = 0; i < graph.getNumV(); i++) {
                parent[i] = -1;
            }

            boolean[] identified = new boolean[graph.getNumV()];

            identified[start] = true;
            theQueue.offer(start);

            while (!theQueue.isEmpty()) {
                int current = theQueue.remove();
                Iterator<Edge> itr = graph.edgeIterator(current);
                Iterator<Edge> itr1 = graph.edgeIterator(current);
                while (itr.hasNext()) {
                    Edge edge = itr.next();
                    //    Edge edge1=itr1.next();

                    int neighbor = edge.getDest();

                    if (!identified[neighbor]) {
                        identified[neighbor] = true;
                        theQueue.offer(neighbor);

                        parent[neighbor] = (int) graph.vertexList.get(edge.getDest()).getWeight();
                    }
                }

            }
            return parent;
        }




        public static void diffBetweenPaths(MyGraph<Integer> graph, int start , int end) {

            DepthFirstSearch depth = new DepthFirstSearch(graph);

            int [] arr  = depth.depthFirstSearch(start);
            int [] arr1 = BreadthFirstSearch.breadthFirstSearch(graph,start);
            arr1[0] = start;

            boolean a = false , b = false , c = false , d = false;
            double DFSCalculation = 0;
            double BFSCalculation = 0;


            for(int i = 0;i< arr.length;i++){
                if (arr[i] == end) {
                    if(a){
                        b = true;
                    }
                    break;
                }
                else if(arr[i] == start) a= true;

            }




            for(int i = 0;i< arr1.length;i++){
                if (arr1[i] == end) {
                    if(c){
                        d = true;

                    }
                    break;
                }
                else if(arr1[i] == start) c= true;

            }



            if(a){
                int idx = 0;

                while(arr[idx] != start) idx++;

                while(true){
                    //System.out.println(arr[idx] + "lets see " + graph.getEdgeArray()[arr[idx]][arr[idx+1]] +  "  " +  arr[idx+1]);
                    //res1+= graph.getEdgeList()[arr[idx]].get(arr[idx+1]).getWeight();
                    DFSCalculation+= graph.adjacencyMatrix[arr[idx]][arr[idx+1]];
                    idx++;
                    if(arr[idx] == end) break;

                }



            }
            else{
                int idx = 0;

                while(arr[idx] != end) idx++;
                while(true){

                    //res1+= graph.getEdgeList()[arr[idx]].get(arr[idx+1]).getWeight();
                    DFSCalculation+= graph.adjacencyMatrix[arr[idx]][arr[idx+1]];
                    idx++;
                    if(arr[idx] == start) break;

                }
            }


            if(c){
                int idx = 0;

                while(arr1[idx] != start) idx++;

                while(true){

                    //res2+= graph.getEdgeList()[arr1[idx]].get(arr1[idx+1]).getWeight();
                    BFSCalculation+= graph.adjacencyMatrix[arr1[idx]][arr1[idx+1]];
                    idx++;
                    if(arr1[idx] == end) break;

                }

            }

            else{
                int idx = 0;

                while(arr1[idx] != end) idx++;
                while(true){

                    //res2+= graph.getEdgeList()[arr1[idx]].get(arr1[idx+1]).getWeight();
                    BFSCalculation+= graph.adjacencyMatrix[arr1[idx]][arr1[idx+1]];
                    idx++;
                    if(arr1[idx] == start) break;

                }
            }

        /*int predArray[] = new int[100];
        double distanceArray[] = new double[100];

        DijkstrasAlgorithm testDijkstrasAlgorithm = new DijkstrasAlgorithm();

        testDijkstrasAlgorithm.dijkstrasAlgorithm(graph,start,predArray,distanceArray);

        for(int i = 0 ; i< 100;i++){
            res1 += distanceArray[i];
        }
        */

            ShortestPath path = new ShortestPath();
            DFSCalculation += path.dijkstra(graph.adjacencyMatrix, start)[end];

            System.out.println("DFS Calculation : "+DFSCalculation);
            System.out.println("BFS Calculation : "+BFSCalculation);
            System.out.println("DFS - BFS : "+ (DFSCalculation - BFSCalculation));




        }
    }


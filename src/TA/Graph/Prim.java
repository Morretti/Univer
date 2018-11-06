package TA.Graph;


public class Prim {
    public static void main(String[] args) {
        int [][] graph = {  {0,7,0,5,0,0,0},
                            {7,0,8,9,7,0,0},
                            {0,8,0,0,5,0,0},
                            {5,9,0,0,15,6,0},
                            {0,7,5,15,0,8,9},
                            {0,0,0,6,8,0,11},
                            {0,0,0,0,9,11,0},};
        int[] mst = new int[graph.length];
        int[] weight = new int[graph.length];

        primMST(graph,weight,mst);

        for (int i = 1; i < graph.length; i++){
            System.out.println(i + " -> " + mst[i] + "\t\tweight: " + weight[i]);
        }

    }

    static void primMST(int[][] graph, int[] minWeightEdge, int[] MST){
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++){
            visited[i] = false;
            minWeightEdge[i] = Integer.MAX_VALUE;
        }

        minWeightEdge[0] = 0;

        for (int i = 0; i < graph.length; i++){
            //Ищем не посещенную вершину у которой есть мнимальное ребро
            int minEdge = getMinEdge(minWeightEdge,visited);
            //Отмечаем ее как посещенную
            visited[minEdge] = true;

            //Ищем непосещенную вершину связаную с посещенной
            for (int j = 0; j < graph.length; j++){
                if (graph[minEdge][j] != 0 && !visited[j] && graph[minEdge][j] < minWeightEdge[j]){
                    //Записываем вес ребра, ведущего к этой вершины
                    minWeightEdge[j] = graph[minEdge][j];
                    //Записываем вершину
                    MST[j] = minEdge;
                }
            }
        }
    }

    private static int getMinEdge(int[] key, boolean[] visited){
        int result = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < key.length; i++){
            if (key[i] < min && !visited[i]) {
                min = key[i];
                result = i;
            }
        }

        return result;
    }

//    static int minKey(int key[], Boolean mstSet[])
//    {
//        // Initialize min value
//        int min = Integer.MAX_VALUE, min_index=-1;
//
//        for (int v = 0; v < 7; v++)
//            if (mstSet[v] == false && key[v] < min)
//            {
//                min = key[v];
//                min_index = v;
//            }
//
//        return min_index;
//    }
//
//    static void printMST(int parent[], int n, int graph[][])
//    {
//        System.out.println("Edge \tWeight");
//        for (int i = 1; i < graph.length; i++)
//            System.out.println(parent[i]+" - "+ i+"\t"+
//                    graph[i][parent[i]]);
//    }
//
//    static void primMST(int graph[][]) {
//        int parent[] = new int[graph.length];
//        int key[] = new int[graph.length];
//        Boolean mstSet[] = new Boolean[graph.length];
//
//        for (int i = 0; i < graph.length; i++) {
//            key[i] = Integer.MAX_VALUE;
//            mstSet[i] = false;
//        }
//
//        key[0] = 0;
//        parent[0] = -1;
//
//        for (int count = 0; count < graph.length - 1; count++) {
//            int u = minKey(key, mstSet);
//            mstSet[u] = true;
//            for (int v = 0; v < graph.length; v++)
//                if (graph[u][v] != 0 && mstSet[v] == false &&
//                        graph[u][v] < key[v]) {
//                    parent[v] = u;
//                    key[v] = graph[u][v];
//                }
//        }
//        printMST(parent, graph.length, graph);
//    }
}

package TA.Graph;

public class Dijkstra {
    public static void main(String[] args) {
        int [][] graph = {  {0, 7, 0, 5, 0, 0,0},
                            {7, 0, 8, 9, 7, 0,0},
                            {0, 8, 0, 0, 5, 0,0},
                            {5, 9, 0, 0,15, 6,0},
                            {0, 7, 5,15, 0, 8,9},
                            {0, 0, 0, 6, 8, 0,11},
                            {0, 0, 0, 0, 9,11,0},};


        int[] result = dijkstra(graph,0);

        System.out.println("Вершина\t\tРастояние от источника");
        for (int i = 1; i < result.length; i++){
            System.out.println(i + "\t\t\t\t" + result[i]);
        }
    }

    static int minDistance(int[] distances, boolean[] checked){
        int min = Integer.MAX_VALUE, index = -1;

        for (int i = 0; i < distances.length; i++) {
            if(distances[i] < min && !checked[i]) {
                min = distances[i];
                index = i;
            }
        }

        return index;
    }

    static int[] dijkstra(int[][] graph, int source){
        boolean[] used = new boolean[graph.length];
        int[] distance = new int[graph.length];
        int minDistanceIndex = 0;

        for (int i = 0; i < graph.length; i++) {
            used[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;

        for(int i = 0; i < graph.length-1; i++){
            minDistanceIndex = minDistance(distance, used);
            used[minDistanceIndex] = true;

            for (int j = 0; j < graph.length; j++) {
                if(!used[j] && graph[minDistanceIndex][j] != 0
                        && distance[minDistanceIndex] != Integer.MAX_VALUE
                        && distance[minDistanceIndex] + graph[minDistanceIndex][j] < distance[j])
                    distance[j] = distance[minDistanceIndex] + graph[minDistanceIndex][j];
            }
        }
        return distance;
    }

}

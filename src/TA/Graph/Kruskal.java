package TA.Graph;

public class Kruskal {
    public static void main(String[] args) {
        int [][] graph = {  {0,7,0,5,0,0,0},
                            {7,0,8,9,7,0,0},
                            {0,8,0,0,5,0,0},
                            {5,9,0,0,15,6,0},
                            {0,7,5,15,0,8,9},
                            {0,0,0,6,8,0,11},
                            {0,0,0,0,9,11,0},};

        kruskal(graph);
    }

    static void kruskal(int[][] graph){
        int[] weight;
        int[] source;
        int[] destination;
        int[] setOfUsingVertices = new int[graph.length];
        int edges = 0;

        for (int i = 0; i < graph.length; i++){
            for (int j = 0; j < graph.length; j++){
                if (graph[i][j] != 0){
                    graph[j][i] = 0;
                    ++edges;
                }
            }
        }

        weight = new int[edges];
        source = new int[edges];
        destination = new int[edges];
        int index = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if(graph[i][j] != 0){
                    weight[index] = graph[i][j];
                    source[index] = i;
                    destination[index++] = j;
                }
            }
        }

        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight.length-1; j++) {
                if (weight[j] > weight[j+1]){
                    int tmp = weight[j+1];
                    weight[j+1] = weight[j];
                    weight[j] = tmp;

                    tmp = source[j+1];
                    source[j+1] = source[j];
                    source[j] = tmp;

                    tmp = destination[j+1];
                    destination[j+1] = destination[j];
                    destination[j] = tmp;
                }
            }
        }



//        for(int i = 0; i < weight.length; i++){
//            System.out.println(weight[i] + "\t" + source[i] + "\t" + destination[i]);
//        }
    }


}

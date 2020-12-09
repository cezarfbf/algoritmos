import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Dijkstras {

    public static void main(String[] args){

        List l[] = new LinkedList[2];
        PriorityQueue pq;

        int[][] edges = new int[4][3];

//        1 2 24
        edges[0][0] = 1;
        edges[0][1] = 2;
        edges[0][2] = 24;
//        1 4 20
        edges[1][0] = 1;
        edges[1][1] = 4;
        edges[1][2] = 20;
//        3 1 3
        edges[2][0] = 3;
        edges[2][1] = 1;
        edges[2][2] = 3;
//        4 3 12
        edges[3][0] = 4;
        edges[3][1] = 3;
        edges[3][2] = 12;

//        Arrays.stream(shortestReach(4,edges,1))
//        .forEach(d -> System.out.print(d+" "));

        DijkstrasShortestPathAdjacencyList dkt = new DijkstrasShortestPathAdjacencyList(4);

        dkt.addEdge(0,1,6);
        dkt.addEdge(0,2,6);

        dkt.getGraph()
                .forEach(ls -> ls
                        .forEach(edge -> System.out.print(edge.from+" "+edge.to+" "+(int)edge.cost)));
        for (double d : dkt.dijkstra(0,2)
             ) {
            System.out.println(d);
        }

        System.out.println(dkt.reconstructPath(0,3));

    }

    static int[] shortestReach(int n, int[][] edges, int s) {

        //decrementa o source pq array são a partir de 0
        int src = s - 1;
        //instancia a matriz de adjacencia com número de nós e preenche toda matriz com a estimativa máxima
        int matrix[][] = IntStream.range(0, n)
                .mapToObj(i -> IntStream.generate(() -> Integer.MAX_VALUE).limit(n).toArray())
                .toArray(i -> new int[n][]);
        // array para guardar o calculo de destancias. preenche distancias com estimativa máxima
        int distance[] = IntStream.generate(() -> Integer.MAX_VALUE).limit(n).toArray();
        // Zera distancia da origem
        distance[src]=0;
        // array para guardar os nós visitados
        boolean visited[] = new boolean[n];

        //preenche a matriz com os valores de entrada
        Arrays.stream(edges).forEach(edge -> {
            // decramenta 1 dos nós de origem e destino
            int from=edge[0]-1;
            int to=edge[1]-1;
            // pega o peso
            int peso=edge[2];
            if(matrix[from][to]>peso || matrix[to][from]>peso)
            {
                matrix[from][to]=peso;
                matrix[to][from]=peso;
            }
        });

//        for(int i=0;i<matrix.length;i++) {
//            System.out.println(" ");
//            for(int j=0;j<matrix[i].length;j++){
//                System.out.print(matrix[i][j]+" ");
//            }
//        }

        // itera sobre o numero de nodes da matriz
        for(int i=0;i<n;i++)
        {
            // busca menor distancia(peso) não visitado
            int minorNode = findMinNode(distance,visited);
            visited[minorNode]=true;

            for(int j=0;j<n;j++) {
                // se o nó não foi visitado, valor do nó diferente do máximo,
                // distancia diferente do máximo e soma da ultima menor distancia
                // com o valor do nó menor que a proxima distancia
                if(!visited[j] &&
                        matrix[minorNode][j] != Integer.MAX_VALUE &&
                        distance[minorNode] != Integer.MAX_VALUE &&
                        distance[minorNode] + matrix[minorNode][j] < distance[j]) {
                    //proxima distancia recebe ultima menor distancia mais valor do nó
                    distance[j] = distance[minorNode] + matrix[minorNode][j];
                }
            }
        }

        return IntStream.range(0, distance.length)
                .filter(i -> i != src)
                .map(i -> distance[i] != Integer.MAX_VALUE ? distance[i] : -1)
                .toArray();
    }

    public static int findMinNode(int dist[],boolean visited[])
    {
        int maxEstimate = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<dist.length;i++)
        {
            if(!visited[i] && dist[i] <= maxEstimate)
            {
                maxEstimate = dist[i];
                index = i;
            }
        }
        return index;
    }
}

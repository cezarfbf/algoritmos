import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class HRSolution {

    // Complete the shortestReach function below.
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

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        while(t-->0)
        {
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int[][] edges = new int[m][3];

            for (int i = 0; i < m; i++) {

                st=new StringTokenizer(br.readLine());
                edges[i][0] =Integer.parseInt(st.nextToken());
                edges[i][1] =Integer.parseInt(st.nextToken());
                edges[i][2] =Integer.parseInt(st.nextToken());
            }

            int s = Integer.parseInt(br.readLine());

            Arrays.stream(shortestReach(n,edges,s))
                    .forEach(d -> System.out.print(d+" "));
            System.out.println();

        }
    }
}


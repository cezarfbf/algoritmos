public class AlgoritmosOrdenacao {

    public static void main(String[] args) {
        int vetor[] = new int[10];

        for (int i=0; i<vetor.length; i++){
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.print(vetor[i]+" ");
        }

        //BUBBLE SORT O(N)^2
        bubbleSort(vetor);

        //SELECTION SORT O(N)^2
        selectSort(vetor);
    }

    private static void bubbleSort(int[] vetor) {
        int aux;
        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i] > vetor[j]) {
                    aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }

        System.out.print("\nBubble Sort: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }

    private static void selectSort(int[] vetor) {
        int menor_pos, aux;
        for (int i = 0; i < vetor.length; i++) {
            menor_pos = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor_pos]) {
                    menor_pos = j;
                }
            }
            aux = vetor[menor_pos];
            vetor[menor_pos] = vetor[i];
            vetor[i] = aux;
        }

        System.out.print("\nSelect Sort: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
}

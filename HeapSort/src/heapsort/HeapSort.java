/*
Custo computacional Teta(n log n)

Objetivo: * Organizar um vetor utilizando estrutura de dados arvore heap
          * Arvore heap é binaria - organiza de acordo, os filhos de um nó pai 
          * Os filhos precisam ser sempre menores que o nó pai
 */
package heapsort;

import java.time.Clock;


public class HeapSort {

    
    public static void ordenar(int[] vetor){
        
        //Primeira Chamada de Montagem da Arvore
        
        montarArvore(vetor);
        int n = vetor.length;
        
        // Para uma arvore de tamanho n, ordenar n - 1 vezes
        
        for(int i = vetor.length - 1; i > 0; i--){
            
            int aux = vetor[i];
            vetor[i] = vetor[0];
            vetor[0] = aux;
            ordenarArvore(vetor, 0, --n);
            
        }
        
    }
    public static void montarArvore(int[] vetor){
        for(int posicao = (vetor.length - 1) /2; posicao >= 0; posicao--){
            ordenarArvore(vetor, posicao, vetor.length);
        }
}
    
    //O metodo recebe o vetor a ser ordenado, a posição e o tamanho do vetor
    
   public static void ordenarArvore(int[]vetor, int posicao, int tamanho){
       
    // Separar os nós pais do filhos
    //O inidice do filho da esquerda é 2*i +1 do nó pai 
    //O inidice do filho da direita é 2*i + 2 do nó pai 
    
    int indiceFilhoEsq = 2 * posicao + 1;
    int indiceFilhoDir = indiceFilhoEsq + 1;
    
    //Condição de parada da recursão 
    if(indiceFilhoEsq < tamanho){ // Verifica se ainda está dentro do vetor de entrada
        if(indiceFilhoDir <tamanho){ // Verifica se ainda está dentro do vetor de entrada
            if(vetor[indiceFilhoEsq] < vetor[indiceFilhoDir]){ // Se o filho esq for menor
                indiceFilhoEsq = indiceFilhoDir;
            }
        }
          //Comparação do filho com o Pai
    if(vetor[indiceFilhoEsq] > vetor[posicao]){
        
        int aux = vetor[indiceFilhoEsq];
        vetor[indiceFilhoEsq] = vetor[posicao];
        vetor[posicao] = aux;
        
     //Reconstruida a arvore depois da troca
        ordenarArvore(vetor, indiceFilhoEsq, tamanho);
    }
    }
    
  
    
   }
    public static void main(String[] args) {
        
        int [] vetor = {9, 5, 88, 76, 44, 18, 0, 11, 21};
        System.out.print("Lista antes: ");
        for (int i:vetor){
           System.out.print(i + " ");
        }
        System.out.println();
        ordenar(vetor);
        System.out.print("Lista Depois: ");
        for (int i:vetor){
           System.out.print(i +" ");
        }
    }
    
}

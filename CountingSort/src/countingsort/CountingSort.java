/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingsort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nieds
 */
public class CountingSort {
    
    //METODO PARA ENCONTRAR O INDICE DE MAIOR VALOR 
    public int getIndiceDoMaiorValor(int[] v){
        int m = 0;
        for(int i = 0; i<v.length; i++){
                if(v[i] >v[m]){
                    m = i;
                }
        }
            return m;
        }
    
    public void CountingSort(int[] vetor){
        
       int maior = getIndiceDoMaiorValor(vetor);
       int[] aux = new int[vetor[maior]+1]; //Cria um vetor auxilar de tamanho vetor +1
       int[] saida = new int[vetor.length]; //Cria um vetor de sapida de tamanho igual a VETOR
       
       //Zera todos os valores do vetor AUX
       for(int i = 0; i< aux.length; i++){
           aux[i] = 0;
       }
       
       //Percorre todo o vetor de entrada e incrementa no indice correspondente em AUX
       for(int i = 0; i<vetor.length;i++){
           aux[vetor[i]] +=1;
       }
       
       //Soma o valor do indice 1 com o valor do indice anterior e assim até chegar ao final de AUX
       for(int i = 1; i<aux.length;i++){
           aux[i] += aux[i-1];
       }
       
       //Usa do valor do vetor como indice no aux, pegando o valor desse indice
       //e usando indice menos 1 para inserir o valor do vetor
       //Depois decrementa aux[i]
       for(int i = 0; i<vetor.length;i++){
            saida[aux[vetor[i]]-- -1] = vetor[i];
            
      }
       
       System.out.println(Arrays.toString(saida));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CountingSort array = new CountingSort();
        int[] entrada = {1,3,2,4,5,44,5,1,8,0,9,99,1};
        array.CountingSort(entrada);
        
    
    }
    
}

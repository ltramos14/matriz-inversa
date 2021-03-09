/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unicundi.matrizinversa;

/**
 * 
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.0.0
 * @since 1.0.0
 */

public class Inverse {

    /**
     * Constructor que inicializa la clase Inverse
     */
    public Inverse() {
    }

    /**
     * Método que transpone la matriz original 
     * @param matrix Matriz original que es digitada en consola
     * @return la matriz adjunta calculada
     */
    private double[][] transposedMatrix(int matrix[][]){
       
       //Variable que intercala las posiciones de la matriz original
       int auxiliar;
       //Variable en donde se va a almacenar la matriz transpuesta
       double transposedMatrix[][];
       
       for(int i = 0; i < 3; i++) {
           for(int j = 0; j < 3; j++) {
                auxiliar = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = auxiliar;
           }   
       }
       
       transposedMatrix = calculateAdjointMatrix(matrix);
       return transposedMatrix;
    }
    
    /**
     * Método que calcula la matriz adjunta a partir de la matriz transpuesta
     * @param matrix Matriz transpuesta
     * @return la matriz adjunta
     */
    private double[][] calculateAdjointMatrix(int matrix[][]) {
        
        //Variable que almacena la matriz adjunta que se va a calcular
        double[][] adjointMatrix = new double[3][3];
        
        //Ciclos for que recorren la matriz que ingresa para calcular sus cofactores
        for(int i = 0; i < 3; i++) {       
            for(int j = 0; j < 3; j++) {
                
                //Variable que almacena los cofactores de la matriz periodicamente
                double[][] cofactorMatrix = new double[2][2];
                
                for(int k = 0; k < 3; k++) {
                    if(k != i) {
                        for(int l = 0; l < 3; l++) {
                            if(l != j) {
                                int index1 = k < i ? k : k-1;
                                int index2 = l < j ? l : l-1;
                                cofactorMatrix[index1][index2] = matrix[k][l];
                            }
                        }
                    }
                }
                //Asignación de valor a cada posición de la matriz adjunta por medio
                //de los cofactores calculados
                adjointMatrix[i][j]= (double) Math.pow(-1,j+i+2) * ((cofactorMatrix[0][0] 
                        * cofactorMatrix[1][1])-(cofactorMatrix[0][1] * cofactorMatrix[1][0]));
            }
        }
        return adjointMatrix;
    }
    
    /**
     * Método que calcula la matriz inversa a partir de la matriz original y su determinante
     * @param determinant que ingresa de la clase Matrix
     * @param matrix matriz original digitada por el usuario
     * @return Matriz inversa calculada
     */
    public double[][] calculateInverseMatrix(double determinant, int matrix[][]) {
        
        //Variable que contiene la matriz inversa 
        double inverseMatrix[][];
        //Variable que almacena los calculos de la matriz transpuesta y adjunta
        inverseMatrix = transposedMatrix(matrix);
        
        //Ciclo for que se encarga de multiplicar cada valor de la matriz inversa
        //por el determinante calculado
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                inverseMatrix[i][j] *= determinant;
            }
        }
        return inverseMatrix;
    }
}
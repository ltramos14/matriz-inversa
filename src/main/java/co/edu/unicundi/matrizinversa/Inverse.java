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

    private double[][] transposedMatrix(double matrix[][]){
       
       double auxiliar = 0.0;
       for(int i = 0; i < 3; i++) {
           for(int j = 0; j < 3; j++) {
                auxiliar = matrix[i][j];
                matrix[i][j] = matrix[j][i];
           }   
       }
       return matrix;
   }
    
    private double[][] calculateAdjointMatrix(double determinante, int matrix[][]) {
        
        double[][] matrizInversa = new double[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j< 3; j++) {
                double[][] matrizDet = new double[2][2];
                for(int k = 0; k<3;k++) {
                    if(k!=i) {
                        for(int l=0;l<3;l++) {
                            if(l!=j) {
                                int indice1=k<i? k : k-1 ;
                                int indice2=l<j ? l : l-1 ;
                                matrizDet[indice1][indice2]=matrix[k][l];
                            }
                        }
                    }
                }
        matrizInversa[i][j]= (double)Math.pow(-1,j+i+2)*((matrizDet[0][0]*matrizDet[1][1])-(matrizDet[0][1]*matrizDet[1][0]));
            }
        }
        transposedMatrix(matrizInversa);
        return matrizInversa;
    }
    
    public double[][] calculateInverseMatrix(double determinante, int matrix[][]) {
        
        double inverseMatrix[][];
        inverseMatrix = calculateAdjointMatrix(determinante, matrix);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                inverseMatrix[i][j] *= determinante;
            }
        }
        return inverseMatrix;
    }
}

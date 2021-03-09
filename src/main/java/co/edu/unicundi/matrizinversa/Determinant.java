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

public class Determinant {

    /**
     * Constructor que instancia la clase Determinat
     */
    public Determinant() {
    }
    
    /**
     * Método que calcula la magnitud de la matriz por medio de sus diagonales
     * @param matrix Matriz original ingresada en consola
     * @return la magnitud calculada de la matriz original
     */
    public double calculateMagnitude(int matrix[][]) {
        
    //Variable que almacena los calculos de las diagonales derechas de la matriz
        int leftDiagonal = (matrix[0][0] * matrix[1][1] * matrix[2][2]) + 
                           (matrix[1][0] * matrix[2][1] * matrix[0][2]) + 
                           (matrix[2][0] * matrix[0][1] * matrix[1][2]); 
        
    //Variable que almacena los calculos de las diagonales izquierdas de la matriz
        int rightDiagonal = (matrix[0][2] * matrix[1][1] * matrix[2][0]) + 
                            (matrix[1][2] * matrix[2][1] * matrix[0][0]) + 
                            (matrix[2][2] * matrix[0][1] * matrix[1][0]); 
        
        int magnitude  = leftDiagonal - rightDiagonal;
        
        return magnitude;     
    }      
}
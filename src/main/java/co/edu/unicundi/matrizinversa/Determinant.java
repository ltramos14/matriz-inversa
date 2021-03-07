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
    
    public double calculateDeterminant(int matrix[][]) {
        
        int leftDiagonal = (matrix[0][0] * matrix[1][1] * matrix[2][2]) + 
                           (matrix[1][0] * matrix[2][1] * matrix[0][2]) + 
                           (matrix[2][0] * matrix[0][1] * matrix[1][2]); 
        
        int rightDiagonal = (matrix[0][2] * matrix[1][1] * matrix[2][0]) + 
                            (matrix[1][2] * matrix[2][1] * matrix[0][0]) + 
                            (matrix[2][2] * matrix[0][1] * matrix[1][0]); 
        
        int magnitude  = leftDiagonal - rightDiagonal;
        
        return magnitude;
        
    }
      
}

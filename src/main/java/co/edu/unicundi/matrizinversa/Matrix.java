/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unicundi.matrizinversa;

import java.util.Scanner;

/**
 * 
 * @author Tatiana Ramos Villanueva
 * @author Nicolás Nieto Cárdenas
 * @version 1.0.0
 * @since 1.0.0
 */
public class Matrix {

   /**
    * Arreglo de dos dimensiones que almacena matriz inicial de números enteros
    */
   private int matrix[][];
   
   private double inverseMatrix[][];

   /**
    * Constructor que instancia la clase Matrix
    */
   public Matrix() {
       this.matrix = new int[3][3];
       this.inverseMatrix = new double[3][3];
   }
   
   
   /**
    * Método que llena el arreglo matrix con números enteros
    */
   public void fillMatrix() {
       
       Scanner entry = new Scanner(System.in);
       
       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
               System.out.println("MATRIZ [ " + i + " ] [ " + j + " ] = ");
               this.matrix[i][j] = entry.nextInt();
           }
       }
       showMatrix(matrix);
       calculateInverseMatrix(matrix);
   }
   
   /**
    * Método que imprime en consola la matriz original
    * @param matrix 
    */
   public void showMatrix(int matrix[][]) {
       
       for(int i = 0; i < 3; i++) {
           for(int j = 0; j < 3; j++) {
                System.out.print(String.format("%3d",  matrix[i][j]) + " ");
           }
           System.out.println(" ");
       }
   }
  
   
   public void calculateInverseMatrix(int matrix[][]) {
       
       Determinant objDeterminant = new Determinant();
       Inverse objInverseMatrix = new Inverse();
       
       double determinant = 1/objDeterminant.calculateDeterminant(matrix);
       this.inverseMatrix = objInverseMatrix.calculateInverseMatrix(determinant, matrix);
       
       printInverseMatrix(this.inverseMatrix);
     
   }
   
   public void printInverseMatrix(double matrix[][]) {
       for(int i = 0; i < 3; i++) {
           for(int j = 0; j < 3; j++) {
                 System.out.print(matrix[i][j]+ " ");
           }
           System.out.println(" ");
       }
   }
}

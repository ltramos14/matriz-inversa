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
   
   /**
    * Arreglo de dos dimensiones que almacena la matriz inversa
    */
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
       
       System.out.println(" **  PROGRAMA QUE CALCULA EL DETERMINANTE Y "
               + "LA INVERSA DE UNA MATRIZ DE [3][3]  **");
       
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
       
       System.out.println("** MATRIZ [3][3] ORIGINAL **");
       
       for(int i = 0; i < 3; i++) {
           for(int j = 0; j < 3; j++) {
                System.out.print(String.format("%3d",  matrix[i][j]) + " ");
            }
           System.out.println(" ");
        }
    }
  
   /**
    * Método que incializa objetos de las clases Determinant e Inverse
    * @param matrix Matriz digitada por el usuario
    */
    public void calculateInverseMatrix(int matrix[][]) {
       
       /**
        *Objetos que inicializan el constructor de las clases Determinant e Inverse
        */
       Determinant objDeterminant = new Determinant();
       Inverse objInverseMatrix = new Inverse();
       
       //Variable que almacena el inverso de la magnitud calculada -> Determinante
       double determinant = 1/objDeterminant.calculateMagnitude(matrix);
       //Asignación de la matriz inversa calculada en la clase Inverse
       this.inverseMatrix = objInverseMatrix.calculateInverseMatrix(determinant, matrix);

       printInverseMatrix(this.inverseMatrix);
        
       System.out.print("** El determinante de la matriz es:  " + determinant); 
    }
   
   /**
    * Método que imprime en consola la matriz inversa calculada
    * @param matrix Matriz inversa almacenada 
    */
    public void printInverseMatrix(double matrix[][]) {
       
       System.out.print("** MATRIZ [3][3] INVERSA **" + '\n');
        
       for(int i = 0; i < 3; i++) {
           for(int j = 0; j < 3; j++) {
                 System.out.print(matrix[j][i]+ "  ");
            }
           System.out.println("  ");
        }
    } 
}

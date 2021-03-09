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
public class Main {

    /**
     * Constructor de la clase Main
     */
    public Main() {
        Matrix matrix = new Matrix();
        matrix.fillMatrix();
    }
    
    /**
     * Método main que inicia la ejecución del programa
     * @param args 
     */
    public static void main(String[] args) {
        
        //Objeto para iniciar el constructor de la clase Main
        Main principal = new  Main();
    }                
}
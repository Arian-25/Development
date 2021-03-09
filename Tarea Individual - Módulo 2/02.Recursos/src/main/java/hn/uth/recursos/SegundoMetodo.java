/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.recursos;

import java.util.Scanner;

/**
 *
 * @author arian
 */
public class SegundoMetodo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Este sera el codigo de nuestro segundo metodo
        
        Scanner scanner = new Scanner(System.in);
        int edad;
        System.out.print("Ingresa su edad: ");
        edad = scanner.nextInt();
        
        NewClass verificar = new NewClass();       
        verificar.VerificarEdad(edad);
    }

}

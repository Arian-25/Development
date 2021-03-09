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

public class TercerMetodo {
    
    public static void main(String[] args) {
        // Aqui escribiremos nuestro tercer metodo
        
        Scanner scanner = new Scanner(System.in);
        Operacion operaciones = new Operacion();
        int number1;
        int number2;
        System.out.print("Multiplicación De Dos Números");
        System.out.print("\n Ingrese Número 1: ");
        number1 = scanner.nextInt();
        
        System.out.print("\n Ingrese Número 2: ");
        number2 = scanner.nextInt();
        
        operaciones.Multiplicar(number1, number2);
    }
    
}

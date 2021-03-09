/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.arith;

import java.util.Scanner;

/**
 *
 * @author arian
 */
public class Operaciones {
    
    public static void main(String[] args) {
        // Creamos los puntos flotantes
        float number1;
        float number2;
        float resultado;
        String leer;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por Favor Ingresa El Primer Número\n");
        number1 = scanner.nextFloat();
          
        System.out.println("Por Favor Ingresa El Segundo número\n");
        number2 = scanner.nextFloat();
        
        //Adicion
        resultado = number1 + number2;
        System.out.println("\n Resultado de una Adicion es: "+ resultado);
        
        //Sustraccion
        resultado = number1 - number2;
        System.out.println("\n Resultado de una Sustraccion es: "+ resultado);
        
        //Multiplicacion
        resultado = number1 * number2;
        System.out.println("\n Resultado de una Multiplicación es: "+ resultado);
        
        //Division
        resultado = number1 / number2;
        System.out.println("\n Resultado de una División es: "+ resultado);
    }
    
}

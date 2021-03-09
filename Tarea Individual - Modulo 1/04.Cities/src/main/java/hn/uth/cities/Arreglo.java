/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.cities;

import java.util.Scanner;

/**
 *
 * @author arian
 */
public class Arreglo {
    public static void main(String[] args) {
        // Nuestro codigo de las ciudades sera el siguiente: 
       Scanner scanner = new Scanner(System.in);
       String[] ciudades = new String[20];
       int contador = 1;
       
       System.out.print("Escriba el nombre de 20 ciudades");
        for (int i = 0; i < 20; i++) {
            System.out.print("\n Escriba ciudad Número " + contador + ":" );
            ciudades[i] = scanner.next();
            contador= contador + 1;
        }  
        
        System.out.print("\n Las ciudades guardadas seran:");
        for (int i = 0; i <20; i++) {
            System.out.print("\n" + ciudades[i]);
        }
    }
    
}

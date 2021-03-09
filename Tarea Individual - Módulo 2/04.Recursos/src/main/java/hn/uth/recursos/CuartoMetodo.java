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
public class CuartoMetodo {
    public static void main(String[] args) {
        Lista lista = new Lista();
        Scanner scanner = new Scanner(System.in);
        int numero;
        System.out.print("Ingrese el numero maximo que desea imprimir en la lista: ");
        numero = scanner.nextInt();
        
        lista.GenerarLista(numero);
        
    }
    
}

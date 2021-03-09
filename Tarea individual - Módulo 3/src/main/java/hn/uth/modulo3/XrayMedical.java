/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.modulo3;

/**
 *
 * @author arian
 */
public class XrayMedical {
    
    public static void main(String[] args) {
      Developing developing = new Developing();
      developing.setEquipo("Acelerador Lineal de Particulas");
      developing.setMarca("ELEKTA");
      developing.setModelo("SYNERGY");
      developing.setSerie(152816);
      developing.setEspecializacion("Radioterapia");
      
      System.out.println("Equipo:" + developing.getEquipo());
      System.out.println("Marca:" + developing.getMarca());
      System.out.println("Modelo:" + developing.getModelo());
      System.out.println("Serie:" + developing.getSerie());
      System.out.println("Especializacion:" + developing.getEspecializacion());
           
    }
}

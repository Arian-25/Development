/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.tareano4;

import ayudas.Doctor;
import ayudas.HospitalDelTorax;
import ayudas.HospitalEscuela;
import ayudas.HospitalMarioCatarino;

/**
 *
 * @author arian
 */
public class Directores {
    
        /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // Parte No 1 Tarea
        Doctor doctor = new Doctor();
        
        // Estableciendo informacion del Director
        doctor.setNombre("Juan");
        doctor.setApellido("Garcia");
        doctor.setEdad(42);
        doctor.setAniosExperiencia(12);
        
        // Obteniendo informacion del Docctor o Director
        System.out.println("Nombre Doctor:" + doctor.getNombre() + " " + doctor.getApellido());
        System.out.println("Edad: " + doctor.getEdad());
        System.out.println("Años de experiencia: " + doctor.getAniosExperiencia());
        
        System.out.println();
        // Parte No 2 Tarea
        HospitalEscuela hEscuela = new HospitalEscuela();
        HospitalMarioCatarino hMarioCatarino = new HospitalMarioCatarino();
        HospitalDelTorax hDelTorax = new HospitalDelTorax();
        
        // Imprimir nombre de los Hospitales con su Director
        System.out.println(hEscuela.getNombreHospital() + ", director(a): " + hEscuela.getDirector());
        System.out.println(hMarioCatarino.getNombreHospital() + ", director(a): " + hMarioCatarino.getDirector());
        System.out.println(hDelTorax.getNombreHospital() + ", director(a): " + hDelTorax.getDirector());

    }
    
}

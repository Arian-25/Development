/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudas;

/**
 *
 * @author arian
 */
public class HospitalEscuela extends Hospital {
    
    @Override
    public String getNombreHospital() {
        return "Hospital Escuela Universitario";
    }

    @Override
    public String getDirector() {
        return "Cristina Suyapa Rodriguez";
    }
    
    @Override
    public String getPais() {
        return "Honduras";
    }
}

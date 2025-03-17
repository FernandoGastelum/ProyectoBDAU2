/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOS.AlumnoDTO;
import DTOS.GuardarAlumnoDTO;
import Entidades.AlumnoEntidad;
import Excepcion.NegocioException;
import Excepcion.PersistenciaException;
import Interfaz.IAlumnoDAO;
import Interfaz.IAlumnoNegocio;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gaspa
 */
public class AlumnoNegocio implements IAlumnoNegocio{
    private IAlumnoDAO alumnoDAO;
    
    public AlumnoNegocio(IAlumnoDAO alumnoDAO){
        this.alumnoDAO = alumnoDAO;
    }
    @Override
    public AlumnoDTO guardar(GuardarAlumnoDTO alumno) throws NegocioException {
        if(this.reglasNegocioGuardar()){
            try {
                AlumnoEntidad alumnoGuardado = this.alumnoDAO.guardar(alumno);
                return this.alumnoDAO.obtenerAlumnoDTO(alumnoGuardado.getId());
            } catch (PersistenciaException ex) {
                System.out.println("Error: "+ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public AlumnoDTO obtener() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean reglasNegocioGuardar(){
        return true;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import DTOS.AlumnoDTO;
import DTOS.GuardarAlumnoDTO;
import Entidades.AlumnoEntidad;
import Excepcion.PersistenciaException;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo
 */
public interface IAlumnoDAO {
    AlumnoEntidad guardar(GuardarAlumnoDTO alumno) throws PersistenciaException;
    
    AlumnoEntidad obtenerPorID(Long id) throws PersistenciaException;
    
    List<AlumnoEntidad> obtener() throws PersistenciaException;
    
    AlumnoDTO obtenerAlumnoDTO(Long id);
}

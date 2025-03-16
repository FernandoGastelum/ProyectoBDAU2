/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import DTOS.AlumnoDTO;
import Entidades.AlumnoEntidad;
import Excepcion.PersistenciaException;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo
 */
public interface IAlumnoDAO {
    void guardar(AlumnoEntidad alumno) throws PersistenciaException;
    
    public AlumnoEntidad obtenerPorID(Long id) throws PersistenciaException;
    
    public List<AlumnoEntidad> obtener() throws PersistenciaException;
}

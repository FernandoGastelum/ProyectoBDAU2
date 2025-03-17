/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import DTOS.AlumnoDTO;
import DTOS.GuardarAlumnoDTO;
import Entidades.AlumnoEntidad;
import Excepcion.NegocioException;

/**
 *
 * @author gaspa
 */
public interface IAlumnoNegocio {
    AlumnoDTO guardar(GuardarAlumnoDTO alumno) throws NegocioException;
    AlumnoDTO obtener() throws NegocioException;
}

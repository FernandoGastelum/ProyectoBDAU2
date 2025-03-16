/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTOS.AlumnoDTO;
import Entidades.AlumnoEntidad;
import Excepcion.PersistenciaException;
import Interfaz.IAlumnoDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author gaspa
 */
public class AlumnoDAO implements IAlumnoDAO{
    private EntityManager em;
    public AlumnoDAO(EntityManager em){
        this.em = em;
    }
    @Override
    public void guardar(AlumnoEntidad alumno) throws PersistenciaException {
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
    }
    
}

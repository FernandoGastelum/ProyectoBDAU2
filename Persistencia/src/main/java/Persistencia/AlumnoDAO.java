/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTOS.AlumnoDTO;
import Entidades.AlumnoEntidad;
import Excepcion.PersistenciaException;
import Interfaz.IAlumnoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

    @Override
    public AlumnoEntidad obtenerPorID(Long id) throws PersistenciaException {
        AlumnoEntidad alumno = em.find(AlumnoEntidad.class, id);
        if(alumno!=null){
            return alumno;
        }else{
            throw new PersistenciaException("No se encontro un alumno con el id "+id);
        }
    }

    @Override
    public List<AlumnoEntidad> obtener() throws PersistenciaException {
        TypedQuery<AlumnoEntidad> query = em.createQuery("""
                                                         SELECT a
                                                         FROM AlumnoEntidad a
                                                         """, AlumnoEntidad.class);
        if(query.getResultList()==null){
            throw new PersistenciaException("No se encontraron resultados");
        }
        return query.getResultList();
    }
    
}

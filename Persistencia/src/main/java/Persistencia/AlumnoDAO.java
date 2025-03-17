/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTOS.AlumnoDTO;
import DTOS.GuardarAlumnoDTO;
import Entidades.AlumnoEntidad;
import Excepcion.PersistenciaException;
import Interfaz.IAlumnoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    public AlumnoEntidad guardar(GuardarAlumnoDTO alumno) throws PersistenciaException {
        em.getTransaction().begin();
        
        AlumnoEntidad alumnoEntidad = new AlumnoEntidad(alumno.getNombre(), 
                                                        alumno.getApellidoPaterno(), 
                                                        alumno.getApellidoMaterno(), 
                                                        alumno.getPasatiempo());
        
        em.persist(alumnoEntidad);
        em.getTransaction().commit();
        return alumnoEntidad;
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
    
    @Override
    public AlumnoDTO obtenerAlumnoDTO(Long id){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AlumnoDTO> cq = cb.createQuery(AlumnoDTO.class);
        Root<AlumnoEntidad> alumno = cq.from(AlumnoEntidad.class);
        cq.select(cb.construct(AlumnoDTO.class,
                alumno.get("id"),
                alumno.get("nombres"),
                alumno.get("paterno"),
                alumno.get("materno"),
                alumno.get("pasatiempo"),
                alumno.get("activo")))
          .where(cb.equal(alumno.get("id"), id));

        TypedQuery<AlumnoDTO> query = em.createQuery(cq);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}

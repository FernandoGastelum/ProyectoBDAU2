package Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Entidades.AlumnoEntidad;
import Excepcion.PersistenciaException;
import Interfaz.IAlumnoDAO;
import Persistencia.AlumnoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gaspa
 */
public class AlumnoTest {
    
    private EntityManagerFactory fabrica;
    private EntityManager entityManager;
    
    @Before
    public void setUp() {
        this.fabrica = Persistence.createEntityManagerFactory("Conexion");
        this.entityManager = fabrica.createEntityManager();
    }
    @Test
    public void testAgregarAlumno(){
        try {
            IAlumnoDAO alumno = new AlumnoDAO(entityManager);
            AlumnoEntidad entidadAlumno = new AlumnoEntidad("Layne", "Rutherford", "Staley", "Cantar");
            
            assertNotNull("El nombre no puede ser nulo. ", entidadAlumno.getNombres());
            assertNotNull("El apellido paterno no puede ser nulo. ", entidadAlumno.getPaterno());
            assertNotNull("El apellido materno no puede ser nulo. ", entidadAlumno.getMaterno());
            assertNotNull("El pasatiempo no puede ser nulo. ", entidadAlumno.getPasatiempo());
            alumno.guardar(entidadAlumno);
            System.out.println("Alumno: "+entidadAlumno);
        } catch (PersistenciaException ex) {
            System.out.println("Error "+ex.getMessage());
        }
    }
    @Test
    public void testConsultarAlumnos(){
        try {
            IAlumnoDAO alumno = new AlumnoDAO(entityManager);
            AlumnoEntidad entidadAlumno = new AlumnoEntidad("Peter", "Thomas", "Ratajczyk", "Cantar");
            alumno.guardar(entidadAlumno);
            List<AlumnoEntidad> alumnos = alumno.obtener();
            assertEquals("El numero de alumnos es incorrecto, deberian de ser 2",2, alumnos.size());
            System.out.println("Lista de alumnos: "+alumnos);
        } catch (PersistenciaException ex) {
            System.out.println("Error "+ex.getMessage());
        }
    }

}

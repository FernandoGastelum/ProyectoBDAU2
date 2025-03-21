package Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import DTOS.AlumnoDTO;
import DTOS.GuardarAlumnoDTO;
import Entidades.AlumnoEntidad;
import Excepcion.NegocioException;
import Excepcion.PersistenciaException;
import Interfaz.IAlumnoDAO;
import Interfaz.IAlumnoNegocio;
import Interfaz.IEntityManager;
import Negocio.AlumnoNegocio;
import Persistencia.AlumnoDAO;
import Persistencia.EntityManagerDAO;
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
public class AlumnoNegocioTest {
    
    public IEntityManager entityManager;
    
    @Before
    public void setUp() {
        entityManager = new EntityManagerDAO();
    }
    @Test
    public void testAgregarAlumno(){
        try {
            IAlumnoDAO alumnoDAO = new AlumnoDAO(entityManager);
            IAlumnoNegocio alumnoNegocio = new AlumnoNegocio(alumnoDAO);
            GuardarAlumnoDTO alumno = new GuardarAlumnoDTO("Layne", "Rutherford", "Staley", "Cantar");
            assertNotNull("El nombre no puede ser nulo. ", alumno.getNombre());
            assertNotNull("El apellido paterno no puede ser nulo. ", alumno.getApellidoPaterno());
            assertNotNull("El apellido materno no puede ser nulo. ", alumno.getApellidoMaterno());
            assertNotNull("El pasatiempo no puede ser nulo. ", alumno.getPasatiempo());
            alumnoNegocio.guardar(alumno);
            System.out.println("Alumno: "+alumno);
        } catch (NegocioException e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    @Test
    public void testConsultarAlumnos() throws NegocioException{
        try {
            IAlumnoDAO alumnoDAO = new AlumnoDAO(entityManager);
            IAlumnoNegocio alumnoNegocio = new AlumnoNegocio(alumnoDAO);
            GuardarAlumnoDTO alumnoDTO1 = new GuardarAlumnoDTO("Peter", "Thomas", "Ratajczyk", "Cantar");
            GuardarAlumnoDTO alumnoDTO2 = new GuardarAlumnoDTO("Layne", "Rutherford", "Staley", "Cantar");
            alumnoNegocio.guardar(alumnoDTO1);
            alumnoNegocio.guardar(alumnoDTO2);
            List<AlumnoDTO> alumnos = alumnoNegocio.obtener();
            assertEquals("El numero de alumnos es incorrecto, deberian de ser 2",2, alumnos.size());
            System.out.println("Lista de alumnos: "+alumnos);
        } catch (NegocioException ex) {
            System.out.println("Error "+ex.getMessage());
        }
    }

}

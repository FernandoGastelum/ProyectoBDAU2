package Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import DTOS.GuardarAlumnoDTO;
import Entidades.AlumnoEntidad;
import Excepcion.PersistenciaException;
import Interfaz.IAlumnoDAO;
import Interfaz.IEntityManager;
import Persistencia.AlumnoDAO;
import Persistencia.EntityManagerDAO;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gaspa
 */
public class AlumnoTest {
    
    public IEntityManager entityManager;
    @Before
    public void setUp() {
        entityManager = new EntityManagerDAO();
    }
    @Test
    public void testAgregarAlumno(){
        try {
            IAlumnoDAO alumno = new AlumnoDAO(entityManager);
            GuardarAlumnoDTO alumnoDTO = new GuardarAlumnoDTO("Layne", "Rutherford", "Staley", "Cantar");
            
            assertNotNull("El nombre no puede ser nulo. ", alumnoDTO.getNombre());
            assertNotNull("El apellido paterno no puede ser nulo. ", alumnoDTO.getApellidoPaterno());
            assertNotNull("El apellido materno no puede ser nulo. ", alumnoDTO.getApellidoMaterno());
            assertNotNull("El pasatiempo no puede ser nulo. ", alumnoDTO.getPasatiempo());
            alumno.guardar(alumnoDTO);
            System.out.println("Alumno: "+alumnoDTO);
        } catch (PersistenciaException ex) {
            System.out.println("Error "+ex.getMessage());
        }
    }
    @Test
    public void testConsultarAlumnos(){
        try {
            IAlumnoDAO alumno = new AlumnoDAO(entityManager);
            GuardarAlumnoDTO alumnoDTO = new GuardarAlumnoDTO("Peter", "Thomas", "Ratajczyk", "Cantar");
            alumno.guardar(alumnoDTO);
            List<AlumnoEntidad> alumnos = alumno.obtener();
            assertEquals("El numero de alumnos es incorrecto, deberian de ser 2",2, alumnos.size());
            System.out.println("Lista de alumnos: "+alumnos);
        } catch (PersistenciaException ex) {
            System.out.println("Error "+ex.getMessage());
        }
    }

}

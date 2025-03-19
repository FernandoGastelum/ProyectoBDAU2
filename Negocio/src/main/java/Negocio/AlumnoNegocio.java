package Negocio;

import DTOS.AlumnoDTO;
import DTOS.GuardarAlumnoDTO;
import Entidades.AlumnoEntidad;
import Excepcion.NegocioException;
import Excepcion.PersistenciaException;
import Interfaz.IAlumnoDAO;
import Interfaz.IAlumnoNegocio;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
            try {this.reglasNegocioGuardar();
                AlumnoEntidad alumnoGuardado = this.alumnoDAO.guardar(alumno);
                return this.alumnoDAO.obtenerAlumnoDTO(alumnoGuardado.getId());
            } catch (PersistenciaException ex) {
                System.out.println("Error: "+ex.getMessage());
            }
        return null;
    }

    @Override
    public List<AlumnoDTO> obtener() throws NegocioException {
            try {this.reglasNegocioGuardar();
                List<AlumnoEntidad> listaAlumno = this.alumnoDAO.obtener();
                return listaAlumno.stream().map(alumno -> this.alumnoDAO.obtenerAlumnoDTO(alumno.getId())).collect(Collectors.toList());
            } catch (PersistenciaException ex) {
                System.out.println("Error: "+ex.getMessage());
            }
        return null;
    }
    
    public boolean reglasNegocioGuardar()throws NegocioException{
        if(1<1){
            throw new NegocioException("error");
        }
        return true;
    }
    
    
}

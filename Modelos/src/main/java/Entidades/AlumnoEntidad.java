package Entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Angel Ruiz Garcia - 00000248171
 */
@Entity
@Table(name = "alumnos")
public class AlumnoEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombres", length = 50, nullable = false)
    private String nombres;

    @Column(name = "apellidoPaterno", length = 30, nullable = false)
    private String paterno;

    @Column(name = "apellidoMaterno", length = 30, nullable = false)
    private String materno;
    
    @Column(name = "pasatiempo", length = 15, nullable = false)
    private String pasatiempo;
    
    @Column(name = "estaBorrado", nullable = false)
    private boolean borrado;
    
    @Column(name = "estaActivo", nullable = false)
    private boolean activo;

    public AlumnoEntidad() {
    }
    
    public AlumnoEntidad(String nombres, String paterno, String materno, String pasatiempo, boolean borrado, boolean activo) {
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
        this.pasatiempo = pasatiempo;
        this.borrado = borrado;
        this.activo = activo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getPasatiempo() {
        return pasatiempo;
    }

    public void setPasatiempo(String pasatiempo) {
        this.pasatiempo = pasatiempo;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoEntidad)) {
            return false;
        }
        AlumnoEntidad other = (AlumnoEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AlumnoEntidad:\nID:" + id + "\nNombre/s:" + nombres + "\nApellido Paterno:" + paterno + "\nApellido Materno:" + materno + "\nPasatiempo:" + pasatiempo + "\nBorrado:" + borrado + "\nActivo:" + activo;
    }
    
}
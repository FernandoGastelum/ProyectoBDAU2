package DTOS;

/**
 *
 * @author Angel Ruiz Garcia - 00000248171
 */
public class AlumnoDTO {
    
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String pasatiempo;
    private String estatus;

    public AlumnoDTO(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String pasatiempo, Boolean estatus) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.pasatiempo = pasatiempo;
        if(estatus==true){
            this.estatus = "Activo";
        }else{
            this.estatus = "Inactivo";
        }
        
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getPasatiempo() {
        return pasatiempo;
    }
    public void setPasatiempo(String pasatiempo) {
        this.pasatiempo = pasatiempo;
    }

    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "\nAlumnoDTO\nID: " + id + "\nNombre/s: " + nombre + "\nApellido Paterno: " + apellidoPaterno + "\n Apellido Materno: " + apellidoMaterno + "\nPasatiempo: " + pasatiempo + "\nEstatus: " + estatus;
    }
    
}
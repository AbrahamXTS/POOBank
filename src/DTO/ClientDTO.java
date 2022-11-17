package DTO;

/**
 * ClientDTO
 */
public class ClientDTO {

    private String nombre;
    private String apellido;
    private String CURP;
    // private Cuenta[] cuentas = new Cuenta[3];

    public ClientDTO(String nombre, String apellido, String CURP) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.CURP = CURP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String cURP) {
        CURP = cURP;
    }

    // public Cuenta[] getCuentas() {
    //     return cuentas;
    // }

    // public void setCuentas(Cuenta[] cuentas) {
    //     this.cuentas = cuentas;
    // }

    
}
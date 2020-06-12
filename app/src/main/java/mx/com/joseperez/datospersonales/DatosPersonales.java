package mx.com.joseperez.datospersonales;

public class DatosPersonales {
    private String Nombre;
    private String FechaNacimiento;
    private String Telefono;
    private String  Email;
    private String Descripcion;

    public DatosPersonales(String nombre){
        this.Nombre = nombre;
    }

    public DatosPersonales(String nombre,
                           String fechaNacimiento,
                           String telefono,
                           String email,
                           String descripcion){
        this.Nombre = nombre;
        this.FechaNacimiento = fechaNacimiento;
        this.Telefono = telefono;
        this.Email = email;
        this.Descripcion = descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}

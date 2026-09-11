package ni.edu.uam.empresaviews.model;

public class Cliente {
    private String Nombre;
    private String Correo;
    private String Telefono;
    private String TipoCliente;
    private String DocumentoIdentidad;
    private String DirectorioCliente;

    public Cliente() {
    }

    public Cliente(String nombre, String correo, String telefono, String tipoCliente, String documentoIdentidad, String directorioCliente) {
        Nombre = nombre;
        Correo = correo;
        Telefono = telefono;
        TipoCliente = tipoCliente;
        DocumentoIdentidad = documentoIdentidad;
        DirectorioCliente = directorioCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getTipoCliente() {
        return TipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        TipoCliente = tipoCliente;
    }

    public String getDocumentoIdentidad() {
        return DocumentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        DocumentoIdentidad = documentoIdentidad;
    }

    public String getDirectorioCliente() {
        return DirectorioCliente;
    }

    public void setDirectorioCliente(String directorioCliente) {
        DirectorioCliente = directorioCliente;
    }
}

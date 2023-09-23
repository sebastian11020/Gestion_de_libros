package model;

public class Autor {
    private String nombre;
    private String apellido;
    private String descripcion;

    public Autor(String nombre, String apellido, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean sonIguales(Autor otroAutor) {
        if (this == otroAutor) {
            return true;
        }
        if (otroAutor == null) {
            return false;
        }
        if (nombre == null) {
            if (otroAutor.nombre != null) {
                return false;
            }
        } else if (!nombre.equals(otroAutor.nombre)) {
            return false;
        }
        if (apellido == null) {
            if (otroAutor.apellido != null) {
                return false;
            }
        } else if (!apellido.equals(otroAutor.apellido)) {
            return false;
        }
        if (descripcion == null) {
            if (otroAutor.descripcion != null) {
                return false;
            }
        } else if (!descripcion.equals(otroAutor.descripcion)) {
            return false;
        }
        return true;
    }
}
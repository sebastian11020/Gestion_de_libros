package model;

public class Sede {
    private String sede_libro;
    private String campus_libro;

    public Sede(String sede_libro, String campus_libro) {
        this.sede_libro = sede_libro;
        this.campus_libro = campus_libro;
    }

    public String getSede_libro() {
        return sede_libro;
    }

    public void setSede_libro(String sede_libro) {
        this.sede_libro = sede_libro;
    }

    public String getCampus_libro() {
        return campus_libro;
    }

    public void setCampus_libro(String campus_libro) {
        this.campus_libro = campus_libro;
    }

    public boolean sonIguales(Sede otraSede) {
        if (this == otraSede) {
            return true;
        }
        if (otraSede == null) {
            return false;
        }
        if (sede_libro == null) {
            if (otraSede.sede_libro != null) {
                return false;
            }
        } else if (!sede_libro.equals(otraSede.sede_libro)) {
            return false;
        }
        if (campus_libro == null) {
            if (otraSede.campus_libro != null) {
                return false;
            }
        } else if (!campus_libro.equals(otraSede.campus_libro)) {
            return false;
        }
        return true;
    }
}
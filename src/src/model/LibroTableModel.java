package model;

import model.Libro;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LibroTableModel extends AbstractTableModel {
    private final List<Libro> libros = new ArrayList<>();
    private final String[] columnNames = {"Título", "ISBN", "Volumen", "Editorial", "Nombre del Autor", "Sede", "Facultad"};

    public void setLibros(Map<Integer, Libro> catalogo) {
        libros.clear();
        libros.addAll(catalogo.values());
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return libros.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Libro libro = libros.get(row);
        switch (column) {
            case 0:
                return libro.getTitulo();
            case 1:
                return libro.getISBN();
            case 2:
                return libro.getVolumen();
            case 3:
                return libro.getEditorial();
            case 4:
                return libro.getAutor().getNombre() + " " + libro.getAutor().getApellido();
            case 5:
                return libro.getSede().getSede_libro();
            case 6:
                return libro.getSede().getCampus_libro();
            default:
                return null;
        }
    }
}

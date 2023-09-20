package view;
import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame = new JFrame("Sistema gestor de libros");
    private  JButton crear = new JButton("Crear Libro");
    private  JPanel panelMenu = new JPanel();

    public void showFrameMenu() {
        JLabel titulo = new JLabel("Sistema gestor de libros");
        JPanel panelTitulo = new JPanel();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelTitulo.add(titulo);
        panelMenu.add(crear);
        frame.getContentPane().add(BorderLayout.NORTH, panelTitulo);
        frame.getContentPane().add(BorderLayout.CENTER, panelMenu);
        crear.addActionListener(e -> {
            showFrameCreate();
        });
        frame.setVisible(true);
    }

    public void showFrameCreate() {
        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Agregar libro");
        JLabel tituloLibro = new JLabel("Titulo");
        JTextField datoTitulo = new JTextField(10);
        JLabel codigoLibro = new JLabel("Codigo ISBN");
        JTextField datoCodigo = new JTextField(10);
        JLabel volumenLibro = new JLabel("Volumen");
        JTextField datoVolumen = new JTextField(10);
        JLabel editorialLibro = new JLabel("Editorial");
        JTextField datoEditorial = new JTextField(10);
        JButton agregarAutor = new JButton("Agregar autor");
        panelMenu.remove(crear);
        panelMenu.add(tituloLibro);
        panelMenu.add(datoTitulo);
        panelMenu.add(codigoLibro);
        panelMenu.add(datoCodigo);
        panelMenu.add(volumenLibro);
        panelMenu.add(datoVolumen);
        panelMenu.add(editorialLibro);
        panelMenu.add(datoEditorial);
        panelMenu.add(agregarAutor);
        panelTitulo.add(titulo);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(BorderLayout.NORTH, panelTitulo);
        frame.getContentPane().add(BorderLayout.CENTER, panelMenu);
        frame.revalidate();
        agregarAutor.addActionListener(e->{
            if(!esNuloOVacio(datoTitulo.getText())&&!esNuloOVacio(datoEditorial.getText())){
               if(esNumero(datoCodigo.getText())&&esNumero(datoVolumen.getText())){
                getTitulo(datoTitulo.getText());
                getCodigo(datoCodigo.getText());
                getVolumen(datoVolumen.getText());
                getEditorial(datoEditorial.getText());
                agregarAutorySede();
                }else {
                    JOptionPane.showMessageDialog(null,"El codigo o el volumen no son validos");
                }
            }else {
                JOptionPane.showMessageDialog(null,"No pueden haber campos vacios");
            }
        });
        frame.repaint();
    }

    public  boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean esNuloOVacio(String str) {
        return str == null || str.trim().isEmpty();
    }

    public void agregarAutorySede(){
        final String[] selectedFacu = {null};
        String[] sedes = {"Duitama", "Sogamoso", "Tunja","Chiquinquira","Aguazul"};
        frame.setSize(380,380);
        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Agregar Autor");
        JLabel nombreAutor = new JLabel("Nombre");
        JTextField datoNombre = new JTextField(10);
        JLabel apellidoAutor = new JLabel("Apellido");
        JTextField datoApellido = new JTextField(10);
        JLabel descripcionAutor = new JLabel("Biografia");
        JTextArea textArea = new JTextArea(1, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JComboBox<String> sedeComboBox = new JComboBox<>(sedes);
        JComboBox<String> facultadComboBox = new JComboBox<>();
        JButton agregarBiblioteca = new JButton("Agregar Libro");
        panelMenu.removeAll();
        panelMenu.add(nombreAutor);
        panelMenu.add(datoNombre);
        panelMenu.add(apellidoAutor);
        panelMenu.add(datoApellido);
        panelMenu.add(descripcionAutor);
        panelMenu.add(textArea);
        panelMenu.add(sedeComboBox);
        panelTitulo.add(titulo);
        sedeComboBox.addActionListener(e->{
                String selectedSede = (String) sedeComboBox.getSelectedItem();
                if ("Duitama".equals(selectedSede)) {
                    String[] facultadesSedeA = {"Seccional Duitama"};
                    facultadComboBox.setModel(new DefaultComboBoxModel<>(facultadesSedeA));
                    selectedFacu[0] = (String) facultadComboBox.getSelectedItem();
                } else if ("Sogamoso".equals(selectedSede)) {
                    String[] facultadesSedeB = {"Seccional Sogamoso"};
                    facultadComboBox.setModel(new DefaultComboBoxModel<>(facultadesSedeB));
                    selectedFacu[0] = (String) facultadComboBox.getSelectedItem();
                } else if ("Tunja".equals(selectedSede)) {
                    String[] facultadesSedeC = {"Biblioteca Central","Facultad Ingenieria", "Facultad Medicina", "Facultad Derecho y Ciencias Sociales","FESAD"};
                    facultadComboBox.setModel(new DefaultComboBoxModel<>(facultadesSedeC));
                    selectedFacu[0] = (String) facultadComboBox.getSelectedItem();
                } else if ("Chiquinquira".equals(selectedSede)) {
                    String[] facultadesSedeC = {"Seccional Chiquinquira"};
                    facultadComboBox.setModel(new DefaultComboBoxModel<>(facultadesSedeC));
                    selectedFacu[0] = (String) facultadComboBox.getSelectedItem();
                } else if ("Aguazul".equals(selectedSede)) {
                    String[] facultadesSedeC = {"Seccional Aguazul"};
                    facultadComboBox.setModel(new DefaultComboBoxModel<>(facultadesSedeC));
                    selectedFacu[0] = (String) facultadComboBox.getSelectedItem();
                }
        });
        String selectedSede = (String) sedeComboBox.getSelectedItem();
        frame.getContentPane().removeAll();
        frame.getContentPane().add(BorderLayout.NORTH, panelTitulo);
        frame.getContentPane().add(BorderLayout.CENTER, panelMenu);
        panelMenu.add(facultadComboBox);
        panelMenu.add(agregarBiblioteca);
        frame.revalidate();
        agregarBiblioteca.addActionListener(e-> {
            if (!esNuloOVacio(datoNombre.getText()) && !esNuloOVacio(datoApellido.getText())
                    && !esNuloOVacio(textArea.getText()) && !esNuloOVacio(selectedSede)
                    && !esNuloOVacio(selectedFacu[0])) {
                getNombre(datoNombre.getText());
                getApellido(datoApellido.getText());
                getBio(textArea.getText());
                getSede(selectedSede);
                getFacu(selectedFacu[0]);
            }else {
                JOptionPane.showMessageDialog(null,"No pueden haber campos vacios o sin seleccionar");
            }
        });
        frame.repaint();
    }

    public String getTitulo(String titulo){
        return titulo;
    }

    public int getCodigo(String codigo){
        int a = Integer.parseInt(codigo);
        return a;
    }

    public int getVolumen(String volumen){
        int a = Integer.parseInt(volumen);
        return a;
    }
    public String getEditorial(String editorial){
        return editorial;
    }
    public String getNombre(String nombre){
        return nombre;
    }
    public String getApellido(String apellido){
        return apellido;
    }
    public String getBio(String bio){
        return bio;
    }
    public String getSede(String sede){
        return sede;
    }
    public String getFacu(String facu){
        return facu;
    }

    public static void main(String[] args) {
        new View().showFrameMenu();
    }
}

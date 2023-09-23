package view;
import javax.swing.*;
import java.awt.*;
import controller.Controller;
public class View {
    private Controller controller;
    private String titulo_libro;
    private int codigo;
    private int volumen;
    private String editorial;
    private String nombre;
    private String apellido;
    private String bio;
    private String sede;
    private String facultad;
    private JFrame frame = new JFrame("Sistema gestor de libros");
    private  JButton crear = new JButton("Crear Libro");
    private  JPanel panelMenu = new JPanel();

    public void showFrameMenu() {
        JLabel titulo = new JLabel("Sistema gestor de libros");
        JPanel panelTitulo = new JPanel();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
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
        JButton volver = new JButton("Volver");
        panelMenu.removeAll();
        panelMenu.add(tituloLibro);
        panelMenu.add(datoTitulo);
        panelMenu.add(codigoLibro);
        panelMenu.add(datoCodigo);
        panelMenu.add(volumenLibro);
        panelMenu.add(datoVolumen);
        panelMenu.add(editorialLibro);
        panelMenu.add(datoEditorial);
        panelMenu.add(agregarAutor);
        panelMenu.add(volver);
        panelTitulo.add(titulo);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(BorderLayout.NORTH, panelTitulo);
        frame.getContentPane().add(BorderLayout.CENTER, panelMenu);
        frame.revalidate();
        volver.addActionListener(e->{
            frame.getContentPane().removeAll();
            panelMenu.removeAll();
            showFrameMenu();
        });
        agregarAutor.addActionListener(e->{
            if(!esNuloOVacio(datoTitulo.getText())&&!esNuloOVacio(datoEditorial.getText())){
               if(esNumero(datoCodigo.getText())&&esNumero(datoVolumen.getText())){
                setTituloLibro(datoTitulo.getText());
                if(Integer.parseInt(datoCodigo.getText())>0 && Integer.parseInt(datoVolumen.getText())>0) {
                    setCodigo(datoCodigo.getText());
                    setVolumen(datoVolumen.getText());
                    setEditorial(datoEditorial.getText());
                    if (controller != null) {
                        controller.addCode();
                    }
                    if(!controller.existCode()) {
                        agregarAutorySede();
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"El codigo o el volumen no puede ser menor a 0");
                }
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

    public boolean esNuloOVacio(String str) {
        return str == null || str.trim().isEmpty();
    }

    public void agregarAutorySede(){
        final String[] sede = {null};
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
        JButton volver = new JButton("Volver");
        panelMenu.removeAll();
        panelMenu.add(nombreAutor);
        panelMenu.add(datoNombre);
        panelMenu.add(apellidoAutor);
        panelMenu.add(datoApellido);
        panelMenu.add(descripcionAutor);
        panelMenu.add(textArea);
        panelMenu.add(sedeComboBox);
        panelTitulo.add(titulo);
        volver.addActionListener(e->{
            frame.getContentPane().removeAll();
            panelMenu.removeAll();
            showFrameCreate();
        });
        sedeComboBox.addActionListener(e->{
                String selectedSede = (String) sedeComboBox.getSelectedItem();
                sede[0] = selectedSede;
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
        frame.getContentPane().removeAll();
        frame.getContentPane().add(BorderLayout.NORTH, panelTitulo);
        frame.getContentPane().add(BorderLayout.CENTER, panelMenu);
        panelMenu.add(facultadComboBox);
        panelMenu.add(agregarBiblioteca);
        panelMenu.add(volver);
        frame.revalidate();
        agregarBiblioteca.addActionListener(e-> {
            if (!esNuloOVacio(datoNombre.getText()) && !esNuloOVacio(datoApellido.getText())
                    && !esNuloOVacio(textArea.getText()) && !esNuloOVacio(sede[0])
                    && !esNuloOVacio(selectedFacu[0])) {
                setNombre(datoNombre.getText());
                setApellido(datoApellido.getText());
                setBio(textArea.getText());
                setSede(sede[0]);
                setFacultad(selectedFacu[0]);
                System.out.println(getNombre()+getApellido()+getBio()+getSede()+getFacultad());
            }else {
                JOptionPane.showMessageDialog(null,"No pueden haber campos vacios o sin seleccionar");
            }
        });
        frame.repaint();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void setTituloLibro(String titulo){
        this.titulo_libro=titulo;
    }
    public String getTitulo(){
        return this.titulo_libro;
    }
    public void setCodigo(String codigo){
        int a = Integer.parseInt(codigo);
        this.codigo=a;
    }
    public int getCodigo(){
        return codigo;
    }
    public void setVolumen(String volumen){
        int a = Integer.parseInt(volumen);
        this.volumen=a;
    }
    public int getVolumen(){
        return volumen;
    }
    public void setEditorial(String editorial){
        this.editorial=editorial;
    }
    public String getEditorial(){
        return this.editorial;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public String getApellido(){
        return this.apellido;
    }
    public void setBio(String bio){
        this.bio=bio;
    }
    public String getBio(){
        return this.bio;
    }
    public void setSede(String sede){
        this.sede=sede;
    }
    public String getSede(){
        return this.sede;
    }
    public void setFacultad(String facultad){
        this.facultad=facultad;
    }
    public String getFacultad(){
        return this.facultad;
    }
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null,message);
    }
}

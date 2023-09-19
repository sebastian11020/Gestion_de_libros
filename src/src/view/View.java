package view;
import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame = new JFrame("Sistema gestor de libros");
    private JLabel titulo = new JLabel("Sistema gestor de libros");
    private JButton crear = new JButton("Crear Libro");


    public void showFrameMenu(){
        JPanel panelTitulo = new JPanel();
        JPanel panelMenu = new JPanel();
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelTitulo.add(titulo);
        panelMenu.add(crear);
        frame.getContentPane().add(BorderLayout.NORTH,panelTitulo);
        frame.getContentPane().add(BorderLayout.CENTER,panelMenu);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new View().showFrameMenu();
    }
}

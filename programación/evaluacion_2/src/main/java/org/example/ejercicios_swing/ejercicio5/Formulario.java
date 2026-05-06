package org.example.ejercicios_swing.ejercicio5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario {
    public static void main(String[] args) {

        JFrame ventana = new JFrame("Formulario de Contacto");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null); // Centrar ventana


        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen

        JPanel panelNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField(20);
        panelNombre.add(labelNombre);
        panelNombre.add(campoNombre);

        JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField(20);
        panelEmail.add(labelEmail);
        panelEmail.add(campoEmail);

        JPanel panelMensaje = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelMensaje = new JLabel("Mensaje:");
        JTextArea areaMensaje = new JTextArea(5, 20);
        areaMensaje.setLineWrap(true);
        areaMensaje.setWrapStyleWord(true);
        JScrollPane scrollMensaje = new JScrollPane(areaMensaje);
        panelMensaje.add(labelMensaje);
        panelMensaje.add(scrollMensaje);

        JPanel panelBoton = new JPanel();
        JButton botonEnviar = new JButton("Enviar");
        panelBoton.add(botonEnviar);

        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String email = campoEmail.getText();
                String mensaje = areaMensaje.getText();
                JOptionPane.showMessageDialog(ventana,
                        "Nombre: " + nombre + "\nEmail: " + email + "\nMensaje: " + mensaje,
                        "Datos enviados",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panelPrincipal.add(panelNombre);
        panelPrincipal.add(panelEmail);
        panelPrincipal.add(panelMensaje);
        panelPrincipal.add(panelBoton);

        ventana.add(panelPrincipal);
        ventana.setVisible(true);
    }
}


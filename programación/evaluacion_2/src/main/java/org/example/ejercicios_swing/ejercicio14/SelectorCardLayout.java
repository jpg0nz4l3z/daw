package org.example.ejercicios_swing.ejercicio14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectorCardLayout {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Selector de Pantallas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 200);
        ventana.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new CardLayout());

        // Panel 1: Formulario con JTextField y botón
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new FlowLayout());
        JLabel labelNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField(15);
        JButton botonEnviar = new JButton("Enviar");
        panelFormulario.add(labelNombre);
        panelFormulario.add(campoNombre);
        panelFormulario.add(botonEnviar);

        // Panel 2: Mensaje de bienvenida
        JPanel panelBienvenida = new JPanel();
        JLabel etiquetaBienvenida = new JLabel("", JLabel.CENTER);
        panelBienvenida.setLayout(new BorderLayout());
        panelBienvenida.add(etiquetaBienvenida, BorderLayout.CENTER);

        panelPrincipal.add(panelFormulario, "Formulario");
        panelPrincipal.add(panelBienvenida, "Bienvenida");

        CardLayout cl = (CardLayout) panelPrincipal.getLayout();

        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                etiquetaBienvenida.setText("Bienvenido, " + nombre);
                cl.show(panelPrincipal, "Bienvenida");
            }
        });

        ventana.add(panelPrincipal);
        ventana.setVisible(true);
    }
}

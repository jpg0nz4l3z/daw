package org.example.ejercicios_swing.ejercicio9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioNombreEdad {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Formulario");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 150);
        ventana.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel labelNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField(15);

        JLabel labelEdad = new JLabel("Edad:");
        JTextField campoEdad = new JTextField(5);

        JButton botonEnviar = new JButton("Enviar");

        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String edad = campoEdad.getText();
                JOptionPane.showMessageDialog(ventana, "Nombre: " + nombre + "\nEdad: " + edad);
            }
        });

        panel.add(labelNombre);
        panel.add(campoNombre);
        panel.add(labelEdad);
        panel.add(campoEdad);
        panel.add(botonEnviar);

        ventana.add(panel);
        ventana.setVisible(true);
    }
}

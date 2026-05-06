package org.example.ejercicios_swing.ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComparadorVisualClasico {
    public static void main(String[] args) {
        // Crear el frame principal
        JFrame frame = new JFrame("Ejercicio JLabel, JTextField, JButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new FlowLayout());

        // Crear componentes
        JLabel label = new JLabel("Escribe algo:");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Aceptar");

        // Añadir acción al botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un JDialog modal
                JDialog dialog = new JDialog(frame, "Mensaje", true); // true = modal
                dialog.setLayout(new FlowLayout());
                dialog.add(new JLabel("Gracias por probar"));
                JButton okButton = new JButton("OK");
                okButton.addActionListener(ev -> dialog.dispose()); // Cierra el diálogo
                dialog.add(okButton);
                dialog.setSize(200, 100);
                dialog.setLocationRelativeTo(frame); // Centrar sobre el frame
                dialog.setVisible(true);
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(button);

        frame.setLocationRelativeTo(null); // Centrar en pantalla
        frame.setVisible(true);
    }
}

package org.example.ejercicios_swing.ejercicio2;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComparadorVisualFlatLight {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("No se pudo inicializar FlatLaf: " + ex);
        }

        // Crear la ventana principal
        JFrame frame = new JFrame("Ejercicio con FlatLightLaf");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Escribe algo:");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Aceptar");

        // Acción al pulsar el botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frame, "Mensaje", true);
                dialog.setLayout(new FlowLayout());
                dialog.add(new JLabel("Gracias por probar"));
                JButton okButton = new JButton("OK");
                okButton.addActionListener(ev -> dialog.dispose());
                dialog.add(okButton);
                dialog.setSize(200, 100);
                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(button);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

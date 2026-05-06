package org.example.ejercicios_swing.ejercicio8;

import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.FlatLightLaf;

public class HolaMundoEstiloso {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("No se pudo aplicar FlatLaf Light, usando Look & Feel por defecto.");
        }

        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Hola Swing");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel etiqueta = new JLabel("Hola Mundo", JLabel.CENTER);
            etiqueta.setFont(new Font("Arial", Font.BOLD, 32)); // Texto grande

            ventana.add(etiqueta, BorderLayout.CENTER);

            ventana.setSize(400, 200);
            ventana.setLocationRelativeTo(null); // Centrar en pantalla
            ventana.setVisible(true);
        });
    }
}

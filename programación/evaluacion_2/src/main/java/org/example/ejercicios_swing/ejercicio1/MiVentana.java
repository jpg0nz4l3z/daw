package org.example.ejercicios_swing.ejercicio1;

import javax.swing.*;
import java.awt.*;

public class MiVentana extends JFrame {
    public MiVentana() {
        setTitle("Mi Ventana Personalizada");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("Juan Pablo");

        panel.add(label);

        add(panel);

        setSize(400, 300);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MiVentana();
    }
}
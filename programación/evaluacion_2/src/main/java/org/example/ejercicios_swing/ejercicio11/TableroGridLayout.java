package org.example.ejercicios_swing.ejercicio11;

import javax.swing.*;
import java.awt.*;

public class TableroGridLayout {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Tablero 3x3");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 300);
        ventana.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 5, 5));

        for (int i = 1; i <= 9; i++) {
            JButton boton = new JButton(String.valueOf(i));
            panel.add(boton);
        }

        ventana.add(panel);
        ventana.setVisible(true);
    }
}

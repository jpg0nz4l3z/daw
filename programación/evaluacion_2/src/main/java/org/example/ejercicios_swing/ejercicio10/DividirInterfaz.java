package org.example.ejercicios_swing.ejercicio10;

import javax.swing.*;
import java.awt.*;

public class DividirInterfaz {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Diseño con BorderLayout");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);

        ventana.setLayout(new BorderLayout());

        JButton botonArriba = new JButton("Botón Superior");
        JTextArea areaTexto = new JTextArea();
        JLabel etiquetaInferior = new JLabel("Etiqueta Inferior", JLabel.CENTER);

        ventana.add(botonArriba, BorderLayout.NORTH);
        ventana.add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        ventana.add(etiquetaInferior, BorderLayout.SOUTH);

        ventana.setVisible(true);
    }
}

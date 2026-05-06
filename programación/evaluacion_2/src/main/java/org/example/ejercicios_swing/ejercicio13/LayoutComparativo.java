package org.example.ejercicios_swing.ejercicio13;

import javax.swing.*;
import java.awt.*;

public class LayoutComparativo {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Layout Comparativo");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new BorderLayout(10, 10));

        JPanel panelFlow = new JPanel(new FlowLayout());
        panelFlow.add(new JButton("Botón 1"));
        panelFlow.add(new JButton("Botón 2"));
        panelFlow.add(new JLabel("Etiqueta"));

        JPanel panelBox = new JPanel();
        panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
        panelBox.add(new JButton("Botón 1"));
        panelBox.add(new JButton("Botón 2"));
        panelBox.add(new JLabel("Etiqueta"));

        JPanel panelGrid = new JPanel(new GridLayout(3, 1, 5, 5));
        panelGrid.add(new JButton("Botón 1"));
        panelGrid.add(new JButton("Botón 2"));
        panelGrid.add(new JLabel("Etiqueta"));

        ventana.add(panelFlow, BorderLayout.NORTH);
        ventana.add(panelBox, BorderLayout.CENTER);
        ventana.add(panelGrid, BorderLayout.SOUTH);

        ventana.setVisible(true);
    }
}

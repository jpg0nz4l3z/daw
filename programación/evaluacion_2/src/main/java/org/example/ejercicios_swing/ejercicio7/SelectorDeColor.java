package org.example.ejercicios_swing.ejercicio7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectorDeColor {
    public static void main(String[] args) {

        JFrame ventana = new JFrame("Selector de Color");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JPanel panelColor = new JPanel();
        panelColor.setBackground(Color.LIGHT_GRAY); // Color inicial
        panelPrincipal.add(panelColor, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonRojo = new JButton("Rojo");
        JButton botonVerde = new JButton("Verde");
        JButton botonAzul = new JButton("Azul");

        panelBotones.add(botonRojo);
        panelBotones.add(botonVerde);
        panelBotones.add(botonAzul);

        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        botonRojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelColor.setBackground(Color.RED);
            }
        });

        botonVerde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelColor.setBackground(Color.GREEN);
            }
        });

        botonAzul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelColor.setBackground(Color.BLUE);
            }
        });

        ventana.add(panelPrincipal);
        ventana.setVisible(true);
    }
}

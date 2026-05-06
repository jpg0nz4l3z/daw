package org.example.ejercicios_swing.ejercicio6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioBorderLayout {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventana con BorderLayout");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);

        ventana.setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Mi Ventana con BorderLayout", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        ventana.add(titulo, BorderLayout.NORTH);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(areaTexto);
        ventana.add(scroll, BorderLayout.CENTER);

        JButton botonConfirmar = new JButton("Confirmar");
        ventana.add(botonConfirmar, BorderLayout.SOUTH);

        botonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenido = areaTexto.getText();
                JOptionPane.showMessageDialog(ventana,
                        "Contenido del área de texto:\n" + contenido,
                        "Confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        ventana.setVisible(true);
    }
}

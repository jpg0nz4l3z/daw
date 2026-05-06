package org.example.ejercicios_swing.ejercicio12;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PanelPersonalizado {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Panel Personalizado");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);

        MiPanel panel = new MiPanel();
        ventana.add(panel);

        ventana.setVisible(true);
    }
}

class MiPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLUE);
        g2.fillRect(30, 30, 100, 60);

        g2.setColor(Color.RED);
        g2.drawOval(150, 30, 80, 80);

        g2.setColor(Color.GREEN);
        Ellipse2D.Double elipse = new Ellipse2D.Double(250, 50, 100, 60);
        g2.fill(elipse);
    }
}

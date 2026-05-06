package org.example.ejercicios_swing.ejercicio3;

import javax.swing.*;
import java.awt.*;

public class FormasGeometricas {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Formas geométricas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);

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
        g2.fillRect(50, 50, 100, 60);

        g2.setColor(Color.RED);
        g2.drawOval(200, 50, 80, 80);

        g2.setColor(Color.GREEN);
        int[] xPoints = {150, 100, 200};
        int[] yPoints = {200, 300, 300};
        Polygon triangulo = new Polygon(xPoints, yPoints, 3);
        g2.fillPolygon(triangulo);
    }
}


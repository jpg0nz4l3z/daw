package org.example.ejercicios_swing.ejercicio4;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Logo {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Mi Logo");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 400);

        MiLogoPanel panel = new MiLogoPanel();
        ventana.add(panel);

        ventana.setVisible(true);

        panel.guardarImagen("mi_logo.png");
    }
}

class MiLogoPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(Color.BLUE);
        g2.setFont(new Font("Arial", Font.BOLD, 48));
        g2.drawString("Mi Logo", 100, 100); // Ajusta posición según necesites

        g2.setColor(Color.ORANGE);
        g2.fillOval(350, 50, 80, 80);

        g2.setColor(new Color(0, 200, 0, 100)); // Verde semi-transparente
        g2.fillRect(90, 50, 250, 60);
    }

    public void guardarImagen(String nombreArchivo) {
        BufferedImage imagen = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imagen.createGraphics();
        this.paint(g2);
        g2.dispose();

        try {
            ImageIO.write(imagen, "png", new File(nombreArchivo));
            System.out.println("Imagen guardada como " + nombreArchivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package world;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GEngine extends JPanel {

    private static final long serialVersionUID = 1769739963400248829L;
    public static int Px;
    public static int Py;
    public static int AIx;
    public static int AIy;

    public GEngine() {
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Px = chars.PTank.Px;
        super.paintComponent(g);
        g.drawString("This is my custom Panel!", 10, 20);
        g.setColor(Color.RED);
        g.fillRect(Px, Py, 50, 50);
        g.setColor(Color.BLACK);
        g.drawRect(AIx, AIy, 50, 50);

    }
}

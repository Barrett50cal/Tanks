package world;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

    public class Board extends JFrame
    {

    public static boolean leftKey;
    public static JSlider slider;
    private static final long serialVersionUID = 1L;
    boolean rightKey = false;
    boolean upKey = false;
    boolean downKey = false;
    private GEngine engine;
    public static JLabel lblPower;
    JFrame frame = new JFrame();

    public void startStuff() {

        frame.addKeyListener(new MyKeyListener());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        engine = new world.GEngine();
        frame.add(engine);

        frame.pack();
        Thread keys = new Thread(new MainLoop());
        Thread playertank = new Thread(new chars.PTank());

        keys.start();
        playertank.start();

        frame.setVisible(true);
    }


    public void Board() {
        startStuff();
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Board();
            }
        });
    }

    public class MainLoop implements Runnable {
        public void run() {
            while (true) {
                engine.repaint(1000);
                if (upKey) {
                    chars.PTank.movePUp();
                } else if (downKey) {
                    chars.PTank.movePDown();
                } else if (leftKey) {
                    chars.PTank.moveLeft();
                } else if (rightKey) {
                    chars.PTank.moveRight();
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    public class MyKeyListener extends KeyAdapter {


        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    leftKey = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightKey = true;
                    break;
                case KeyEvent.VK_UP:
                    upKey = true;
                    break;
                case KeyEvent.VK_DOWN:
                    downKey = true;
                    break;
            }
        }


        public void keyReleased(KeyEvent e) {

            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    leftKey = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightKey = false;
                    break;
                case KeyEvent.VK_UP:
                    upKey = false;
                    break;
                case KeyEvent.VK_DOWN:
                    downKey = false;
                    break;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
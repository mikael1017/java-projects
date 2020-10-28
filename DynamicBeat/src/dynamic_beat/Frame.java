package dynamic_beat;


import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Frame extends JFrame{

    private Image screenImage;
    private Graphics screenGraphic;

    private Image introBackground;

    public Frame() {
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        ImageIcon imageicon = new ImageIcon("images/background.jpg");
        introBackground = imageicon.getImage();

    }

    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g) {
        g.drawImage(introBackground, 0, 0, null);
        this.repaint();
    }
}
package dynamic_beat;


import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame { 

    private JLabel introBackground = new JLabel(new ImageIcon("images/background.jpg"));
    private JLabel menuBar = new JLabel(new ImageIcon("images/menuBar.png"));
    private JButton exitButton = new JButton(new ImageIcon("images/exit.png"));

    private int mouseX, mouseY;
    public Frame() {
        setUndecorated(true);
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exitButton.setBounds(40, 40, 20, 20);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        
        
        menuBar.setBounds(0, 0, 1280, 30);
        menuBar.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });

        
        add(exitButton);
        add(menuBar);
        add(introBackground);
        pack();
        
        Music introMusic = new Music("introMusic.mp3", true);
        introMusic.start();
        

        setVisible(true);
    }

    // public void paint(Graphics g) {
    //     screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
    //     screenGraphic = screenImage.getGraphics();
    //     screenDraw(screenGraphic);
    //     g.drawImage(screenImage, 0, 0, this);
    // }

    // public void screenDraw(Graphics g) {
    //     super.paintComponents(g);
    //     //g.drawImage(this.introBackground, 0, 0, null);
    //     //this.repaint();
    // }

}

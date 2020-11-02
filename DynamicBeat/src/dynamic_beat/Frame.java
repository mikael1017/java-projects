package dynamic_beat;


import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame { 

    private JLabel background = new JLabel(new ImageIcon("images/background.jpg"));
    private JLabel menuBar = new JLabel(new ImageIcon("images/menuBar.png"));
    private ImageIcon exitButtonImage = new ImageIcon("images/exit.png");
    
    private ImageIcon exitButtonClickedImage = new ImageIcon("images/exitEntered.png");
    private ImageIcon startButtonImage = new ImageIcon("images/startbutton.png");
    private ImageIcon startButtonClickedImage = new ImageIcon("images/startbuttonEntered.png");
    private ImageIcon quitButtonImage = new ImageIcon("images/quitbutton.png");
    private ImageIcon quitButtonClickedImage = new ImageIcon("images/quitbuttonEntered.png");
    private ImageIcon backButtonImage = new ImageIcon("images/backbutton.png");

    private JButton backButton = new JButton(backButtonImage);
    private JButton exitButton = new JButton(exitButtonImage);
    private JButton startButton = new JButton(startButtonImage);
    private JButton quitButton = new JButton(quitButtonImage);

    private int mouseX, mouseY;
    public Frame() {
        setUndecorated(true);
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exitButton.setBounds(5, 5, 20, 20);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        //  add event handling of exit button icon
        exitButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonClickedImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        

        startButton.setBounds(40, 200, 400, 100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        //  add event handling of start button icon
        startButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonClickedImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                startGame();
            }
        });

        quitButton.setBounds(40, 330, 400, 100);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        //  add event handling of quit button icon
        quitButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                quitButton.setIcon(quitButtonClickedImage);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                quitButton.setIcon(quitButtonImage);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        
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
        backButton.setBounds(5, 5, 50, 20);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setVisible(false);
        
        backButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mainPage();
            }
        });


        add(backButton);
        add(exitButton);
        add(startButton);
        add(quitButton);
        add(menuBar);
        add(background);
        pack();
        
        Music introMusic = new Music("introMusic.mp3", true);
        introMusic.start();
        

        setVisible(true);
    }

    public void startGame() {
        background.setIcon(new ImageIcon("images/mainScreen.jpg"));
        startButton.setVisible(false);
        exitButton.setVisible(false);
        quitButton.setVisible(false);
        backButton.setVisible(true);
    }

    public void mainPage() {
        background.setIcon(new ImageIcon("images/background.jpg"));
        startButton.setVisible(true);
        exitButton.setVisible(true);
        quitButton.setVisible(true);
        backButton.setVisible(false);
    }

}

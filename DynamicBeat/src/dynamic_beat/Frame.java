package dynamic_beat;

import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame { 

    private Image screenImage;
    private Graphics screenGraphic;
    private Image backgroundImage = new ImageIcon("images/background.jpg").getImage();

    private JLabel background = new JLabel(new ImageIcon("images/background.jpg"));
    private JLabel menuBar = new JLabel(new ImageIcon("images/menuBar.png"));
    private ImageIcon exitButtonImage = new ImageIcon("images/exit.png");
    
    private ImageIcon exitButtonClickedImage = new ImageIcon("images/exitEntered.png");
    private ImageIcon startButtonImage = new ImageIcon("images/startbutton.png");
    private ImageIcon startButtonClickedImage = new ImageIcon("images/startbuttonEntered.png");
    private ImageIcon quitButtonImage = new ImageIcon("images/quitbutton.png");
    private ImageIcon quitButtonClickedImage = new ImageIcon("images/quitbuttonEntered.png");
    private ImageIcon backButtonImage = new ImageIcon("images/backbutton.png");
    private ImageIcon easyImage = new ImageIcon("images/rm.jpg");
    private ImageIcon mediumImage = new ImageIcon("images/mu.jpg");
    private ImageIcon hardImage = new ImageIcon("images/barcelona.jpg");

    private JLabel titleImage = new JLabel(new ImageIcon("images/easyTitle.jpg"));

    private JButton backButton = new JButton(backButtonImage);
    private JButton exitButton = new JButton(exitButtonImage);
    private JButton startButton = new JButton(startButtonImage);
    private JButton quitButton = new JButton(quitButtonImage);
    private JLabel easy = new JLabel(easyImage);
    private JLabel medium = new JLabel(mediumImage);
    private JLabel hard = new JLabel(hardImage);
    
    private JButton easyLabel = new JButton(new ImageIcon("images/easylabel.png"));
    private JButton mediumLabel = new JButton(new ImageIcon("images/mediumlabel.png"));
    private JButton hardLabel = new JButton(new ImageIcon("images/hardlabel.png"));
    
    private Image bar = new ImageIcon("images/bar.png").getImage();
    private Image imagebar = new ImageIcon("images/hitbar.png").getImage();
    private Image judgementLine = new ImageIcon("images/judgementline.png").getImage();


    
    private Music currMusic = new Music("introMusic.mp3", true);
    private boolean isMainScreen = false;
    private boolean gameScreen = false;

    private int mouseX, mouseY;
    public Frame() {
        currMusic.start();
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
                currMusic.close();
                currMusic = new Music("gameMusic.mp3", true);
                currMusic.start();
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
                if (gameScreen) {
                    currMusic.close();
                    currMusic = new Music("gameMusic.mp3", true);
                    currMusic.start();
                    gameScreen = !gameScreen;
                    startGame();
                } else {
                    currMusic.close();
                    currMusic = new Music("introMusic.mp3", true);
                    currMusic.start();
                    mainPage();
                }
            }
        });

        drawLevels();
        add(backButton);
        add(exitButton);
        add(startButton);
        add(quitButton);
        add(menuBar);
        add(background);
        pack();
        
        

        setVisible(true);
    }

    public void startGame() {
        background.setIcon(new ImageIcon("images/mainScreen.jpg"));
        startButton.setVisible(false);
        exitButton.setVisible(false);
        quitButton.setVisible(false);
        backButton.setVisible(true);
        easy.setVisible(true);
        medium.setVisible(true);
        hard.setVisible(true);
        easyLabel.setVisible(true);
        mediumLabel.setVisible(true);
        hardLabel.setVisible(true);
        isMainScreen = true;
        titleImage.setVisible(false);
        gameScreen = false;

    }

    public void mainPage() {
        background.setIcon(new ImageIcon("images/background.jpg"));
        startButton.setVisible(true);
        exitButton.setVisible(true);
        quitButton.setVisible(true);
        backButton.setVisible(false);
        easy.setVisible(false);
        medium.setVisible(false);
        hard.setVisible(false);
        easyLabel.setVisible(false);
        mediumLabel.setVisible(false);
        hardLabel.setVisible(false);
        titleImage.setVisible(false);
    }

    public void drawLevels() {
        easyLabel.setBounds(120, 100, 200, 160);
        mediumLabel.setBounds(120, 300, 200, 160);
        hardLabel.setBounds(120, 500, 200, 160);

        easy.setBounds(120, 100, 200, 160);;
        easyLabel.setBorderPainted(false);
        easyLabel.setContentAreaFilled(false);
        easyLabel.setFocusPainted(false);

        medium.setBounds(120, 300, 200, 160);
        mediumLabel.setBorderPainted(false);
        mediumLabel.setContentAreaFilled(false);
        mediumLabel.setFocusPainted(false);

        hard.setBounds(120, 500, 200, 160);
        hardLabel.setBorderPainted(false);
        hardLabel.setContentAreaFilled(false);
        hardLabel.setFocusPainted(false);

        easyLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                easyLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                easyLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                easyGame(); 
            }
        });

        mediumLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                mediumLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                mediumLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
                mediumGame(); 
            }
        });

        hardLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                hardLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                hardLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                hardGame(); 
            }
        });
        titleImage.setBounds(340, 100, 600, 500);
        add(easyLabel);
        add(mediumLabel);
        add(hardLabel);
        add(easy);
        add(medium);
        add(hard);
        add(titleImage);
        titleImage.setVisible(false);
        easy.setVisible(false);
        medium.setVisible(false);
        hard.setVisible(false);
        easyLabel.setVisible(false);
        mediumLabel.setVisible(false);
        hardLabel.setVisible(false);
        
    }

    public void easyGame() {
        titleImage.setIcon(new ImageIcon("images/easyTitle.jpg"));
        currMusic.close();
        currMusic = new Music("easyMusic.mp3", true);
        currMusic.start();
        drawScreen();
    }

    public void mediumGame() {
        titleImage.setIcon(new ImageIcon("images/mediumTitle.jpg"));
        currMusic.close();
        currMusic = new Music("mediumMusic.mp3", true);
        currMusic.start();
        drawScreen();
    }

    public void hardGame() {
        titleImage.setIcon(new ImageIcon("images/hardTitle.jpg"));
        currMusic.close();
        currMusic = new Music("hardMusic.mp3", true);
        currMusic.start();
        drawScreen();
    }

    public void drawScreen() {
        titleImage.setVisible(true);
        easy.setVisible(false);
        medium.setVisible(false);
        hard.setVisible(false);
        easyLabel.setVisible(false);
        mediumLabel.setVisible(false);
        hardLabel.setVisible(false);
        gameScreen = true;
    }

    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);

        if (gameScreen) {
            g.drawImage(bar, 240, 30, null);
            g.drawImage(judgementLine, 0, 500, null);
        }
        paintComponents(g);
        this.repaint();
    }



}

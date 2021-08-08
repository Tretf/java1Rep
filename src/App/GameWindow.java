package App;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame {

    private int winWidth = 800;
    private int winHeight = 600;
    private int winPosX = 450;
    private int winPosy = 200;

    private GameMap map;
    private JPanel gui;

    private JPanel gameControls;
    private JButton btnStartGame;
    private JButton btnExitGame;

    private JPanel gameInfo;
    private JLabel mapSizeInfo;
    private JLabel countEnemyInfo;
    private JLabel countRoundInfo;

    private JPanel playerInfo;
    private JLabel playerHealthInfo;
    private JLabel playerStepsInfo;

    private JPanel playerActions;
    private JButton moveUp;
    private JButton moveDown;
    private JButton moveLeft;
    private JButton moveRight;
    private JButton moveLeftUp;
    private JButton moveRightUp;
    private JButton moveLeftDown;
    private JButton moveRightDown;
    //+
    private JButton moveNot;

    private BufferedImage pictureUP;
    private BufferedImage pictureDown;
    private BufferedImage pictureLeft;
    private BufferedImage pictureRight;
    private BufferedImage PictureLeftUP;
    private BufferedImage pictureRightUP;
    private BufferedImage pictureLeftDown;
    private BufferedImage pictureRightDown;
    private BufferedImage pictureCenter;
    //-

    private JScrollPane containerForGameLog;


    GameWindow() throws IOException {
        //System.out.println("Hello! I am window");
        prepareWindow();

        map = new GameMap();

        prepareGui();

        add(gui, BorderLayout.EAST);
        add(map);

        //setLayout(new GridLayout(10,15));
        //setLayout(new FlowLayout());

        //add(btnStartGame, BorderLayout.WEST);
        //add(btnExitGame, BorderLayout.SOUTH);

//        for (int i = 0; i < 30; i++) {
//            add(new JButton("Button#" + i));
//        }

        setVisible(true);
    }

    private void prepareGui() throws IOException {
        gui = new JPanel();
        gui.setLayout(new GridLayout(5,1));

        prepareGameControls();
        prepareGameInfo();
        preparePlayerInfo();
        preparePlayerActions();
        prepareGameActionsLog();

        gui.add(gameControls);
        gui.add(gameInfo);
        gui.add(playerInfo);
        gui.add(playerActions);
        gui.add(containerForGameLog);
    }

    private void prepareGameControls() {
        gameControls = new JPanel();
        gameControls.setLayout(new GridLayout(2,1));

        btnStartGame = new JButton("Start game!");
        btnExitGame = new JButton("Exit game!");

        gameControls.add(btnStartGame);
        gameControls.add(btnExitGame);
    }

    private void prepareGameInfo() {
        gameInfo = new JPanel();
        gameInfo.setLayout(new GridLayout(4,1));
        gameInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        mapSizeInfo = new JLabel("Current map size: ");
        countRoundInfo = new JLabel("Current Round: ");
        countEnemyInfo = new JLabel("Current enemy count: ");

        gameInfo.add(new JLabel("== Game Info =="));
        gameInfo.add(mapSizeInfo);
        gameInfo.add(countRoundInfo);
        gameInfo.add(countEnemyInfo);

    }

    private void preparePlayerInfo() {
        playerInfo = new JPanel();
        playerInfo.setLayout(new GridLayout(3,1));
        playerInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        playerHealthInfo = new JLabel("Health: -");
        playerStepsInfo = new JLabel("Current Round: -");


        playerInfo.add(new JLabel("== Player Info =="));
        playerInfo.add(playerHealthInfo);
        playerInfo.add(playerStepsInfo);

    }

    private void preparePlayerActions() throws IOException {
        playerActions= new JPanel();
        playerActions.setLayout(new GridLayout(3,3));
        pictureUP = ImageIO.read(GameWindow.class.getResourceAsStream("pictureUp.png"));
        pictureDown = ImageIO.read(GameWindow.class.getResourceAsStream("pictureDown.png"));
        pictureLeft = ImageIO.read(GameWindow.class.getResourceAsStream("pictureLeft.png"));
        pictureRight = ImageIO.read(GameWindow.class.getResourceAsStream("pictureRight.png"));
        PictureLeftUP = ImageIO.read(GameWindow.class.getResourceAsStream("PictureLeftUP.png"));
        pictureRightUP = ImageIO.read(GameWindow.class.getResourceAsStream("pictureRightUP.png"));
        pictureLeftDown = ImageIO.read(GameWindow.class.getResourceAsStream("pictureLeftDown.png"));
        pictureRightDown = ImageIO.read(GameWindow.class.getResourceAsStream("pictureRightDown.png"));
        pictureCenter = ImageIO.read(GameWindow.class.getResourceAsStream("pictureCenter.png"));

        moveUp = new JButton(new ImageIcon(pictureUP));
        moveDown = new JButton(new ImageIcon(pictureDown));
        moveLeft = new JButton(new ImageIcon(pictureLeft));
        moveRight = new JButton(new ImageIcon(pictureRight));
        moveLeftUp = new JButton(new ImageIcon(PictureLeftUP));
        moveRightUp = new JButton(new ImageIcon(pictureRightUP));
        moveLeftDown = new JButton(new ImageIcon(pictureLeftDown));
        moveRightDown = new JButton(new ImageIcon(pictureRightDown));
        moveNot = new JButton(new ImageIcon(pictureCenter));

        playerActions.add(moveLeftUp);
        playerActions.add(moveUp);
        playerActions.add(moveRightUp);
        playerActions.add(moveLeft);
        playerActions.add(moveNot);
        playerActions.add(moveRight);
        playerActions.add(moveLeftDown);
        playerActions.add(moveDown);
        playerActions.add(moveRightDown);

    }

    private void prepareGameActionsLog(){
        containerForGameLog = new JScrollPane();
        containerForGameLog.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JScrollBar jScrollBar = new JScrollBar();
        containerForGameLog.setVerticalScrollBar(jScrollBar);

        containerForGameLog.add(new JLabel("== Action Logs =="));

    }

    private void prepareWindow() {
        //setDefaultCloseOperation(EXIT_ON_CLOSE);      // тоже сработало
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(winPosX, winPosy);
        setSize(winWidth, winHeight);
        setTitle("GraphicApp Game");
        setResizable(false);
    }
}

package swing.ch09;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame {
    private JLabel backgroundMap;
    private JLabel player;
    private final int MOVE_STEP = 10;
    private final int INIT_X = 1000;
    private final int INIT_Y = 670;
    private ImageIcon playerLeftIcon;
    private ImageIcon playerRightIcon;

    public MyFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setTitle("이미지 사용 연습");
        setSize(INIT_X, INIT_Y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 배경 이미지 설정
        ImageIcon backgroundIcon = new ImageIcon("images/backgroundMap.png");
        backgroundMap = new JLabel(backgroundIcon);
        backgroundMap.setSize(INIT_X, INIT_Y);
        backgroundMap.setLocation(0, 0);

        playerLeftIcon = new ImageIcon("images/playerL.png");
        playerRightIcon = new ImageIcon("images/playerR.png");

        // 플레이어 설정
        ImageIcon playerIcon = new ImageIcon("images/playerL.png");
        player = new JLabel(playerIcon);
        player.setSize(100, 100);
        player.setLocation(50, 540);
    }

    private void setInitLayout() {
        setLayout(null); // 좌표기반
        backgroundMap.add(player);
        add(backgroundMap);
        setVisible(true);
    }

    private void addEventListener() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int x = player.getX();
                int y = player.getY();

                if (keyCode == KeyEvent.VK_LEFT) {
                    player.setIcon(playerLeftIcon);
                    player.setLocation(x - MOVE_STEP, y);
                } else if (keyCode == KeyEvent.VK_UP) {
                    player.setLocation(x, y - MOVE_STEP);
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    player.setIcon(playerRightIcon);
                    player.setLocation(x + MOVE_STEP, y);
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    player.setLocation(x, y + MOVE_STEP);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    // 테스트 코드 (메인 쓰레드)
    public static void main(String[] args) {
        new MyFrame();
    }
}

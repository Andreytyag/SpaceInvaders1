import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Enemy{
    public int x;
    public int y;
}

class Player{
    public int x;
    public int y;
}

class Display{ // параметры окна
    public Enemy[] enemy = new Enemy[4]; // враги
    public Player player = new Player(); // игрок
    public int window_Height = 500; // высота окна
    public int window_Width = 500; // ширина окна
    public boolean top_panel = true; // верхняя панель


    public void create_Window(){
        JFrame frame = new JFrame("Space Invaders beta 0.00");
        frame.setPreferredSize(new Dimension(window_Width,window_Height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(!top_panel);
        frame.pack();
        frame.add(new Painter(enemy, player)); // класс прорисовки
        frame.setVisible(true);

    }
}

class Painter extends JPanel implements ActionListener{
    Image enemy_imj = new ImageIcon("C:/Users/atyag/Desktop/Alien_Invasion/Alien Invasion/sprites/Enemy.png").getImage();
    Image player_imj = new ImageIcon("C:/Users/atyag/Desktop/Alien_Invasion/Alien Invasion/sprites/Player.png").getImage();
    Timer timer = new Timer(20, this); // таймер ( 200 - время)

    Enemy[] enemy;
    Player player;

    public Painter(Enemy[] enemy, Player player){
        timer.start(); // запуск таймера
        this.enemy = enemy;
        this.player = player;
    }
    public void paint(Graphics g) { // отрисовка
        super.paint(g); // очистка окна
        for(Enemy a: enemy) {
            g.drawImage(enemy_imj, a.x, a.y, 50, 50, null);
        }
        g.drawImage(player_imj,player.x,player.y,50,50,null);
    }

    @Override
    public void actionPerformed(ActionEvent e){ // перерисовка
        repaint();
    }
}
public class Main {
    public static void main(String[] args) {
        int x1 = 0;
        int y1 = 0;
        Display window = new Display();
        for (int i = 0; i < window.enemy.length; i++) {
            window.enemy[i] = new Enemy();
            window.enemy[i].x = x1;
            window.enemy[i].y = y1;
            x1 += 60;
            y1 += 60;
        }
        window.create_Window();
        window.player.x = 200;
        window.player.y = 400;

    }
}
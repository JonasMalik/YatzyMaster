import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by jonas on 2015-11-19.
 */
public class PlayerLayout extends JFrame {

        static JPanel playerPanel = new JPanel();
        static MyPlayerListener playerButtonListener = new MyPlayerListener();
        static JFrame playerFrame = new JFrame();

        public PlayerLayout() {
            super();
            createFrame();
        }

        public void createFrame() {
            // All kod f�r att skapa och s�tta samman ett f�nster (dvs ett JFrame)


            playerPanel.setLayout(null);
            playerPanel.setBackground(new Color(22, 103, 0));
            playerFrame.add(playerPanel); // l�gger in mainpanel i Jframe

            CreatePlayerButtons.CreatingPlayersButtons();

            // l�gger in en bild i jframe
            // ImageIcon icon = new ImageIcon("D://Desctop//dice6.png");
            // JLabel label = new JLabel(icon);
            // label.setBounds(10,10,300,300);// possition och storlek
            // mainPanel.add(new JLabel(new ImageIcon()));


            playerFrame.setSize(1450, 1700);
            playerFrame.setTitle("Yatzy");
            playerFrame.setDefaultCloseOperation(PlayerLayout.DISPOSE_ON_CLOSE);
            playerFrame.setLocationRelativeTo(null); //Centrerar f�nstret mitt p� sk�rmen
            playerFrame.setVisible(true);
            playerFrame.setResizable(false);

        }

    }

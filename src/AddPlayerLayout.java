import javax.swing.*;
import java.awt.*;

/**
 * Created by jonas on 2015-12-01.
 */
public class AddPlayerLayout extends JFrame{

    static String rowData[][] = {{"  Spelare 1:", ""}, {"  Spelare 2:", ""}, {"  Spelare 3:", ""}, {"  Spelare 4:", ""}, {"  Spelare 5:", ""}, {"  Spelare 6:", ""}};
    static String columnNames[] = { "","" };
    static JPanel playerPanel = new JPanel();
    static MyPlayerListener playerButtonListener = new MyPlayerListener();
    static JFrame playerFrame = new JFrame();
    static JTable addTable = new JTable(rowData, columnNames);
    static JTextField input = new JTextField();
    static JButton addPlayer = new JButton();
    static JButton startTheGame = new JButton();
    static JLabel inputText = new JLabel();
    static JLabel tableText = new JLabel();
    static JLabel playerCounter = new JLabel();

        public AddPlayerLayout() {
            super();
            createFrame();
        }

        public void createFrame() {
            // All kod för att skapa och sätta samman ett fönster (dvs ett JFrame)


            playerPanel.setLayout(null);
            playerPanel.setBackground(new Color(22, 103, 0));
            playerFrame.add(playerPanel); // lägger in mainpanel i Jframe

            inputText.setText("Namn på spelare:");
            inputText.setBounds(325, 220, 800, 100);
            inputText.setFont(new Font("", Font.CENTER_BASELINE, 50));
            playerPanel.add(inputText);

            tableText.setText("Namn på tillagda spelare:");
            tableText.setBounds(325, 480, 800, 100);
            tableText.setFont(new Font("", Font.CENTER_BASELINE, 50));
            playerPanel.add(tableText);

            playerCounter.setText("0/6");
            playerCounter.setBounds(1045,1130,100,100 );
            playerCounter.setFont(new Font("", Font.CENTER_BASELINE, 30));
            playerPanel.add(playerCounter);

            addTable.setRowHeight(100); // höjd på raderna
            addTable.setBounds(325,560,800,600); // possition och storlek
            addTable.setFont(new Font("", Font.CENTER_BASELINE, 30)); // font och storlek
            addTable.setBackground(Color.WHITE); // bakgrund
            addTable.setBorder(BorderFactory.createLineBorder(Color.BLACK,5)); // HERE
            playerPanel.add(addTable);

            input.setBounds(325,300,800,100);
            input.setFont(new Font("", Font.CENTER_BASELINE, 50));
            input.setText("  ");
            playerPanel.add(input);

            addPlayer.setBounds(925, 410, 200, 50);
            addPlayer.setFont(new Font("", Font.CENTER_BASELINE, 30));
            addPlayer.setText("Lägg till");
            addPlayer.addActionListener(playerButtonListener);
            playerPanel.add(addPlayer);

            startTheGame.setBounds(325, 1250, 800, 100);
            startTheGame.setFont(new Font("", Font.CENTER_BASELINE, 40));
            startTheGame.setText("Starta spelet!");
            startTheGame.setEnabled(false);
            startTheGame.addActionListener(playerButtonListener);
            playerPanel.add(startTheGame);

            playerFrame.setSize(1450, 1700);
            playerFrame.setTitle("Yatzy");
            playerFrame.setDefaultCloseOperation(PlayerLayout.DISPOSE_ON_CLOSE);
            playerFrame.setLocationRelativeTo(null); //Centrerar fönstret mitt på skärmen
            playerFrame.setVisible(true);
            playerFrame.setResizable(false);

        }

    }



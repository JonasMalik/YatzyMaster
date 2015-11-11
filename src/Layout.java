import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;

public class Layout extends JFrame {

    static JPanel mainPanel = new JPanel();
    static JButton rollDices = new JButton("Roll dices");
    static MyListener buttonListener = new MyListener();

    public Layout() {
        super();
        createFrame();
    }

    public void createFrame() {
        // All kod f�r att skapa och s�tta samman ett f�nster (dvs ett JFrame)
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(22, 103, 0));
        CreateDices.CreatingDices();

        rollDices.setBounds(100, 250, 1200, 50); // (PlaceringX, PlaceringY, StorlekX, StorlekY)
        rollDices.setFont(new Font("", Font.CENTER_BASELINE, 42));
        rollDices.setBackground(Color.green);
        rollDices.setBorder(null);
        rollDices.setFocusPainted(false);
        rollDices.addActionListener(buttonListener);



        // l�gger in en bild i jframe
        // ImageIcon icon = new ImageIcon("D://Desctop//dice6.png");
        // JLabel label = new JLabel(icon);
        // label.setBounds(10,10,300,300);// possition och storlek




        // mainPanel.add(new JLabel(new ImageIcon()));


        add(mainPanel); // l�gger in mainpanel i Jframe
        mainPanel.add(rollDices); // l�gger in en knapp i mainPanel

        setSize(1450,400);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); //fullsk�rm
        setTitle("Yatzi Layout");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Centrerar f�nstret mitt p� sk�rmen
        setVisible(true);

    }

}

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Layout extends JFrame {

    static Object rowData[][] = { { "  Spelare" }, { "  Ettor"       }, { "  Tvåor"      }, { "  Treor"  },
                                  { "  Fyror"   }, { "  Femmor"      }, { "  Sexor"      }, { "  Summa"  },
                                  { "  Bonus"   }, { "  Par"         }, { "  Två par"    }, { "  Tretal" },
                                  { "  Fyrtal"  }, { "  Liten stege" }, { "  Stor stege" }, { "  Kåk"    },
                                  { "  Chans"   }, { "  Yatzy"       }, { "  Total"      }};

    static Object columnNames[] = { "Column One" };
    static JTable table = new JTable(rowData, columnNames);
    static JPanel mainPanel = new JPanel();
    static JButton rollDices = new JButton("Roll dices");
    static MyListener buttonListener = new MyListener();
    static JFrame mainFrame = new JFrame();

    public Layout() {
        super();
        createFrame();
    }

    public void createFrame() {
        // All kod för att skapa och sätta samman ett fönster (dvs ett JFrame)

        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(22, 103, 0));
        mainFrame.add(mainPanel); // lägger in mainpanel i Jframe

        CreateDices.CreatingDices();

        rollDices.setBounds(100, 250, 1200, 50); // (PlaceringX, PlaceringY, StorlekX, StorlekY)
        rollDices.setFont(new Font("", Font.CENTER_BASELINE, 42));
        rollDices.setBackground(Color.green);
        rollDices.setBorder(null);
        rollDices.setFocusPainted(false);
        rollDices.addActionListener(buttonListener);
        mainPanel.add(rollDices); // lägger in en knapp i mainPanel


        table.setRowHeight(66); // höjd på raderna
        table.setBounds(100,330,185,1254); // possition och storlek
        table.setFont(new Font("", Font.CENTER_BASELINE, 30)); // font och storlek
        table.setBackground(Color.WHITE); // bakgrund
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK,5)); // HERE
        table.setFocusable(true);
        table.setEnabled(false);
        mainPanel.add(table);



        // lägger in en bild i jframe
        // ImageIcon icon = new ImageIcon("D://Desctop//dice6.png");
        // JLabel label = new JLabel(icon);
        // label.setBounds(10,10,300,300);// possition och storlek




        // mainPanel.add(new JLabel(new ImageIcon()));


        mainFrame.setSize(1450, 1700);
        mainFrame.setTitle("Yatzy");
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null); //Centrerar fönstret mitt på skärmen
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

    }

}

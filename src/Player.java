import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Player {

     Object rowData[][] = { { "1" }, { "2" }, { "3" }, { "4" },
            { "5" }, { "6" }, { "7" }, { "8"},
            { "9" }, { "10" }, { "11" }, { "12" },
            { "13" }, { "14" }, { "15" },
            { "16" }, { "17" }, { "18" }, { "19" }};

     Object columnNames[] = { "Column One" };
     JTable table = new JTable(rowData, columnNames);


}

class CreatePlayer {

    static ArrayList<Player> players = new ArrayList<>();
    static byte i = 0;
    static byte j = 1;
    static int possition = 290;

    static void CreatingPlayers(int nrOfPlayers) {

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );

        while (i < nrOfPlayers) {

            // skapar en tabell för varje spelare
            players.add(new Player());
            players.get(i).table.setRowHeight(66); // höjd på raderna
            players.get(i).table.setBounds(possition, 330, 164, 1254); // possition och storlek
            players.get(i).table.setFont(new Font("", Font.CENTER_BASELINE, 30)); // font och storlek
            players.get(i).table.setBackground(Color.WHITE); // bakgrund
            players.get(i).table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            players.get(i).table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer ); // centrerar text
            Layout.mainPanel.add(players.get(i).table);
            possition = possition + 169;

            j++;
            i++;
        }

    }
}

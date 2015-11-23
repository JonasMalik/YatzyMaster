import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by jonas on 2015-11-19.
 */
public class CreatePlayerButtons {

    static ArrayList<JButton> playerButtons = new ArrayList<>();

    static void CreatingPlayersButtons() {

        int possition = 300;
        int i = 0;
        int j = 1;
        JLabel nrOfPlayers = new JLabel();

        nrOfPlayers.setText("Hur många spelare är ni ?");
        nrOfPlayers.setBounds(150,50,1150,200);
        nrOfPlayers.setFont(new Font("", Font.BOLD, 72));
        nrOfPlayers.setHorizontalAlignment(SwingConstants.CENTER);
        PlayerLayout.playerPanel.add(nrOfPlayers);

        while (i < 6) {

            playerButtons.add(new JButton());
            playerButtons.get(i).setText(j+" Spelare");

            playerButtons.get(i).setBounds(150, possition, 1130, 170); // (PlaceringX, PlaceringY, StorlekX, StorlekY)
            playerButtons.get(i).setFont(new Font("", Font.BOLD, 72));
            playerButtons.get(i).setBackground(Color.red);
            playerButtons.get(i).setBorder(null);
            playerButtons.get(i).setFocusPainted(false);
            playerButtons.get(i).addActionListener(PlayerLayout.playerButtonListener);
            PlayerLayout.playerPanel.add(playerButtons.get(i));

            i++;
            j++;
            possition = possition + 220;
        }
    }
}

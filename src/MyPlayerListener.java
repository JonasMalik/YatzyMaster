import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jonas on 2015-11-19.
 */
public class MyPlayerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        int i = 0;

        while(i < 6) {
            if (e.getSource() == CreatePlayerButtons.playerButtons.get(i)) {
                i++;
                new Layout();
                PlayerLayout.playerFrame.dispose();
                CreatePlayer.CreatingPlayers(i);
            }
            i++;
        }
    }
}

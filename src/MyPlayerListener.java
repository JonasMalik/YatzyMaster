import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jonas on 2015-11-19.
 */
public class MyPlayerListener implements ActionListener {

    static int i = 0;

    @Override
    public void actionPerformed(ActionEvent e) {



        if (e.getSource() == AddPlayerLayout.startTheGame) {
            new Layout();
            AddPlayerLayout.playerFrame.dispose();

            CreatePlayer.CreatingPlayers(6);
        }

        if (e.getSource() == AddPlayerLayout.addPlayer) {
            if (AddPlayerLayout.input.getText().trim().equals("")){
                // felkod
            }
            else {
                AddPlayerLayout.addTable.setEnabled(true);
                AddPlayerLayout.rowData[i][1] = AddPlayerLayout.input.getText();
                AddPlayerLayout.addTable.setEnabled(false);
                AddPlayerLayout.input.setText("  ");
                AddPlayerLayout.startTheGame.setEnabled(true);
                i++;
                AddPlayerLayout.playerCounter.setText(i + "/6");
            }
        }

        if (i == 6){
            AddPlayerLayout.addPlayer.setEnabled(false);
        }


       /*
       while(i < 6) {
            if (e.getSource() == CreatePlayerButtons.playerButtons.get(i)) {
                i++;
                new Layout();
                PlayerLayout.playerFrame.dispose();
                CreatePlayer.CreatingPlayers(i);
            }
            i++;
        }
        */
    }
}

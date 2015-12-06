import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class is used to handle all buttons of the Class named
 * AddPlayerLayout.
 */
public class MyPlayerListener implements ActionListener {

    static int i = 0;

    /**
     * Invoked when an action occurs.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {



        if (e.getSource() == AddPlayerLayout.startTheGame) {
            new Layout();
            CreatePlayer.CreatingPlayers(i);
            AddPlayerLayout.playerFrame.dispose();

           // CreatePlayer.CreatingPlayers(6);
        }

        if (e.getSource() == AddPlayerLayout.addPlayer) {
            if (AddPlayerLayout.input.getText().trim().equals("")){
                // felkod
            }
            else {
                AddPlayerLayout.addTable.setEnabled(true);
                AddPlayerLayout.rowData[i][0] = AddPlayerLayout.input.getText();
                AddPlayerLayout.addTable.setEnabled(false);
                AddPlayerLayout.input.setText("  ");
                AddPlayerLayout.startTheGame.setEnabled(true);
                i++;
                AddPlayerLayout.playerCounter.setText(i + "/"+AddPlayerLayout.playersPossible);
            }
        }

        if (i == AddPlayerLayout.playersPossible){
            AddPlayerLayout.addPlayer.setEnabled(false);
        }
    }
}

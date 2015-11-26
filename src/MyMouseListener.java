
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jonas on 2015-11-23.
 */
public class MyMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = CreatePlayer.players.get(0).table.rowAtPoint(e.getPoint());
        int i = 0;

        System.out.println("CLICK");
        if (row == 18 || row == 7|| row == 8){
            System.out.println("TOTAL");
        }
        else {
            MyListener.nextPlayer = true;
            CreatePlayer.players.get(Rules.turn).table.setEnabled(true);
            CreatePlayer.players.get(Rules.turn).rowData[row][0] = Rules.RuleSelector(row);
            CreatePlayer.players.get(Rules.turn).table.setEnabled(false);

            // startar metod för att byta spelare
            Rules.WhosTurn();

            //återställning
            MyListener.spins = 0;
            MyListener.nextPlayer = false;
            while (i < 5){
                CreateDices.dices.get(i).setIcon(GetRandomNumber.icon = new ImageIcon("D://Desctop//Dice//"+CreateDices.valueOfDice[i]+".png"));
                CreateDices.diceClickedOrNot.set(i, 0);
                i++;
            }
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

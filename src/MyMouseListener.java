
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Class is used to handle all mouse click of the Class named
 * Layout.
 */
public class MyMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = CreatePlayer.players.get(0).table.rowAtPoint(e.getPoint());
        int i = 0;

        System.out.println("CLICK");
        if (row == 18 || row == 7|| row == 8 || Dice.valueOfDice[1] == 0){
            System.out.println("TOTAL");
        }
        else {
            if (Rules.RuleSelector(row) >= 0) {
                MyListener.nextPlayer = true;
                CreatePlayer.players.get(Rules.turn).table.setEnabled(true);
                CreatePlayer.players.get(Rules.turn).rowData[row][0] = Rules.RuleSelector(row);
                CreatePlayer.players.get(Rules.turn).table.setEnabled(false);

                //metod för att räkna summan av första delen och dela ut bonus
                Rules.RuleSumAndBunus();
                // metod för att räkna total poäng
                Rules.RuleTotal();
                // startar metod för att byta spelare
                Rules.WhosTurn();

                Rules.ResetDices();
               /* //återställning
                MyListener.spins = 0;
                MyListener.nextPlayer = false;
                while (i < 5) {
                    CreateDices.dices.get(i).setIcon(GetRandomNumber.icon = new ImageIcon("D://Desctop//Dice//" + CreateDices.valueOfDice[i] + ".png"));
                    CreateDices.diceClickedOrNot.set(i, 0);
                    i++;
                }*/
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

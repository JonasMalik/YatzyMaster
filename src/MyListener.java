import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class is used to handle all buttons of the Class named
 * Layout.
 */
public class MyListener  implements ActionListener {

    int i = 0;
    int j = 0;
    int diceCounter;
    static int spins = 0;
    static int throwsLeft = 3;
    static Boolean nextPlayer = false;

    /**
     * Invoked when an action occurs.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        i = 0;
        while (i < Dice.nrOfDices){

            if (e.getSource() == Dice.myDices.getDices().get(i)) {

                if (Dice.diceClickedOrNot.get(i) == 1) {
                    Dice.myDices.getDices().get(i).setIcon(GetRandomNumber.icon = new ImageIcon("D://Desctop//Dice//"+Dice.valueOfDice[i]+".png"));
                    Dice.diceClickedOrNot.set(i, 0);
                    diceCounter++;

                }

                else if (Dice.diceClickedOrNot.get(i) == 0) {
                    Dice.myDices.getDices().get(i).setIcon(GetRandomNumber.icon = new ImageIcon("D://Desctop//ClickedDice//"+Dice.valueOfDice[i]+"Clicked.png"));
                    Dice.diceClickedOrNot.set(i, 1);
                    diceCounter--;
                }
                System.out.println(Dice.diceClickedOrNot);
            }
            i++;
        }


        if (e.getSource() == Layout.rollDices) {
            j = 0;
            spins++;
            throwsLeft--;

            if (throwsLeft>0) {
                Layout.throwsLeft.setText("  Kast kvar: " + throwsLeft + "  ");
            }
            else {
                Layout.throwsLeft.setText("  Gör ditt val!  Kast kvar: 0  ");
                Layout.rollDices.setEnabled(false);
            }
            System.out.println(spins+" "+nextPlayer);

            if (spins <= 3 && nextPlayer == false) {
                while (j < 5) {
                    if (Dice.diceClickedOrNot.get(j) == 0) {
                        GetRandomNumber.RandomNumber(j);
                    }
                    j++;

                    if (nextPlayer == true){

                        nextPlayer = false;
                    }
                }
            }
        }
    }
}


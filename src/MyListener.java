import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jonas on 2015-11-09.
 */
public class MyListener  implements ActionListener {

    int i = 0;
    int j = 0;
    int diceCounter;
    static int spins = 0;
    static int throwsLeft = 3;
    static Boolean nextPlayer = false;

    @Override
    public void actionPerformed(ActionEvent e) {

        i = 0;
        while (i < CreateDices.nrOfDices){

            if (e.getSource() == CreateDices.dices.get(i)) {

                if (CreateDices.diceClickedOrNot.get(i) == 1) {
                    CreateDices.dices.get(i).setIcon(GetRandomNumber.icon = new ImageIcon("D://Desctop//Dice//"+CreateDices.valueOfDice[i]+".png"));
                    CreateDices.diceClickedOrNot.set(i, 0);
                    diceCounter++;

                }

                else if (CreateDices.diceClickedOrNot.get(i) == 0) {
                    CreateDices.dices.get(i).setIcon(GetRandomNumber.icon = new ImageIcon("D://Desctop//ClickedDice//"+CreateDices.valueOfDice[i]+"Clicked.png"));
                    CreateDices.diceClickedOrNot.set(i, 1);
                    diceCounter--;
                }
                System.out.println(CreateDices.diceClickedOrNot);
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
                    if (CreateDices.diceClickedOrNot.get(j) == 0) {
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


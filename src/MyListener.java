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

    @Override
    public void actionPerformed(ActionEvent e) {

        i = 0;
        while (i < CreateDices.nrOfDices){

            if (e.getSource() == CreateDices.dices.get(i)) {

                if (CreateDices.diceClickedOrNot.get(i) == 1) {
                    CreateDices.dices.get(i).setBackground(Color.red);
                    CreateDices.diceClickedOrNot.set(i, 0);
                    diceCounter++;

                }

                else if (CreateDices.diceClickedOrNot.get(i) == 0) {
                    CreateDices.dices.get(i).setBackground(Color.green);
                    CreateDices.diceClickedOrNot.set(i, 1);
                    diceCounter--;
                }
                System.out.println(CreateDices.diceClickedOrNot);
            }
            i++;
        }


        if (e.getSource() == Layout.rollDices) {
            j = 0;
            while (j<5){
                if (CreateDices.diceClickedOrNot.get(j) == 0){
                    GetRandomNumber.RandomNumber(j);
                }
                j++;
            }
        }

    }
}


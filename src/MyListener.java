import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by jonas on 2015-11-09.
 */
public class MyListener  implements ActionListener {

    int i = 0;
    int diceCounter;

    @Override
    public void actionPerformed(ActionEvent e) {

        i = 0;
        while (i < CreateDices.nrOfDices){

            if (e.getSource() == CreateDices.dices.get(i)) {

                if (CreateDices.diceClickedOrNot.get(i) == 1) {
                    CreateDices.dices.get(i).setBackground(Color.red);
                    CreateDices.diceClickedOrNot.set(i, 0);

                }

                else if (CreateDices.diceClickedOrNot.get(i) == 0) {
                    CreateDices.dices.get(i).setBackground(Color.green);
                    CreateDices.diceClickedOrNot.set(i, 1);
                }
                System.out.println(CreateDices.diceClickedOrNot);
            }
            i++;
        }


        if (e.getSource() == Layout.rollDices) {
            GetRandomNumber.RandomNumber(0);
            GetRandomNumber.RandomNumber(1);
            GetRandomNumber.RandomNumber(2);
            GetRandomNumber.RandomNumber(3);
            GetRandomNumber.RandomNumber(4);

        }
    }
}


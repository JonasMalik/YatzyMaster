import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jonas on 2015-11-10.
 */
class CreateDices {


    static String[] yatzy = { "Y", "A", "T", "Z", "Y" };
    static JButton rollDices = new JButton("Roll dices");
    static int nrOfDices = 5;
    static ArrayList<JButton> dices = new ArrayList<>();
    static ArrayList<Integer> diceClickedOrNot = new ArrayList();

    static void CreatingDices(){

        int possition = 100;
        int i = 0;

        while (i < nrOfDices) {

            dices.add(new JButton());
            dices.get(i).setText(yatzy[i]);

            dices.get(i).setBounds(possition, 30, 200, 200); // (PlaceringX, PlaceringY, StorlekX, StorlekY)
            dices.get(i).setFont(new Font("", Font.BOLD, 72));
            dices.get(i).setBackground(Color.red);
            dices.get(i).setBorder(null);
            dices.get(i).setFocusPainted(false);
            dices.get(i).addActionListener(Layout.buttonListener);
            Layout.mainPanel.add(dices.get(i));

            i++;
            possition = possition + 250;
        }

        i = 0;

        while (i < nrOfDices) {
            diceClickedOrNot.add(0);
            i++;
        }
    }

}

class GetRandomNumber {


    static void RandomNumber(int index) {

        Random rand = new Random();
        int random = rand.nextInt(6) + 1;
        CreateDices.dices.get(index).setText(Integer.toString(random));
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jonas on 2015-11-10.
 */
class Dice {

    static Dice myDices = new Dice();
    static String[] yatzy = { "Y", "A", "T", "Z", "Y" };
    static JButton rollDices = new JButton("Roll dices");
    static int nrOfDices = 5;
    private ArrayList<JButton> dices = new ArrayList<>();
    static ArrayList<Integer> diceClickedOrNot = new ArrayList();
    static int[] valueOfDice = new int[5];

    public ArrayList<JButton> getDices() {
        return dices;
    }

     static void CreatingDices(){

        int possition = 100;
        int i = 0;

        while (i < nrOfDices) {

            myDices.getDices().add(new JButton());
            myDices.getDices().get(i).setText(yatzy[i]);
            myDices.getDices().get(i).setBounds(possition, 30, 195, 192); // (PlaceringX, PlaceringY, StorlekX, StorlekY)
            myDices.getDices().get(i).setFont(new Font("", Font.BOLD, 120));
            myDices.getDices().get(i).setBackground(new Color(22, 103, 0));
            myDices.getDices().get(i).setBorder(null);
            myDices.getDices().get(i).setFocusPainted(false);
            myDices.getDices().get(i).addActionListener(Layout.buttonListener);
            Layout.mainPanel.add(myDices.getDices().get(i));

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

    static ImageIcon icon = new ImageIcon();

    static void StartRandomNumber(int index1){
        GetRandomNumber temp1 = new GetRandomNumber();
        GetRandomNumber.RandomNumber(index1);
    }

    public static void RandomNumber(int index) {

        Random rand = new Random();
         int random = rand.nextInt(6) + 1;
         icon = new ImageIcon("D://Desctop//Dice//"+random+".png");
         Dice.myDices.getDices().get(index).setText("");
         Dice.myDices.getDices().get(index).setIcon(icon);
         Dice.valueOfDice[index] = random;


    }
}

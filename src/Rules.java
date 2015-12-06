import javax.swing.*;
import java.awt.*;

/**
 * Class is used to store all rules .
 */
public class Rules {

    static int turn = 0;
    static int players = CreatePlayer.players.size() - 1;
    static int valueOfDices = 0;
    static int throwsLeft = 3;

    /**
     * Method used to show which player it is to play right now.
     */
    static void WhosTurn(){

        if (turn < players){
            CreatePlayer.players.get(Rules.turn).table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            turn++;
            CreatePlayer.players.get(Rules.turn).table.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
            Layout.throwsLeft.setText("  Kast kvar: "+throwsLeft+"  ");
            Layout.throwsLeft.setText("  Kast kvar: 3  ");
            Layout.playerName.setText("  Spelare: "+AddPlayerLayout.rowData[turn][0].trim().toUpperCase()+"  ");
            Layout.rollDices.setEnabled(true);
        }
        else {
            CreatePlayer.players.get(Rules.turn).table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            turn = 0;
            CreatePlayer.players.get(Rules.turn).table.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
            Layout.throwsLeft.setText("  Kast kvar: 3  ");
            Layout.playerName.setText("  Spelare: "+AddPlayerLayout.rowData[turn][0].trim().toUpperCase()+"  ");
            Layout.rollDices.setEnabled(true);
        }
        System.out.println("player "+turn);
    }


    /**
     * Method used to select which rule to do.
     * @param rowSelected Row clicked on.
     * @return Returns the value from the specific rule.
     */
    // Väljer regel beroende på vilken rad du klickar på
    static int RuleSelector(int rowSelected){

        valueOfDices = 0;

        if (CreatePlayer.players.get(turn).table.getModel().getValueAt(rowSelected, 0) == null) {
            if (rowSelected <= 6) {
                RuleOneToSix(rowSelected);
            } else if (rowSelected == 9) {
                RulePair();
            } else if (rowSelected == 10) {
                RuleTwoPair();
            } else if (rowSelected == 11) {
                RuleThreeOfAKind();
            } else if (rowSelected == 12) {
                RuleFourOfAKind();
            } else if (rowSelected == 13) {
                RuleSmallStraight();
            } else if (rowSelected == 14) {
                RuleBigStraight();
            } else if (rowSelected == 15) {
                RuleFullHouse();
            } else if (rowSelected == 16) {
                RuleChance();
            } else if (rowSelected == 17) {
                RuleYatzy();
            }
        }
        else{
            valueOfDices = -1;
        }
        return valueOfDices;
    }


    /**
     * Method used to calculate rules for (Rows 1-6).
     * @param rule Which role of 1-6.
     * @return value of calculated rule.
     */
    // Regler för ettor till sexor, räknar ihop en viss siffra som är på tärningarna
    static int RuleOneToSix(int rule){

        for (int i = 0; i < 5; i++){
            if (Dice.valueOfDice[i] == rule ) {
                valueOfDices += Dice.valueOfDice[i];
            }
        }
        return valueOfDices;
    }


    /**
     * Method used to calculate (Sum Points Of Rows 1-6).
     */
    // Räknar ut värdet av första delen på tabellen, om summan är minst 63 så får man en bonus på 50 poäng.
    static void RuleSumAndBunus(){

        int value = 0;
        int total = 0;

        for (int i = 1; i <= 6; i++){
            if(CreatePlayer.players.get(turn).table.getModel().getValueAt(i, 0) != null){
                value = (int) CreatePlayer.players.get(turn).table.getModel().getValueAt(i, 0);
                total = total + value;
            }
        }
        CreatePlayer.players.get(Rules.turn).rowData[7][0] = total;
        if (total >= 63){
            CreatePlayer.players.get(Rules.turn).rowData[8][0] = 50;
        }
    }


    /**
     * Method used to calculate rules for (Pair).
     * @return Points of (Pair).
     */
    // tar det största möjliga par
    static int RulePair() {

        int match = 0;
        int j = 6;

        while (match < 2 && j > 1) {
            match = 0;
            for (int i = 0; i < 5; i++) {
                if (j == Dice.valueOfDice[i]) {
                    match++;
                    if (match == 2) {
                        valueOfDices = j * 2;
                        break;
                    }
                }
            }
            j--;
            if (match == 2){
                break;
            }
        }

        if (match != 2){
            valueOfDices = 0;
        }
        return valueOfDices;
    }



    /**
     * Method used to calculate rules for (Two Pair).
     * @return Points of (Two Pair).
     */
    // tar de två största möjliga par
    static int RuleTwoPair(){

        int match = 0;
        int j = 6;
        int valueOfDices1 = 0;
        int valueOfDices2 = 0;
        int check = 0;

        while (match < 2 && j >= 1) {
            match = 0;
            for (int i = 0; i < 5; i++) {
                if (j == Dice.valueOfDice[i]) {
                    match++;
                    if (match == 2) {
                        valueOfDices1 = j * 2;
                        break;
                    }
                }
            }
            j--;
            if (match == 2){
                break;
            }
        }

        match = 0;

        while (match < 2 && j >= 1) {
            match = 0;
            for (int i = 0; i < 5; i++) {
                if (j == Dice.valueOfDice[i]) {
                    match++;
                    if (match == 2) {
                        valueOfDices2 = j * 2;
                        check++;
                        break;
                    }
                }
            }
            j--;
            if (match == 2){
                break;
            }
        }

        if (check == 1){
            valueOfDices = valueOfDices1 + valueOfDices2;
        }
        else if(check == 0) {
            valueOfDices = 0;
        }
        return valueOfDices;
    }


    /**
     * Method used to calculate rules for (Three Of A Kind).
     * @return points of (Three Of A Kind).
     */
    // tre av samma siffra
    static int RuleThreeOfAKind(){

        int match = 0;
        int j = 6;

        while (match < 3 && j >= 1) {
            match = 0;
            for (int i = 0; i < 5; i++) {
                if (j == Dice.valueOfDice[i]) {
                    match++;
                    if (match == 3) {
                        valueOfDices = j * 3;
                        break;
                    }
                }
            }
            j--;
            if (match == 3){
                break;
            }
        }
        if (match != 3){
            valueOfDices = 0;
        }
        return valueOfDices;
    }



    /**
     * Method used to calculate rules for (Four Of A Kind).
     * @return Points of (Four Of A Kind).
     */
    // Fyra av samma siffra
    static int RuleFourOfAKind(){

            int match = 0;
            int j = 6;

            while (match < 4 && j >= 1) {
                match = 0;
                for (int i = 0; i < 5; i++) {
                    if (j == Dice.valueOfDice[i]) {
                        match++;
                        if (match == 4) {
                            valueOfDices = j * 4;
                            break;
                        }
                    }
                }
                j--;
                if (match == 4){
                    break;
                }
            }
            if (match != 4){
                valueOfDices = 0;
            }
            return valueOfDices;
        }


    /**
     * Method used to calculate rules for (Small Straight).
     * @return Points of (Small Straight).
     */
    // Liten stege (1,2,3,4,5)
    static int RuleSmallStraight(){

            int match = 0;
            int j = 5;

            while (match < 5 && j >= 1) {
                for (int i = 0; i < 5; i++) {
                    if (j == Dice.valueOfDice[i]) {
                        match++;
                        if (match == 5) {
                            valueOfDices = 15;
                            break;
                        }
                        break;
                    }
                }
                j--;
                if (match == 5){
                    break;
                }
            }
            if (match != 5){
                valueOfDices = 0;
            }
            return valueOfDices;
        }


    /**
     * Method used to calculate rules for (Big Straight).
     * @return Points of (Big Straight).
     */
    // Stor stege (2,3,4,5,6)
    static int RuleBigStraight(){

        int match = 0;
        int j = 6;

        while (match < 5 && j > 1) {
            for (int i = 0; i < 5; i++) {
                if (j == Dice.valueOfDice[i]) {
                    match++;
                    if (match == 5) {
                        valueOfDices = 20;
                        break;
                    }
                    break;
                }
            }
            j--;
            if (match == 5){
                break;
            }
        }
        if (match != 5){
            valueOfDices = 0;
        }
        return valueOfDices;
    }


    /**
     * Method used to calculate rules for (Full House).
     * @return Points of (Full House).
     */
    // Ett par med två tärningar och ett par med tre tärningar
    static int RuleFullHouse() {

        int match = 0;
        int j = 6;
        int valueOfDices1 = 0;
        int valueOfDices2 = 0;
        int check = 0;

        while (match < 3 && j >= 1) {
            match = 0;
            for (int i = 0; i < 5; i++) {
                if (j == Dice.valueOfDice[i]) {
                    match++;
                    if (match == 3) {
                        valueOfDices1 = j * 3;
                        check++;
                        break;
                    }

                }
            }
            j--;
            if (match == 3) {
                break;
            }
        }

        match = 0;
        j = 6;

        if (check == 1) {
            while (match < 2 && j >= 1) {
                match = 0;
                if (j == valueOfDices1 / 3) {
                    j--;
                }
                for (int i = 0; i < 5; i++) {
                    if (j == Dice.valueOfDice[i]) {
                        match++;
                        if (match == 2) {
                            valueOfDices2 = j * 2;
                            check++;
                            break;
                        }
                    }
                }
                j--;
                if (match == 2) {
                    break;
                }
            }
        }

        if (check == 2) {
            valueOfDices = valueOfDices1 + valueOfDices2;
        } else if (check == 0 || check == 1) {
            valueOfDices = 0;
        }
        return valueOfDices;
    }


    /**
     * Method used to calculate rules for (Chance).
     * @return Points of (Chance).
     */
    // Räknar ut värdet av alla tärningar
    static int RuleChance(){

        for (int i = 0; i < 5; i++){
            valueOfDices += Dice.valueOfDice[i];
        }
        return valueOfDices;
    }


    /**
     * Method used to calculate rules for (Yatzy).
     * @return Points of (Yatzy).
     */
    // Alla tärningar visar samma siffra
    static int RuleYatzy(){

            int match = 0;
            int j = 6;

            while (match < 5 && j >= 1) {
                match = 0;
                for (int i = 0; i < 5; i++) {
                    if (j == Dice.valueOfDice[i]) {
                        match++;
                        if (match == 5) {
                            valueOfDices = 50;
                            break;
                        }
                    }
                }
                j--;
                if (match == 5){
                    break;
                }
            }
            if (match != 5){
                valueOfDices = 0;
            }
            return valueOfDices;
        }


    /**
     * Method used to calculate (Total Points).
     */
    // Räknar ut total poängen
    static void RuleTotal(){

        int value = 0;
        int total = 0;

        for (int i = 7; i <= 17; i++){
            if(CreatePlayer.players.get(turn).table.getModel().getValueAt(i, 0) != null){
                value = (int) CreatePlayer.players.get(turn).table.getModel().getValueAt(i, 0);
                total = total + value;
            }
        }
        CreatePlayer.players.get(Rules.turn).rowData[18][0] = total;
    }


    /**
     * Method used to reset all dices.
     */
    static void ResetDices(){

        int i = 0;
        MyListener.spins = 0;
        MyListener.nextPlayer = false;
        MyListener.throwsLeft = 3;

        while (i < 5) {
            Dice.myDices.getDices().get(i).setIcon(GetRandomNumber.icon = new ImageIcon("D://esctop//Dice//" + Dice.valueOfDice[i] + ".png"));
            Dice.diceClickedOrNot.set(i, 0);
            Dice.valueOfDice[i] = 0;
            Dice.myDices.getDices().get(i).setText(Dice.yatzy[i]);
            i++;
        }
    }

}

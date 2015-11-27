import javax.swing.*;
import java.awt.*;

/**
 * Created by jonas on 2015-11-24.
 */
public class Rules {

    static int turn = 0;
    static int players = CreatePlayer.players.size() - 1;
    static int valueOfDices = 0;

    static void WhosTurn(){

        if (turn < players){
            CreatePlayer.players.get(Rules.turn).table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            turn++;
            CreatePlayer.players.get(Rules.turn).table.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
        }
        else {
            CreatePlayer.players.get(Rules.turn).table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            turn = 0;
            CreatePlayer.players.get(Rules.turn).table.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
        }
        System.out.println("player "+turn);
    }


    // V�ljer regel beroende p� vilken rad du klickar p�
    static int RuleSelector(int rowSelected){

        valueOfDices = 0;

        if (rowSelected <=6){
            RuleOneToSix(rowSelected);
        }
        else if (rowSelected == 9) {
            RulePair();
        }
        else if (rowSelected == 10) {
            RuleTwoPair();
        }
        else if (rowSelected == 11) {
            RuleThreeOfAKind();
        }
        else if (rowSelected == 12) {
            RuleFourOfAKind();
        }
        else if (rowSelected == 13) {
            RuleSmallStraight();
        }
        else if (rowSelected == 14){
            RuleBigStraight();
        }
        else if (rowSelected == 15) {
            RuleFullHouse();
        }
        else if (rowSelected == 16) {
            RuleChance();
        }
        else if (rowSelected == 17) {
            RuleYatzy();
        }
        return valueOfDices;
    }


    // Regler f�r ettor till sexor, r�knar ihop en viss siffra som �r p� t�rningarna
    static int RuleOneToSix(int rule){

        for (int i = 0; i < 5; i++){
            if (CreateDices.valueOfDice[i] == rule ) {
                valueOfDices += CreateDices.valueOfDice[i];
            }
        }
        return valueOfDices;
    }


    // R�knar ut v�rdet av f�rsta delen p� tabellen, om summan �r minst 63 s� f�r man en bonus p� 50 po�ng.
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


    // tar det st�rsta m�jliga par
    static int RulePair() {

        int match = 0;
        int j = 6;

        while (match < 2 && j > 1) {
            match = 0;
            for (int i = 0; i < 5; i++) {
                if (j == CreateDices.valueOfDice[i]) {
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



    // tar de tv� st�rsta m�jliga par
    static int RuleTwoPair(){

        int match = 0;
        int j = 6;
        int valueOfDices1 = 0;
        int valueOfDices2 = 0;
        int check = 0;

        while (match < 2 && j >= 1) {
            match = 0;
            for (int i = 0; i < 5; i++) {
                if (j == CreateDices.valueOfDice[i]) {
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
                if (j == CreateDices.valueOfDice[i]) {
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


    // tre av samma siffra
    static int RuleThreeOfAKind(){

        int match = 0;
        int j = 6;

        while (match < 3 && j >= 1) {
            match = 0;
            for (int i = 0; i < 5; i++) {
                if (j == CreateDices.valueOfDice[i]) {
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



    // Fyra av samma siffra
    static int RuleFourOfAKind(){

            int match = 0;
            int j = 6;

            while (match < 4 && j >= 1) {
                match = 0;
                for (int i = 0; i < 5; i++) {
                    if (j == CreateDices.valueOfDice[i]) {
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


    // Liten stege (1,2,3,4,5)
    static int RuleSmallStraight(){

            int match = 0;
            int j = 5;

            while (match < 5 && j >= 1) {
                for (int i = 0; i < 5; i++) {
                    if (j == CreateDices.valueOfDice[i]) {
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


    // Stor stege (2,3,4,5,6)
    static int RuleBigStraight(){

        int match = 0;
        int j = 6;

        while (match < 5 && j > 1) {
            for (int i = 0; i < 5; i++) {
                if (j == CreateDices.valueOfDice[i]) {
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


    // Ett par med tv� t�rningar och ett par med tre t�rningar
    static int RuleFullHouse() {

        int match = 0;
        int j = 6;
        int valueOfDices1 = 0;
        int valueOfDices2 = 0;
        int check = 0;

        while (match < 3 && j >= 1) {
            match = 0;
            for (int i = 0; i < 5; i++) {
                if (j == CreateDices.valueOfDice[i]) {
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
                    if (j == CreateDices.valueOfDice[i]) {
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


    // R�knar ut v�rdet av alla t�rningar
    static int RuleChance(){

        for (int i = 0; i < 5; i++){
            valueOfDices += CreateDices.valueOfDice[i];
        }
        return valueOfDices;
    }


    // Alla t�rningar visar samma siffra
    static int RuleYatzy(){

            int match = 0;
            int j = 6;

            while (match < 5 && j >= 1) {
                match = 0;
                for (int i = 0; i < 5; i++) {
                    if (j == CreateDices.valueOfDice[i]) {
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


    // R�knar ut total po�ngen
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

}

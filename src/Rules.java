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
    static int RuleSumAndBunus(){


        return valueOfDices;
    }


    // tar det st�rsta m�jliga par
    static int RulePair(){


        return valueOfDices;
    }


    // tar de tv� st�rsta m�jliga par
    static int RuleTwoPair(){


        return valueOfDices;
    }


    // tre av samma siffra
    static int RuleThreeOfAKind(){


        return valueOfDices;
    }


    // Fyra av samma siffra
    static int RuleFourOfAKind(){


        return valueOfDices;
    }


    // Liten stege (1,2,3,4,5)
    static int RuleSmallStraight(){


        return valueOfDices;
    }


    // Stor stege (2,3,4,5,6)
    static int RuleBigStraight(){


        return valueOfDices;
    }


    // Ett par med tv� t�rningar och ett par med tre t�rningar
    static int RuleFullHouse(){


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


        return valueOfDices;
    }


    // R�knar ut total po�ngen
    static int RuleTotal(){


        return valueOfDices;
    }

}

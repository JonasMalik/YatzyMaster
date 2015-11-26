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


    // Väljer regel beroende på vilken rad du klickar på
    static int RuleSelector(int rowSelected){

        valueOfDices = 0;

        if (rowSelected <=6){
            RuleOneToSix(rowSelected);
        }

        return valueOfDices;
    }


    // Regler för ettor till sexor, räknar ihop en viss siffra som är på tärningarna
    static int RuleOneToSix(int rule){

        for (int i = 0; i < 5; i++){
            if (CreateDices.valueOfDice[i] == rule ) {
                valueOfDices += CreateDices.valueOfDice[i];
            }
        }
        return valueOfDices;
    }


    // Räknar ut värdet av första delen på tabellen, om summan är minst 63 så får man en bonus på 50 poäng.
    static int RuleSumAndBunus(){


        return valueOfDices;
    }


    // tar det största möjliga par
    static int RulePair(){


        return valueOfDices;
    }


    // tar de två största möjliga par
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


    // Ett par med två tärningar och ett par med tre tärningar
    static int RuleFullHouse(){


        return valueOfDices;
    }


    // Räknar ut värdet av alla tärningar
    static int RuleChance(){

        for (int i = 0; i < 5; i++){
            valueOfDices += CreateDices.valueOfDice[i];
        }
        return valueOfDices;
    }


    // Alla tärningar visar samma siffra
    static int RuleYatzy(){


        return valueOfDices;
    }


    // Räknar ut total poängen
    static int RuleTotal(){


        return valueOfDices;
    }

}

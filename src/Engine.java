import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingr on 6/7/2017.
 */
public class Engine {

    public static class Card {
        private enum Type {
            MAKI_ROLL, TEMPURA, SASHIMI, DUMPLING, NIGIRI;
        }
        private Type cardType;
        private int point;

        public Card(Type t, int p) {
            setCardType(t);
            setPoint(p);
        }

        public Type getCardType() {
            return cardType;
        }

        public void setCardType(Type cardType) {
            this.cardType = cardType;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

    }

    public static class Tableau {
        private ArrayList<Card> tableau = new ArrayList<Card>();
        public int getTotalPoints(Tableau t) {
            int totalPoints = 0;
            int totalMakis = 0, totalTempura = 0, totalSashimi = 0, totalDumpling = 0;
            for (Card c:t.tableau) {
                switch (c.getCardType()) {
                    case MAKI_ROLL:
                        totalMakis += 1;
                        break;
                    case TEMPURA:
                        totalTempura += 1;
                        break;
                    case SASHIMI:
                        totalSashimi += 1;
                        break;
                    case DUMPLING:
                        totalDumpling += 1;
                        break;
                    case NIGIRI:
                        totalPoints += c.getPoint();
                        break;
                }
            }
            if (totalMakis > 0) {
                totalPoints += 6;
            }
            //To be changed LATER
            int TempuraPoints = (totalTempura/2) * 5;
            totalPoints += TempuraPoints;
            int SashimiPoints = (totalSashimi/3) * 10;
            totalPoints += SashimiPoints;
            int DumplingPoints = 0;
            switch(totalDumpling) {//NOTE: might have negative numbers
                case 0:
                    DumplingPoints = 0;
                    break;
                case 1:
                    DumplingPoints = 1;
                    break;
                case 2:
                    DumplingPoints = 3;
                    break;
                case 3:
                    DumplingPoints = 6;
                    break;
                case 4:
                    DumplingPoints = 10;
                    break;
                default:
                    DumplingPoints = 15;
            }
            totalPoints += DumplingPoints;
            return totalPoints;
        }
    }

    public static void main(String[] args) {
        Card makiRoll = new Card(Card.Type.MAKI_ROLL, 6);
        Card tempura = new Card(Card.Type.TEMPURA, 5);
        Card sashimi = new Card(Card.Type.SASHIMI, 10);
        Card dumpling = new Card(Card.Type.DUMPLING, 15);
        Card nigiri1 = new Card(Card.Type.NIGIRI, 1);
        Card nigiri2 = new Card(Card.Type.NIGIRI, 2);
        Card nigiri3 = new Card(Card.Type.NIGIRI, 3);

        Tableau tableau = new Tableau();
        tableau.tableau.add(makiRoll); //6
        tableau.tableau.add(tempura);
        tableau.tableau.add(tempura); //5
        tableau.tableau.add(tempura);
        tableau.tableau.add(sashimi);
        tableau.tableau.add(sashimi); //10
        tableau.tableau.add(sashimi);
        tableau.tableau.add(sashimi);
        tableau.tableau.add(dumpling); //1
        tableau.tableau.add(nigiri1);
        tableau.tableau.add(nigiri2);
        tableau.tableau.add(nigiri3);

        int totalPoints = tableau.getTotalPoints(tableau);
        System.out.println("Points: " + totalPoints);

//        ArrayList<Card> hand = new ArrayList<Card>();
//
//        hand.add(makiRoll);
//        hand.add(tempura);
//        hand.add(sashimi);
//        hand.add(dumpling);
//        hand.add(nigiri);
//
//        int addPoints = 0;
//
//        for (Card c:hand) {
//            addPoints += c.getPoint();
//        }
//        System.out.println("Points: " + addPoints);
    }
}

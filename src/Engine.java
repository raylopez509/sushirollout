import java.util.ArrayList;

/**
 * Created by kingr on 6/7/2017.
 */
public class Engine {

    public static class Card {
        private String name;
        private int point;

        public Card(String n, int p) {
            setName(n);
            setPoint(p);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world");

        Card makiRoll = new Card("Maki Roll", 6);
        Card tempura = new Card("Tempura", 5);
        Card sashimi = new Card("Sashimi", 10);
        Card dumpling = new Card("Dumplings", 15);
        Card nigiri = new Card("Nigiri", 3);

        ArrayList<Card> hand = new ArrayList<Card>();

        hand.add(makiRoll);
        hand.add(tempura);
        hand.add(sashimi);
        hand.add(dumpling);
        hand.add(nigiri);

        int addPoints = 0;

        for (Card c:hand) {
            addPoints += c.getPoint();
        }
        System.out.println("Points: " + addPoints);
    }
}

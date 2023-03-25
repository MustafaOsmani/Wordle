import java.util.ArrayList;
import java.util.Scanner;

// The Wordle class takes the user's guess, the answer, and the arraylist.
public class Wordle {
    private String answer;
    private String guess;
    private final ArrayList<String> list;

    public Wordle(String answer, String guess, ArrayList<String> list) {
        this.answer = answer;
        this.guess = guess;
        this.list = list;
    }

    Scanner in = new Scanner(System.in);

    /* The test method is where the user's guess is tested to see if it matches
    with the actual answer. The user is given six chances to guess, or they lose.
    First, the method will check if the guess is valid, according to the list.
    If so, then the guess will be checked to see if it matches with the answer.
    If not, then the individual characters will be checked. If any are in the
    exact spot the answer is, the user will be noted. If any of the characters
    in the user's guess are anywhere in the answer, the user will be noted.
    Every wrong guess takes a chance away.
     */
    public void test (){
        int chance = 5;
        while (chance>0) {
            boolean counts = list.contains(guess);
            if (counts) {
                if (guess.equals(answer)) {
                    System.out.println("Congratulations, you got it!");
                    System.exit(0);
                } else {
                    for (int i = 0; i < guess.length(); i++) {
                        if (guess.charAt(i)==(answer.charAt(i))) {
                           System.out.println("The " + guess.charAt(i) + " is right!");
                        } else {
                            char ch = guess.charAt(i);
                            for (int j = 0; j < answer.length(); j++)
                                if (ch == answer.charAt(j)) {
                                    System.out.println("There is a " + ch + " but not here.");
                            }
                        }
                    }
                    chance = chance - 1;
                    System.out.println("");
                    System.out.print("What is your guess? ");
                    guess = in.next();
                }
            } else {
                System.out.println("Please enter a valid 5-letter word.");
                System.out.println("");
                System.out.print("What is your guess? ");
                guess = in.next();
            }
        }
        System.out.println("Sorry, the word is " + answer);

    }
}

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/* The Main class takes in the text file and adds each line into an arraylist.
It, then selects a word within that list at random. That word will be the answer.
The instructions are displayed and a guess from the user is asked.
Finally, the user's guess, the actual answer, and the arraylist are sent over to the
Wordle class. */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = null;
        try {
            FileReader reader = new FileReader("words.txt");
            Scanner w = new Scanner(reader);
            list = new ArrayList<>();

            //adding words to arraylist
            while (w.hasNext()) {
                list.add(w.next());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }
        //picks target word
        Random rand = new Random();
        int x = rand.nextInt(4500);
        String targetWord = list.get(x);

        //initial start
        Scanner in = new Scanner(System.in);
        System.out.println("You have six tries to guess a five-letter word.");
        System.out.println("");
        System.out.print("What is your guess? ");
        String answer = in.next();

        //guess and answer has been established using list
        Wordle user = new Wordle(targetWord, answer, list);
        //game officially starts
        user.test();

    }

}
//A Java package organizes Java classes into namespaces, giving a different namespace for every type it has. The name of this package is javaapplication31.
package javaapplication31;
//The following line of code imports and Scanner, allowing me to utilize it in my program. Without it, I cannot use scanner, allowing me to not obtain the user's input.
import java.util.Scanner;
/**
* @author Vedant Shah
* Date: Monday, May 2, 2018
* Course Info: ICS3U-25 Teacher: Ms. Navabi
* Project Information: This project is a project where a topic is randomly selected by the computer. The user has to guess what these letters 
* are in order to win. If the user enters a letter that is in the word, the computer will insert the letter where it occurs in the secret
* word, remove the letter from the letters remaining, add the letter to the letters used, and re-output the secret word. If the letter the 
* user guesses is not in the word, the computer will output a message to the user indicating
* that the letter is not in the word, remove the letter from the letters remaining, add the letter to the
* letters used, and deduct one from the number of guesses remaining. However, if the user enters a letter that has already been used, the computer will 
* output a message indicating to the user that the letter has already been used.If the user enters '!' as a letter guess, the user will be prompted
* for the secret word. If the user guesses the word correctly, the computer will output a message congratulating the user and prompt the user to play again. 
* However, if the user guesses incorrectly, the computer will output a message indicating that the user has lost, reveal the secret word and ask the user if 
* he/she would like to play again. If the user guesses all the letters in the word, the computer will output a message congratulating the user and
* prompt the user to play again; unfortunately, if the user run out of guesses, the computer will output a message indicating that they are all out 
* of guesses, reveal the answer to the user, and ask them if they want to play again
*/
public class Hangman {
    /**
     * Public allows the main method to be accessible anywhere. Static assists the main method to get loaded and void clarifies that the main method will not output any value. ain is the name of the method.
     * This is required as you can only code after this has been written.
     */
    public static void main(String[] args) {
        //The following nine values are all variables.
        boolean run = true;
        boolean guess = false;
        boolean hangman = true;
        String secretWordTrue = "";
        char guessedLetter;
        int guessesRemaining = 6;
        int incrementer = 0;
        String guessedLetters = "";
        char yesOrNo = ' ';
        String correctLetters = "";
        System.out.printf("%50s", "WELCOME TO HANGMAN!\n");
        //This is the 2D array that stores the names of the topics and its corresponding words.
        String[][] words = new String[][]{
            {"Teachers at Northview Heights Secondary School", "Simin Navabi", "Eric Wu", "Ben Mathai", "Allan Thoms", "Alan Tang", "Samantha Juruc", "Kirk Fischer", "Scott Carter", "Jill Bandzierz", "Mark Woodley"},
            {"Television Shows", "The Flash", "Suits", "The Big Bang Theory", "The Walking Dead", "Stranger Things", "Riverdale", "House Of Cards", "Kevin Can Wait", "Dragons Den", "Big Brother Canada"},    
            {"Cars", "Honda Motor Company", "Ferrari", "Edfor", "Lambourghini", "Marussia Motors", "Land Rover", "Ford Motor Company", "Rocar", "General Motors", "Maserati"},
            {"Successful Individuals", "Mark Zuckerberg", "Steve Jobbs", "Bill Gates", "Nelson Mandela", "Richard Banson", "Walt Disney", "Henry Ford", "Larry Page", "Stephen King", "Michael Jackson"},
            {"Countries", "Canada", "Slovakia", "Seychelles", "Chad", "Cyprus", "Iran", "Egypt", "Ecuador", "France", "Uganda"},
            {"Provinces and Territories of Canada", "Ontario", "British Columbia", "Nova Scotia", "Northwest Territories", "Quebec", "Nunavut", "Manitoba", "Alberta", "Yukon", "Saskatchewan"},
            {"Cities Around the World", "New York", "Toronto", "Paris", "Mumbai", "Ottawa", "London", "Beijing", "Seoul", "New Delhi", "Cape Town"}, 
            {"Characters from The Flash", "Barry Allen", "Iris West Allen", "Joe West", "Killer Frost", "Cisco Ramon", "Ralph Dibny", "Captain Singh", "Reverse Flash", "Harrison Wells", "The Thinker"}, 
            {"NHL Teams", "Toronto Maple Leafs", "Carolina Hurricanes", "Los Angeles Kings", "Edmonton Oilers", "Chicago Blackhawks", "Vegas Golden Knights", "Nashville Predators", "Winnepeg Jets", "Boston Bruins", "Minnesota Wild"},
            {"NBA Teams", "Toronto Raptors", "New York Knicks", "Brooklyn Nets", "Golder State Cavaliers", "Washington Wizards", "Houston Rockets", "Seattle Supersonics", "Portland Trail Blazers", "New Orleans Pelicans", "Boston Celtics"}, 
        };
        String usedAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Scanner prompt1 = new Scanner(System.in);  
        //The next two lines finds two random integers from 0-9, which will be used to determine the topic and the secret word from that topic.
        int topic = (int) (Math.random() * 10); 
        int column = (int) (Math.random() * 10);
        String secretWord = words[topic][column + 1].toUpperCase();
        //The 1D array below stores the char value of each of the user's input so it can output the dashes, spaces, and letters that the user has correctly guessed.
        char[] secretWordArray = new char[secretWord.length()];
        guessedLetters = "";
        //The while below will run as long as the boolean variable 'hangman' = true. 
        while(hangman)
        {
            //The do-while below will run as long as the guesses remaining is greater than. All users start off with 6 guesses. 
            do{
                //The lines from 66 to 86 output the topic, how many letters the user been able to correct guess, the letters they can still use from, the letters that they have used, and how many guesses they have.
                System.out.println("\n=========================================================================================================");
                System.out.printf("%-58s%-1s", "Topic:", words[topic][0]);
                //The while loop below will run as long as the boolean variable run = true. 
                while(run){
                    //This nested for loop outputs the letters the user still needs to guess as dashes. If there is a space, the computer will output a space. This will run until the variable run = false.
                    for(int counter1 = 0; counter1 < secretWord.length(); counter1++){
                        if(Character.isWhitespace(secretWord.charAt(counter1)) == false)
                            secretWordArray[counter1] = '-';
                        else
                            secretWordArray[counter1] = ' ';
                    }
                    run = false;
                }
                run = false;
                System.out.printf("%-58s%-1s", "\nSecret Word:", "");
                //The for-each loop below prints the letters the user has correctly guessed.
                for(char A : secretWordArray)
                    System.out.print(A);
                System.out.printf("\n\n%-58s%-1s", "Letters Remaining:", usedAlphabet); 
                System.out.printf("\n%-58s%-1s", "Letters Used:", guessedLetters);
                System.out.printf("\n%-58s%-1s", "Guesses Remaining:", guessesRemaining);
                System.out.println("\n=========================================================================================================");

                System.out.printf("%-57s%-1s", "Enter a letter (! to guess the entire word):", "");
                guessedLetter = prompt1.next().toUpperCase().charAt(0);
                //The while loop will only run if the user inputs a letter that they previously inputted.
                while(guessedLetters.contains(Character.toString(guessedLetter))){
                    System.out.printf("\n" + guessedLetter + " has already been used!");
                    System.out.printf("%-55s%-1s", "\nPlease enter another letter (! to guess the entire word):", "");
                    guessedLetter = prompt1.next().toUpperCase().charAt(0);
                }
                //The if statement below will run if the letter the user guesses is not '!' and it is a valid letter.
                if(guessedLetter != '!' && Character.isLetter(guessedLetter))
                    guessedLetters += guessedLetter;
                //The if statement below runs when the user inputs '!'. If not, it will go to the else-if statement below.
                if(guessedLetter == '!'){
                    Scanner prompt2 = new Scanner(System.in);
                    System.out.printf("%-57s%-1s", "Enter the secret word:", " ");
                    String guessedSecretWord = prompt2.nextLine().toUpperCase();
                        //If the user inputs the correct secret word, this if statement will run. If not, it will go to the else statement below.
                        if(guessedSecretWord.equals(words[topic][column + 1].toUpperCase())){
                            System.out.println("\nCongratulations..." + guessedSecretWord + " is correct!"); 
                            secretWord = secretWordTrue;
                            guess = true;
                        }
                        //If the user does not input the correct secret word, the else statement below will run. 
                        else{
                            System.out.println("\n" + guessedSecretWord + " is incorrect! The correct answer was " + secretWord + "!");
                            secretWord = secretWordTrue;
                            guess = true;
                        }
                }
                //This else-if statement will run if the user's input is not a letter and it will ask the user to enter a letter.
                else if(!Character.isLetter(guessedLetter)) {
                    System.out.print("Invalid input! Please enter a letter.");
                }
                /**This else statement will run if the above if and else-if statement are false. What this else statement does that it runs until counter1 = secretWord.length().
                *  While counter1 < secretWord.length(), the computer checks if the letter the user has inputted is equal to any of the letters in the secret word.
                *  If it is, the computer adds this letter to secretWordArray[counter1] and makes guess = true. If this does not happen, guess = false. Either way, the computer
                *  will the add the value of Character.toString(secretWordArray[counter1]) to secretWordTrue. 
                */
                else{
                    for(int counter1 = 0; counter1 < secretWord.length(); counter1++){
                        if(guessedLetter == secretWord.charAt(counter1)){
                            secretWordArray[counter1] = guessedLetter;
                            incrementer--;
                        }
                        else  
                            incrementer++;
                        secretWordTrue += Character.toString(secretWordArray[counter1]);
                    }
                }
                //This if statement will run if guess from the else statement above results to false.
                if(incrementer == secretWord.length()){
                    guessesRemaining--;
                    System.out.println("The letter " + guessedLetter + " is not in the word!");
                }
                incrementer = 0;
                //This if statement puts a blank space in the place of the letter that is guessed by the user.
                if(usedAlphabet.contains(Character.toString(guessedLetter))){
                    usedAlphabet = usedAlphabet.replace(Character.toString(guessedLetter), "");
                }
                /**This for loop is run when the user enters a letter. It checks to see if the user has inputted all the correct letters to get
                *  the secret word, without using '!'. If this is true, secretWordTrue = secretWord, and the user is prompted if they want to play again.
                */
                for(int counter1 = 0; counter1 < secretWordArray.length; counter1++){
                  if(secretWordArray[counter1] == '-'){
                    break;
                  }
                  if(counter1 == secretWordArray.length - 1){
                    secretWordTrue = secretWord;
                    System.out.println("\nCongratulations..." + secretWord + " is correct!"); 
                  }
                }
                //This if statement runs when the user gets the correct secret word.
                if(secretWord.equals(secretWordTrue)){
                    System.out.printf("\n%-57s%-1s", "Would you like to play again (Y or N)?", "");
                    char playAgain = prompt1.next().charAt(0);
                    yesOrNo = playAgain;
                    //If the user does not want to play again, the if statement below is executed.
                    if(yesOrNo == 'N' || yesOrNo == 'n'){
                        System.out.println("\nThank you for playing! Goodbye!");
                        System.exit(0);
                    }
                    //If the user does want to play again, the else-if statement below is executed.
                    else if(yesOrNo == 'Y' || yesOrNo == 'y'){
                        guessedLetters = "";
                        topic = (int) (Math.random() * 10);
                        column = (int) (Math.random() * 10);
                        secretWord = words[topic][column + 1].toUpperCase();
                        secretWordArray = new char[secretWord.length()];
                        usedAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                        guessesRemaining = 6;
                        run = true;
                    }
                }
            }while(guessesRemaining > 0);
            //If the user loses all of their guesses, the computer will reveal what the secret word was and prompts the user to ask them if they want to play again.
            if(guessesRemaining == 0)
            {
                System.out.println("GAME OVER! The secret word was " + secretWord + "!");
                System.out.printf("\n%-57s%-1s", "Would you like to play again (Y or N)?", "");
                char playAgain = prompt1.next().charAt(0);
                yesOrNo = playAgain;
                //If the user does not want to play again, the if statement below is executed.
                if(yesOrNo == 'N' || yesOrNo == 'n'){
                    System.out.println("\nThank you for playing! Goodbye!");
                    System.exit(0);
                }
                //If the user does want to play again, the else-if statement below is executed.
                else if(yesOrNo == 'Y' || yesOrNo == 'y'){
                    guessedLetters = "";
                    topic = (int) (Math.random() * 10);
                    column = (int) (Math.random() * 10);
                    secretWord = words[topic][column + 1].toUpperCase();
                    secretWordArray = new char[secretWord.length()];
                    usedAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    guessesRemaining = 6;
                    hangman = true;
                }       
            }
        }
    }
}
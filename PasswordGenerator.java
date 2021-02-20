/*
Author: Yash Jain
Date: January 24, 2021
Project: Password Generator With Java
*/

// importing java libraries
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {

    // text colours using ANSI codes
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void main(String[] args) {

        // using & calling java libraries
        Scanner s = new Scanner (System.in);
        Random r = new Random();

        // variables
        boolean isInputValid = false;
        int length = 0;

        // enter loop to check if user input is valid
        while (isInputValid == false) {
            try {
                // instructions & user input
                System.out.println("How many characters would you like in your password?");
                length = s.nextInt();

                s.nextLine(); // clear scanner buffer

                // if user input is not valid in terms of integers print this
                if (length <= 0)
                System.err.println(ANSI_RED + "\n" + "Please enter a positive integer number!" + "\n" + ANSI_RESET);
            }

            catch (Exception e) {
                // print error statement if user input is not valid in terms of the variable
                System.err.println(ANSI_RED + "\n" + "Please enter a positive integer number!" + "\n" + ANSI_RESET);

                s.nextLine(); // clear scanner buffer
                isInputValid = false; // set to false
            }

            // exit loop if input is valid
            if (length >= 0)
            isInputValid = true;

            else
            isInputValid = false;
        }

        // variables
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String upperCaseLetters = lowerCaseLetters.toUpperCase();
        String numbers = "1234567890";
        String specialCharacters = "!@#$%^&*()[]{}";

        String passwordPart1 = lowerCaseLetters;
        String passwordPart2 = upperCaseLetters;
        String passwordPart3 = numbers;
        String passwordPart4 = specialCharacters;
        String pwdInProgress = "";

        /*
        * while Loop Logic..
        * keeps going until the passwordPart has met the user's desired length of the entire password
        * generates a random number which will not be greater than the length of the passwordPart
        * creates a new string variable which holds the 0th index to the random generated number's index
        * creates a new string variable which adds 1 to the random generated number so that size of the passwordPart can meet the user's desired length
        * takes the passwordPart and makes it hold the 2 new string variables
        */

        while (passwordPart1.length() > length) {
            int characterposition = r.nextInt(passwordPart1.length());
            String shortenPassword1 = passwordPart1.substring(0, characterposition);
            String shortenPassword2 = passwordPart1.substring(characterposition + 1);
            
            passwordPart1 = shortenPassword1 + shortenPassword2;
        }

        while (passwordPart2.length() > length) {
            int characterposition = r.nextInt(passwordPart2.length());
            String shortenPassword1 = passwordPart2.substring(0, characterposition);
            String shortenPassword2 = passwordPart2.substring(characterposition + 1);
            
            passwordPart2 = shortenPassword1 + shortenPassword2;
        }

        while (passwordPart3.length() > length) {
            int characterposition = r.nextInt(passwordPart3.length());
            String shortenPassword1 = passwordPart3.substring(0, characterposition);
            String shortenPassword2 = passwordPart3.substring(characterposition + 1);
            
            passwordPart3 = shortenPassword1 + shortenPassword2;
        }

        while (passwordPart4.length() > length) {
            int characterposition = r.nextInt(passwordPart1.length());
            String shortenPassword1 = passwordPart4.substring(0, characterposition);
            String shortenPassword2 = passwordPart4.substring(characterposition + 1);
            
            passwordPart4 = shortenPassword1 + shortenPassword2;
        }

        // takes all poasswordParts and puts it inside a variable
        pwdInProgress = passwordPart1 + passwordPart2 + passwordPart3 + passwordPart4;

        while (pwdInProgress.length() > length) { // while loop
            int characterposition = r.nextInt(pwdInProgress.length());
            String shortenPassword1 = pwdInProgress.substring(0, characterposition);
            String shortenPassword2 = pwdInProgress.substring(characterposition + 1);

            pwdInProgress = shortenPassword1 + shortenPassword2;
        }

        /*
        * array logic...
        * store the variable which holds the passwordParts in an array
        * sort the array
        * create a string variable which holds all the sorted characters in the array
        */

        char [] chars = pwdInProgress.toCharArray();
        Arrays.sort(chars);
        String usersFinalPassword = new String (chars);
        
        // print password
        System.out.println("\n" + "Your password is: " + usersFinalPassword);

        // close scanner
        s.close();
    }
}
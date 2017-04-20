package implementation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Created by Lyudmila Azarenko on 20.12.2016.
 */

public class Palindrome {
    private SortedSet<Integer> palindromes = new TreeSet<>();
    private LinkedList<Integer> multipliers1 = new LinkedList<>();
    private LinkedList<Integer> multipliers2 = new LinkedList<>();

    /**
     * Method iterates through multiplications of two numbers, each one taken from range 999...900. Multiplication result
     * is converted into Character array in order to be added to collection. At the same time duplicating collection
     * is created so that it's Character elements were reversed.
     * It is necessary to compare two collections whose elements are sorted in natural and reversed order.
     * Once comparison returns true this means that the result is found.
     * Palindrome number and it's multipliers are added to separate collections and both for loops are interrupted.*/

    private int findPalindrome() {
        for (int number1 = 999 ; number1 > 899 ; number1--) {
            for (int number2 = 999; number2 > 899 ; number2--) {
                int multiplication = number1*number2;

                char[] digits = Integer.toString(multiplication).toCharArray();
                Character[] digitsCharacter = new Character[digits.length];
                for(int i = 0; i < digitsCharacter.length; i++) {
                    digitsCharacter[i]=digits[i];
                }

                List<Character> digitsList = new ArrayList<>(Arrays.asList(digitsCharacter));
                List<Character> digitsListReversed = new ArrayList<>(Arrays.asList(digitsCharacter));
                Collections.reverse(digitsListReversed);

                if(digitsList.equals(digitsListReversed)){
                    int palindrome = Integer.parseInt(new String(digits));
                    palindromes.add(palindrome);
                    multipliers1.add(number1);
                    multipliers2.add(number2);
                    break;
                }
            }
            if (palindromes.size() > 0) {
                break;
            }
        }

        int result = palindromes.first();
        System.out.print(multipliers1.getFirst() + " * " + multipliers2.getFirst() + " = ");
        return result;
    }

    public static void main(String[] args) {
        Palindrome foundPalindrome = new Palindrome();
        System.out.print(foundPalindrome.findPalindrome());
    }
}


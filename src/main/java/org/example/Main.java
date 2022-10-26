package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Sort an array of ints
     * <P>
     *     Sorts an array of ints by checking each elements next neighbour to see if it is smaller, and if it is, swaps their positions in the array, floating them to the top like bubbles.
     * </P>
     * @param inArray The array of ints to be sorted.
     */
    public static void bubbleSortNumbers(int[] inArray)
    {
        //bubblesort - float the smallest numbers to front of array
        int arrLength = inArray.length;
        int streak = 0;
        while(streak < arrLength)
        {
            for(int i = 0; i < arrLength - 1; i++)
            {
                if(inArray[i] > inArray[i+1])
                {
                    int temp = inArray[i];
                    inArray[i] = inArray[i + 1];
                    inArray[i+1] = temp;
                    streak = 0;
                }
                else
                {
                    streak++;
                }
            }
        }
        return;
    }

    /**
     * Finds the largest gaps between numbers.
     * <P>
     *     Given an array of ints, this function will find the difference between element and it's next neighbour, looking for the biggest difference between a pair. This is not the biggest gap across any two elements, just each element and the next (n and n + 1).
     * </P>
     * @param inArray An array of numbers
     * @return The biggest gap between two consecutive elements.
     */
    public static int findGapBetweenNumbers(int[] inArray)
    {
        int biggestGap = 0;
        bubbleSortNumbers(inArray);
        for(int looper = 0; looper < inArray.length - 1; looper++)
        {
            int gap = inArray[looper + 1] - inArray[looper];
            if(gap < 0)
            {
                //make negs positive
                gap = gap - (gap*2);
            }
            if(gap > biggestGap)
            {
                biggestGap = gap;
            }
        }
        return biggestGap;
    }


    public static List<Integer> findNumberPairs(int[] inArray)
    {
        List<Integer> outputArray = new ArrayList<Integer>();
        //order array numerically, means we can just see how many elements have same value - place single instance of value in out array for each pair
        bubbleSortNumbers(inArray);
        //flag to indicate next number already has been matched to a pair - basically "Skip this index, it's already accounted for"
        boolean matched = false;
        for (int looper = 0; looper < inArray.length - 1; looper++)
        {
            if(!matched)
            {
                if(inArray[looper] == inArray[looper +1])
                {
                    matched = true;
                    outputArray.add(inArray[looper]);
                }
            }
            else
            {
                matched = false;
            }
        }
        return outputArray;
    }

    public static int sumNumberPairs(int[] inArray)
    {
        List<Integer> inList = findNumberPairs(inArray);
        int sum = 0;
        for(int element: inList)
        {
            sum += element;
        }
        return sum;
    }

    public static int[] cashDenominationCalc(double value)
    {
        int[] outputDenomination = new int[] {0,0,0,0,0,0,0,0,0,0,0,0}; //array holds number of each individual currency needed - £50, £20, £10, £5, £2, £1, 50p, 20p, 10p, 5p, 2p, 1p
        value *= 100;
        int remainingValue = (int)value;
        while(remainingValue > 0)
        {
            if(remainingValue >= 5000)
            {
                remainingValue -= 5000;
                outputDenomination[0] += 1;
            }
            else if(remainingValue >= 2000)
            {
                remainingValue -= 2000;
                outputDenomination[1] += 1;
            }
            else if(remainingValue >= 1000)
            {
                remainingValue -= 1000;
                outputDenomination[2] += 1;
            }
            else if(remainingValue >= 500)
            {
                remainingValue -= 500;
                outputDenomination[3] += 1;
            }
            else if(remainingValue >= 200)
            {
                remainingValue -= 200;
                outputDenomination[4] += 1;
            }
            else if(remainingValue >= 100)
            {
                remainingValue -= 100;
                outputDenomination[5] += 1;
            }
            else if(remainingValue >= 50)
            {
                remainingValue -= 50;
                outputDenomination[6] += 1;
            }
            else if(remainingValue >= 20)
            {
                remainingValue -= 20;
                outputDenomination[7] += 1;
            }
            else if(remainingValue >= 10)
            {
                remainingValue -= 10;
                outputDenomination[8] += 1;
            }
            else if(remainingValue >= 5)
            {
                remainingValue -= 5;
                outputDenomination[9] += 1;
            }
            else if(remainingValue >= 2)
            {
                remainingValue -= 2;
                outputDenomination[10] += 1;
            }
            else if(remainingValue >= 1)
            {
                remainingValue -= 1;
                outputDenomination[11] += 1;
            }
        }

        return outputDenomination;
    }

    public static void printCashDenomination(double Value)
    {
        int[] denomination = cashDenominationCalc(Value);
        System.out.printf("Cash Denomination for £%.2f\n", Value);
        System.out.printf("£50: %d\n", denomination[0]);
        System.out.printf("£20: %d\n", denomination[1]);
        System.out.printf("£10: %d\n", denomination[2]);
        System.out.printf("£5: %d\n", denomination[3]);
        System.out.printf("£2: %d\n", denomination[4]);
        System.out.printf("£1: %d\n", denomination[5]);
        System.out.printf("50p: %d\n", denomination[6]);
        System.out.printf("20p: %d\n", denomination[7]);
        System.out.printf("10p: %d\n", denomination[8]);
        System.out.printf("5p: %d\n", denomination[9]);
        System.out.printf("2p: %d\n", denomination[10]);
        System.out.printf("1p: %d\n", denomination[11]);

    }

    public static boolean isAlphaNumeric(char inChar)
    {
        return (inChar >= 48 && inChar <= 57) || (inChar >= 65 && inChar <= 90) || (inChar >= 97 && inChar <= 122); //ascii values for alphanumeric
    }

    public static char findFirstRepeatingCharacter(String inString)
    {
        char repeated = '.'; //as we're looking at alphanumeric not punctuation, I'll use a punctuation as an empty value
        int repeatPos = -1;
        for(int stringLoop = 0; stringLoop < inString.length() - 1; stringLoop++)
        {

            char thisChar = inString.toLowerCase().charAt(stringLoop); //storing lower case for standardised output
            if(isAlphaNumeric(thisChar))
            {
                for(int innerLoop = stringLoop +1; innerLoop < inString.length(); innerLoop++)
                {
                    if(isAlphaNumeric(inString.charAt(innerLoop)))
                    {
                        if(thisChar == inString.toLowerCase().charAt(innerLoop)) // eliminating case sensitivity here
                        {
                            if(innerLoop < repeatPos || repeatPos == -1)
                            {
                                repeated = thisChar;
                                repeatPos = innerLoop;
                            }
                        }
                    }
                }
            }
        }

        return repeated;
    }
    public static void main(String[] args) {
        //given set of unordered numbers, find largest numeric gap
        int[] numbers = {1, 2, 3, 6, 6, 7, 8, 9, 10};

        System.out.printf("Largest gap %d\n", findGapBetweenNumbers(numbers));
        numbers = new int[] {1,1,56,56,32,32,54,65,768,89,100,100};
        System.out.printf("Sum of pairs %d\n", sumNumberPairs(numbers));
        printCashDenomination(88.88);
        String words = "I tire of this farce!";
        System.out.printf("String \"%s\" first repeated char is %c\n", words, findFirstRepeatingCharacter(words));
    }
}
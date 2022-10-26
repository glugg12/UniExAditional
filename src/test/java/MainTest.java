import org.example.Main;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class MainTest {
    @Test
    void sortNumbers()
    {
        int[] numbers = {12,58,4567,8951,24,75,63,2,75, 95, 741, 36};
        Main.bubbleSortNumbers(numbers);
        assertArrayEquals(new int[] {2, 12, 24, 36, 58, 63, 75, 75, 95, 741, 4567, 8951}, numbers);
        int[] oneDiff = {1,1,1,1,1,5,1,1,1,1,1};
        Main.bubbleSortNumbers(oneDiff);
        assertArrayEquals(new int[] {1,1,1,1,1,1,1,1,1,1,5}, oneDiff);
        int[] oneLarge = {1,1,999999999,1,1};
        Main.bubbleSortNumbers(oneLarge);
        assertArrayEquals(new int[] {1,1,1,1,999999999}, oneLarge);
        int[] alreadySorted = {1,2,3,4,5,6,7,8};
        Main.bubbleSortNumbers(alreadySorted);
        assertArrayEquals(new int[] {1,2,3,4,5,6,7,8}, alreadySorted);
        int[] many = {30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        Main.bubbleSortNumbers(many);
        assertArrayEquals(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30}, many);
        int[] allSame = {2,2,2,2,2};
        Main.bubbleSortNumbers(allSame);
        assertArrayEquals(new int[] {2,2,2,2,2}, allSame);
        int[] hasNegative = {-4,-8,0,8,4};
        Main.bubbleSortNumbers(hasNegative);
        assertArrayEquals(new int[] {-8,-4,0,4,8}, hasNegative);
    }

    @Test
    void findGap()
    {
        int[] numbers = {1,2,3,4,5,6,9,10};
        assertEquals(3,Main.findGapBetweenNumbers(numbers));
        int[] noGapDiff = {1,2,3,4,5,6,7,8};
        assertEquals(1,Main.findGapBetweenNumbers(noGapDiff));
        int[] oneLargeDiff = {1,2,3,4,5,6,100000006};
        assertEquals(100000000,Main.findGapBetweenNumbers(oneLargeDiff));
        int[] twoSameLargeDiff = {1,2,3,4,404,804};
        assertEquals(400,Main.findGapBetweenNumbers(twoSameLargeDiff));
        int[] hasNegative = {-10, -20, -4, -1, 0, 1, 2, 3, 4, 5};
        assertEquals(10, Main.findGapBetweenNumbers(hasNegative));
    }

    @Test
    void pairMatching()
    {
        int[] numbers = {22,22,11,11,5,6,7,8,8};
        int[] expected = {8,11,22};
        List<Integer> output = Main.findNumberPairs(numbers);
        int count = 0;
        for(int e:output)
        {
            assertEquals(expected[count], e);
            count++;
        }

        numbers = new int[] {-1,-1,5,40,12,40,900,901,-1,-1};
        expected = new int[] {-1,-1,40};
        output = Main.findNumberPairs(numbers);
        count = 0;
        for(int e:output)
        {
            assertEquals(expected[count], e);
            count++;
        }

        numbers = new int[] {1,1,90,90,90,1,5,5,5,5,5,5,999999,999999};
        expected = new int[] {1,5,5,5,90,999999};
        output = Main.findNumberPairs(numbers);
        count = 0;
        for(int e:output)
        {
            assertEquals(expected[count], e);
            count++;
        }

        numbers = new int[] {-999999,999999,1,2,3,1,2,3,-999999,-999999};
        expected = new int[] {-999999,1,2,3};
        output = Main.findNumberPairs(numbers);
        count = 0;
        for(int e:output)
        {
            assertEquals(expected[count], e);
            count++;
        }

        numbers = new int[] {1,1,1,1,1,1,1,1,1,1};
        expected = new int[] {1,1,1,1,1};
        output = Main.findNumberPairs(numbers);
        count = 0;
        for(int e:output)
        {
            assertEquals(expected[count], e);
            count++;
        }
    }
    @Test
    void pairSumming()
    {
        int[] numbers = {22,22,11,11,5,6,7,8,8};
        assertEquals(41, Main.sumNumberPairs(numbers));

        numbers = new int[] {-1,-1,5,40,12,40,900,901,-1,-1};
        assertEquals(38, Main.sumNumberPairs(numbers));

        numbers = new int[] {1,1,90,90,90,1,5,5,5,5,5,5,999999,999999};
        assertEquals(1000105, Main.sumNumberPairs(numbers));

        numbers = new int[] {-999999,999999,1,2,3,1,2,3,-999999,-999999};
        assertEquals(-999993, Main.sumNumberPairs(numbers));

        numbers = new int[] {1,1,1,1,1,1,1,1,1,1};
        assertEquals(5, Main.sumNumberPairs(numbers));
    }

    @Test
    void cashDenomTest()
    {
        int[] testDenom = {0,0,0,1,0,0,1,0,0,1,0,0};
        assertArrayEquals(testDenom, Main.cashDenominationCalc(5.55));
        testDenom = new int[]{10,0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(testDenom, Main.cashDenominationCalc(500));
        testDenom = new int[]{4,0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(testDenom, Main.cashDenominationCalc(200));
        testDenom = new int[]{2,0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(testDenom, Main.cashDenominationCalc(100));
        testDenom = new int[]{1,0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(testDenom, Main.cashDenominationCalc(50));
        testDenom = new int[]{0,1,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(testDenom, Main.cashDenominationCalc(20));
        testDenom = new int[]{1,1,1,1,1,1,1,1,1,1,1,1};
        assertArrayEquals(testDenom, Main.cashDenominationCalc(88.88));
        testDenom = new int[]{20000,0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(testDenom, Main.cashDenominationCalc(1000000));
        testDenom = new int[]{0,0,0,0,0,0,0,0,0,0,0,1};
        assertArrayEquals(testDenom, Main.cashDenominationCalc(0.01));
    }

    @Test
    void isAlphanumeric()
    {
        assertEquals(true, Main.isAlphaNumeric('M'));
        assertEquals(true, Main.isAlphaNumeric('m'));
        assertEquals(true, Main.isAlphaNumeric('A'));
        assertEquals(true, Main.isAlphaNumeric('a'));
        assertEquals(true, Main.isAlphaNumeric('Z'));
        assertEquals(true, Main.isAlphaNumeric('z'));
        assertEquals(true, Main.isAlphaNumeric('1'));
        assertEquals(true, Main.isAlphaNumeric('2'));
        assertEquals(true, Main.isAlphaNumeric('3'));
        assertEquals(true, Main.isAlphaNumeric('4'));
        assertEquals(true, Main.isAlphaNumeric('5'));
        assertEquals(true, Main.isAlphaNumeric('9'));
        assertEquals(false, Main.isAlphaNumeric(' '));
        assertEquals(false, Main.isAlphaNumeric('.'));
        assertEquals(false, Main.isAlphaNumeric('@'));
        assertEquals(false, Main.isAlphaNumeric('['));
        assertEquals(false, Main.isAlphaNumeric('/'));
        assertEquals(false, Main.isAlphaNumeric('`'));
        assertEquals(false, Main.isAlphaNumeric(';'));
        assertEquals(false, Main.isAlphaNumeric('!'));
    }
    @Test
    void repeatedChars()
    {
        assertEquals('o',Main.findFirstRepeatingCharacter("Boo!"));
        assertEquals('o',Main.findFirstRepeatingCharacter("BoO!"));
        assertEquals('1',Main.findFirstRepeatingCharacter("11 There should be a 1 in the output"));
        assertEquals('a',Main.findFirstRepeatingCharacter("Yahahar!"));
        assertEquals('l',Main.findFirstRepeatingCharacter("Tell me. For whom do you fight? Hmph! How very glib. And do you believe in Eorzea? Eorzea's unity is forged of falsehoods. Its city-states are built on deceit. And its faith is an instrument of deception."));
        assertEquals('a',Main.findFirstRepeatingCharacter("abcdefghijklmnopqrstuvwxyza"));
        assertEquals('n',Main.findFirstRepeatingCharacter("How many strings can one possibly come up with?"));
        assertEquals('e',Main.findFirstRepeatingCharacter("Like two maybe."));
        assertEquals('.',Main.findFirstRepeatingCharacter("abcdefghijklmnopqrstuv123456789"));
        assertEquals('h',Main.findFirstRepeatingCharacter("Ah, I, Uh, am showing that repeated punctuation doesn't count."));
        assertEquals('a',Main.findFirstRepeatingCharacter("What is a man?"));
        assertEquals('a',Main.findFirstRepeatingCharacter("A miserable little pile of secrets!"));
        assertEquals('u',Main.findFirstRepeatingCharacter("But enough talk!"));
        assertEquals('a',Main.findFirstRepeatingCharacter("Have at you!"));
        assertEquals('.',Main.findFirstRepeatingCharacter("a"));
    }
}

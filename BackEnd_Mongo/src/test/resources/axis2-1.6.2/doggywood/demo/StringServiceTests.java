package com.doggywood.demo;
  
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Rule;

import com.doggywood.utilities.StringService;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringServiceTests {
	private static final StringService stringService = new StringService(); 
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	/*******************************************************************
	 * Question 1
	 ******************************************************************/
	@Test
	public void testAnEmptyString() {
		assertEquals("", stringService.reverse(""));
	}

	@Test
	public void testAWord() {
		assertEquals("tobor", stringService.reverse("robot"));
	}

	@Test
	public void testACapitalizedWord() {
		assertEquals("nemaR", stringService.reverse("Ramen"));
	}

	@Test
	public void testASentenceWithPunctuation() {
		assertEquals("!yrgnuh m'I", stringService.reverse("I'm hungry!"));
	}

	@Test
	public void testAPalindrome() {
		assertEquals("racecar", stringService.reverse("racecar"));
	}

	/*******************************************************************
	 * Question 2
	 ******************************************************************/
	@Test
	public void basic() {
		final String phrase = "Portable Network Graphics";
		final String expected = "PNG";
		assertEquals(expected, stringService.acronym(phrase));
	}

	@Test
	public void punctuation() {
		final String phrase = "First In, First Out";
		final String expected = "FIFO";
		assertEquals(expected, stringService.acronym(phrase));
	}

	@Test
	public void NonAcronymAllCapsWord() {
		final String phrase = "GNU Image Manipulation Program";
		final String expected = "GIMP";
		assertEquals(expected, stringService.acronym(phrase));
	}

	@Test
	public void punctuationWithoutWhitespace() {
		final String phrase = "Complementary metal-oxide semiconductor";
		final String expected = "CMOS";
		assertEquals(expected, stringService.acronym(phrase));
	}

	/*******************************************************************
	 * Question 3
	 ******************************************************************/

	@Test
	public void trianglesWithNoEqualSidesAreNotEquilateral() {
		StringService.Triangle triangle = new StringService.Triangle(5, 4, 6);
		assertFalse(triangle.isEquilateral());
	}

	@Test
	public void verySmallTrianglesCanBeEquilateral() {
		StringService.Triangle triangle = new StringService.Triangle(0.5, 0.5, 0.5);
		assertTrue(triangle.isEquilateral());
	}

	@Test
	public void isoscelesTrianglesMustHaveAtLeastTwoEqualSides() {
		StringService.Triangle triangle = new StringService.Triangle(2, 3, 4);
		assertFalse(triangle.isIsosceles());
	}

	@Test
	public void verySmallTrianglesCanBeIsosceles() {
		StringService.Triangle triangle = new StringService.Triangle(0.5, 0.4, 0.5);
		assertTrue(triangle.isIsosceles());
	}

	@Test
	public void trianglesWithAllSidesEqualAreNotScalene() {
		StringService.Triangle triangle = new StringService.Triangle(4, 4, 4);
		assertFalse(triangle.isScalene());
	}

	@Test
	public void verySmallTrianglesCanBeScalene() {
		StringService.Triangle triangle = new StringService.Triangle(0.5, 0.4, 0.6);
		assertTrue(triangle.isScalene());
	}

	/*******************************************************************
	 * Question 4
	 ******************************************************************/
	@Test
	public void testAValuableLetter() {
		assertEquals(4, stringService.getScrabbleScore("f"));
	}

	@Test
	public void testAShortValuableWord() {
		assertEquals(12, stringService.getScrabbleScore("zoo"));
	}

	@Test
	public void testAMediumWord() {
		assertEquals(6, stringService.getScrabbleScore("street"));
	}

	@Test
	public void testAMediumValuableWord() {
		assertEquals(22, stringService.getScrabbleScore("quirky"));
	}

	@Test
	public void testALongMixCaseWord() {
		assertEquals(41, stringService.getScrabbleScore("OxyphenButazone"));
	}

	/*******************************************************************
	 * Question 5
	 ******************************************************************/
	@Test
	public void cleansTheNumber() {
		final String expectedNumber = "2234567890";
		final String actualNumber = stringService.cleanPhoneNumber("(223) 456-7890");
		assertEquals(expectedNumber, actualNumber);
	}

	@Test
	public void cleansNumbersWithDots() {
		final String expectedNumber = "2234567890";
		final String actualNumber = stringService.cleanPhoneNumber("223.456.7890");
		assertEquals(expectedNumber, actualNumber);
	}

	@Test
	public void cleansNumbersWithMultipleSpaces() {
		final String expectedNumber = "2234567890";
		final String actualNumber = stringService.cleanPhoneNumber("223 456   7890   ");
		assertEquals(expectedNumber, actualNumber);
	}

	@Test
	public void invalidWhenMoreThan11Digits() {
		expectedException.expect(IllegalArgumentException.class);
		stringService.cleanPhoneNumber("321234567890");
	}

	@Test
	public void invalidWithNonNumeric() {
		expectedException.expect(IllegalArgumentException.class);
		stringService.cleanPhoneNumber("123-abc-7890");
		expectedException.expect(IllegalArgumentException.class);
		stringService.cleanPhoneNumber("123-@:!-7890");
	}

	/*******************************************************************
	 * Question 6
	 ******************************************************************/
	@Test
	public void countOneWord() {
		Map<String, Integer> expectedWordCount = new HashMap<>();
		expectedWordCount.put("word", 1);

		Map<String, Integer> actualWordCount = stringService.wordCount("word");
		assertEquals(expectedWordCount, actualWordCount);
	}

	@Test
	public void countOneOfEachWord() {
		Map<String, Integer> expectedWordCount = new HashMap<>();
		expectedWordCount.put("one", 1);
		expectedWordCount.put("of", 1);
		expectedWordCount.put("each", 1);

		Map<String, Integer> actualWordCount = stringService.wordCount("one of each");
		assertEquals(expectedWordCount, actualWordCount);
	}

	@Test
	public void multipleOccurrencesOfAWord() {
		Map<String, Integer> expectedWordCount = new HashMap<>();
		expectedWordCount.put("one", 1);
		expectedWordCount.put("fish", 4);
		expectedWordCount.put("two", 1);
		expectedWordCount.put("red", 1);
		expectedWordCount.put("blue", 1);

		Map<String, Integer> actualWordCount = stringService.wordCount("one fish two fish red fish blue fish");
		assertEquals(expectedWordCount, actualWordCount);
	}

	@Test
	public void handlesCrampedLists() {
		Map<String, Integer> expectedWordCount = new HashMap<>();
		expectedWordCount.put("one", 1);
		expectedWordCount.put("two", 1);
		expectedWordCount.put("three", 1);

		Map<String, Integer> actualWordCount = stringService.wordCount("one,two,three");
		assertEquals(expectedWordCount, actualWordCount);
	}

	@Test
	public void handlesExpandedLists() {
		Map<String, Integer> expectedWordCount = new HashMap<>();
		expectedWordCount.put("one", 1);
		expectedWordCount.put("two", 1);
		expectedWordCount.put("three", 1);

		Map<String, Integer> actualWordCount = stringService.wordCount("one,\ntwo,\nthree");
		assertEquals(expectedWordCount, actualWordCount);
	}

	/*******************************************************************
	 * Question 7
	 ******************************************************************/
	@Test
	public void findsAValueInTheMiddleOfAnArray() {
		List<String> sortedList = Collections.unmodifiableList(Arrays.asList("1", "3", "4", "6", "8", "9", "11"));

		StringService.BinarySearch<String> search = new StringService.BinarySearch<>(sortedList);

		assertEquals(3, search.indexOf("6"));
	}

	@Test
	public void findsAValueAtTheBeginningOfAnArray() {
		List<Integer> sortedList = Collections.unmodifiableList(Arrays.asList(1, 3, 4, 6, 8, 9, 11));

		StringService.BinarySearch<Integer> search = new StringService.BinarySearch<>(sortedList);

		assertEquals(0, search.indexOf(1));
	}

	@Test
	public void findsAValueAtTheEndOfAnArray() {
		List<Integer> sortedList = Collections.unmodifiableList(Arrays.asList(1, 3, 4, 6, 8, 9, 11));

		StringService.BinarySearch<Integer> search = new StringService.BinarySearch<>(sortedList);

		assertEquals(6, search.indexOf(11));
	}

	@Test
	public void findsAValueInAnArrayOfOddLength() {
		List<Integer> sortedListOfOddLength = Collections
				.unmodifiableList(Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634));

		StringService.BinarySearch<Integer> search = new StringService.BinarySearch<>(sortedListOfOddLength);

		assertEquals(9, search.indexOf(144));
	}

	@Test
	public void findsAValueInAnArrayOfEvenLength() {
		List<Integer> sortedListOfEvenLength = Collections
				.unmodifiableList(Arrays.asList(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377));

		StringService.BinarySearch<Integer> search = new StringService.BinarySearch<>(sortedListOfEvenLength);

		assertEquals(5, search.indexOf(21));
	}

	/*******************************************************************
	 * Question 8
	 ******************************************************************/
	@Test
	public void testWordBeginningWithA() {
		assertEquals("appleay", stringService.toPigLatin("apple"));
	}

	@Test
	public void testThTreatedLikeAConsonantAtTheBeginningOfAWord() {
		assertEquals("erapythay", stringService.toPigLatin("therapy"));
	}

	@Test
	public void testSchTreatedLikeAConsonantAtTheBeginningOfAWord() {
		assertEquals("oolschay", stringService.toPigLatin("school"));
	}

	@Test
	public void testYTreatedLikeAConsonantAtTheBeginningOfAWord() {
		assertEquals("ellowyay", stringService.toPigLatin("yellow"));
	}

	@Test
	public void testAWholePhrase() {
		assertEquals("ickquay astfay unray", stringService.toPigLatin("quick fast run"));
	}

	/*******************************************************************
	 * Question 9
	 ******************************************************************/
	@Test
	public void singleDigitsAreArmstrongNumbers() {
		int input = 5;

		assertTrue(stringService.isArmstrongNumber(input));
	}

	@Test
	public void noTwoDigitArmstrongNumbers() {
		int input = 10;

		assertFalse(stringService.isArmstrongNumber(input));
	}

	@Test
	public void threeDigitNumberIsArmstrongNumber() {
		int input = 153;

		assertTrue(stringService.isArmstrongNumber(input));
	}

	@Test
	public void threeDigitNumberIsNotArmstrongNumber() {
		int input = 100;

		assertFalse(stringService.isArmstrongNumber(input));
	}

	@Test
	public void fourDigitNumberIsArmstrongNumber() {
		int input = 9474;

		assertTrue(stringService.isArmstrongNumber(input));
	}

	/*******************************************************************
	 * Question 10
	 ******************************************************************/

	@Test
	public void testPrimeNumber() {
		assertEquals(Collections.singletonList(2L), stringService.calculatePrimeFactorsOf(2L));
	}

	@Test
	public void testSquareOfAPrime() {
		assertEquals(Arrays.asList(3L, 3L), stringService.calculatePrimeFactorsOf(9L));
	}

	@Test
	public void testCubeOfAPrime() {
		assertEquals(Arrays.asList(2L, 2L, 2L), stringService.calculatePrimeFactorsOf(8L));
	}

	@Test
	public void testProductOfPrimesAndNonPrimes() {
		assertEquals(Arrays.asList(2L, 2L, 3L), stringService.calculatePrimeFactorsOf(12L));
	}

	@Test
	public void testProductOfPrimes() {
		assertEquals(Arrays.asList(5L, 17L, 23L, 461L), stringService.calculatePrimeFactorsOf(901255L));
	}

	/*******************************************************************
	 * Question 11
	 ******************************************************************/

	@Test
	public void rotateSingleCharacterWithWrapAround() {
		StringService.RotationalCipher rotationalCipher = new StringService.RotationalCipher(13);
		assertEquals("a", rotationalCipher.rotate("n"));
	}

	@Test
	public void rotateCapitalLetters() {
		StringService.RotationalCipher rotationalCipher = new StringService.RotationalCipher(5);
		assertEquals("TRL", rotationalCipher.rotate("OMG"));
	}

	@Test
	public void rotateNumbers() {
		StringService.RotationalCipher rotationalCipher = new StringService.RotationalCipher(4);
		assertEquals("Xiwxmrk 1 2 3 xiwxmrk", rotationalCipher.rotate("Testing 1 2 3 testing"));
	}

	@Test
	public void rotatePunctuation() {
		StringService.RotationalCipher rotationalCipher = new StringService.RotationalCipher(21);
		assertEquals("Gzo'n zvo, Bmviyhv!", rotationalCipher.rotate("Let's eat, Grandma!"));
	}

	@Test
	public void rotateAllLetters() {
		StringService.RotationalCipher rotationalCipher = new StringService.RotationalCipher(13);
		assertEquals("The quick brown fox jumps over the lazy dog.",
				rotationalCipher.rotate("Gur dhvpx oebja sbk whzcf bire gur ynml qbt."));
	}

	/*******************************************************************
	 * Question 12
	 ******************************************************************/
	@Test
	public void testFirstPrime() {
		assertThat(stringService.calculateNthPrime(1), is(2));
	}

	@Test
	public void testSecondPrime() {
		assertThat(stringService.calculateNthPrime(2), is(3));
	}

	@Test
	public void testSixthPrime() {
		assertThat(stringService.calculateNthPrime(6), is(13));
	}

	@Test
	public void testBigPrime() {
		assertThat(stringService.calculateNthPrime(10001), is(104743));
	}

	@Test
	public void testUndefinedPrime() {
		expectedException.expect(IllegalArgumentException.class);
		stringService.calculateNthPrime(0);
	}

	/*******************************************************************
	 * Question 13
	 ******************************************************************/

	@Test
	public void testEncodeYes() {
		assertEquals("bvh", StringService.AtbashCipher.encode("yes"));
	}

	@Test
	public void testEncodeOmgInCapital() {
		assertEquals("lnt", StringService.AtbashCipher.encode("OMG"));
	}

	@Test
	public void testEncodeMindBlowingly() {
		assertEquals("nrmwy oldrm tob", StringService.AtbashCipher.encode("mindblowingly"));
	}

	@Test
	public void testEncodeNumbers() {
		assertEquals("gvhgr mt123 gvhgr mt", StringService.AtbashCipher.encode("Testing,1 2 3, testing."));
	}

	@Test
	public void testEncodeDeepThought() {
		assertEquals("gifgs rhurx grlm", StringService.AtbashCipher.encode("Truth is fiction."));
	}

	@Test
	public void testEncodeAllTheLetters() {
		assertEquals("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt",
				StringService.AtbashCipher.encode("The quick brown fox jumps over the lazy dog."));
	}

	/*******************************************************************
	 * Question 14
	 ******************************************************************/
	@Test
	public void testDecodeExercism() {
		assertEquals("exercism", StringService.AtbashCipher.decode("vcvix rhn"));
	}

	@Test
	public void testDecodeASentence() {
		assertEquals("anobstacleisoftenasteppingstone",
				StringService.AtbashCipher.decode("zmlyh gzxov rhlug vmzhg vkkrm thglm v"));
	}

	@Test
	public void testDecodeNumbers() {
		assertEquals("testing123testing", StringService.AtbashCipher.decode("gvhgr mt123 gvhgr mt"));
	}

	@Test
	public void testDecodeAllTheLetters() {
		assertEquals("thequickbrownfoxjumpsoverthelazydog",
				StringService.AtbashCipher.decode("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"));
	}

	/*******************************************************************
	 * Question 15
	 ******************************************************************/
	@Test
	public void validIsbnNumber() {
		assertTrue(stringService.isValidIsbn("3-598-21508-8"));
	}

	@Test
	public void invalidIsbnCheckDigit() {
		assertFalse(stringService.isValidIsbn("3-598-21508-9"));
	}

	@Test
	public void validIsbnNumberWithCheckDigitOfTen() {
		assertTrue(stringService.isValidIsbn("3-598-21507-X"));
	}

	@Test
	public void checkDigitIsACharacterOtherThanX() {
		assertFalse(stringService.isValidIsbn("3-598-21507-A"));
	}

	@Test
	public void invalidCharacterInIsbn() {
		assertFalse(stringService.isValidIsbn("3-598-2K507-0"));
	}

	/*******************************************************************
	 * Question 16
	 ******************************************************************/
	@Test
	public void emptySentenceIsNotPangram() {
		assertFalse(stringService.isPangram(""));
	}

	@Test
	public void recognizesPerfectLowerCasePangram() {
		assertTrue(stringService.isPangram("abcdefghijklmnopqrstuvwxyz"));
	}

	@Test
	public void pangramWithOnlyLowerCaseLettersIsRecognizedAsPangram() {
		assertTrue(stringService.isPangram("the quick brown fox jumps over the lazy dog"));
	}

	@Test
	public void phraseMissingCharacterXIsNotPangram() {
		assertFalse(stringService.isPangram("a quick movement of the enemy will jeopardize five gunboats"));
	}

	@Test
	public void phraseMissingAnotherCharacterIsNotPangram() {
		assertFalse(stringService.isPangram("five boxing wizards jump quickly at it"));
	}

	/*******************************************************************
	 * Question 17
	 ******************************************************************/
	@Test
	public void modernTime() {
		assertEquals(LocalDateTime.of(2043, Month.JANUARY, 1, 1, 46, 40),
				stringService.getGigasecondDate(LocalDate.of(2011, Month.APRIL, 25)));
	}

	@Test
	public void afterEpochTime() {
		assertEquals(LocalDateTime.of(2009, Month.FEBRUARY, 19, 1, 46, 40),
				stringService.getGigasecondDate(LocalDate.of(1977, Month.JUNE, 13)));
	}

	@Test
	public void beforeEpochTime() {
		assertEquals(LocalDateTime.of(1991, Month.MARCH, 27, 1, 46, 40),
				stringService.getGigasecondDate(LocalDate.of(1959, Month.JULY, 19)));
	}

	@Test
	public void withFullTimeSpecified() {
		assertEquals(LocalDateTime.of(2046, Month.OCTOBER, 2, 23, 46, 40),
				stringService.getGigasecondDate(LocalDateTime.of(2015, Month.JANUARY, 24, 22, 0, 0)));
	}

	@Test
	public void withFullTimeSpecifiedAndDayRollover() {
		assertEquals(LocalDateTime.of(2046, Month.OCTOBER, 3, 1, 46, 39),
				stringService.getGigasecondDate(LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59)));
	}

	/*******************************************************************
	 * Question 18
	 ******************************************************************/
	@Test
	public void testSumOfMultiplesOf4and6UpToFifteen() {

		int[] set = { 4, 6 };
		int output = stringService.getSumOfMultiples(15, set);
		assertEquals(30, output);

	}

	@Test
	public void testSumOfMultiplesOf5and6and8UpToOneHundredFifty() {

		int[] set = { 5, 6, 8 };
		int output = stringService.getSumOfMultiples(150, set);
		assertEquals(4419, output);

	}

	@Test
	public void testSumOfMultiplesOf5and25UpToFiftyOne() {

		int[] set = { 5, 25 };
		int output = stringService.getSumOfMultiples(51, set);
		assertEquals(275, output);

	}

	@Test
	public void testSumOfMultiplesOf43and47UpToTenThousand() {

		int[] set = { 43, 47 };
		int output = stringService.getSumOfMultiples(10000, set);
		assertEquals(2203160, output);

	}

	@Test
	public void testSumOfMultiplesOfOneUpToOneHundred() {

		int[] set = { 1 };
		int output = stringService.getSumOfMultiples(100, set);
		assertEquals(4950, output);

	}

	/*******************************************************************
	 * Question 19
	 ******************************************************************/
	@Test
	public void testThatAValidCanadianSocialInsuranceNumberIsIdentifiedAsValidV1() {
		assertTrue(stringService.isLuhnValid("046 454 286"));
	}

	@Test
	public void testThatAnInvalidCanadianSocialInsuranceNumberIsIdentifiedAsInvalid() {
		assertFalse(stringService.isLuhnValid("046 454 287"));
	}

	@Test
	public void testThatAnInvalidCreditCardIsIdentifiedAsInvalid() {
		assertFalse(stringService.isLuhnValid("8273 1232 7352 0569"));
	}

	@Test
	public void testThatAddingANonDigitCharacterToAValidStringInvalidatesTheString() {
		assertFalse(stringService.isLuhnValid("046a 454 286"));
	}

	@Test
	public void testThatStringContainingPunctuationIsInvalid() {
		assertFalse(stringService.isLuhnValid("055-444-285"));
	}

	/*******************************************************************
	 * Question 20
	 ******************************************************************/
	@Test
	public void testSingleAddition1() {
		assertEquals(2, stringService.solveWordProblem("What is 1 plus 1?"));
	}

	@Test
	public void testSingleAdditionWithNegativeNumbers() {
		assertEquals(-11, stringService.solveWordProblem("What is -1 plus -10?"));
	}

	@Test
	public void testSingleSubtraction() {
		assertEquals(16, stringService.solveWordProblem("What is 4 minus -12?"));
	}

	@Test
	public void testSingleMultiplication() {
		assertEquals(-75, stringService.solveWordProblem("What is -3 multiplied by 25?"));
	}

	@Test
	public void testSingleDivision() {
		assertEquals(-11, stringService.solveWordProblem("What is 33 divided by -3?"));
	}

}

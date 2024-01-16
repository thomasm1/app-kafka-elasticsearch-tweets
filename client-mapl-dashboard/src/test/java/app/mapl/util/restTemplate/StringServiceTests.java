package app.mapl.util.restTemplate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import app.mapl.util.methods.StringService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

//import org.junit.Rule;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class StringServiceTests {
    private static final StringService stringService = new StringService();

//	@Rule
//	public ExpectedException expectedException = ExpectedException.none();
//  NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {...



    @Test
    public void testAnEmptyString() {

        assertEquals("", stringService.reverse(""));
    }

    ///////// TEST 1
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

}

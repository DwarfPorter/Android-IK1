package ru.geekbrains.helloapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void Greeting_get_isEvening16() {
        Greeting greeting = new Greeting(16);
        String actual = greeting.get();
        String expected = "Good evening";
        assertEquals(expected, actual);
    }

    @Test
    public void Greeting_get_isEvening24() {
        Greeting greeting = new Greeting(24);
        String actual = greeting.get();
        String expected = "Good evening";
        assertEquals(expected, actual);
    }

    @Test
    public void Greeting_get_isAfternoon12(){
        Greeting greeting = new Greeting(12);
        String actual = greeting.get();
        String expected = "Good afternoon";
        assertEquals(expected, actual);
    }

    @Test
    public void Greeting_get_isAfternoon15(){
        Greeting greeting = new Greeting(15);
        String actual = greeting.get();
        String expected = "Good afternoon";
        assertEquals(expected, actual);
    }

    @Test
    public void Greeting_get_isMorning4(){
        Greeting greeting = new Greeting(4);
        String actual = greeting.get();
        String expected = "Good morning";
        assertEquals(expected, actual);
    }

    @Test
    public void Greeting_get_isMorning11(){
        Greeting greeting = new Greeting(11);
        String actual = greeting.get();
        String expected = "Good morning";
        assertEquals(expected, actual);
    }

    @Test
    public void Greeting_get_isNight0(){
        Greeting greeting = new Greeting(0);
        String actual = greeting.get();
        String expected = "Good night";
        assertEquals(expected, actual);
    }

    @Test
    public void Greeting_get_isNight3(){
        Greeting greeting = new Greeting(3);
        String actual = greeting.get();
        String expected = "Good night";
        assertEquals(expected, actual);
    }
}
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
    public void Greeting_get_isEvening(){
        Greeting greeting = new Greeting(16);
        String actual = greeting.get();
        String expected = "Good evening";
        assertEquals(expected, actual);

    }
}
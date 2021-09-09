package com.company.smoothiechallenge;

import com.company.smoothiechallenge.Smoothie;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmoothieTest {

    @Test
    public void classicSmoothie() {
        assertEquals("banana,honey,mango,peach,pineapple,strawberry",
                Smoothie.ingredients("Classic"));
    }

    @Test
    public void classicSmoothieWithoutStrawberry() {
        assertEquals("banana,honey,mango,peach,pineapple",
                Smoothie.ingredients("Classic,-strawberry"));
    }



}
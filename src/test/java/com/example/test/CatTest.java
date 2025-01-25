package com.example.test;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


// зависимый класс
@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Feline feline;
    private Cat cat;

    @Before
    public void setUpMockAndObject() {
        feline = Mockito.mock(Feline.class);
        cat = new Cat(feline);
    }

    @Test
    public void testCatGetSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testCatGetFood() throws Exception {
        cat.getFood();
        cat.getFood();
        Mockito.verify(feline, Mockito.times(2)).eatMeat();
    }
}

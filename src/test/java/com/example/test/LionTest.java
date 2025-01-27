package com.example.test;

import com.example.Feline;
import com.example.Lion;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class LionTest {
    private Feline feline = new Feline();

    private Lion lion = new Lion(feline);
    @Test

    public void testLionGetKittens(){
        Assert.assertEquals(lion.getKittens(),1);

    }
    @Test
    public void testLionGetFood() throws Exception{
        Assert.assertEquals(lion.getFood(), List.of("Животные", "Птицы", "Рыба"));

    }

    @Test
    public void testExceptionOfMane () {
        String sex = "Оно";
        Exception thrown = assertThrows(
                Exception.class,
                () -> {Lion lion = new Lion(sex);
                    lion.doesHaveMane();
                });
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", thrown.getMessage());

    }
}

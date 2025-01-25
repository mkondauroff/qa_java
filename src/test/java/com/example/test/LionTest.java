package com.example.test;

import com.example.Feline;
import com.example.Lion;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

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
}

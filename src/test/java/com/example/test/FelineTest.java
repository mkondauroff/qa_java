package com.example.test;


import com.example.Feline;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void testGetKittensWithCounts() {
        Assert.assertEquals("Проверка методов с количеством", 3, feline.getKittens(3));
    }

    @Test
    public void testGetKittensWithoutCounts() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testGetFamilyIsFeline() {
        Assert.assertEquals("Проверка получения значения 'Кошачьи'", "Кошачьи", feline.getFamily());
    }

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFoodWhenThaAnimalIsPredator() throws Exception {
        Assert.assertEquals(feline.getFood("Хищник"),List.of("Животные", "Птицы", "Рыба"));
    }

    @Test
    public void testGetFoodWhenThaAnimalIsPlantEating() throws Exception {
        Assert.assertEquals(feline.getFood("Травоядное"),List.of("Трава", "Различные растения"));
    }
}

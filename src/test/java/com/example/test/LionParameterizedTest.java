package com.example.test;

import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class LionParameterizedTest {

    private Lion lion;
    private final String sex;
    private Object expectedResult;
    Object actualResult;

    public LionParameterizedTest(String sex, Object expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Object[][] testData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Оно", new Exception("Используйте допустимые значения пола животного - самей или самка").toString()},

        };
    }

    @Test
    public void testOfHasMane()  {
        try {
            lion = new Lion(sex);
            actualResult = lion.doesHaveMane();
        } catch (Exception exception) {
            actualResult=exception.toString();
        }finally {
            Assert.assertEquals(expectedResult, actualResult);
        }

    }
}

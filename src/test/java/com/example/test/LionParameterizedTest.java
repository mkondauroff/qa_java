package com.example.test;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class LionParameterizedTest {

    private Lion lion;
    private Feline feline;
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
        };
    }

    @Test
    public void testOfHasMane() throws Exception {
            lion = new Lion(feline, sex);
            actualResult = lion.doesHaveMane();
            Assert.assertEquals(expectedResult, actualResult);
        }

    }

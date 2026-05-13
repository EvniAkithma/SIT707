package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testTrueAdd() {

        Assert.assertEquals(
                3,
                MathQuestionService.q1Addition("1", "2"),
                0);
    }

    @Test
    public void testTrueSubtract() {

        Assert.assertEquals(
                2,
                MathQuestionService.q2Subtraction("5", "3"),
                0);
    }

    @Test
    public void testTrueMultiply() {

        Assert.assertEquals(
                12,
                MathQuestionService.q3Multiplication("3", "4"),
                0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNumber1Empty() {

        MathQuestionService.q1Addition("", "2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullInput() {

        MathQuestionService.q1Addition(null, "2");
    }

    @Test(expected = NumberFormatException.class)
    public void testAddInvalidInput() {

        MathQuestionService.q1Addition("abc", "2");
    }
}
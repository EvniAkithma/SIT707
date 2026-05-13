package web.service;

public class MathQuestionService {

    /**
     * Q1 Addition
     */
    public static double q1Addition(String number1, String number2) {

        if (number1 == null || number2 == null
                || number1.isEmpty() || number2.isEmpty()) {

            throw new IllegalArgumentException(
                    "Input values cannot be empty.");
        }

        return Double.valueOf(number1)
                + Double.valueOf(number2);
    }

    /**
     * Q2 Subtraction
     */
    public static double q2Subtraction(String number1, String number2) {

        if (number1 == null || number2 == null
                || number1.isEmpty() || number2.isEmpty()) {

            throw new IllegalArgumentException(
                    "Input values cannot be empty.");
        }

        return Double.valueOf(number1)
                - Double.valueOf(number2);
    }

    /**
     * Q3 Multiplication
     */
    public static double q3Multiplication(String number1, String number2) {

        if (number1 == null || number2 == null
                || number1.isEmpty() || number2.isEmpty()) {

            throw new IllegalArgumentException(
                    "Input values cannot be empty.");
        }

        return Double.valueOf(number1)
                * Double.valueOf(number2);
    }
}
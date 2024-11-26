package org.example.demo;

import java.util.Stack;

public class CalculatorLogic {
    public static double evaluateExpression(String expression) {
        // Удаляем пробелы из выражения
        expression = expression.replaceAll("\\s+", "");

        // Стек для чисел
        Stack<Double> numbers = new Stack<>();
        // Стек для операций
        Stack<Character> operations = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            // Если текущий символ - число, добавляем его в стек чисел
            if (Character.isDigit(currentChar)) {
                StringBuilder number = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    number.append(expression.charAt(i));
                    i++;
                }
                numbers.push(Double.parseDouble(number.toString()));
                i--; // Уменьшаем i, так как в конце цикла for будет увеличено
            }
            // Если текущий символ - операция
            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                while (!operations.isEmpty() && precedence(operations.peek()) >= precedence(currentChar)) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char operation = operations.pop();
                    numbers.push(applyOperation(a, b, operation));
                }
                operations.push(currentChar);
            }
        }

        // Обрабатываем оставшиеся операции в стеке
        while (!operations.isEmpty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            char operation = operations.pop();
            numbers.push(applyOperation(a, b, operation));
        }

        // Результат будет в стеке чисел
        return numbers.pop();
    }

    private static int precedence(char operation) {
        return switch (operation) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }

    private static double applyOperation(double a, double b, char operation) {
        return switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) throw new IllegalArgumentException("/0");
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Invalid Operation: " + operation);
        };
    }
}


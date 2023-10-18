import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа (арабских или римских): ");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }

    public static String parse(String expression) throws Exception {
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        boolean isRoman;
        String[] operands = expression.split("[+\\-*/]");
        if (operands.length != 2) throw new Exception("Должно быть два операнда");
        int x = operands[0].length();
        char operation = expression.charAt(x);
        if (Roman.checkRoman(operands[0])) {
            if (!Roman.checkRoman(operands[1])) {
                throw new IllegalArgumentException("Операнды не одинаковы");
            }
            num1 = Roman.convertToArabian(operands[0]);
        } else {
            if (Roman.checkRoman(operands[1])) {
                throw new IllegalArgumentException("Операнды не одинаковы");
            }
            num1 = Integer.parseInt(operands[0]);
        }
        if (Roman.checkRoman(operands[1])) {
            if (!Roman.checkRoman(operands[0])) {
                throw new IllegalArgumentException("Операнды не одинаковы");
            }
            num2 = Roman.convertToArabian(operands[1]);
        } else {
            if (Roman.checkRoman(operands[0])) {
                throw new IllegalArgumentException("Операнды не одинаковы");
            }
            num2 = Integer.parseInt(operands[1]);
        }
        if(num1 > 10 || num2 > 10 || num1 < 1 || num2 < 1){
            throw new RuntimeException("Числа должны быть от 1 до 10");
        }
        result = Roman.applyOperation(operation, num1, num2);
        if (Roman.checkRoman(operands[0])) {
            return Roman.convertToRoman(result);
        }
        return String.valueOf(result);
    }
}



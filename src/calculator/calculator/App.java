package calculator.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";

        // 반복문 사용
        while (!answer.equals("exit")) {
            // 양의 정수(0 포함) 입력받기
            System.out.print("첫번째 숫자를 입력하세요:");
            double num1 = sc.nextDouble();

            System.out.print("두번째 숫자를 입력하세요:");
            double num2 = sc.nextDouble();

            // 사칙연산 기호 입력받기
            sc.nextLine(); // 정수형 입력 후 제거되지 않은 개행문자 제거하기
            System.out.print("사칙연산의 기호를 입력하세요 (+, -, *, /): ");
            char operator = sc.nextLine().charAt(0);

            // 결과를 저장할 변수 설정하기
            double result = 0;

            // 위에서 입력받은 정수 2개와 사칙연산 기호를 이용하여 연산 후 결과값 출력하기
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.print("결과: " + result);
                    break;

                case '-':
                    result = num1 - num2;
                    System.out.print("결과: " + result);
                    break;

                case '*':
                    result = num1 * num2;
                    System.out.print("결과: " + result);
                    break;

                case '/':
                    if (num2 == 0) {
                        System.out.print("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                        break;
                    }
                    result = num1 / num2;
                    System.out.print("결과: " + result);
                    break;
                default:
                    System.out.print("사칙연산 기호가 적절하지 않습니다.");
                    break;
            }

            // 종료를 알려주는 "exit"문자열 입력 전까지 계산 무한 반복
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            answer = sc.next();
            System.out.println("-----------------------------------");
        }
    }
}
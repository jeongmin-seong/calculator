# 🧮 Calculator

이 프로젝트는 **Java 콘솔 기반 계산기 프로그램**입니다.  
사용자로부터 두 개의 숫자와 사칙연산 기호(`+`, `-`, `*`, `/`)를 입력받아  
연산 결과를 출력합니다.  
`exit`을 입력하기 전까지 반복 실행됩니다.

---

1. **코드 구성**
```
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
                    System.out.print("결과： " + result);
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
```

2. **출력 예시**
```
첫번째 숫자를 입력하세요: 10
두번째 숫자를 입력하세요: 5
사칙연산의 기호를 입력하세요 (+, -, *, /): *
결과: 50.0
더 계산하시겠습니까? (exit 입력 시 종료)
exit
-----------------------------------
```
3. **주요 기능**

| 기능       | 설명                              |
| -------- | ------------------------------- |
| ➕ 덧셈     | 두 수를 더합니다                       |
| ➖ 뺄셈     | 첫 번째 수에서 두 번째 수를 뺍니다            |
| ✖️ 곱셈    | 두 수를 곱합니다                       |
| ➗ 나눗셈    | 첫 번째 수를 두 번째 수로 나눕니다 (0 나눗셈 방지) |
| 🔁 반복 실행 | 사용자가 `exit`을 입력할 때까지 무한 반복 실행   |

4. **코드 설명**
```
●입력 처리

  ●Scanner 클래스를 사용해 사용자로부터 숫자와 연산자를 입력받습니다.
  
  ●nextDouble()을 사용하여 실수 입력을 처리할 수 있습니다.

●연산 처리

  ●switch 문을 사용하여 연산자를 분기 처리합니다.

  ●나눗셈 시 num2가 0일 경우 오류 메시지를 출력하고 연산을 건너뜁니다.

●종료 처리

  ●exit 문자열이 입력되면 while 루프가 종료되고 프로그램이 끝납니다.
```

5. **개선 아이디어**
```
●예외 처리 (try-catch)를 추가하여 문자 입력 시 프로그램이 멈추지 않도록 개선

●결과를 소수점 자릿수 제한 (예: %.2f 형식)
```

6. **개발 환경**
```
Language: Java 17+

IDE: IntelliJ IDEA / Eclipse / VS Code

Build System: none (단일 클래스 실행 가능)
```

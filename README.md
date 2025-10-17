🧮 Calculator Program

간단한 사칙연산 계산기 프로그램입니다.

사용자로부터 두 개의 양의 정수(0 포함)와 사칙연산 기호를 입력받아 결과를 출력하며,

exit을 입력하기 전까지 반복 실행됩니다.

1. **코드 구성**
```
package calculator.calculator2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Caculator 인스턴스 생성
        Calculator calculator = new Calculator();

        String answer = "";
        Scanner sc = new Scanner(System.in);

        // 반복문 사용
        while (!answer.equals("exit")) {
            // 양의 정수(0포함) 입력
            System.out.print("첫번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();

            System.out.print("두번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            // 사칙연산 기호 입력
            sc.nextLine(); // 정수형 입력 후 제거되지 않은 개행문자 제거하기
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.nextLine().charAt(0);

            //결과값 반환받아 출력
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                if ((operator == '/') && num2 == 0) {
                    System.out.println("나눗셈은 분모에 0이 들어갈 수 없습니다.");
                }
                else {
                    calculator.setResult(calculator.calculate(num1, num2, operator));
                    System.out.println("결과: " +calculator.getresult());
                    calculator.removeresult();
                }
            }
            else {
                System.out.println("사칙연산 기호가 적절하지 않습니다.");
            }

            // 종료를 알려주는 "exit"문자열 입력 전까지 계산 무한 반복
            System.out.println("더 계산하시겠습니다? (eixt 입력시 종료)");
            answer = sc.next();
            System.out.println("--------------------------------");
        }

    }
}
```
```
package calculator.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스 생성
    private List<Integer> result = new ArrayList<>();

    // 사칙연산 수행 후,결과값 반환 메서드 작성
    public int calculate(int num1, int num2, char op) {
        return switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
    }

    // getter 메서드 작성
    public int getresult() {
        return this.result.get(result.size() - 1);
    }

    // setter 메서드 작성
    public void setResult(int r) {
        this.result.add(r);
    }

    // 삭제기능 메서드 작성
    public void removeresult() {
        this.result.remove(0);
    }
}
```
2. **출력 예시**
```
첫번째 숫자를 입력하세요: 10
두번째 숫자를 입력하세요: 5
사칙연산 기호를 입력하세요: *
결과: 50
더 계산하시겠습니다? (exit 입력시 종료)
no
--------------------------------
첫번째 숫자를 입력하세요: 12
두번째 숫자를 입력하세요: 0
사칙연산 기호를 입력하세요: /
나눗셈은 분모에 0이 들어갈 수 없습니다.
더 계산하시겠습니다? (exit 입력시 종료)
exit
--------------------------------
```
3. **주요 기능**

| 기능            | 설명                                   |
| ------------- | ------------------------------------ |
| ➕➖✖️➗ 사칙연산 수행 | +, -, *, / 연산 수행                     |
| 🚫 0으로 나누기 방지 | 나눗셈 시 두 번째 숫자가 0이면 오류 메시지 출력         |
| 🔁 반복 실행      | `exit`을 입력하기 전까지 계속 계산 가능            |
| 📋 결과 저장 및 관리 | 연산 결과를 리스트(`List<Integer>`)에 저장 및 삭제 |

4. **클래스 설명**

1️⃣ Calculator 클래스

연산을 수행하고 결과를 관리하는 핵심 클래스입니다.

주요 필드

● `List<Integer> result`

  → 연산 결과를 저장하는 리스트

  **메서드**

  | 메서드명                                         | 설명                              |
| -------------------------------------------- | ------------------------------- |
| `int calculate(int num1, int num2, char op)` | 전달받은 두 숫자와 연산자로 사칙연산 수행 후 결과 반환 |
| `void setResult(int r)`                      | 계산된 결과를 리스트에 추가                 |
| `int getresult()`                            | 가장 최근의 계산 결과를 반환                |
| `void removeresult()`                        | 리스트의 첫 번째 결과값을 삭제               |

2️⃣ App 클래스

프로그램의 진입점 (main 메서드) 으로, 사용자 입력을 받아 계산을 수행합니다.

**주요 흐름**
```
1. Calculator 인스턴스 생성

2. 사용자에게 첫 번째, 두 번째 숫자 입력 받기

3. 사칙연산 기호 입력

4. 연산 결과 출력

5. "exit" 입력 시 프로그램 종료
```
6. **주의사항**

● 나눗셈(/) 수행 시, 두 번째 숫자가 0이면 오류 메시지 출력 후 연산을 건너뜁니다.

● 연산자는 반드시 '+', '-', '*', '/' 중 하나여야 합니다.

● 결과 리스트(result)는 가장 오래된 결과를 하나씩 제거하여 최신 결과만 유지합니다.

7. **개발 정보**

| 항목    | 내용                       |
| ----- | ------------------------ |
| 언어    | Java 17+                 |
| 작성자   | 성종민              |
| 패키지명  | `calculator.calculator2` |
| 실행 파일 | `App.java`               |


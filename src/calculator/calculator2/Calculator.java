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
package innerclass;

public class OuterClass {
    private int num = 10;

    // 클래스 파일 안에 내부에 또 클래스 선언(중첩 클래스) // 인스턴스 내부 클래스
    class InnerClass {
        public void display() {
            System.out.println("num: " + num);
        }
    }

} // end of outer class

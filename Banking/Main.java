public class Main {
    public static void main(String[] args) {
        System.out.println("How many students do you want to add? ");
        Student testStudent = new Student();
        testStudent.showInfo();
        testStudent.tuition.enroll();
        testStudent.tuition.payTuition();
        testStudent.showInfo();
    }
}

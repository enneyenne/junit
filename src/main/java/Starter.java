public class Starter {
    public static void main(String[] args) {

        Student st1 = new Student("Kate");

//        st1.addGrade(5);
//        st1.addGrade(2);
//        st1.addGrade(6);
//        st1.addGrade(1);

        st1.addGrade(4);
        st1.addGrade(4);
        st1.getGrades().add(-20);
        st1.getGrades().add(5);
        System.out.println(st1);

    }
}

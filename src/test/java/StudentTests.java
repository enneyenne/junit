import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTests {

    @ParameterizedTest(name = "Корректные оценки добавляются в список оценок")
    @MethodSource("GradesGenerator#ints")
    public void testAddGradeInRange(int x) {
        Student stud = new Student("Kate");
        int num = x;
        stud.addGrade(num);
        Assertions.assertEquals(stud.getGrades().get(0), num);
        System.out.println(stud.getGrades());
    }

    @ParameterizedTest(name = "Добавление неверных оценок кидает исключение")
    @MethodSource("GradesGenerator#intsEx")
    public void testAddGradeLessOrMoreThenExpected(int x) {
        Student stud = new Student("Kate");

        //Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(x));

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(x));
        Assertions.assertEquals("Grade must be between 2 and 5!", e.getMessage());

    }

    @Test
    public void testEqualsAndHashCode() {
        Student stud1 = new Student("Kate");
        stud1.addGrade(5);
        Student stud2 = new Student("Kate");
        stud2.addGrade(5);
        Assertions.assertEquals(stud1, stud2);
        Assertions.assertTrue(stud1.hashCode() == stud2.hashCode());
    }

    @Test
    public void testGetStudentName() {
        Student stud1 = new Student("Kate");
        assertEquals("Kate", stud1.getName());
    }

    @Test
    public void testSetStudentName() {
        Student stud1 = new Student("Kate");
        stud1.setName("Olga");
        assertEquals("Olga", stud1.getName());
    }

    @ParameterizedTest
    @MethodSource("GradesGenerator#ints")
    public void testAddGradeAfterGetArraysGrades(int x) {
        Student stud1 = new Student("Kate");

        stud1.addGrade(4);
        int gradesSizeBefore = stud1.getGrades().size();
        System.out.println("Размер списка оценок при добавлении допустимой оценки = " + gradesSizeBefore);

        stud1.getGrades().add(x);
        int gradesSizeAfter = stud1.getGrades().size();
        System.out.println("Размер списка оценок после попытки добавления недопустимой оценки = " + gradesSizeAfter);

        assertEquals(gradesSizeBefore, gradesSizeAfter, "Сравние размера списков");

    }
}
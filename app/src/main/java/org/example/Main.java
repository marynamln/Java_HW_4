package org.example;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Subject subject1 = new Subject("Python", 3, 3);
        Subject subject2 = new Subject("Java", 4, 5);
        Student student = new Student("Maryna", "Melnyk");
        JournalRecord record1 = new JournalRecord(subject1, student, new Date(), 95);
        JournalRecord record2 = new JournalRecord(subject2, student, new Date(), 105);

        try {
            AnnotationValidator.validate(record1);
            System.out.println("Validation 1 passed.");

            AnnotationValidator.validate(record2);
            System.out.println("Validation 2 passed.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        JournalRecordReport report = new JournalRecordReport();
        report.generate();
    }
}

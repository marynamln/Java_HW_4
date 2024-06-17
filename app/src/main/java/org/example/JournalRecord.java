package org.example;

import java.util.Date;

@GenerateReport
public class JournalRecord {
    Subject subject;
    Student student;
    Date dateOfExam;

    @ValidateMark(min = 0, max = 100)
    int mark;

    public JournalRecord(Subject subject, Student student, Date dateOfExam, int mark) {
        this.subject = subject;
        this.student = student;
        this.dateOfExam = dateOfExam;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Subject: " + this.subject.toString() + ", Student:  " + this.student.toString() + ", date of exam: "
                + this.dateOfExam.toString() + ", mark: " + this.mark;
    }
}

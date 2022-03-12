package dao;

import dto.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StudentRepository {
    private List<Student> listofstudent = new ArrayList<>();

    private static StudentRepository instance = new StudentRepository();

    public static StudentRepository getInstance(){
        return instance;
    }
    public void addStudent(Student student){
        listofstudent.add(student);
    }
    public int getStudentCnt(){
        return listofstudent.size();
    }

    public int scoreToTotal(Integer[] scores) {
        return Stream.of(scores).mapToInt(num -> num).sum();
    }

    public double totalToAvg(int total, int subjectCnt) { // FB : 정수 / 정수 --> 정수 / 실수
        return total / (double)subjectCnt;
    }

    public List<Student> getAllStudents(){
        return listofstudent;
    }

    /* 석차구하는 메서드*/
    public void getRank() {
        for (Student student : listofstudent) { // 사전작업 : 모든 rank를 1로 초기화
            student.setRank(1);
        }
        // 자기보다 총점 높은 학생이 있으면 석차가 1등씩 밀려남
        for (Student targetStudent : listofstudent) {                         // studentList에서 한명씩 보면서
            for (Student compareStudent : listofstudent) {
                if (targetStudent.getTotal() < compareStudent.getTotal()) // 자기보다 총점 높은 학생 있으면 석차 +1
                    targetStudent.setRank(targetStudent.getRank() + 1);
            }
        }
    }

    /*성적순 정렬 메서드*/
    public void sortByScore() {
        // Collection.sort에 Comparator 구현 ( 내림차순 구현 위해 +1,-1 바꿈)
        Collections.sort(listofstudent, (s1, s2) -> { // Comparator --> lambda로 수정
            if (s1.getTotal() < s2.getTotal()) {
                return +1;
            } else if (s1.getTotal() > s2.getTotal()) {
                return -1;
            }
            return 0;
        });
    }


    /*이름 유효성 검사*/
    public boolean checkName(String name) {
        String regExp = "^[가-힣]*$";                 // 한글만 가능한 정규식
        if (!(name.length() >= 2 && name.length() <= 5))  // 글자수 2~5 제한
            return false;
        return name.matches(regExp) ? true : false;    // 한글만 입력
    }

    /*성적 유효성 검사*/
    public boolean checkScores(Integer[] scores) {
        if (scores.length != 3)            // 3과목 입력되지 않거나
            return false;
        for (Integer score : scores) {  // 한과목이라도
            if (score < 0 || score > 100)    // 유효점수(0~100) 범위가 아니면
                return false;
        }
        return true;
    }

    /*주소 유효성 검사*/
    public boolean checkAddress(String addr) {
        return addr.length() > 0 ? true : false; // 1글자 이상이면 true
    }

    public void printInfo(){
        for (Student student : listofstudent) {
            System.out.println(student.getStudentId());
            System.out.println(student.getName());
            System.out.println(student.getScores());
            System.out.println(student.getTotal());
            System.out.println(student.getAvg());
            System.out.println(student.getRank());
            System.out.println(student.getAddr());
        }
    }
}

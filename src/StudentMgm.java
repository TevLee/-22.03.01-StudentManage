import java.util.Collections;
import java.util.List;

public class StudentMgm {
    /* 석차구하는 메서드*/
    public static void getRank(List<Student> studentList) {
        // 자기보다 총점 높은 학생이 있으면 석차가 1등씩 밀려남
        for (Student targetStudent : studentList) {                         // studentList에서 한명씩 보면서
            for (Student compareStudent : studentList) {
                if (targetStudent.getTotal() < compareStudent.getTotal()) // 자기보다 총점 높은 학생 있으면 석차 +1
                    targetStudent.setRank(targetStudent.getRank() + 1);
            }
        }
    }

    /*성적순 정렬 메서드*/
    public static void sortByScore(List<Student> studentList) {
        // Collection.sort에 Comparator 구현 ( 내림차순 구현 위해 +1,-1 바꿈)
        Collections.sort(studentList, (s1, s2) -> { // Comparator --> lambda로 수정
            if (s1.getTotal() < s2.getTotal()) {
                return +1;
            } else if (s1.getTotal() > s2.getTotal()) {
                return -1;
            }
            return 0;
        });
    }
}

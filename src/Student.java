import java.util.stream.Stream;

public class Student {
    //.. FB : 객체 클래스 내부의 변수들은 일반적으로 private으로 선언
    private int studentId;
    private String name;
    private final Integer[] scores;
    private int total;
    private final double avg;
    private int rank;
    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Integer[] getScores() {
        return scores;
    }

    public double getAvg() {
        return avg;
    }

    public String getAddr() {
        return addr;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Student(int studentId, String name, Integer[] scores, String addr) {
        this.studentId = studentId;
        this.name = name;
        this.scores = scores;
        //.. FB : 총점(total)과 평균(avg)는 클래스 내 다른 함수에서 데이터 생성 후 접근.
        this.total = scoreToTotal(this.scores);
        this.avg = totalToAvg(this.total, this.scores.length);
        this.rank = 1;
        this.addr = addr;
    }

    private int scoreToTotal(Integer[] scores) {
        return Stream.of(scores).mapToInt(num -> num).sum();
    }

    private double totalToAvg(int total, int subjectCnt) { // FB : 정수 / 정수 --> 정수 / 실수
        return total / (double)subjectCnt;
    }
}
public class CheckCollectInput {

    /*이름 유효성 검사*/
    public static boolean checkName(String name) {
        String regExp = "^[가-힣]*$";                 // 한글만 가능한 정규식
        if (!(name.length() >= 2 && name.length() <= 5))  // 글자수 2~5 제한
            return false;
        return name.matches(regExp) ? true : false;    // 한글만 입력
    }

    /*성적 유효성 검사*/
    public static boolean checkScores(Integer[] scores) {
        if (scores.length != 3)            // 3과목 입력되지 않거나
            return false;
        for (Integer score : scores) {  // 한과목이라도
            if (score < 0 || score > 100)    // 유효점수(0~100) 범위가 아니면
                return false;
        }
        return true;
    }

    /*주소 유효성 검사*/
    public static boolean checkAddress(String addr) {
        return addr.length() > 0 ? true : false; // 1글자 이상이면 true
    }
}

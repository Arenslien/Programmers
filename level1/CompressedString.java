import java.util.ArrayList;

public class CompressedString {
  public int solution(String s) {
    int answer = 1000;

    // 문자열의 길이 X : 1 ~ 1000 -> 패턴 압축은 X/2가 최대
    
    for (int i=2; i<s.length()/2; i++) {
      ArrayList<String> pieces = new ArrayList<>();
      String compressedString = "";

      // 1. 문자열 자르기
      for (int j=0; j<=s.length()-i; j+=i) {
        pieces.add(s.substring(j, j+i));
      }

      for(int j=0; j<pieces.size(); j++) {
        System.out.print("["+pieces.get(j)+"] ");
      }
      System.out.println();

      // 2. 단위 패턴 찾기
      String pattern = pieces.get(0);
      int compressedCount = 0;
      for(int j=0; j<pieces.size(); j++) {
        if (pattern.equals(pieces.get(j))) {
          compressedCount++;
        } else {
          compressedString += (compressedCount==1 ? "" : compressedCount + pattern);
          pattern = pieces.get(j);
        }
      }
      System.out.println(compressedString);
      // ab ab ac ac de sd aq

      // 갱신
      if (answer > compressedString.length()) {
        answer = compressedString.length();
      }

    }
    
    return answer;
  }

  public static void main(String[] args) {
    CompressedString class1 = new CompressedString();

    class1.solution("asdfasdfasdfa");
  }
}
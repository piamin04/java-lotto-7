package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    //로또 금액 예외 처리 및 로또 개수 구하기
    public static int getMoney() {
        while (true) {
            try {
                String input = readLine();
                if (!input.matches("\\d+"))  //숫자가 아닌 경우 예외처리
                    throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
                int money = Integer.parseInt(input);
                if (money % 1000 != 0) //1000 단위로 안나눠떨어질 경우 예외처리
                    throw new IllegalArgumentException("[Error] 구입 금액은 1,000원 단위로 입력해주세요");
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //3. 로또 발행
    public static List<Integer> createLotto() {
        List<Integer> lotto =Randoms.pickUniqueNumbersInRange(1,45,6);
        return lotto; // 배열 반환
    }

    public static void main(String[] args) {
        //1.로또 구입 금앱 입력받기 및 예외처리
        System.out.println("구입금액을 입력해 주세요.");
        //2. 로또 개수 구하기
        int lottoCount=getMoney()/1000;

        //1번 메서드 확인용 출력
        System.out.println(lottoCount);

    }
}

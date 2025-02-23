package lotto.view;

import lotto.model.Lotto;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResults(Map<Integer, Integer> results) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + results.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + results.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.get(5) + "개");
        System.out.println("5개 + 보너스 볼 일치 (30,000,000원) - " + results.get(7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.get(6) + "개");
    }
}


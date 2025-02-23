package lotto.service;

import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.*;

public class LottoService {
    private List<Lotto> userLottos; // 사용자가 구매한 로또 리스트
    private List<Integer> winningNumbers; // 당첨 번호
    private int bonusNumber; // 보너스 번호

    public void buyLottos(int count) {
        userLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            userLottos.add(new Lotto());
        }
        OutputView.printLottos(userLottos);
    }

    public void inputWinningNumbers() {
        winningNumbers = InputView.getWinningNumbers();
        bonusNumber = InputView.getBonusNumber(winningNumbers);
    }

    public void checkResults() {
        Map<Integer, Integer> results = new HashMap<>();
        results.put(3, 0);
        results.put(4, 0);
        results.put(5, 0);
        results.put(6, 0);
        results.put(7, 0); // 5개 + 보너스

        for (Lotto lotto : userLottos) {
            int matchCount = countMatches(lotto.getNumbers());
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 5 && hasBonus) results.put(7, results.get(7) + 1);
            else if (results.containsKey(matchCount)) results.put(matchCount, results.get(matchCount) + 1);
        }

        OutputView.printResults(results);
    }

    private int countMatches(List<Integer> userNumbers) {
        int count = 0;
        for (int num : userNumbers) {
            if (winningNumbers.contains(num)) {
                count++;
            }
        }
        return count;
    }
}

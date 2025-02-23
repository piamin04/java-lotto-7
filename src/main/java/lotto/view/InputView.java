package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.*;

public class InputView {
    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return validateMoney(readLine());
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return validateNumbers(readLine().split(","));
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                int bonus = Integer.parseInt(readLine());
                if (winningNumbers.contains(bonus)) throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                return bonus;
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static int validateMoney(String input) {
        if (!input.matches("\\d+") || Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
        return Integer.parseInt(input);
    }

    private static List<Integer> validateNumbers(String[] input) {
        if (input.length != 6) throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");

        List<Integer> numbers = new ArrayList<>();
        for (String num : input) {
            int number = Integer.parseInt(num.trim());
            if (number < 1 || number > 45 || numbers.contains(number)) {
                throw new IllegalArgumentException("유효하지 않은 로또 번호입니다.");
            }
            numbers.add(number);
        }
        return numbers;
    }
}


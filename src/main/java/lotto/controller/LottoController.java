package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        int money = InputView.readMoney();
        int count = money / 1000;

        LottoService lottoService = new LottoService();
        lottoService.buyLottos(count);
        lottoService.inputWinningNumbers();
        lottoService.checkResults();
    }
}
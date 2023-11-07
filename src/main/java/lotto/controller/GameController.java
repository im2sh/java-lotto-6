package lotto.controller;

import lotto.domain.dto.InputBonusNumber;
import lotto.domain.dto.InputMoney;
import lotto.domain.dto.InputWinningNumbers;
import lotto.domain.dto.PurchasedLottoDTO;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    public static void lottoStart(){
        inputMoney();
        PurchasedLottoDTO purchasedLottoDTO = LottoService.purchasedLottoToDTO();
        OutputView.printPurchasedLotto(purchasedLottoDTO);
        inputWinningNumbers();
        inputBonusNumber();
    }

    private static void inputMoney(){
        try{
            InputMoney money = InputView.inputMoney();
            LottoService.lottoStart(money);
        } catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            inputMoney();
        }
    }

    private static void inputWinningNumbers(){
        try{
            InputWinningNumbers inputWinningNumbers = InputView.inputWinningNumbers();
            LottoService.inputWinningLotto(inputWinningNumbers);
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            inputWinningNumbers();
        }
    }

    private static void inputBonusNumber(){
        try{
            InputBonusNumber inputBonusNumber = InputView.inputBonusNumber();
            LottoService.inputBonusLotto(inputBonusNumber);
        }catch (IllegalArgumentException e){
            OutputView.printErrorMessage(e);
            inputBonusNumber();
        }
    }
}

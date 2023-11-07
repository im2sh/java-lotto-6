package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningNumbersTest {

    @Test
    @DisplayName("입력받은 당첨 번호에 정수가 아닌 입력이 있을 경우 예외가 발생한다.")
    public void 당첨_번호_정수_아닌_경우() throws Exception {
        String winningNumbersString = "a,2,3,4,5,6";
        assertThatThrownBy(() -> new LottoWinningNumbers(winningNumbersString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 당첨 번호에 공백이 있을 경우 예외가 발생한다.")
    public void 당첨_번호_공백_제외() throws Exception {
        String winingNumbersString = "1, 2,3,4, 5,6";
        assertThatThrownBy(() -> new LottoWinningNumbers(winingNumbersString))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("입력받은 당첨 번호가 6개보다 많으면 예외가 발생한다.")
    public void 당첨_번호_6개보다_많은_경우() throws Exception {
        //given
        String winningNumbersString = "1,2,3,4,5,6,7";

        //then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(winningNumbersString));
    }

    @Test
    @DisplayName("입력받은 당첨 번호가 6개보다 적으면 예외가 발생한다.")
    public void 당첨_번호_6개보다_적은_경우() throws Exception {
        //given
        String winningNumbersString = "1,2,3,4,5";

        //then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(winningNumbersString));
    }

    @Test
    @DisplayName("입력받은 당첨 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
    public void 당첨_번호_범위() throws Exception {
        //given
        String winningNumberZeroString = "0,1,2,3,4,5";
        String winningNumberOverString = "1,2,3,4,5,46";

        //then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(winningNumberZeroString));
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(winningNumberOverString));
    }

    @Test
    @DisplayName("입력받은 당첨 범위에 중복이 있을 경우 예외가 발생한다.")
    public void 당첨_번호_중복() throws Exception {
        //given
        String winnerNumbersDuplicateString = "1,1,2,3,4,5";

        //then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(winnerNumbersDuplicateString));
    }


}

package lotto.service;

import static lotto.service.LottoService.lottoGenerator;
import static lotto.service.LottoService.purchasedLottoToDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.domain.PurchasedLottoNumbers;
import lotto.domain.User;
import lotto.domain.dto.PurchasedLottoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("구입 금액만큼 로또가 생성되는지 검사한다.")
    public void 로또_구매() throws Exception {
        //given
        User user = new User("10000");

        //when
        List<Lotto> purchasedLotto = lottoGenerator(user.getAmount());

        //then
        //purchasedLotto.getPurchasedLotto().size();
        assertEquals(10, purchasedLotto.size());
    }

    @Test
    @DisplayName("생성된 로또가 출력되는지 검사한다.")
    public void 로또_출력() throws Exception {
        //given
        List<Lotto> lottos = lottoGenerator(3000);
        PurchasedLottoNumbers purchasedLottoNumbers = new PurchasedLottoNumbers(lottos);

        //when
        PurchasedLottoDTO purchasedLottoDTO = purchasedLottoToDTO();

        String lottoDTO1 = Arrays.toString(purchasedLottoDTO.getPurchasedLotto().get(0).getNumbers().toArray());
        String lottoDTO2 = Arrays.toString(purchasedLottoDTO.getPurchasedLotto().get(1).getNumbers().toArray());
        String lottoDTO3 = Arrays.toString(purchasedLottoDTO.getPurchasedLotto().get(2).getNumbers().toArray());

        //then
        Assertions.assertEquals(
                Arrays.toString(purchasedLottoNumbers.getPurchasedLotto().get(0).getNumbers().toArray()), lottoDTO1);
        Assertions.assertEquals(
                Arrays.toString(purchasedLottoNumbers.getPurchasedLotto().get(1).getNumbers().toArray()), lottoDTO2);
        Assertions.assertEquals(
                Arrays.toString(purchasedLottoNumbers.getPurchasedLotto().get(2).getNumbers().toArray()), lottoDTO3);
    }
}

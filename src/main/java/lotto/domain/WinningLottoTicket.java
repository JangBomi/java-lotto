package lotto.domain;

import java.util.List;

public class WinningLottoTicket {
    private static final String DUPLICATION_NUMBER = "보너스 볼 번호는 당첨 번호와 중복될 수 없습니다.";

    private final LottoTicket lottoTicket;
    private final LottoNumber bonusBallNumber;

    private WinningLottoTicket(LottoTicket lottoTicket, LottoNumber bonusBallNumber) {
        this.lottoTicket = lottoTicket;
        this.bonusBallNumber = bonusBallNumber;
    }

    public static WinningLottoTicket of(List<Integer> winningNumbers, int bonusBallNumber) {
        validateDuplicateNumbers(winningNumbers, bonusBallNumber);
        LottoTicket lottoTicket = LottoTicket.generateTicket(winningNumbers);
        LottoNumber bonusLottoNumber = new LottoNumber(bonusBallNumber);
        return new WinningLottoTicket(lottoTicket, bonusLottoNumber);
    }

    private static void validateDuplicateNumbers(List<Integer> winningNumbers, int bonusBallNumber) {
        if (winningNumbers.contains(bonusBallNumber)) {
            throw new IllegalArgumentException(DUPLICATION_NUMBER);
        }
    }

    public LottoRank compareNumbers(LottoTicket lottoTicket) {
        int matchCounts = this.lottoTicket.getMatchCounts(lottoTicket);
        boolean isBonusBall = lottoTicket.contains(bonusBallNumber);
        return LottoRank.of(matchCounts, isBonusBall);
    }
}

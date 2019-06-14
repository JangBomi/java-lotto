package lotto.domain.lotto.dto;

public class PrizeInfoDTO {
    private final int matchCount;
    private final long prizeMoney;
    private final int lottoCount;

    public PrizeInfoDTO(int matchCount, long prizeMoney, int lottoCount) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.lottoCount = lottoCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
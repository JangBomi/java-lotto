package lotto.model;

public class LottoSize {
    private final int size;

    public LottoSize(int size) {
        validateLottoSize(size);
        this.size = size;
    }

    public int getAutoLottoSize(Money money) {
        int autoLottoSize = money.getBuyableLottoSize() - size;
        validateLottoSize(autoLottoSize);
        return autoLottoSize;
    }

    private void validateLottoSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("로또는 0장 이상 구매하셔야 합니다.");
        }
    }

    public int getSize() {
        return size;
    }
}
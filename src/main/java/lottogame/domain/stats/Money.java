package lottogame.domain.stats;

import java.util.Objects;
import java.util.regex.Pattern;

public class Money {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9][0-9]{3,}$");
    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money of(String money) {
        validate(money);
        return new Money(Integer.parseInt(money));
    }

    public static Money of(int money) {
        return new Money(money);
    }

    private static void validate(String money) {
        if (!NUMBER_PATTERN.matcher(money).matches()) {
            throw new IllegalArgumentException("금액은 1,000이상이어야 합니다.");
        }
    }

    public int value() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    @DisplayName("3개의 로또 생성하는지 확인")
    void GenerateLottos() {
        Lottos lottos = Lottos.generate(3);

        assertThat(lottos.getLottos().size()).isEqualTo(3);
    }
}
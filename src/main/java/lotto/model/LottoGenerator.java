package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;


    public Lotto generateLotto() {
        List<Integer> lottoNumbers = generateSequentialIntegers();
        Collections.shuffle(lottoNumbers);

        return new Lotto(lottoNumbers.subList(0, LOTTO_SIZE));
    }

    private List<Integer> generateSequentialIntegers() {
        return IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Lotto> generateLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
    }
}

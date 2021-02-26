package lotto.domain;

import lotto.domain.lottomachine.LottoMachine;
import lotto.domain.lottomachine.RandomLottoMachine;
import lotto.domain.rating.RatingCounter;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoMachine lottoMachine;
    private final List<Lotto> lottos = new ArrayList<>();
    private final RatingCounter ratingCounter = new RatingCounter();
    private final Ticket ticket;


    public LottoService(Ticket ticket) {
        this(new RandomLottoMachine(), ticket);
    }

    public LottoService(LottoMachine lottoMachine, Ticket ticket) {
        this.lottoMachine = lottoMachine;
        this.ticket = ticket;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public void generateLottos() {
        for (int i = 0; i < ticket.getRandomCount(); i++) {
            lottos.add(new Lotto(lottoMachine.generate()));
        }
    }

    public void scratchLotto(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            ratingCounter.update(winningLotto.scratch(lotto));
        }
    }

    public double getEarningRate(final Money money) {
        return ratingCounter.totalSum() / money.getValue();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public RatingCounter getRatingCounter() {
        return ratingCounter;
    }
}
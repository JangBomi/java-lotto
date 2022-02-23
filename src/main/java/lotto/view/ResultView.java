package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.LottoResult;

import java.util.*;

public class ResultView {

    public static void printGeneratedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.stream()
                .map(Lotto::getLottoNumbers)
                .forEach(System.out::println);
        printEmptyLine();
    }

    public static void printResultStatistics(LottoResult lottoResult) {
        printEmptyLine();
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.FAIL)
                .map(rank -> getOneRankStatus(rank, lottoResult.getResult().getOrDefault(rank, 0)))
                .forEach(System.out::println);
    }

    private static String getOneRankStatus(Rank rank, Integer winningCount) {
        if (rank == Rank.SECOND) {
            return rank.getValue() + "개 일치, 보너스 볼 일치(" + rank.getMoney() + "원)- " + winningCount + "개";
        }
        return rank.getValue() + "개 일치 (" + rank.getMoney() + "원)- " + winningCount + "개";
    }

    public static void printYield(float yield) {
        System.out.println(getYieldStatus(yield));
    }

    private static String getYieldStatus(float yield) {
        if (yield >= 1) {
            return String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)", yield) ;
        }
        return String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", yield);
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}

package lotto.view;

import lotto.model.LotteryTickets;
import lotto.model.Win;

import java.util.Map;

public class OutputView {

    public static void showLotteryCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void showLotteryTickets(LotteryTickets lotteryTickets) {
        lotteryTickets.getTickets().forEach(System.out::println);
        System.out.println();
    }

    public static void showResults(Map<Win, Integer> totalWin, int outcome) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 0; i < Win.values().length; i++) {
            showResult(totalWin, i);
        }

        final int income = Win.totalMoney(totalWin);
        System.out.println("총 수익률은 " + Win.calculateProfitRate(income, outcome) + "입니다.");
    }

    private static void showResult(Map<Win, Integer> winTotal, int i) {
        Win win = Win.values()[i];
        if (!Win.DEFAULT.equals(win)) {
            String matchString = getMatchString(win);
            System.out.println(matchString + " (" + win.getPrize() + "원)- " + winTotal.getOrDefault(win, 0));
        }
    }

    private static String getMatchString(Win win) {
        if (Win.WIN_5_BONUS.equals(win)) {
            return (int) win.getPoints() + "개 일치, 보너스 볼 일치";
        }
        return (int) win.getPoints() + "개 일치";
    }

}

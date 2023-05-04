package lotto.model;

import java.util.*;

public class LotteryTickets {

    private static final int LOTTERY_PRICE = 1000;

    private List<LotteryTicket> tickets;

    public LotteryTickets(int money) {
        List<LotteryTicket> tickets = new ArrayList<>();
        for (int i = 0; i < money / LOTTERY_PRICE; i++) {
            tickets.add(new LotteryTicket());
        }
        this.tickets = Collections.unmodifiableList(tickets);
    }

    public Map<Win, Integer> getWinTotal(List<Integer> winNumbers) {
        Map<Win, Integer> winTotal = initialize();
        tickets.forEach(ticket -> {
            int winPoint = ticket.compare(winNumbers);
            countWinTotal(winTotal, winPoint);
        });
        return winTotal;
    }

    private Map<Win, Integer> initialize() {
        Map<Win, Integer> winTotal = new EnumMap<>(Win.class);
        for (int i = 0; i < Win.values().length; i++) {
            winTotal.put(Win.values()[i], 0);
        }
        return winTotal;
    }

    private static void countWinTotal(Map<Win, Integer> winTotal, int winPoint) {
        if (winPoint == 3) {
            winTotal.put(Win.WIN_3, winTotal.get(Win.WIN_3) + 1);
        }
        if (winPoint == 4) {
            winTotal.put(Win.WIN_4, winTotal.get(Win.WIN_4) + 1);
        }
        if (winPoint == 5) {
            winTotal.put(Win.WIN_5, winTotal.get(Win.WIN_5) + 1);
        }
        if (winPoint == 6) {
            winTotal.put(Win.WIN_6, winTotal.get(Win.WIN_6) + 1);
        }
    }

    public int size() {
       return this.tickets.size();
    }

    public List<LotteryTicket> getTickets() {
        return tickets;
    }
}

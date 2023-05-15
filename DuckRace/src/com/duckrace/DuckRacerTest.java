package com.duckrace;

import java.util.List;

class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racer10 = new DuckRacer(10, "Kevin");
        System.out.println(racer10); // toString()

        racer10.win(Reward.DEBIT_CARD);
        racer10.win(Reward.PRIZES);
        racer10.win(Reward.PRIZES);
        System.out.println(racer10);

        // retrive a read-only view of the rewards List, add(), remove(), clear(), No good
        List<Reward> rewardsList = racer10.getRewards();
//        rewardsList.add(Reward.DEBIT_CARD);
//        rewardsList.add(Reward.DEBIT_CARD);
//        rewardsList.add(Reward.DEBIT_CARD);
//        System.out.println(racer10);

        //show just the rewards
        System.out.println(rewardsList);

        //make it win again, and notice how our 'rewardsList reflects
        racer10.win(Reward.PRIZES);

        //the rewards List will reflect this new win

    }
}
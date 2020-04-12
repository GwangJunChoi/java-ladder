package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.Prizes;
import ladder.domain.Players;
import ladder.dto.GameInfo;
import ladder.dto.GameResults;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameRun {
    private static final String KEYWORD_ALL_VIEW = "all";

    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        Prizes prizes = InputView.inputPlayResults();
        GameInfo gameInfo = new GameInfo(players, prizes);
        int ladderHeight = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(gameInfo, ladderHeight);
        ResultView.viewLadder(gameInfo, ladderGame.getLadder());
        GameResults gameResults = ladderGame.play();

        while (true) {
            String playerName = InputView.inputPlayerNameForViewResult();
            if (playerName.equals(KEYWORD_ALL_VIEW)) {
                break;
            }
            ResultView.viewPlayerResult(gameResults, playerName);
        }
        ResultView.viewAllPlayerResult(gameResults);
    }
}

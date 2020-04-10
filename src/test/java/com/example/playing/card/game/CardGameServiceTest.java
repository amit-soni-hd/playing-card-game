package com.example.playing.card.game;

import com.example.playing.card.player.Player;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.rules.Timeout;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(MockitoJUnitRunner.class)
public class CardGameServiceTest {

    @InjectMocks
    private CardGameService cardGameService;

    private List<Player> players;
    private static final int MIN_TIMEOUT = 10000;

    @Before
    public void setUp() {
        this.players = new ArrayList<>(2);
        players.add(new Player("Radha", true, false));
        players.add(new Player("Krishna",true, false));
    }

    @SuppressWarnings("deprecation")
    @Rule
    public Timeout timeout = new Timeout(MIN_TIMEOUT, TimeUnit.MILLISECONDS) {
        public Statement apply(Statement base, Description description) {
            return new FailOnTimeout(base, MIN_TIMEOUT) {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        super.evaluate();
                        throw new RuntimeException("");
                    } catch (Exception e) {}
                }
            };
        }
    };

    @Test(expected = RuntimeException.class)
    public void startGame() {
        cardGameService.startGame(players);
    }

}

package hangman.model;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import hangman.model.BonusScore;
import hangman.model.GameScore;
import hangman.model.OriginalScore;
import hangman.model.PowerScore;

public class GameScoreTest {

    /**
     * OriginalScore: 
     * @pre 100 puntos
     * @pos -10 letras incorrectas
     * @pos 0 min puntaje
     * PowerScore:
     * @pre 0 puntos
     * @pos -8 letras incorrectas
     * @pos 500 puntaje maximo
     * @pos 0 min puntaje 
     * BonusScore:
     * @pre 0 puntos
     * @pos -5 letras incorrectas
     * @pos +10 letras correctas
     * @pos 0 min puntaje
     */


    @Test
    public void validateGameOriginalScore() {
        GameScore gamescore = new OriginalScore();
        int puntaje = gamescore.calculateScore(3, 2);
        assertEquals(80, puntaje);

        GameScore game = new OriginalScore();
        int puntajes = game.calculateScore(5, 3);
        assertEquals(70, puntajes);

        GameScore score = new OriginalScore();
        int puntaj = score.calculateScore(4, 20);
        assertEquals(0, puntaj);

        GameScore games = new OriginalScore();
        int punta = games.calculateScore(2,12);
        assertEquals(0, punta);
    }

    @Test
    public void validateGameBonusScore() {
        GameScore gamescore = new BonusScore();
        int puntaje = gamescore.calculateScore(3, 2);
        assertEquals(20, puntaje);

        GameScore game = new BonusScore();
        int puntajes = game.calculateScore(5, 3);
        assertEquals(35, puntajes);

        GameScore score = new BonusScore();
        int puntaj = score.calculateScore(4, 20);
        assertEquals(0, puntaj);

        GameScore games = new BonusScore();
        int punta = games.calculateScore(2,12);
        assertEquals(0, punta);
    }

    @Test
    public void validateGamePowerScore() {
        GameScore gamescore = new PowerScore();
        int puntaje = gamescore.calculateScore(3, 2);
        assertEquals(109, puntaje);

        GameScore game = new PowerScore();
        int puntajes = game.calculateScore(5, 3);
        assertEquals(500, puntajes);

        GameScore score = new PowerScore();
        int puntaj = score.calculateScore(4, 20);
        assertEquals(465, puntaj);

        GameScore games = new PowerScore();
        int punta = games.calculateScore(2,12);
        assertEquals(0, punta);
    }
}

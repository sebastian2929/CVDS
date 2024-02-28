package hangman.model;

/**
 * Interface about the diferente forms to calculate de game score
 * @param correctCount puntaje de letras acertadas
 * @param incorrectCount puntaje de letras no acertadas
 */
public interface GameScore{
    public int calculateScore(int correctCount , int incorrectCount );
}
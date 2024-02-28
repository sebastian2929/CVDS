package hangman.model;

public class OriginalScore implements GameScore{

    private int puntaje = 100;
    /**
     * @pre 100 puntos
     * @pos -10 letras incorrectas
     * @pos 0 min puntaje
     * @param correctCount puntaje de letras acertadas
     * @param incorrectCount puntaje de letras no acertadas
     * @throws
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        puntaje += (incorrectCount * -10);
        if(puntaje < 0){
            puntaje = 0;
        }
        return puntaje;
    }
    
}

package hangman.model;

public class BonusScore implements GameScore{

    private int puntaje = 0;
    /**
     * @pre 0 puntos
     * @pos -5 letras incorrectas
     * @pos +10 letras correctas
     * @pos 0 min puntaje
     * @param correctCount puntaje de letras acertadas
     * @param incorrectCount puntaje de letras no acertadas
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        puntaje += (correctCount * 10) - (incorrectCount * 5);
        if(puntaje < 0){
            puntaje = 0;
        }
        return puntaje;
    }
    
}

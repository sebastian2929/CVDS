package hangman.model;

public class PowerScore implements GameScore{
    private int puntaje = 0;
    /**
     * @pre 0 puntos
     * @pos -8 letras incorrectas
     * @pos 500 puntaje maximo
     * @pos 0 min puntaje tg
     * @param correctCount puntaje de letras acertadas
     * @param incorrectCount puntaje de letras no acertadas
     * @throws
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        int correct = correctCount;
        puntaje += (incorrectCount * -8) + (elevado(correct));
        if(puntaje < 0){
            puntaje = 0;
        }
        else if(puntaje > 500){
            puntaje = 500;
        }
        return puntaje;
    }

    private int elevado(int correct){
        int num = 1;
        if(correct > 0){
            for(int i = 0; i < correct; i++){
                num = num * 5;
            }
        }
        else{
            num = 0;
        }
        return num;
    }
}

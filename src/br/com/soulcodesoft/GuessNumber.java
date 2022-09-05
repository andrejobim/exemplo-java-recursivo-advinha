package br.com.soulcodesoft;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuessNumber {

    private static final Logger logger = Logger.getLogger(GuessNumber.class.getName());

    public static void main(String[] args) {
        Random random = new Random();
        int guess = random.nextInt(11);
        int tryGuess = 3;
        int numberTryGuess = 1;
        tryGuessAgain(guess, tryGuess, numberTryGuess);
    }

    private static void tryGuessAgain(int guess, int tryGuess, int numberTryGuess){
        tryGuess(guess, tryGuess, numberTryGuess);
        logger.log(Level.INFO,"Deseja tentar novamente ? (s/n) ");
        Scanner guessAgain = new Scanner(System.in);
        String againOption = guessAgain.next();
        if (againOption.equalsIgnoreCase("s")){
            tryGuessAgain(guess, tryGuess, numberTryGuess);
        }
    }

    private static void tryGuess(int guess, int tryGuess, int numberTryGuess){
        logger.log(Level.INFO, "Digite um valor de 0 a 10: ");
        Scanner putNumberGuess = new Scanner(System.in);
        int numberGuess = putNumberGuess.nextInt();
        if (guess != numberGuess && numberTryGuess < tryGuess){
            numberTryGuess++;
            tryGuess(guess, tryGuess, numberTryGuess);
        } else if (guess == numberGuess){
            logger.log(Level.INFO,"Parabéns, acertou o número!");
        } else {
            logger.log(Level.INFO,"Não foi dessa vez, boa sorte na próxima!");
        }
    }
}

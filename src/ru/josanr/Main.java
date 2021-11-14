package ru.josanr;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
        var anagram = new Anagram();
        Console console = System.console();
        String word = console.readLine("Enter anagram word: ");
        var invertedWord = anagram.inverseWord(word);
        System.out.println(invertedWord);
    }
}

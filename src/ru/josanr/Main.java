package ru.josanr;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
        var anagram = new Anagram();

        Console console = System.console();
        String words = console.readLine("Enter anagram words: ");
        var invertedWords = anagram.invertWords(words);
        System.out.println(invertedWords);
    }
}

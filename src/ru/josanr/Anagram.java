package ru.josanr;


public class Anagram {
    private String invertWord(String word) {

        char[] characterList = word.toCharArray();
        char[] resultList = new char[characterList.length];

        int rightIndex = characterList.length - 1;
        int leftIndex = 0;

        while (leftIndex < rightIndex) {
            char leftSymbol = characterList[leftIndex];
            char rightSymbol = characterList[rightIndex];

            if (!Character.isAlphabetic(leftSymbol)) {
                resultList[leftIndex] = leftSymbol;
                leftIndex++;
            }else if(!Character.isAlphabetic(rightSymbol)){
                resultList[rightIndex] = rightSymbol;
                rightIndex--;
            } else {
                resultList[rightIndex] = leftSymbol;
                resultList[leftIndex] = rightSymbol;
                rightIndex--;
                leftIndex++;
            }
        }
        return new String(resultList);
    }

    public String invertWords(String words) {
        var invertedPhrase = new StringBuilder();
        for(String word : words.split(" ")) {
            String invertedWord = this.invertWord(word);
            invertedPhrase.append(invertedWord);
            invertedPhrase.append(" ");
        }

        return invertedPhrase.toString().trim();
    }
}

package com.infogen.problems;

import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//tuple of prediction sorted high to low (max of 3 decimal place), or pad with 0
//same prediction sored alphabetically
class JPMorgenNGramTest {
    public static List<String> ngrams(String[] words, int size) {

        return IntStream.rangeClosed(1, size)
                .mapToObj(counter -> prepareSentence(words, counter, size))
                .collect(Collectors.toList());
    }

    private static String prepareSentence(String[] words, int startingPosition, int numberOfWords) {
        return Arrays.stream(words, startingPosition - 1, startingPosition + numberOfWords - 1)
                .collect(Collectors.joining(" ")).trim();
    }

    private final static String N_GRAM_TEXT = "Mary had a little lamb its fleece was white as snow; " +
            "And everywhere that Mary went, the lamb was sure to go. " +
            "It followed her to school one day, which was against the rule; " +
            "It made the children laugh and play, to see a lamb at school. " +
            "And so the teacher turned it out, but still it lingered near, " +
            "And waited patiently about till Mary did appear. " +
            "\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"";


    public static void main(String args[]) {

        final String input = "2,the";
        String output = new JPMorgenNGramTest().performNGram(input);
        System.out.println(output);
    }

    private String performNGram(final String input) {
        final String[] inputArray = input.split(",");
        final int numberOfWords = Integer.parseInt(inputArray[0]) - 1;
        final String nGramWord = inputArray[1];

        final String[] ngramTextArray = N_GRAM_TEXT.replaceAll("[^a-zA-Z\\s]", "").split(nGramWord + " ");

        final int skipArray = N_GRAM_TEXT.startsWith(nGramWord) ? 0 : 1;

        final Map<String, Long> ngrams = Arrays.stream(ngramTextArray)
                .skip(skipArray)
                .map(current -> current.split(" "))
                .map(words -> ngrams(words, numberOfWords))
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final float totalOccurrence = ngrams.values().stream().mapToLong(Long::valueOf).sum();

        final StringBuilder predictionScore = ngrams.entrySet().stream().sorted(Map.Entry.comparingByKey()).sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(StringBuilder::new, (r, e) -> accumulator(r, e, totalOccurrence), (a1, a2) -> {
                });

        predictionScore.deleteCharAt(predictionScore.length() - 1);
        return predictionScore.toString();

    }

    private void accumulator(final StringBuilder r, final Map.Entry<String, Long> currentEntry, Float total) {
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        r.append(currentEntry.getKey());
        r.append(",");
        r.append(decimalFormat.format(currentEntry.getValue() / total));
        r.append(";");
    }
}

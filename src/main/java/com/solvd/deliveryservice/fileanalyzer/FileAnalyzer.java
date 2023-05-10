package com.solvd.deliveryservice.fileanalyzer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



public class FileAnalyzer {
    private final static Logger LOGGER = LogManager.getLogger(FileAnalyzer.class);

    public static void main(String[] args) {

        wordCounter2("src/main/resources/text/sample.txt", "Word count:");
    }

    // using for each loop to remove punctuation
    public static void wordCounter1(String path, String myWord) {
        try {
            FileAnalyzer.LOGGER.info("Reading file");
            File file = new File(path);
            String text = StringUtils.lowerCase(FileUtils.readFileToString(file, "UTF-8"));
            String[] toRemove = {",", "?", "!", ".", "-", ":", ";", "/"};
            for (String el : toRemove) {
                text = StringUtils.remove(text, el);
            }
            Set<String> uniqueSet = new HashSet<>(Arrays.asList(StringUtils.split(text, " ")));
            FileAnalyzer.LOGGER.info("Creating new file at src/main/resources/text");
            File newFile = new File ("src/main/resources/text/output.txt");
            FileUtils.touch(newFile);
            FileAnalyzer.LOGGER.info("Writing to new file");
            FileUtils.write(newFile, myWord+" "+uniqueSet.size(), "UTF-8", false);
        } catch (IOException e) {
            FileAnalyzer.LOGGER.error(e.getMessage(), e);
        }
    }

    // using regex to remove punctuation
    public static void wordCounter2(String path, String myWord) {
        try {
            FileAnalyzer.LOGGER.info("Reading file");
            File file = new File(path);
            String text = StringUtils.lowerCase(FileUtils.readFileToString(file, "UTF-8"));
            String[] toRemove = {",", "?", "!", ".", "-", ":", ";", "/"};
            text = text.replaceAll("[\\p{Punct}&&[^']]+", "");
            Set<String> uniqueSet = new HashSet<>(Arrays.asList(StringUtils.split(text, " ")));
            FileAnalyzer.LOGGER.info("Creating new file at src/main/resources/text");
            File newFile = new File ("src/main/resources/text/output.txt");
            FileUtils.touch(newFile);
            FileAnalyzer.LOGGER.info("Writing to new file");
            FileUtils.write(newFile, myWord+" "+uniqueSet.size(), "UTF-8", false);
        } catch (IOException e) {
            FileAnalyzer.LOGGER.error(e.getMessage(), e);
        }
    }
}

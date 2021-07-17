package com.dskills.homeoffice.assigment.utils;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileReader {

    public File loadFileFromResources(String fileName) throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("testdata/" + fileName).getFile());
    }

    public List<String> findRegNumber(File file) throws IOException {
        String data = FileUtils.readFileToString(file, "UTF-8");
//        List<String> words = Arrays.asList(data.split(" "));
        String pat = "([A-Za-z]{2}[0-9]{2})\\s*[A-Za-z]{3}";
        Pattern pattern = Pattern.compile(pat);
        Matcher m = pattern.matcher(data);

        List<String> reg = new ArrayList<>();

        while (m.find()) {
            String group = m.group();
            reg.add(group);
        }
        return reg;
    }

    public List<String> readOutputData(File filepath) throws IOException {
        Path path = Paths.get(String.valueOf(filepath));
        return Files.lines(path).skip(1).collect(Collectors.toList());
    }

    @Test
    public void aM() throws IOException {
        List<String> reg = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("testdata/car_input.txt").getFile());
        String data = FileUtils.readFileToString(file, "UTF-8");
        String pat = "([A-Za-z]{2}[0-9]{2})\\s*[A-Za-z]{3}";
        Pattern pattern = Pattern.compile(pat);
        Matcher m = pattern.matcher(data);
        while (m.find()) {
            String group = m.group();
            reg.add(group);
        }
        reg.forEach(System.out::println);
    }
}

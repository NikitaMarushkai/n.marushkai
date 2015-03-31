package ru.kpfu.itis.group408.marushkai.encodings;

import java.io.*;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) {
	    Charset winCharset = Charset.forName("windows-1251");
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt"), winCharset))){
            String text = "Hello everyone";
            writer.write(text);
        } catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("out.txt"), winCharset))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

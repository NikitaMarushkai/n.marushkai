package ru.kpfu.itis.group408.marushkai.BracketConversion;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> stArray = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("code.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                stArray.add(line);
            }
            for (int i = 0; i < stArray.size(); i++){
                if (stArray.get(i).contains("{") && !stArray.get(i).contains("(")){
                    stArray.set(i-1, stArray.get(i-1) + " {");
                    stArray.set(i,"");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("result.txt"))){
            for (int i = 0; i < stArray.size(); i++){
                writer.write(stArray.get(i));
                writer.println();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

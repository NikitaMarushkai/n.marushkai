package ru.kpfu.itis.group408.marushkai.Archiver;

public class Main {
    public static void main(String[] args){
        Archiver zip = new Archiver();
        zip.unarchive("start.zip");
        zip.archive("archived.zip", new String[]{"first.txt", "second.txt", "third.txt", "fourth.txt"});
    }
}

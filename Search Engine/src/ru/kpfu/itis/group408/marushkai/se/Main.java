package ru.kpfu.itis.group408.marushkai.se;

public class Main {

    public static void main(String[] args) {
        Searcher searcher = new Searcher();
        ConsoleRead cr = new ConsoleRead(args);
        /*System.out.println(cr.depth);
        System.out.println(cr.folder);
        System.out.println(cr.isdepth);
        System.out.println(cr.mask);
        System.out.println(cr.recursion);
        System.out.println(cr.startAt);*/
        if (cr.recursion) {
            if (cr.folder) {
                try {
                    System.out.println(searcher.getAll(cr.startAt, cr.mask).toString());
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                try {
                    System.out.println(searcher.getFiles(cr.startAt, cr.mask).toString());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if(cr.isdepth){
            if (cr.folder) {
                try {
                    System.out.println(searcher.getAll(cr.startAt, cr.mask, cr.depth).toString());
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                try {
                    System.out.println(searcher.getFiles(cr.startAt, cr.mask).toString());
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }
}


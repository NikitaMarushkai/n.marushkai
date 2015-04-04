package ru.kpfu.itis.group408.marushkai.Set;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    MySet<String> set = new MySet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("fill the set");
        for (int i = 0; i < 5; i++){
            set.add(sc.next());
        }
        boolean a = true;
        System.out.println("here is your set");
        while (a){
            System.out.println(set.iterator().next());
            if (!set.iterator().hasNext())
                a = false;
        }
    }
}

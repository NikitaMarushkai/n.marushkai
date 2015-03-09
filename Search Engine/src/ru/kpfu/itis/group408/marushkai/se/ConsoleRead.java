package ru.kpfu.itis.group408.marushkai.se;

/**
 * Created by unlim_000 on 09.03.2015.
 */
public class ConsoleRead {
    public boolean recursion, folder = false, isdepth;
    public int depth;
    public String startAt, mask;
    public ConsoleRead(String[] str) {
        if (str.length == 0) {
            System.out.println("args are empty");
        } else {
            startAt = str[str.length - 2];
            mask = str[str.length - 1];
            int i = 0;
            while (!str[i].equals(startAt)) {
                if (str[i].contains("r") || str[i].contains("R")) {
                    recursion = true;
                }
                if (str[i].contains("d") || str[i].contains("D")) {
                    isdepth = true;
                    final int k = i;
                    depth = Integer.parseInt(str[k + 1]);
                }
                if (str[i].contains("v") || str[i].contains("V")) {
                    folder = true;
                }
                i++;
            }
        }
    }
}

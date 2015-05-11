package ru.kpfu.itis.group408.marushkai.Bank;

import java.util.Random;

/**
 * Created by unlim_000 on 09.05.2015.
 */
public class Client {

    private long cash, onCard;
    private long ID;

    public Client(long cash, long onCard){
        Random rd = new Random();
        this.cash = cash;
        this.onCard = onCard;
        this.ID = Math.abs(rd.nextLong());
    }

    public long getMoney(){
        return onCard;
    }

    public long setCard(long amount){
        onCard += amount;
        cash -= amount;
        return amount;
    }

    public void setCash(long amount){
        onCard -= amount;
        cash += amount;
    }

    public long getID(){
        return this.ID;
    }
}

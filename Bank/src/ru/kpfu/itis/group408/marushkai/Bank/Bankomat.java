package ru.kpfu.itis.group408.marushkai.Bank;

/**
 * Created by unlim_000 on 09.05.2015.
 */
public class Bankomat {

    private long money;

    public Bankomat(long money){
        this.money = money;
    }

    public long getMoney(Client client, long amount) {
        client.setCash(amount);
        this.money -= amount;
        return amount;
    }

    public void putMoney(Client client, long amount){
        client.setCard(amount);
        this.money += amount;
    }

    public long getBalance(Client client){
        return client.getMoney();
    }

    public long toBank(){
        return this.money;
    }
}

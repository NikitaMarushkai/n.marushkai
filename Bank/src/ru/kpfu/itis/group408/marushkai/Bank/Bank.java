package ru.kpfu.itis.group408.marushkai.Bank;

import java.util.HashMap;

/**
 * Created by unlim_000 on 09.05.2015.
 */
public class Bank {

    private long money;
    private HashMap<Long, Client> clients;

    public Bank(long money){
        this.money = money;
        clients = new HashMap<>();
    }

    public long getMoney(){
        return money;
    }

    public void putMoney(Bankomat bankomat){
        money += bankomat.toBank();
    }

    public void addClient(Client client){
        clients.put(client.getID(), client);
    }

    public void removeClient(Client client){
        clients.remove(client.getID());
    }

    public boolean hasClient(long ID){
        return clients.containsKey(ID);
    }

    public Client getClient(long ID){
        return clients.get(ID);
    }


}

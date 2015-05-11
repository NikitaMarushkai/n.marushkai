package ru.kpfu.itis.group408.marushkai.Bank;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Random rd = new Random();
    ArrayList<Long> IDs = new ArrayList<>();

    Bank bank = new Bank(1000000000);

    private void fillClients(){
        System.out.println("number of clients");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++){
            Client client = new Client(rd.nextLong(), rd.nextLong());
            bank.addClient(client);
            IDs.add(client.getID());
        }
        System.out.println("Clients IDs:");
        System.out.println(IDs.toString());
    }

    private class Bankomats implements Runnable{


        @Override
        public void run() {
            System.out.println("Enter the amount");
            Bankomat bankomat = new Bankomat(sc.nextLong());
            System.out.println("Choose what to do: 1 - put money, 2 - get money, 3 - get balance");
            int a = sc.nextInt();
            switch (a){
                case 1:
                    System.out.println("ID of a client");
                    long id = sc.nextLong();
                    if (bank.hasClient(id)) {
                        System.out.println("how much to put?");
                        bankomat.putMoney(bank.getClient(id), sc.nextLong());
                        bank.putMoney(bankomat);
                    }
                    System.out.println("The number of money now: ");
                    System.out.println("In the bank: " + bank.getMoney());
                    System.out.println("In the bankomat: " + bankomat.toBank());
                    break;
                case 2:
                    System.out.println("ID of a client");
                    long id2 = sc.nextLong();
                    if (bank.hasClient(id2)) {
                        System.out.println("how much to get?");
                        bankomat.getMoney(bank.getClient(id2), sc.nextLong());
                    }
                    System.out.println("The number of money now: ");
                    System.out.println("In the bank: " + bank.getMoney());
                    System.out.println("In the bankomat: " + bankomat.toBank());
                    break;
                case 3:
                    System.out.println("ID of a client");
                    long id3 = sc.nextLong();
                    if (bank.hasClient(id3)) {
                        System.out.println(bankomat.getBalance(bank.getClient(id3)));
                    }
                    break;
            }


        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.fillClients();
        System.out.println("enter the number of bankomats working with this bank");
        Bankomats[] bankomats = new Bankomats[sc.nextInt()];
        for (int i = 0; i < bankomats.length; i++){
            bankomats[i] = main.new Bankomats();
            Thread thread = new Thread(bankomats[i]);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

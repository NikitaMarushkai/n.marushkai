package ru.kpfu.itis.group408.marushkai.queue;

import java.util.ArrayList;

/**
 * Created by unlim_000 on 22.03.2015.
 */
public class Physical {
    Queue<String> queue = new ArrayQueue<String>();
    Deanery dr = new Deanery();

    /*public Physical(ArrayList<String> t){
        arrayList.addAll(t);
    }*/

    public void toQueue(){

       for (int i = 0; i < dr.getSize(); i++) {
           try {
               queue.offer(dr.getStudent());
           } catch (Exception e){
               System.out.println(e.getMessage());
           }
           try {
               if (queue.size() == queue.maxSize() - 1) {
                   while (!queue.isEmpty()) {
                       System.out.print(queue.poll() + " ");
                   }
                   System.out.println();
               }
           } catch (Exception e) {
               System.out.println(e.getMessage());
           }
       }
        try {
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

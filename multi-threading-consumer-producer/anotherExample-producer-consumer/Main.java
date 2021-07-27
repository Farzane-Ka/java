package com.example.awtSample;
import static com.example.awtSample.Main.EOF;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final String EOF="EOF";
    public static void main(String[] args) {
	// write your code here
        List<String> buffer = new ArrayList<String>();
        MyProducer producer=new MyProducer(buffer,Threadcolor.ANSI_BLUE);
        MyConsumer consumer1=new MyConsumer(buffer,Threadcolor.ANSI_GREEN);
        MyConsumer consumer2=new MyConsumer(buffer,Threadcolor.ANSI_CYAN);
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}
class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run(){
        Random random=new Random();
        String[] numbers={"1","2","3","4","5"};
        for (String num:numbers){
            try {
                System.out.println(color+"Adding ..."+num);
                synchronized (buffer){
                    buffer.add(num);
                }
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Thread was interrupted");
            }
        }
        System.out.println("Adding end of file");
        synchronized (buffer){
            buffer.add("EOF");
        }
    }
}
class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }
    public void run(){
        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty())
                    continue;
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    System.out.println(color + "Removing" + buffer.get(0));
                    buffer.remove(0);
                }
            }
        }
    }
}

package com.example.awtSample;

import java.util.Map;

public class Main {
    private static StockList stockList=new StockList();
    public static void main(String[] args) {
	// write your code here
        StockItem temp=new StockItem("bread",40,100);
        stockList.addStock(temp);

        temp=new StockItem("cake",20,90);
        stockList.addStock(temp);

        temp=new StockItem("car",100,90);
        stockList.addStock(temp);
        temp=new StockItem("chair",500,200);
        stockList.addStock(temp);
        temp=new StockItem("cup",20,90);
        stockList.addStock(temp);
        temp=new StockItem("cup",10,90);
        stockList.addStock(temp);
        temp=new StockItem("table",600,90);
        stockList.addStock(temp);
        temp=new StockItem("door",700,90);
        stockList.addStock(temp);
        temp=new StockItem("phone",1000,90);
        stockList.addStock(temp);

        System.out.println(stockList);// used the method toString in StockList
        for (String s:stockList.Items().keySet()){
            System.out.println(s);
        }
        Basket myBasket=new Basket("myBasket");
        sellItem(myBasket,"car",1);
        System.out.println(myBasket);// calls toString in Basket class

        sellItem(myBasket,"car",1);
        System.out.println(myBasket);

        sellItem(myBasket,"spinach",1);
        System.out.println(myBasket);
        for (Map.Entry<String, Double> price:stockList.priceList().entrySet()){
            System.out.println(price.getKey()+" costs "+price.getValue());
        }

    }
    public static int sellItem(Basket basket, String item, int quantity){
        //retrieve the item fro stock list first
       StockItem stockItem=stockList.get(item);
       if (stockItem==null){
           System.out.println("we do not sell "+item);
           return 0;
       }
       if (stockList.sellStock(item,quantity)!=0){
           basket.addToBasket(stockItem,quantity);
           return quantity;
       }
       return 0;
    }
}

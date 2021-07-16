package com.example.awtSample;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list=new LinkedHashMap<>();// adding the items in alphabetic order that were specified
    }
    public int addStock(StockItem item){
        if (item!=null){
            //check if we already have quantities of this item
            StockItem inStock=list.getOrDefault(item.getName(),item);
            //adjusting the quantity
            if (inStock!=item){
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(),item);
            return item.quantityInStock();
        }
        return 0;
    }
    public int sellStock(String item,int quantity){
        StockItem inStock = list.get(item);

        if((inStock != null) && (quantity > 0)) {
            return inStock.finalizeStock(quantity);
        }
        return 0;
       // StockItem inStock=list.getOrDefault(item,null);
       // if ((inStock!=null) && (inStock.quantityInStock()>=quantity) && quantity>0){
       //     inStock.adjustStock(-quantity);
        //    return quantity;
       // }
       // return 0;
    }
    public int reserveStock(String item, int quantity){
        StockItem stockItem=list.get(item);
        if((stockItem != null) && (quantity > 0)) {
            return stockItem.reserveStock(quantity);
        }
        return 0;
       // StockItem stockItem=list.get(item);
       // if (stockItem!=null && quantity>0){
        //    return stockItem.reserveStock(quantity);
       // }
       // return 0;
    }

    public int unReserveStock(String item, int quantity){
        StockItem stockItem=list.get(item);
        if (stockItem!=null && quantity>0){
            return stockItem.unReserveStock(quantity);
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }
    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(list);// returning a read only map list
    }
    public Map<String, Double> priceList(){
        Map<String,Double> priceList=new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item:list.entrySet()){
            priceList.put(item.getKey(),item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(priceList);
    }
    @Override
    public String toString() {
        String s="\nStockList\n";
        double totalCost=0.0;
        for (Map.Entry<String, StockItem> item:list.entrySet()){
            StockItem stockItem=item.getValue();
            double itemValue=stockItem.getPrice()*stockItem.quantityInStock();
            s=s+ stockItem+ " . there are "+ stockItem.quantityInStock()+ " in stock. Value of items: ";
            s=s+ String.format("%.2f",itemValue) + "\n";;
            totalCost+=itemValue;

        }
        return s+"Total stock value "+totalCost;
    }
}

package com.example.assignment2;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {
    //this class stores global variables

    private static ArrayList<String> favourites = new ArrayList<String>();
    private static ArrayList<String> cart = new ArrayList<>();

    private static String[] flowerNames = {
            "Sunflower","Rose","Tulip","Lily","Orchid","Carnation","Daffodil","Poppy","Anemone","Gladiolus"
    };
    private static String[] giftNames = {
            "Book","Television","Computer","Bracelet","Mug","Shirt","Painting","Movie","Necklace","Gift Card"
    };

    //these are the prices of all the flowers and gifts (gifts start at index 10)
    private static String[] prices = {"5.99","4.99","6.99","4.99","3.99","3.50","3.99","5.99","3.99","4.99","10.99","145.50","700.50","20.99","12.99","25.99","80.99","7.99","95.50","50"};




    public MyApplication(){

    }

    public static ArrayList<String> getFavourites() {
        return favourites;
    }

    public static void setFavourites(ArrayList favourites) {
        MyApplication.favourites = favourites;
    }

    public static ArrayList<String> getCart() {
        return cart;
    }

    public static void setCart(ArrayList<String> cart) {
        MyApplication.cart = cart;
    }

    public static String[] getPrices() {
        return prices;
    }

    public static void setPrices(String[] prices) {
        MyApplication.prices = prices;
    }

    public static String[] getFlowerNames() {
        return flowerNames;
    }

    public static void setFlowerNames(String[] flowerNames) {
        MyApplication.flowerNames = flowerNames;
    }

    public static String[] getGiftNames() {
        return giftNames;
    }

    public static void setGiftNames(String[] giftNames) {
        MyApplication.giftNames = giftNames;
    }
}

package com.company;

import java.io.*;
import java.util.ArrayList;


public class Database {
    private ArrayList<Object> list;

    Database(){
        list=new ArrayList<>();
    }

    /**
     * Добавление обьектов в list
     * @param object
     */
    public void add(Object object){
        list.add(object);
    }
    @Override
    public String toString() {
        return "Database{" +
                "list=" + list +
                '}';
    }

    /**
     * Сериализация , запись в файл всех обьектов переменной этого класса list
     * @param filename
     */
    public void save(String filename) {
        String date="";
        try {
            FileOutputStream fileOut = new FileOutputStream(filename+date);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.list);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Десериализация , считывание с файла всех обьектов
     * @param filename
     */
    public void load(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.list = (ArrayList<Object>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }
    public void clear(){
        this.list.clear();
    }
}

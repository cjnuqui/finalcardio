package com.example.finalcardio;

import android.util.Log;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class InMemoryDb {
    public static InMemoryDb instance;
    private ArrayList<Person> data;
    private InMemoryDb() {
        data = new ArrayList<>();
    }
    public void insertData(Person p) {data.add(p);
    }
    public static InMemoryDb getInstance() {
        if(instance == null) {
            Log.v("InMemoryDb", "calling instance");
            instance = new InMemoryDb();
        }
        return instance;

    }public ArrayList<Integer> getData() {
        return (ArrayList<Integer>) data.stream().map(p -> p.getAge()).collect(Collectors.toList());
    }

}


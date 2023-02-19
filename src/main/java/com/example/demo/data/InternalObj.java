package com.example.demo.data;

import lombok.Data;

import java.io.Serializable;

@Data
public class InternalObj implements Serializable {
    private int current;

    public void modify(int add){
        current+=add;
    }
}

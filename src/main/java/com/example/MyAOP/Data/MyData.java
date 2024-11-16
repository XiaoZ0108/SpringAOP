package com.example.MyAOP.Data;

import org.springframework.stereotype.Repository;

@Repository
public class MyData {

    public int[] getData(){
        return new int[]{1,2,3,4,5,6,7,8,9,10};
    }

}

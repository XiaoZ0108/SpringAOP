package com.example.MyAOP.Service;

import com.example.MyAOP.Annotations.TrackTime;
import com.example.MyAOP.Data.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyService {

    @Autowired
    private MyData myData;
    public int dummyMethod(int ...a){
        int [] data=myData.getData();
        return Arrays.stream(data).max().orElse(0);
    }

    public void throwErrorMethod(){
        throw new RuntimeException("dummy error");
    }

    //for performance aop
    @TrackTime
    public void dummyMethod2() throws Exception {
        long sleepTime = (long)(Math.random() * 5000);
        Thread.sleep(sleepTime);
    }
}

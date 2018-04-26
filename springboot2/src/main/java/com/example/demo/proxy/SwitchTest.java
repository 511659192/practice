package com.example.demo.proxy;

import org.springframework.cglib.core.Signature;

/**
 * Created by ym on 2018/4/16.
 */
public class SwitchTest {

    public int getIndex(Integer code) {
        switch(code) {
            case -1422510685:
                return 1;
            case 1826985398:
                return 2;
        }
        return -1;
    }
}

package com.example.demo.mock;

import org.mockito.Mockito;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * Created by ym on 2018/4/1.
 */
public class MockTest {
    public static void main(String[] args) {
        Entity<String> entity = Mockito.mock(Entity.class);
        Mockito.when(entity.getObject()).thenReturn("111");
        Mockito.when(entity.getA()).thenReturn("222");
        System.out.println(entity.getObject());
        System.out.println(entity.getA() + "");
    }
}

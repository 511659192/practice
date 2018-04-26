package com.example.demo.orika;

import com.alibaba.fastjson.JSON;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.test.json.JsonbTester;

import java.util.ArrayList;

/**
 * Created by ym on 2018/3/31.
 */
public class OrikaTest {
    public static void main(String[] args) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Person.class, PersonDto.class)
                .field("names{fullName}", "personalNames{key}")
                .field("names{}", "personalNames{value}")
                .register();
        Name name = new Name();
        name.setFirst("first");
        name.setLast("last");
        name.setFirst("first last");
        Person person = new Person();
        person.setNames(new ArrayList<>());
        person.getNames().add(name);

        PersonDto dto = mapperFactory.getMapperFacade().map(person, PersonDto.class);
        System.out.println(JSON.toJSONString(dto));
    }
}

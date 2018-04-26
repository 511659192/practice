package com.example.demo.orika;

import java.util.List;
import java.util.Map;

/**
 * Created by ym on 2018/3/31.
 */
public class PersonDto<T> {
    private Map<String, Name> personalNames;
    private String[] firstNames;
    private List<String> lastNames;
    private List<T> objects;

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public Map<String, Name> getPersonalNames() {
        return personalNames;
    }

    public void setPersonalNames(Map<String, Name> personalNames) {
        this.personalNames = personalNames;
    }

    public String[] getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String[] firstNames) {
        this.firstNames = firstNames;
    }

    public List<String> getLastNames() {
        return lastNames;
    }

    public void setLastNames(List<String> lastNames) {
        this.lastNames = lastNames;
    }
}


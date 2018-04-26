package com.example.demo.classConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ym on 2018/4/1.
 */
public class Mapper {

    public Entity mapper(Entity source) {
        Entity target = new Entity();
        target.setField01(source.getField02());
        target.setField02(source.getField01());
        target.setField03(source.getField03());
        target.setField04(source.getField04());
        target.setField05(source.getField05());
        target.setField06(source.getField06());
        target.setField07(source.getField07());
        target.setField08(source.getField08());
        target.setField09(source.getField04());
        target.setField10((long) source.getField03());
        target.setField11(source.isField11());
        target.setField12(source.getField12());
        target.setField13(source.getField13());
        target.setField14(source.getField14());
        target.setField15(source.getField15());
        target.setField16(source.getField16());
        return target;

    }

}


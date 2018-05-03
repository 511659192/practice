package com.spring.beans.factory;

import com.google.common.base.Preconditions;
import com.spring.beans.factory.AliasRegistry;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ym on 2018/4/26.
 */
public class DefaultAliasRegstry implements AliasRegistry {

    private final Map<String, String> aliasMap = new ConcurrentHashMap<String, String>(256);

    public String getAliasIfExist(String beanName) {
        String alias = aliasMap.get(beanName);
        if (StringUtils.isNotBlank(alias)) {
            return alias;
        }
        return beanName;
    }

    @Override
    public void registerAlias(String beanName, String alias) {
        Preconditions.checkArgument(StringUtils.isNotBlank(beanName));
        Preconditions.checkArgument(StringUtils.isNotBlank(alias));
        aliasMap.put(alias, beanName);
    }
}

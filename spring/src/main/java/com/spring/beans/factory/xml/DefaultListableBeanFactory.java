package com.spring.beans.factory.xml;

import com.google.common.base.Preconditions;
import com.spring.beans.factory.config.BeanDefinition;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ym on 2018/4/26.
 */
public class DefaultListableBeanFactory extends AbstractBeanFactory implements BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);
    private volatile List<String> beanDefinitionNames = new ArrayList<String>(256);

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        Preconditions.checkArgument(StringUtils.isNotBlank(beanName));
        Preconditions.checkNotNull(beanDefinition);
        beanDefinitionMap.put(beanName, beanDefinition);
        beanDefinitionNames.add(beanName);
    }

    public BeanDefinition getBeanDefinition(String beanName) throws RuntimeException {
        BeanDefinition bd = this.beanDefinitionMap.get(beanName);
        if (bd == null) {
            throw new RuntimeException("not found of bean" + beanName);
        }
        return bd;
    }
}

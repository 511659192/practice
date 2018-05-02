package com.spring.beans.factory.xml;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ym on 2018/4/30.
 */
public class DefaultSingletonBeanRegistry extends DefaultAliasRegstry {
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);
    private final Map<String, Object> earlySingletonObjects = new HashMap<>(16);
    private final Set<String> singletonsCurrentlyInCreation = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>(16));
    private final Set<String> registeredSingletons = new LinkedHashSet<>(256);

    public Object getSingleton(String beanName) {
        Object singletonObject = this.singletonObjects.get(beanName);
        if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
            synchronized (this.singletonObjects) {
                singletonObject = this.earlySingletonObjects.get(beanName);
                if (singletonObject == null) {
                    ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
                    if (singletonFactory != null) {
                        singletonObject = singletonFactory.getObject();
                        this.earlySingletonObjects.put(beanName, singletonObject);
                        this.singletonFactories.remove(beanName);
                    }
                }
            }
        }
        return singletonObject;
    }

    public Object getSingleton(String beanName, ObjectFactory<Object> singletonFactory) {
        Object bean = null;
        synchronized (this.singletonObjects) {
            bean = this.singletonObjects.get(beanName);
            if (bean != null) {
                return bean;
            }

            beforeSingletonCreation(beanName);
            boolean newSingleton = false;
            try {
                bean = singletonFactory.getObject();
                newSingleton = true;
            } catch (RuntimeException ex) {
                bean = this.singletonObjects.get(beanName);
                if (bean == null) {
                    throw ex;
                }
            } finally {
                afterSingletonCreation(beanName);
            }

            if (newSingleton) {
                addSingleton(beanName, bean);
            }
        }
        return bean;
    }

    private void addSingleton(String beanName, Object bean) {
        synchronized (this.singletonObjects) {
            this.singletonObjects.put(beanName, bean);
            this.singletonFactories.remove(beanName);
            this.earlySingletonObjects.remove(beanName);
            this.registeredSingletons.add(beanName);
        }
    }

    private void afterSingletonCreation(String beanName) {
        if (!this.singletonsCurrentlyInCreation.remove(beanName)) {
            throw new RuntimeException("bean is not creating at this container " + beanName);
        }
    }

    private void beforeSingletonCreation(String beanName) {
        if (!this.singletonsCurrentlyInCreation.add(beanName)) {
            throw new RuntimeException("bean is creating");
        }
    }

    public boolean isSingletonCurrentlyInCreation(String beanName) {
        return this.singletonsCurrentlyInCreation.contains(beanName);
    }

}

package com.spring.beans.factory;

import com.spring.beans.BeanWrapper;
import com.spring.beans.BeanWrapperImpl;
import com.spring.beans.factory.config.BeanDefinition;

/**
 * Created by ym on 2018/5/2.
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    private InstantiationStrategy instantiationStrategy = new DefaultInstantiationStrategy();

    public <T> T getBean(String name) throws RuntimeException {
        final String beanName = getAliasIfExist(name);
        Object instance = getSingleton(beanName);
        if (instance != null) {
            return (T) instance;
        }

        final BeanDefinition beanDefinition = getBeanDefinition(beanName);
        instance = getSingleton(beanName, new ObjectFactory<Object>() {
            @Override
            public Object getObject() throws RuntimeException {
                return createBean(beanName, beanDefinition);
            }
        });
        return (T) instance;
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class<?> clazz = resolveBeanClass(beanDefinition, beanName);
        Object bean = null;
        try {
            bean = resolveBeforeInstantiation(beanName, beanDefinition);
            if (bean != null) {
                return bean;
            }
            bean = doCreateBean(beanName, beanDefinition);
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        BeanWrapper beanWrapper = createBeanInstance(beanName, beanDefinition);

        return null;
    }

    private BeanWrapper createBeanInstance(String beanName, BeanDefinition beanDefinition) {
        if (beanDefinition.hasConstractArgumentValues()){
            return autowireByConstractor(beanName, beanDefinition);
        }
        return instantiateBean(beanName, beanDefinition);
    }

    private BeanWrapper autowireByConstractor(String beanName, BeanDefinition beanDefinition) {
        return null;
    }

    private BeanWrapper instantiateBean(String beanName, BeanDefinition beanDefinition) {
        Object instance = getInstantiationStrategy().instantiate(beanDefinition, beanName);
        BeanWrapper wrapper = new BeanWrapperImpl(instance);
        initBeanWrapper(wrapper);
        return wrapper;
    }

    private void initBeanWrapper(BeanWrapper wrapper) {
//        bw.setConversionService(getConversionService());
//        registerCustomEditors(bw);
    }

    private Object resolveBeforeInstantiation(String beanName, BeanDefinition beanDefinition) {
        return null;
    }

    private Class<?> resolveBeanClass(BeanDefinition beanDefinition, String beanName) {
        if (beanDefinition.hasBeanClass()) {
            return beanDefinition.getBeanClass();
        }
        Class<?> clazz = beanDefinition.resolveBeanClass();
        return clazz;
    }

    protected InstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);
}

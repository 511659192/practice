package com.spring.beans.factory;

import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.spring.beans.BeanDefinitionValueResolver;
import com.spring.beans.BeanWrapper;
import com.spring.beans.BeanWrapperImpl;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.config.PropertyValue;
import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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

    private Object doCreateBean(final String beanName, final BeanDefinition beanDefinition) {
        BeanWrapper beanWrapper = createBeanInstance(beanName, beanDefinition);
        final Object bean = beanWrapper.getWrappedObject();
        boolean earlySingletonExposure = isSingletonCurrentlyInCreation(beanName);
        if (earlySingletonExposure) {
            addSingletonFactory(beanName, new ObjectFactory<Object>() {
                @Override
                public Object getObject() throws RuntimeException {
                    return getEarlyBeanReference(beanName, beanDefinition, bean);
                }
            });
        }

        Object exposedObject = bean;
        populateBean(beanName, beanDefinition, beanWrapper);

        return beanWrapper.getWrappedObject();
    }

    private void populateBean(String beanName, BeanDefinition beanDefinition, BeanWrapper beanWrapper) {
        Preconditions.checkNotNull(beanWrapper);

        List<PropertyValue> propertyValues = beanDefinition.hasPropertyValues() ? beanDefinition.getPropertyValues() : null;
        if (propertyValues == null) {
            return;
        }
        BeanDefinitionValueResolver valueResolver = new BeanDefinitionValueResolver(this);

        for (PropertyValue propertyValue : propertyValues) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            value = valueResolver.resolveValueIfNecessary(propertyValue, value);
            for (PropertyDescriptor propertyDescriptor : beanWrapper.getPropertyDescriptors()) {
                if (propertyDescriptor.getName().equals(name)) {
                    try {
                        propertyDescriptor.getWriteMethod().invoke(beanWrapper.getWrappedObject(), value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private Object getEarlyBeanReference(String beanName, BeanDefinition beanDefinition, Object bean) {
        return bean;
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

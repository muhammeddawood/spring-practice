package com.sp.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		System.out.println(" post processor 'postProcessBeforeInitialization'  called for bean name :" + beanName);
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(" post processor 'postProcessAfterInitialization'  called for bean name :" + beanName);
		return bean;
	}
	

}
 
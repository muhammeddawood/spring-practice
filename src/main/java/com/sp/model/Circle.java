package com.sp.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.sp.listener.DrawEvent;

@Component
//@Repository
//@Controller
//@Service
public class Circle implements ApplicationEventPublisherAware, Shape {
	private Point center;
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	public void draw() {
		System.out.println("Drawing circle");
		DrawEvent event = new DrawEvent(this);
		publisher.publishEvent(event);

	}

	public Point getCenter() {
		return center;
	}
	
	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	@PostConstruct
	public void intializeCircle() {
		System.out.println("Circle initializing greeting : " + messageSource.getMessage("greetings", new Object[]{}, null));
		System.out.println("Initialize circle");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroy circle");
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void setApplicationEventPublisher(
			ApplicationEventPublisher applicationEventPublisher) {
		publisher = applicationEventPublisher;
	}

}

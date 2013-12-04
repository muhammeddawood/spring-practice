package com.rest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.springframework.http.MediaType;

public class TodoTest extends JerseyTest {

	@Override
	protected Application configure() {
		ResourceConfig config = new ResourceConfig(TodoResource.class, JacksonFeature.class);
		return config; 
	}
	
	@Test
	public void testGetTodo() {
		System.out.println(target("todo").path("1").request().accept(MediaType.APPLICATION_JSON_VALUE).get(String.class));
		System.out.println(target("todo").path("2").request().accept(MediaType.APPLICATION_XML_VALUE).get(String.class));
		System.out.println(target("todo").path("2").request().accept(MediaType.APPLICATION_XML_VALUE).delete());
		final Todo todo = new Todo("3", "JAX-RS 2.0");
		System.out.println(target("todo").request(MediaType.APPLICATION_XML_VALUE).put(Entity.entity(todo, MediaType.APPLICATION_XML_VALUE)));
		System.out.println(target("todo").path("3").request().accept(MediaType.TEXT_XML.getType()).get(String.class));
		System.out.println(target("todo").path("all").request().accept(MediaType.APPLICATION_JSON_VALUE).get(String.class));
	}
}

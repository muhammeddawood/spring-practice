package com.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

@Path("/todo")
public class TodoResource {
	@Context
	private UriInfo uriInfo;
	@Context
	private Request request;

	public TodoResource() {
	}

	public TodoResource(UriInfo uriInfo, Request request) {
		this.uriInfo = uriInfo;
		this.request = request;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{id}")
	public Todo getTodoXml(@PathParam("id") String id) {
		return TodoRepository.instance.getModel().get(id);
	}

	@GET
	@Produces({ MediaType.TEXT_XML })
	@Path("{id}")
	public Todo getHTML(@PathParam("id") String id) {
		return TodoRepository.instance.getModel().get(id);
	}

	@DELETE
	@Path("{id}")
	public void deleteTodo(@PathParam("id") String id) {
		Todo c = TodoRepository.instance.getModel().remove(id);
		if (c == null)
			throw new RuntimeException("Delete: Todo with " + id + " not found");
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putTodo(JAXBElement<Todo> todo) {
		Todo c = todo.getValue();
		return putAndGetResponse(c);
	}

	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Todo> getTodos() {
		List<Todo> todos = new ArrayList<Todo>();
		todos.addAll(TodoRepository.instance.getModel().values());
		return todos;
	}

	private Response putAndGetResponse(Todo todo) {
		Response res;
		if (TodoRepository.instance.getModel().containsKey(todo.getId())) {
			res = Response.noContent().build();
		} else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		TodoRepository.instance.getModel().put(todo.getId(), todo);
		return res;
	}
}

package com.acme.todolist.adapters.rest_api;

import java.util.List;

import javax.inject.Inject;

import com.acme.todolist.application.port.in.AddTodoItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.domain.TodoItem;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {
	
	
	private GetTodoItems getTodoItemsQuery;
	// A compléter
	private AddTodoItem addTodoItem;
	
	@Inject
	//A compléter
	public TodoListController(GetTodoItems getTodoItemsQuery,AddTodoItem addTodoItem ) {
		this.addTodoItem = addTodoItem;
		this.getTodoItemsQuery = getTodoItemsQuery;
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQuery.getAllTodoItems();
	}
	
	
	// Endpoint de type POST vers "/todos"
	// A compléter
	@PostMapping("/todos")
	@ResponseStatus(HttpStatus.CREATED)
	public void ajouterItem(@RequestBody TodoItem item) {
		// A compléter
		this.addTodoItem.addTodoItem(item);
	}
	
	
}

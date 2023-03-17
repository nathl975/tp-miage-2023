package com.acme.todolist;

import com.acme.todolist.adapters.rest_api.TodoListController;
import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.application.service.GetTodoItemsService;
import com.acme.todolist.configuration.TodolistApplication;
import com.acme.todolist.domain.TodoItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Inject;

import java.time.Instant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TodolistApplication.class)
@AutoConfigureMockMvc
class TodolistApplicationTests {
	@Inject
	TodoListController controller;

	@Inject
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void getTodosReturnsNewTodo() throws Exception {
		TodoItem item = new TodoItem("0f8-06eb17ba8d35", Instant.parse("2020-02-27T10:31:43Z"), "Cuire le pain");

		controller.ajouterItem(item);
		this.mockMvc.perform(get("/todos")).andDo(print()).andExpect(status().isOk())
				.andExpect( content().string(containsString("Cuire le pain")));
	}
}

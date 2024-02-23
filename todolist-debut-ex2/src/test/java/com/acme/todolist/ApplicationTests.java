package com.acme.todolist;

import com.acme.todolist.domain.TodoItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void onTimeItemShouldNotHaveModifiedContent() throws Exception{

		Instant time = Instant.now();

		TodoItem todoItem = new TodoItem("0f8-06eb17ba8d34", time, "Faire les courses");
		assertEquals( "Faire les courses", todoItem.finalContent(), "Le contenu devrait être identique si il n'a pas de retard");
	}

	@Test
	public void LateItemShouldHaveContentWithLateAtBeginning() throws Exception{
		Instant time = Instant.parse("2020-02-27T10:31:43Z");
		TodoItem todoItem = new TodoItem("0f8-06eb17ba8d34", time, "Faire les courses");

		assertEquals("[LATE!] Faire les courses", todoItem.finalContent(), "Le contenu devrait être différent si il y a du retard");
	}

}

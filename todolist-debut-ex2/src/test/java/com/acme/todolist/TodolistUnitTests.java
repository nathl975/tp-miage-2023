package com.acme.todolist;

import com.acme.todolist.domain.TodoItem;
import org.junit.jupiter.api.Test;
import java.time.Instant;

class TodolistUnitTests {
    @Test
    void textContainsIsLate() {
        TodoItem itemLate = new TodoItem("0f8-06eb17ba8d35", Instant.parse("2020-02-27T10:31:43Z"), "Faire les courses");

        assert(itemLate.finalContent().contains("[LATE!] "));
    }
}

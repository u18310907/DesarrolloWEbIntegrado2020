package net.java.guides.todoapp.dao;
import java.sql.SQLException;
import java.util.List;
import net.java.guides.todoapp.model.Todo;
public interface TodoDao {
	void insertTodo(Todo todo) throws SQLException;

	 Todo selectTodo(long todoId);

	 List<Todo> selectAllTodos();

	 boolean deleteTodo(int id) throws SQLException;

	 boolean updateTodo(Todo todo) throws SQLException;
}

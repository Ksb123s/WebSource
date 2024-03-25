package service;

import java.util.List;

import dto.TodoDto;

// DAO의 CRUD 메소드를 호출
// 서비스 메소드
public interface TodoService {
    List<TodoDto> list();

    TodoDto getRow(String no);

    boolean insert(TodoDto inserDto);

    boolean update(TodoDto inserDto);

    boolean delete(String no);
}

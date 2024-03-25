package service;

import java.util.List;

import dto.BookDto;
import dto.ChangeDto;
import dto.MemberDto;

public interface BookService {
    // DAO 호출
    // CRUD - 조회,검색,삽입,삭제,수정
    BookDto read(int code);

    List<BookDto> listAll();

    List<BookDto> searhListAll(String criteria, String keyword);

    boolean create(BookDto insertDto);

    boolean update(BookDto insertDto);

    boolean delete(int code);

    // 멤버

    MemberDto login(MemberDto loginDto);

    boolean pwdChange(ChangeDto changeDto);

    boolean register(MemberDto registerDto);

    boolean Leave(MemberDto LeaveDto);
}

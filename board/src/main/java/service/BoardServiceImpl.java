package service;

import java.util.List;

import dao.BoardDao;
import dto.BoardDto;

public class BoardServiceImpl implements BoardService {
    BoardDao dao = new BoardDao();

    @Override
    public List<BoardDto> list() {
        return dao.getList();
    }

    @Override
    public Boolean insert(BoardDto insertDto) {

        return dao.create(insertDto) == 1;
    }

    @Override
    public BoardDto getRow(int bno) {

        return dao.getRow(bno);
    }

}

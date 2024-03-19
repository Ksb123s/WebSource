package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.ToDoDto;

public class ToDoDao {
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    // JDBC 단계
    // 1. Driver Load
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 2. 커낵션 얻기
    public Connection getConnection() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "c##test2";
        String password = "test";

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }

    // 3. sql 작업
    // 전체조회 READ
    public List<ToDoDto> getList() {
        List<ToDoDto> list = new ArrayList<>();

        con = getConnection();
        String sql = "select NO,title,created_at,completed from todotbl order by NO desc";
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ToDoDto dto = new ToDoDto();
                dto.setNo(rs.getInt("no"));
                dto.setTitle(rs.getString("title"));
                dto.setCreatedAt(rs.getDate("created_at"));
                dto.setCompleted(rs.getBoolean("completed"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }

        return list;
    }

    // 개별 조회
    public ToDoDto getRow(String no) {
        ToDoDto dto = null;

        con = getConnection();
        String sql = "select * from todotbl where no=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(no));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new ToDoDto();
                dto.setNo(rs.getInt("no"));
                dto.setTitle(rs.getString("title"));
                dto.setCreatedAt(rs.getDate("created_at"));
                dto.setCompleted(rs.getBoolean("completed"));
                dto.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }

        return dto;
    }

    // 추가
    public int insert(ToDoDto insertDto) {
        int result = 0;

        con = getConnection();
        String sql = "INSERT INTO TODOTBL(NO, TITLE, DESCRIPTION) VALUES(todo_seq.NEXTVAL, ?, ?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, insertDto.getTitle());
            pstmt.setString(2, insertDto.getDescription());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;
    }

    // 수정
    public int update(ToDoDto insertDto) {
        int result = 0;
        con = getConnection();
        String sql = "UPDATE TODOTBL SET COMPLETED = ?, DESCRIPTION = ? WHERE NO = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setBoolean(1, insertDto.isCompleted());
            pstmt.setString(2, insertDto.getDescription());
            pstmt.setInt(3, insertDto.getNo());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;
    }

    // 4. 자원 정리
    public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close(Connection con, PreparedStatement pstmt) {
        try {
            if (pstmt != null)
                pstmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

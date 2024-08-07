package com.jsp.jsp_board.DAO;

import com.jsp.jsp_board.DTO.TestDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/database-tong.cnasam86gevz.ap-northeast-2.rds.amazonaws.com";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "15689725";

    public TestDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TestDTO> getAllBoards() {
        List<TestDTO> boardList = new ArrayList<>();
        String sql = "SELECT * FROM search";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                TestDTO test = new TestDTO();
                test.setSearchId(rs.getInt("search_id"));
                test.setContent(rs.getString("content"));
                // 필요한 필드들을 추가로 설정

                boardList.add(test);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return boardList;
    }

    private void close() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

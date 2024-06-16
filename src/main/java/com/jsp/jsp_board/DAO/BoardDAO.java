package com.jsp.jsp_board.DAO;

import com.jsp.jsp_board.DTO.BoardDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // MySQL 연결 설정 (실제 환경에 맞게 수정 필요)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/database-tong.cnasam86gevz.ap-northeast-2.rds.amazonaws.com";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "15689725";

    public BoardDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<BoardDTO> getAllBoards() {
        List<BoardDTO> boardList = new ArrayList<>();
        String sql = "SELECT * FROM board";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDTO board = new BoardDTO();
                board.setId(rs.getInt("id"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                // 필요한 필드들을 추가로 설정

                boardList.add(board);
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

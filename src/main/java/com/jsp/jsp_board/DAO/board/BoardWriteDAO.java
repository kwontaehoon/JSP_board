package com.jsp.jsp_board.DAO.board;

import com.jsp.jsp_board.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWriteDAO {

    // 글 작성 메서드
    public boolean writeBoard(String title, String content, String category, String subCategory, int hits,
                              int recommend, int userId, int commentCount) {

        System.out.println("boardWrite DAO");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean isSuccess = false;

        // 현재 날짜 가져오기
        java.util.Date currentDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

        String query = "INSERT INTO board (title, content, category, sub_category, hits, recommend, create_date, user_id, comment_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, category);
            ps.setString(4, subCategory);
            ps.setInt(5, hits);
            ps.setInt(6, recommend);
            ps.setDate(7, sqlDate);
            ps.setInt(8, userId);
            ps.setInt(9, commentCount);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("A new row was inserted successfully!");
                isSuccess = true;
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            // 연결 종료
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }

        return isSuccess;
    }
}

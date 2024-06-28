package com.jsp.jsp_board.servlet;

import com.jsp.jsp_board.DBConnect;
import com.jsp.jsp_board.DTO.TestDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/t")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("TestServlet");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TestDTO> testList = new ArrayList<>();

        String query = "SELECT * FROM search";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            // 결과 데이터를 TestDTO 객체 리스트로 변환
            while (rs.next()) {
                TestDTO test = new TestDTO();
                test.setSearchId(rs.getInt("search_id"));
                test.setContent(rs.getString("content"));
                testList.add(test);
            }

            // 데이터를 request에 설정하여 JSP 페이지로 전달
            request.setAttribute("testData", testList);
            request.getRequestDispatcher("/test.jsp").forward(request, response);

        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("id");
        String userPassword = request.getParameter("password");

        System.out.println("ddddd userId userPassword: " + userId + userPassword);

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConnect.getConnection();
            System.out.println("Connected to the database test postmethod");

            // 현재 날짜 가져오기
            java.util.Date currentDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

            // 'board' 테이블에 데이터 삽입
            String insertSQL = "INSERT INTO `board` (comment_count, hits, recommend, create_date, user_id, category, content, title, sub_category) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(insertSQL);
            ps.setInt(1, 3);
            ps.setInt(2, 1);
            ps.setInt(3, 1);
            ps.setDate(4, sqlDate);
            ps.setInt(5, 2);
            ps.setString(6, "test");
            ps.setString(7, "test_content");
            ps.setString(8, "test_title");
            ps.setString(9, "test");

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new row was inserted successfully!");
            }

            // 데이터를 request에 설정하여 JSP 페이지로 전달
            request.getRequestDispatcher("/board.jsp").forward(request, response);

        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        } finally {
            // 연결 종료
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}

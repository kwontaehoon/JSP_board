package com.jsp.jsp_board.servlet;

import com.jsp.jsp_board.DTO.TestDTO;
import org.apache.commons.dbcp2.BasicDataSource;

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
public class    TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "jdbc:mysql://database-tong.cnasam86gevz.ap-northeast-2.rds.amazonaws.com:3306/tong";
        String user = "admin";
        String password = "15689725";

        // MySQL JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("MySQL JDBC Driver not found", e);
        }

        Connection connection = null;
        List<TestDTO> testList = new ArrayList<>();

        try {
            // 데이터베이스 연결
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database test getmethod");

            // 'board' 테이블 데이터 조회
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM search");

            // 결과 데이터를 Board 객체 리스트로 변환
            while (resultSet.next()) {
                TestDTO test = new TestDTO();
                test.setSearchId(resultSet.getInt("search_id"));
                test.setContent(resultSet.getString("content"));
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
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "jdbc:mysql://database-tong.cnasam86gevz.ap-northeast-2.rds.amazonaws.com:3306/tong";
        String user = "admin";
        String password = "15689725";

        String userId = request.getParameter("id");
        String userPassword = request.getParameter("password");

        System.out.println("ddddd userId userPassword: " + userId + userPassword);

        // MySQL JDBC 드라이버 로드
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("MySQL JDBC Driver not found", e);
        }

        Connection connection = null;

        try {
            // 데이터베이스 연결
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database test postmethod");

            // 현재 날짜 가져오기
            java.util.Date currentDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

            // 'board' 테이블에 데이터 삽입
            String insertSQL = "INSERT INTO `board` (comment_count, hits, recommend, create_date, user_id, category, content, title, sub_category) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, 3);
            preparedStatement.setInt(2, 1);
            preparedStatement.setInt(3, 1);
            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setInt(5, 2);
            preparedStatement.setString(6, "test");
            preparedStatement.setString(7, "test_content");
            preparedStatement.setString(8, "test_title");
            preparedStatement.setString(9, "test");

            int rowsInserted = preparedStatement.executeUpdate();
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
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
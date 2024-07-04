package com.jsp.jsp_board.servlet.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "/signUpServlet", value = "/signUp")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/t").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

        String url = "jdbc:mysql://database-tong.cnasam86gevz.ap-northeast-2.rds.amazonaws.com:3306/tong";
        String user = "admin";
        String password = "15689725";

        String userId = request.getParameter("id");
        String userPassword = request.getParameter("password");
        String userName = request.getParameter("name");
        String userNickName = request.getParameter("nickName");
        String userEmail = request.getParameter("email");
        String userBirth = request.getParameter("birth");

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
            String insertSQL = "INSERT INTO `users` (id, password, name, nick_name, email, birth, position, profile, user_role, marketing_flag, expire_date, expire_reason, create_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, userPassword);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, userNickName);
            preparedStatement.setString(5, userEmail);
            preparedStatement.setString(6, userBirth);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 0);
            preparedStatement.setString(9, "user");
            preparedStatement.setInt(10, 0);
            preparedStatement.setDate(11, sqlDate);
            preparedStatement.setString(12, "다른 계정이 있어요.");
            preparedStatement.setDate(13, sqlDate);


//            int rowsInserted = preparedStatement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("A new row was inserted successfully!");
//
//                // 데이터를 request에 설정하여 JSP 페이지로 전달
//                // request.getRequestDispatcher("/test.jsp").forward(request, response);
//                response.sendRedirect(request.getContextPath() + "/main");
//            }

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

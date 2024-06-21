package com.jsp.jsp_board.servlet;

import com.jsp.jsp_board.DTO.BoardDTO;
import com.jsp.jsp_board.DTO.UserDTO;
import com.jsp.jsp_board.utill.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet(name = "/emailLoginServlet", value = "/emailLogin")
public class EmailLoginServlet extends HttpServlet {

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

        System.out.println(userId);
        System.out.println(userPassword);

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

            String selectSQL = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("resultSet: " + resultSet);

            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("password");

                if (BCrypt.checkPassword(userPassword, hashedPassword)) {
                    System.out.println("Password matches, redirecting to main page");
                    response.sendRedirect(request.getContextPath() + "/main");
                } else {
                    System.out.println("Password does not match, redirecting to login failed page");
//                    response.sendRedirect(request.getContextPath() + "/loginFailed.jsp");
                }
            } else {
                System.out.println("User does not exist, redirecting to login failed page");
                request.setAttribute("loginError", "User does not exist");
                request.getRequestDispatcher(request.getContextPath() + "/emailLogin").forward(request, response);
            }


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

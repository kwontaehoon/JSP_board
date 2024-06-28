package com.jsp.jsp_board.servlet;

import com.jsp.jsp_board.DBConnect;
import com.jsp.jsp_board.DTO.BoardDTO;
import com.jsp.jsp_board.DTO.UserDTO;
import com.jsp.jsp_board.utill.BCrypt;
import com.jsp.jsp_board.utill.Effectiveness;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "/emailLoginServlet", value = "/emailLogin")
public class EmailLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/t").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

        System.out.println("emailLoginServlet");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        HttpSession session = request.getSession();

        String query = "SELECT * FROM users";
        String userId = request.getParameter("id");
        String userPassword = request.getParameter("password");

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                String hashedId = rs.getString("id");
                String hashedPassword = rs.getString("password");

                if (BCrypt.checkPassword(userPassword, hashedPassword) && hashedId.equals(userId)) {
                    System.out.println("로그인됨");
                    session.setAttribute("login", true);
                } else {
                    request.setAttribute("loginError", "error");
                    session.removeAttribute("login");
                    request.getRequestDispatcher(request.getContextPath() + "/component/account/emailLogin/index.jsp").forward(request, response);
                }
            }
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
}

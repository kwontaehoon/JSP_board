package com.jsp.jsp_board.servlet;

import com.jsp.jsp_board.DTO.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/main")
public class BoardServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://database-tong.cnasam86gevz.ap-northeast-2.rds.amazonaws.com:3306/tong";
    private static final String USER = "admin";
    private static final String PASSWORD = "15689725";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BoardDTO> boardList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("MySQL JDBC Driver not found", e);
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM board")) {

            while (resultSet.next()) {
                BoardDTO board = new BoardDTO();
                board.setBoardId(resultSet.getInt("board_id"));
                board.setTitle(resultSet.getString("title"));
                board.setContent(resultSet.getString("content"));
                board.setCategory(resultSet.getString("category"));
                board.setSubCategory(resultSet.getString("sub_category"));
                board.setHits(resultSet.getInt("hits"));
                board.setRecommend(resultSet.getInt("recommend"));
                board.setCreateDate(resultSet.getDate("create_date"));
                boardList.add(board);
            }

            request.setAttribute("boardList", boardList);
            request.getRequestDispatcher("/main.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Failed to retrieve board data", e);
        }
    }
}

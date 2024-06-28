package com.jsp.jsp_board.servlet;

import com.jsp.jsp_board.DBConnect;
import com.jsp.jsp_board.DTO.BoardDTO;
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

@WebServlet(name = "mainServlet", value = "/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("BoardServlet");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<BoardDTO> boardList = new ArrayList<>();

        String query = "SELECT " +
                "    b.board_id, " +
                "    b.title, " +
                "    b.content, " +
                "    b.category, " +
                "    b.sub_category, " +
                "    b.hits, " +
                "    b.recommend, " +
                "    b.create_date, " +
                "    u.user_id, " +
                "    u.email, " +
                "    u.nick_name, " +
                "    u.name " +
                "FROM " +
                "    board b " +
                "JOIN " +
                "    users u ON b.user_id = u.user_id;";

        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            // 결과 데이터를 TestDTO 객체 리스트로 변환
            while (rs.next()) {
                BoardDTO board = new BoardDTO();
                board.setBoardId(rs.getInt("board_id"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setCategory(rs.getString("category"));
                board.setSubCategory(rs.getString("sub_category"));
                board.setHits(rs.getInt("hits"));
                board.setRecommend(rs.getInt("recommend"));
                board.setCreateDate(rs.getDate("create_date"));
                board.setUserId(rs.getInt("user_id"));
                board.setEmail(rs.getString("email"));
                board.setNickName(rs.getString("nick_name"));
                board.setName(rs.getString("name"));
                boardList.add(board);
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

            request.setAttribute("boardList", boardList);
            request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
}


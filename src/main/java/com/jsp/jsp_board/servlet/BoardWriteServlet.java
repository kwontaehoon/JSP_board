package com.jsp.jsp_board.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jsp.jsp_board.DBConnect;
import com.jsp.jsp_board.DAO.board.BoardWriteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "/boardWriteServlet", value = "/boardWrite")
public class BoardWriteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // JSON 데이터 읽기
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String jsonString = sb.toString();

        // JSON 파싱
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        String title = jsonObject.get("title").getAsString();
        String content = jsonObject.get("content").getAsString();
        String category = jsonObject.get("category").getAsString();
        String subCategory = jsonObject.get("subCategory").getAsString();
        String userId = jsonObject.get("userId").getAsString(); // userId는 String으로 가져옴
        String nickname = jsonObject.get("nickname").getAsString();

        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("Category: " + category);
        System.out.println("SubCategory: " + subCategory);
        System.out.println("UserId: " + userId);
        System.out.println("Nickname: " + nickname);

//        System.out.println("boardWriteServlet");
//
//        String title = request.getParameter("title");
//        String content = request.getParameter("content");
//        String category = request.getParameter("category");
//        String subCategory = request.getParameter("subCategory");
//        String userId = request.getParameter("userId");
//
//        System.out.println(title + content + category + subCategory + userId);
//
//        BoardWriteDAO BoardWriteDAO = new BoardWriteDAO();
//        boolean isSuccess = BoardWriteDAO.writeBoard(
//                "test",
//                "test_content",
//                "test_category",
//                "test_sub_category",
//                0,
//                0,
//                2,
//                0);
//
//        if (isSuccess) {
//            response.sendRedirect("/main");
//        } else {
//            // 실패했을 때의 처리
//        }
    }
}

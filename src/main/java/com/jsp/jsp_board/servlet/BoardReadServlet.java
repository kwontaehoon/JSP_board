package com.jsp.jsp_board.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "boardReadServlet", value = "/boardRead-servlet")
public class BoardReadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // API 엔드포인트 URL
        String apiUrl = "https://www.tongtongball.com/api/reservation/list";

        // API에 보낼 HTTP 요청 설정
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // 응답 읽기
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer apiResponse = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            apiResponse.append(inputLine);
        }
        in.close();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");

        // API 응답 출력
//        response.getWriter().write("API 응답: " + apiResponse.toString());
    }
}

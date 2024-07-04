package com.jsp.jsp_board.utill;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 유효성 검사
 */

public class Effectiveness {
    public static void login(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("loginError", "1111");
        System.out.println("Setting loginError attribute to 'loginError'");
        request.getRequestDispatcher(request.getContextPath() + url).forward(request, response);
    }
}

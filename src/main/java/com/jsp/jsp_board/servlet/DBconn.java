package com.jsp.jsp_board.servlet;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "InitServlet", urlPatterns = "/init", loadOnStartup = 1)
public class DBconn extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();

        // 데이터베이스 연결 정보
        String url = "jdbc:mysql://database-tong.cnasam86gevz.ap-northeast-2.rds.amazonaws.com:3306/tong";
        String user = "admin";
        String password = "15689725";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("MySQL JDBC Driver not found", e);
        }

        // Connection Pool 설정
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        // Pool 설정 (옵션)
        dataSource.setInitialSize(5);  // 초기 연결 수
        dataSource.setMaxTotal(10);    // 최대 연결 수

        // ServletContext에 DataSource 저장
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("dataSource", dataSource);
    }

    @Override
    public void destroy() {
        super.destroy();
        // Servlet 종료 시 DataSource를 shutdown
        BasicDataSource dataSource = (BasicDataSource) getServletContext().getAttribute("dataSource");
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

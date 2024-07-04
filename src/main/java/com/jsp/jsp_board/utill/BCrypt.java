package com.jsp.jsp_board.utill;

/**
 * DB 암호화 패스워드 복호화
 */

public class BCrypt {
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return org.mindrot.jbcrypt.BCrypt.checkpw(plainPassword, hashedPassword);
    }
}


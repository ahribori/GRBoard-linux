package com.daniel.grboard.dao;

import com.daniel.grboard.vo.Member;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by daniel on 15. 4. 5.
 */
@Repository
public class MemberDAOImpl implements MemberDAO {

    /**
     * 커넥션을 생성해서 리턴해주는 메소드
     * @return
     * @throws SQLException
     */
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/GRBOARD";
        String userId = "root";
        String userPass = "1234";
        return DriverManager.getConnection(url, userId, userPass);
    }

    /**
     * 모든 Member를 가져오는 메소드
     * @return
     */
    public ArrayList<Member> getAllList() {
        ArrayList<Member> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;
        try {
            con = getConnection();
            sql = "SELECT * FROM MEMBER";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                String memberId = rs.getString(1);
                String password = rs.getString(2);
                String memberName = rs.getString(3);
                list.add(new Member(memberId, password, memberName));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs,pstmt,con);
        }
        return list;
    }

    /**
     * memberNo를 입력받아 해당하는 Member가 있으면 vo를 리턴해주는 메소드
     * @param memberId
     * @return
     */
    public Member getMemberById(String memberId) {
        Member vo = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;
        try {
            con = getConnection();
            sql = "SELECT * FROM MEMBER WHERE Member_ID=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                String password = rs.getString(2);
                String memberName = rs.getString(3);
                vo = new Member(memberId, password, memberName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs,pstmt,con);
        }
        return vo;
    }

    /**
     * 멤버를 등록하는 메소드
     * @param memberId
     * @param password
     * @param memberName
     * @return
     */
    public int registerMember(String memberId, String password, String memberName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int i = -1;
        String sql = null;
        try {
            con = getConnection();
            sql = "INSERT INTO MEMBER(MEMBER_ID,PASSWORD,MEMBER_NAME)" +
                    " VALUES(?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            pstmt.setString(2, password);
            pstmt.setString(3, memberName);
            i = pstmt.executeUpdate();
            System.out.println(i + "행이 추가되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(pstmt,con);
        }
        return i;
    }

    /**
     * 입력받은 memberId와 일치하는 행이 있으면 수정하는 메소드
     * @param memberId
     * @param password
     * @param memberName
     * @return
     */
    public int updateMember(String memberId, String password, String memberName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int i = -1;
        String sql = null;
        try {
            con = getConnection();
            sql = "UPDATE MEMBER SET PASSWORD=?, MEMBER_NAME=? WHERE MEMBER_ID=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setString(2, memberName);
            pstmt.setString(3, memberId);
            i = pstmt.executeUpdate();
            System.out.println(i + "행이 수정되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(pstmt,con);
        }
        return i;
    }

    /**
     * 입력받은 memberId와 일치하는 행이 있으면 삭제하는 메소드
     * @param memberId
     * @return
     */
    public int deleteMember(String memberId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int i = -1;
        String sql = null;
        try {
            con = getConnection();
            sql = "DELETE FROM MEMBER WHERE MEMBER_ID=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            i = pstmt.executeUpdate();
            System.out.println(i + "행이 삭제되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(pstmt,con);
        }
        return i;
    }

    /**
     * ResultSet, PrepareStatement, Connection 객체를 일괄 close() 해주는 메소드
     * @param rs
     * @param pstmt
     * @param con
     */
    private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * PrepareStatement, Connection 객체를 일괄 close() 해주는 메소드
     * @param pstmt
     * @param con
     */
    private void closeAll(PreparedStatement pstmt, Connection con) {
        try {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

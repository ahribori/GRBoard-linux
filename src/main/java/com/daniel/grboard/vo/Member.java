package com.daniel.grboard.vo;

/**
 * Created by daniel on 15. 4. 5.
 */
public class Member {
    private String memberId;
    private String password;
    private String memberName;

    public Member(String memberId, String password, String memberName) {
        this.memberId = memberId;
        this.password = password;
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", password='" + password + '\'' +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}

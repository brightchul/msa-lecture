package com.week3team2.lectureservice.model.token;

import com.week3team2.lectureservice.model.member.MemberType;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class TokenInfo {
    private int memberId;
    private MemberType memberType;
    private String exp;

    public static TokenInfo create(Claims tokenClaims) {
        int memberId = (int) tokenClaims.get("memberId");
        MemberType memberType = getMemberType(tokenClaims.get("memberType").toString());
        String exp =  tokenClaims.get("exp").toString();

        return new TokenInfo(memberId, memberType, exp);
    }

    public static MemberType getMemberType(String value) {
        switch(value) {
            case "ADMIN": return MemberType.ADMIN;
            case "TEACHER": return MemberType.TEACHER;
            case "STUDENT": return MemberType.STUDENT;
            default: return null;
        }
    }
}

package com.ryu.studyhelper.common.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CustomResponseStatus {

    /***
     * 1000: 요청 성공
     */
    SUCCESS(HttpStatus.OK.value(), "1000", "요청에 성공하였습니다."),

    /***
     * 2000: UNAUTHORIZED
     */
    EXPIRED_JWT(HttpStatus.UNAUTHORIZED.value(), "2000", "만료된 토큰입니다."),
    BAD_JWT(HttpStatus.UNAUTHORIZED.value(), "2001", "잘못된 토큰입니다."),

    /***
     * 3000: ACCESS DENIED
     */
    ACCESS_DENIED(HttpStatus.FORBIDDEN.value(), "3000", "인증되지 않은 사용자입니다."),
    LOGOUT_MEMBER(HttpStatus.FORBIDDEN.value(), "3001", "로그아웃된 사용자입니다."),
    ALREADY_MAP_EXIST(HttpStatus.CONFLICT.value(), "3002", "이미 존재하는 채팅 입니다. 새롭게 시작할 수 없습니다."),
    ALREADY_EVALUATION_MAP_EXIST(HttpStatus.CONFLICT.value(), "3003", "평가리스트가 존재합니다. 새롭게 만들 수 없습니다."),

    /***
     * 4000: NOT_FOUND
     */
    NULL_JWT(HttpStatus.NO_CONTENT.value(), "4000", "토큰이 공백입니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4001", "해당 유저를 찾을 수 없습니다."),
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4002", "리프레시 토큰을 찾을 수 없습니다."),
    ROLE_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4003", "해당 권한을 찾을 수 없습니다."),
    GPT_NOT_ANSWER(HttpStatus.NOT_FOUND.value(), "4004", "GPT가 응답하지 않습니다."),
    BADGE_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4005", "해당 뱃지를 찾을 수 없습니다."),
    TEAM_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4006", "해당 팀을 찾을 수 없습니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED.value(), "4007", "허용되지 않은 요청 방식입니다."),
    GITHUB_USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4008", "해당 GitHub 사용자를 찾을 수 없습니다."),
    GITHUB_API_ERROR(HttpStatus.BAD_GATEWAY.value(), "4009", "GitHub API 호출에 실패했습니다."),
    COMMIT_HISTORY_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4010", "해당 커밋 기록을 찾을 수 없습니다."),
    //    MAP_VALUE_NOT_EXIST(HttpStatus.NOT_FOUND.value(), "4005", "채팅이 존재하지 않습니다. 채팅을 새롭게 시작해주세요."),
    //    EVALUATION_SERVER_NOT_ANSWER(HttpStatus.NOT_FOUND.value(), "4006", "평가서버가 응답하지 않습니다."),
    //    CS_CHAT_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4007", "해당 CS 채팅이 존재하지 않습니다."),
    //    SELF_INTRO_CHAT_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4008", "해당 자기소개서 채팅이 존재하지 않습니다."),
    //    EVALUATION_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4009", "해당 채팅의 평가 내역을 찾을 수 없습니다."),

    /***
     * 5000: NOT_MATCH
     */
    REFRESH_TOKEN_NOT_MATCH(HttpStatus.CONFLICT.value(), "5000", "잘못된 리프레시 토큰입니다."),
    BAD_TOKEN(HttpStatus.BAD_REQUEST.value(), "5001", "잘못된 토큰입니다."),
    MEMBER_NOT_MATCH(HttpStatus.BAD_REQUEST.value(), "5002", "사용자가 일치하지 않습니다."),

    /***
     * 6000: Server_Error
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "6000", "내부 서버 오류입니다."),
    ASYNC_COMPLETION_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "6001", "비동기 작업에서 오류가 발생하였습니다.");

    private final int httpStatusCode;
    private final String code;
    private final String message;

    CustomResponseStatus(int httpStatusCode, String code, String message) {
        this.httpStatusCode = httpStatusCode;
        this.code = code;
        this.message = message;
    }
}
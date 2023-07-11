package com.jyp.koreannumbersproject;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/*
 * https://www.law.go.kr/LSW/admRulLsInfoP.do?admRulSeq=2100000095072
 * https://ko.wikipedia.org/wiki/%EB%8C%80%ED%95%9C%EB%AF%BC%EA%B5%AD%EC%9D%98_%EC%A0%84%ED%99%94%EB%B2%88%ED%98%B8_%EC%B2%B4%EA%B3%84
 * https://namu.wiki/w/%EC%A0%84%ED%99%94%EB%B2%88%ED%98%B8
 */
// 2022.11.10 jypark
public class KoreanNumbers {
    // This class should never be instantiated.
    private KoreanNumbers() {
    }

    public static final String KOREAN_NATION_CODE = "+82";
    private static final char[] NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    @NonNull public static final Map<String, String> AREA_NUMBERS = new HashMap<>(); // 0A(B)-XXX-XXXX
    @NonNull
    public static final Map<String, String> UNIQUE_NUMBERS = new HashMap<>();
    @NonNull public static final Map<String, String> MOBILE_NUMBERS = new HashMap<>(); // 01A-XXXX-XXXX
    @NonNull public static final Map<String, String> COMMON_NUMBERS = new HashMap<>(); // 0A0-XXXX-XXXX
    @NonNull public static final Map<String, String> COMMON_FREE_NUMBERS = new HashMap<>(); // 1ABC-XX(XX)
    @NonNull public static final Map<String, String> COLLECT_NUMBERS = new HashMap<>(); // 1ABC-XX(XX)
    @NonNull public static final Map<String, String> INTERCITY_NUMBERS = new HashMap<>(); // 08B(BC)-XX(XX)

    static {
        // 이동통신 및 부가통신망 등 (01A-XXXX-XXXX)
        MOBILE_NUMBERS.put("010", "이동전화");
        MOBILE_NUMBERS.put("011", "이동전화 (SK텔레콤)");
        MOBILE_NUMBERS.put("012", "사물통신");
        MOBILE_NUMBERS.put("013", "재난안전통신망");
        MOBILE_NUMBERS.put("015", "무선호출");
        MOBILE_NUMBERS.put("016", "이동전화 (KT)");
        MOBILE_NUMBERS.put("017", "이동전화 (SK텔레콤)");
        MOBILE_NUMBERS.put("018", "이동전화 (KT)");
        MOBILE_NUMBERS.put("019", "이동전화 (LG유플러스)");

        // 공통 서비스 (0A0-XXXX-XXXX)
        COMMON_NUMBERS.put("030", "통합 메시징 서비스 (UMS)");
        COMMON_NUMBERS.put("050", "개인 번호 서비스");
        COMMON_NUMBERS.put("060", "전화 정보 서비스");
        COMMON_NUMBERS.put("070", "인터넷 전화 (VolP)");
        COMMON_NUMBERS.put("080", "착신 과금 서비스 (수신자 부담 전화)");

        // 시외전화 08B(BC)-XX(XX)
        INTERCITY_NUMBERS.put("081", "KT");
        INTERCITY_NUMBERS.put("082", "LG유플러스");
        INTERCITY_NUMBERS.put("083", "세종텔레콤");
        INTERCITY_NUMBERS.put("084", "SK브로드밴드");
        INTERCITY_NUMBERS.put("08560", "(주)브이텔레콤");
        INTERCITY_NUMBERS.put("08565", "엔터프라이즈네트웍스");
        INTERCITY_NUMBERS.put("08566", "SK브로드밴드");
        INTERCITY_NUMBERS.put("08582", "(주)KT솔루션스");
        INTERCITY_NUMBERS.put("086", "SK텔링크");

        // 특수번호
        UNIQUE_NUMBERS.put("100", "KT 고객센터");
        UNIQUE_NUMBERS.put("101", "LG유플러스 고객센터");
        UNIQUE_NUMBERS.put("106", "SK브로드밴드 고객센터");
        UNIQUE_NUMBERS.put("107", "손말이음센터");
        UNIQUE_NUMBERS.put("109", "중동호흡기증후군 상담 센터");
        UNIQUE_NUMBERS.put("110", "정부 통합 민원 안내 콜센터");
        UNIQUE_NUMBERS.put("111", "간첩 신고 (국가정보원)");
        UNIQUE_NUMBERS.put("112", "범죄 신고 (경찰청)");
        UNIQUE_NUMBERS.put("113", "간첩 신고 (경찰청)");
        UNIQUE_NUMBERS.put("114", "전화번호 안내");
        UNIQUE_NUMBERS.put("115", "전보 접수");
        UNIQUE_NUMBERS.put("116", "표준시각 안내 (KT)");
        UNIQUE_NUMBERS.put("117", "학교폭력·여성폭력·가정폭력 긴급지원센터 (경찰청)");
        UNIQUE_NUMBERS.put("118", "사이버테러 신고 (한국인터넷진흥원)");

        UNIQUE_NUMBERS.put("119", "화재·구조·구급·재난신고·병원 정보 안내 (소방청 / 응급 전화번호)");
        UNIQUE_NUMBERS.put("120", "생활정보 및 민원");
        UNIQUE_NUMBERS.put("122", "해양 긴급 신고 (해양경찰청)");
        UNIQUE_NUMBERS.put("123", "전기 고장신고 (한국전력공사)");
        UNIQUE_NUMBERS.put("124", "디지털 방송 콜센터 신고");
        UNIQUE_NUMBERS.put("125", "밀수사범 신고 (관세청)");
        UNIQUE_NUMBERS.put("126", "세무상담센터 (국세청)");
        UNIQUE_NUMBERS.put("127", "마약사범 신고 (검찰청)");
        UNIQUE_NUMBERS.put("128", "환경오염 신고 (환경부)");
        UNIQUE_NUMBERS.put("129", "보건복지콜센터 (보건복지부)");

        UNIQUE_NUMBERS.put("1300", "우체국 민원안내 (우정사업본부)");
        UNIQUE_NUMBERS.put("1301", "마약·범죄종합신고 (검찰청)");
        UNIQUE_NUMBERS.put("131", "보건복지콜센터 (보건복지부)");
        UNIQUE_NUMBERS.put("132", "법률상담 (대한법률구조공단)");
        UNIQUE_NUMBERS.put("1330", "관광정보 안내 (한국관광공사)");
        UNIQUE_NUMBERS.put("1331", "인권 침해 상담 (국가인권위원회)");
        UNIQUE_NUMBERS.put("1332", "금융민원 상담 (금융감독원)");
        UNIQUE_NUMBERS.put("1333", "교통정보 안내 (국토교통부)");
        UNIQUE_NUMBERS.put("1335", "방송통신 민원 (과학기술정보통신부)");
        UNIQUE_NUMBERS.put("1336", "개인정보 침해 상담 (한국인터넷진흥원)");
        UNIQUE_NUMBERS.put("1337", "테러신고, 안보상담 (군사안보지원사령부)");
        UNIQUE_NUMBERS.put("1338", "통신민원 상담 (과학기술정보통신부)");
        UNIQUE_NUMBERS.put("1339", "보건복지부 질병관리청");
        UNIQUE_NUMBERS.put("1350", "노동법령, 제도상담 (고용노동부)");
        UNIQUE_NUMBERS.put("1355", "국민연금 상담 (국민연금공단)");
        UNIQUE_NUMBERS.put("1357", "중소기업 지원 (중소벤처기업부)");
        UNIQUE_NUMBERS.put("1365", "자원봉사 안내 (행정안전부)");
        UNIQUE_NUMBERS.put("1366", "여성 긴급전화 (여성가족부)");
        UNIQUE_NUMBERS.put("1369", "금융정보 조회 (금융결제원)");
        UNIQUE_NUMBERS.put("1372", "소비자 민원 (소비자상담센터)");
        UNIQUE_NUMBERS.put("1377", "방송통신심의 민원 (과학기술정보통신부)");
        UNIQUE_NUMBERS.put("1379", "정부민원안내 (국민권익위원회)");
        UNIQUE_NUMBERS.put("1380", "수출안내통합콜센터 (FTA통합콜센터)");
        UNIQUE_NUMBERS.put("1382", "주민등록증 진위 확인 (행정안전부)");
        UNIQUE_NUMBERS.put("1385", "기업불편 신고 (감사원, 188과 동일)");
        UNIQUE_NUMBERS.put("1388", "헬프콜 청소년 긴급전화 (한국청소년상담복지개발원)");
        UNIQUE_NUMBERS.put("1390", "선거법 안내 (중앙선거관리위원회)");
        UNIQUE_NUMBERS.put("1391", "아동학대 상담 (보건복지부)");
        UNIQUE_NUMBERS.put("1393", "자살 예방 상담전화 (보건복지부)");
        UNIQUE_NUMBERS.put("1397", "서민금융 다모아 콜센터");
        UNIQUE_NUMBERS.put("1398", "부패신고 (국민권익위원회)");
        UNIQUE_NUMBERS.put("1399", "부정·불량식품 신고 (식품의약품안전처)");
        UNIQUE_NUMBERS.put("182", "경찰 민원 신고 (경찰청)");
        UNIQUE_NUMBERS.put("188", "기업불편 신고 (감사원)");

        // 기간통신사업자 공통부가서비스 1ABC-XX(XX)
        COMMON_FREE_NUMBERS.put("1588", "KT");
        COMMON_FREE_NUMBERS.put("1577", "KT");
        COMMON_FREE_NUMBERS.put("1899", "KT");
        COMMON_FREE_NUMBERS.put("1544", "LG유플러스");
        COMMON_FREE_NUMBERS.put("1644", "LG유플러스");
        COMMON_FREE_NUMBERS.put("1661", "LG유플러스");
        COMMON_FREE_NUMBERS.put("1566", "SK브로드밴드");
        COMMON_FREE_NUMBERS.put("1600", "SK브로드밴드");
        COMMON_FREE_NUMBERS.put("1670", "SK브로드밴드");
        COMMON_FREE_NUMBERS.put("1688", "세종텔레콤");
        COMMON_FREE_NUMBERS.put("1666", "세종텔레콤");
        COMMON_FREE_NUMBERS.put("1599", "SK텔링크");
        COMMON_FREE_NUMBERS.put("1877", "한국케이블텔레콤");
        COMMON_FREE_NUMBERS.put("1855", "CJ헬로");
        COMMON_FREE_NUMBERS.put("1800", "티온텔레콤");

        // 콜렉트콜 1ABC(D)-XX(XX)
        COLLECT_NUMBERS.put("1541", "KT");
        COLLECT_NUMBERS.put("1633", "LG유플러스");
        COLLECT_NUMBERS.put("08217", "LG유플러스");
        COLLECT_NUMBERS.put("1655", "SK브로드밴드");
        COLLECT_NUMBERS.put("1677", "세종텔레콤");
        COLLECT_NUMBERS.put("1682", "SK텔링크");

        // 지역번호 0A(B)-XXX-XXXX
        AREA_NUMBERS.put("02", "서울특별시");
        AREA_NUMBERS.put("031", "경기도");
        AREA_NUMBERS.put("032", "인천광역시");
        AREA_NUMBERS.put("033", "강원도");
        AREA_NUMBERS.put("041", "충청남도");
        AREA_NUMBERS.put("042", "대전광역시");
        AREA_NUMBERS.put("043", "충청북도");
        AREA_NUMBERS.put("044", "세종특별자치시");
        AREA_NUMBERS.put("051", "부산광역시");
        AREA_NUMBERS.put("052", "울산광역시");
        AREA_NUMBERS.put("053", "대구광역시");
        AREA_NUMBERS.put("054", "경상북도");
        AREA_NUMBERS.put("055", "경상남도");
        AREA_NUMBERS.put("061", "전라남도");
        AREA_NUMBERS.put("062", "광주광역시");
        AREA_NUMBERS.put("063", "전라북도");
        AREA_NUMBERS.put("064", "제주특별자치도");
    }

    public static boolean containNumber(@NonNull char n){
        for(char c : NUMBERS){
            if (c == n) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasInvalidCharacter(@NonNull String number) {
        char[] charNumber = number.trim().toCharArray();
        int count = charNumber.length;
        for (int i = 0; i < count; i++) {
            // Allow first character is + character
            if (i == 0 && charNumber[i] == '+') {
                continue;
            }
            if (!isValidCharacter(charNumber[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidCharacter(@NonNull char c) {
        return (c >= '0' && c <= '9') || c == '-' || c == ' ' || c == '(' || c == ')';
    }

    public static boolean containUniqueNumber(@NonNull String number){
        return KoreanNumbers.UNIQUE_NUMBERS.get(number)!=null;
    }

    public static int containAreaNumber(@NonNull String number){
        for(String areaNumber: KoreanNumbers.AREA_NUMBERS.keySet()){
            if(number.startsWith(areaNumber)) return areaNumber.length();
        }
        return -1;
    }

    public static boolean containMobileNumber(@NonNull String number){
        for(String mobilNumber: KoreanNumbers.MOBILE_NUMBERS.keySet()){
            if(number.startsWith(mobilNumber)) return true;
        }
        return false;
    }

    public static boolean containCommonNumber(@NonNull String number){
        for(String commonNumber: KoreanNumbers.COMMON_NUMBERS.keySet()){
            if(number.startsWith(commonNumber)) return true;
        }
        return false;
    }

    public static boolean containCommonFreeNumber(@NonNull String number){
        for(String freeNumber: KoreanNumbers.COMMON_FREE_NUMBERS.keySet()){
            if(number.startsWith(freeNumber)) return true;
        }
        return false;
    }

    public static int containCollectNumber(@NonNull String number){
        for(String collectNumber: KoreanNumbers.COLLECT_NUMBERS.keySet()){
            if(number.startsWith(collectNumber)) return collectNumber.length();
        }
        return -1;
    }

    public static int containIntercityNumber(@NonNull String number){
        for(String intercityNumber: KoreanNumbers.INTERCITY_NUMBERS.keySet()){
            if(number.startsWith(intercityNumber)) return intercityNumber.length();
        }
        return -1;
    }
}

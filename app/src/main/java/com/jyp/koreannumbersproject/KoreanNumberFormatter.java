package com.jyp.koreannumbersproject;

import static com.jyp.koreannumbersproject.KoreanNumbers.KOREAN_NATION_CODE;
import static com.jyp.koreannumbersproject.KoreanNumbers.containAreaNumber;
import static com.jyp.koreannumbersproject.KoreanNumbers.containCollectNumber;
import static com.jyp.koreannumbersproject.KoreanNumbers.containCommonFreeNumber;
import static com.jyp.koreannumbersproject.KoreanNumbers.containCommonNumber;
import static com.jyp.koreannumbersproject.KoreanNumbers.containIntercityNumber;
import static com.jyp.koreannumbersproject.KoreanNumbers.containMobileNumber;
import static com.jyp.koreannumbersproject.KoreanNumbers.containNumber;
import static com.jyp.koreannumbersproject.KoreanNumbers.containUniqueNumber;
import static com.jyp.koreannumbersproject.KoreanNumbers.hasInvalidCharacter;

import android.text.Editable;
import android.text.SpannableStringBuilder;

import androidx.annotation.NonNull;

public class KoreanNumberFormatter {
    private static final String TAG = "KoreanPhoneNumberFormatter";

    private KoreanNumberFormatter(){}

    // to prevent infinite loop
    private static long prevTime = 0;
    private static int cnt = 0;

    @NonNull
    public static String formatNumber(@NonNull String text){
        SpannableStringBuilder spannable = new SpannableStringBuilder(text);
        format(spannable);
        return spannable.toString();
    }

    public static Editable format(@NonNull Editable text) {
        if(!hasInvalidCharacter(text.toString())){
            if(!containUniqueNumber(text.toString().replaceAll("-", ""))){
                SpannableStringBuilder spbText = new SpannableStringBuilder(text);
                clearBlankAndHyphen(spbText);
                if (text.length() > 2)  {
                    if(System.currentTimeMillis() - prevTime < 10) {
                        cnt++;
                    }
                    prevTime = System.currentTimeMillis();
                    if(cnt>40){
                        clearBlankAndHyphen(text);
                        cnt = 0;
                        return text;
                    }
                    if(spbText.toString().startsWith(KOREAN_NATION_CODE)){
                        spbText.replace(0,3, "0");
                    }
                    String newText = verifyFormatNumber(spbText);
                    if(!newText.contentEquals(text)) {
                        text.replace(0, text.length(), newText);
                    }
                }
            }
            else{
                clearBlankAndHyphen(text);
            }
        }
        return text;
    }

    private static String verifyFormatNumber(@NonNull SpannableStringBuilder spbText){
        String newText;
        if(containAreaNumber(spbText.toString())> -1){
            int dashPos1 = containAreaNumber(spbText.toString());
            newText = formatNumber(dashPos1,dashPos1+4, spbText).toString();
        }
        else if(containMobileNumber(spbText.toString()) || containCommonNumber(spbText.toString())){
            newText = formatNumber(3,8, spbText).toString();
        }
        else if(containCommonFreeNumber(spbText.toString()) || containCollectNumber(spbText.toString()) > -1) {
            int dashPos1 = containCollectNumber(spbText.toString());
            if(dashPos1>-1) newText = formatNumber(dashPos1,-1, spbText).toString();
            else newText = formatNumber(4,-1, spbText).toString();
        }
        else if(containIntercityNumber(spbText.toString()) > -1){
            int dashPos1 = containIntercityNumber(spbText.toString());
            newText = formatNumber(dashPos1,-1, spbText).toString();
        }
        else{
            clearBlankAndHyphen(spbText);
            newText = spbText.toString();
        }
        return newText;
    }

    private static Editable formatNumber(int dashPos1, int dashPos2, @NonNull SpannableStringBuilder text){
        if (text.length() <= 12) {
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if ((i == dashPos1 || i == dashPos2) && containNumber(c)) {
                    text.insert(i, "-");
                    i++;
                }
            }
        }
        return text;
    }

    private static void clearBlankAndHyphen(Editable text){
        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if(c=='-' || c == ' ') {
                text.delete(i, i+1);
                i--;
            }
        }
    }

}

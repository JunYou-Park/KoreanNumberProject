package com.jyp.koreannumbersproject;

import static com.jyp.koreannumbersproject.KoreanNumberFormatter.formatNumber;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

public class KoreanNumberEditText extends EditText {
    private static final String TAG = "KoreanNumberEditText";
    private final TextWatcher textWatcher = new TextWatcher() {
        boolean isSubtract = false;
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            isSubtract = count != 0 && after == 0;
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String formatText = formatNumber(s.toString());
            if(!formatText.contentEquals(s)){
                int sHyphenLength = s.toString().replaceAll("[0-9]", "").length();
                int formatHyphenLength = formatText.replaceAll("[0-9]", "").length();
                Log.d(TAG, "onTextChanged: sHyphenLength=" + sHyphenLength + ", formatHyphenLength=" + formatHyphenLength);
                int selectionStart;
                if(isSubtract){
                    selectionStart = getSelectionStart();
                    // 0135203011222| 이 상태에서 삭제한 경우 하이픈이 2개 생기므로 selection 포지션을 2 더 해줘야함
                    if(sHyphenLength==0 && formatHyphenLength==2 && selectionStart == s.length()){
                        selectionStart += 2;
                    }
                }
                else{
                    // 0|352030112 이 상태에서 1을 입력하면 하이픈이 2개 생긴 경우나 01|3-5203-0112 에서 1을 삭제하는 경우 하이픈이 2개 삭제되는 경우 selection의 포지션 변경이 필요 없다.
                    if((sHyphenLength==0 && formatHyphenLength==2) || (formatHyphenLength==0 && sHyphenLength==2)){
                        selectionStart = getSelectionStart();
                    }
                    else{
                        // 013| 이 상태에서 입력하는 경우 하이픈이 증가하는 수 만큼 selection의 위치를 옮겨줘야한다.
                        selectionStart = getSelectionStart() + formatHyphenLength - sHyphenLength;
                    }
                }
                setText(formatText);
                setSelection(Math.min(selectionStart, formatText.length()));
            }
        }
        @Override
        public void afterTextChanged(Editable s) {}
    };

    public KoreanNumberEditText(Context context) {
        super(context);
        addTextChangedListener(textWatcher);
        setInputType(InputType.TYPE_CLASS_PHONE);
    }

    public KoreanNumberEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTextChangedListener(textWatcher);
        setInputType(InputType.TYPE_CLASS_PHONE);
    }

    public KoreanNumberEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addTextChangedListener(textWatcher);
        setInputType(InputType.TYPE_CLASS_PHONE);
    }


}

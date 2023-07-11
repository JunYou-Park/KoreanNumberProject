package com.jyp.koreannumbersproject;

import static com.jyp.koreannumbersproject.KoreanNumberFormatter.formatNumber;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

public class KoreanNumberEditText extends EditText {
    private static final String TAG = "KoreanNumberEditText";
    private TextWatcher textWatcher = new TextWatcher() {
        boolean isSubtract = false;
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            isSubtract = count != 0 && after == 0;
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String formatText = formatNumber(s.toString());
            if(!formatText.contentEquals(s)){
                if(isSubtract){
                    setSelection(getSelectionStart());
                }
                else{
                    setText(formatText);
                    setSelection(formatText.length());
                }
            }
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public KoreanNumberEditText(Context context) {
        super(context);
    }

    public KoreanNumberEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTextChangedListener(textWatcher);
        setInputType(InputType.TYPE_CLASS_PHONE);
    }

    public KoreanNumberEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}

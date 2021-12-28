package jp.sai.ap_quizapp;

import android.content.Context;
import android.util.AttributeSet;

/*** プッシュするエフェクトのボタン ***/
public class PushButton extends androidx.appcompat.widget.AppCompatButton {
    public PushButton(Context context) {
        super(context);
    }

    public PushButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setPressed(boolean pressed) {
        if(pressed){
            this.setScaleY(0.92f);
            this.setScaleX(0.96f);
            this.setAlpha(0.75f);
        }else{
            this.setScaleY(1.0f);
            this.setScaleX(1.0f);
            this.setAlpha(1.0f);
        }
        super.setPressed(pressed);
    }

}
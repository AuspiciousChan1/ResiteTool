package Function;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ButtonHandler {
    public static Button createButtonInLinearLayout(String text, Context context, LinearLayout linearLayout, View.OnClickListener onClick){
        Button button = new Button(context);
        button.setText(text);
        button.setOnClickListener(onClick);
        linearLayout.addView(button);
        return button;
    }
    public static Button createButtonInLinearLayout(int width, int height,String text, Context context, LinearLayout linearLayout, View.OnClickListener onClick){
        Button button = new Button(context);
        button.setWidth(width);
        button.setHeight(height);
        button.setText(text);
        button.setOnClickListener(onClick);
        linearLayout.addView(button);
        return button;
    }
    public static Button createButtonInLinearLayout(int width, int height,String text, int color, Context context, LinearLayout linearLayout, View.OnClickListener onClick){
        Button button = new Button(context);
        button.setWidth(width);
        button.setHeight(height);
        button.setText(text);
        button.setBackgroundColor(color);
        button.setOnClickListener(onClick);
        linearLayout.addView(button);
        return button;
    }
}

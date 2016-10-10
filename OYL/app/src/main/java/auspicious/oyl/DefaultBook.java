package auspicious.oyl;

import Function.ButtonHandler;
import Function.MyFileHandler;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DefaultBook extends AppCompatActivity {
    private LinearLayout linearLayoutDefaultBookFunction = null;

    private TextView textViewDefaultBookWord = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dafault_book_resite);
        linearLayoutDefaultBookFunction = (LinearLayout)findViewById(R.id.linearLayoutDefaultBookFunction);
        //添加按钮
        ButtonHandler.createButtonInLinearLayout(80, linearLayoutDefaultBookFunction.getHeight(), getResources().getString(R.string.add), Color.GRAY, DefaultBook.this, linearLayoutDefaultBookFunction, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layout_default_book_add_new_words);
            }
        });
        textViewDefaultBookWord = (TextView)findViewById(R.id.textViewDefaultBookWord);

    }
}

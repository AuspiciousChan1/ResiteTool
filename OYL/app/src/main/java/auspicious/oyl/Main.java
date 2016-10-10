package auspicious.oyl;

import Data.Constant;
import Data.Variable;
import Function.ButtonHandler;
import Function.MyMessageBox;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class Main extends AppCompatActivity {
    //______________________________________________________________________________________________________________
    //登录界面//
    private EditText editTextAccount = null;
    private EditText editTextPassword = null;
    private Button buttonLogIn = null;
    //--------------------------------------------------------------------------------------------------------------

    //______________________________________________________________________________________________________________
    //程序主界面//
    private LinearLayout linearLayoutAfterLogInFunction = null;
    private LinearLayout linearLayoutAfterLogInBooks = null;
    private EditText editTextSearchAndAdd = null;
    private Button buttonSearch = null;
    private Button buttonAdd = null;
    private Button buttonDefaultBook = null;
    //--------------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources resources = this.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        float density = displayMetrics.density;
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        Variable.screenheight = screenHeight;
        Variable.screenWidth = screenWidth;

        //______________________________________________________________________________________________________________
        //登录界面//
        setContentView(R.layout.layout_main);
        editTextAccount = (EditText) findViewById(R.id.editTextMainAccount);
        editTextPassword = (EditText) findViewById(R.id.editTextMainPassword);

        buttonLogIn = (Button) findViewById(R.id.buttonMainLogIn);
        //--------------------------------------------------------------------------------------------------------------

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            {}
            @Override
            public void onClick(View v) {
                String stringAccount = editTextAccount.getText().toString();
                String stringPassword = editTextPassword.getText().toString();
                //______________________________________________________________________________________________________________
                //程序主界面//
                setContentView(R.layout.layout_after_log_in);

                //输入框
                editTextSearchAndAdd = (EditText)findViewById(R.id.editTextAfterLogInSearchAndAdd);

                //搜索按钮
                buttonSearch = (Button)findViewById(R.id.buttonAfterLogInSearch);
                buttonSearch.setOnClickListener(new View.OnClickListener() {
                    {}@Override
                    public void onClick(View v) {

                    }
                });
                //添加按钮
                buttonAdd = (Button)findViewById(R.id.buttonAfterLogInAdd);
                buttonAdd.setOnClickListener(new View.OnClickListener(){
                    {}@Override
                    public void onClick(View v) {
                        //应该有查重，查空的功能，添加后清空输入框
                        String newBook = editTextSearchAndAdd.getText().toString();
                        if(newBook != null && newBook.length() > 0){
                            if(!Variable.bookList.contains(newBook)){
                                Variable.bookList.add(newBook);
                                ButtonHandler.createButtonInLinearLayout(linearLayoutAfterLogInBooks.getWidth(), Constant.buttonBookListHeight, newBook, Main.this, linearLayoutAfterLogInBooks, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        System.out.println("新本");
                                    }
                                });
                                editTextSearchAndAdd.setText("");
                            }
                            else{
                                MyMessageBox.showInformation("命名重复", Main.this);
                            }
                        }
                        else{
                            MyMessageBox.showInformation("输入不能为空", Main.this);
                        }
//                        //直接拨打
//                        //Intent intent = new Intent(Intent.ACTION_CALL);
//                        //进入拨号界面，并输入号码
//                        Intent intent = new Intent(Intent.ACTION_DIAL);
//                        Uri data = Uri.parse("tel:" + "15008440857");
//                        intent.setData(data);
//                        if (ActivityCompat.checkSelfPermission(Main.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                            // TODO: Consider calling
//                            //    ActivityCompat#requestPermissions
//                            // here to request the missing permissions, and then overriding
//                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                            //                                          int[] grantResults)
//                            // to handle the case where the user grants the permission. See the documentation
//                            // for ActivityCompat#requestPermissions for more details.
//                            return;
//                        }
//                        Main.this.startActivity(intent);
                    }
                });
                //--------------------------------------------------------------------------------------------------------------

                buttonDefaultBook = (Button)findViewById(R.id.buttonAfterLogInDefaultBook);
                buttonDefaultBook.setOnClickListener(new View.OnClickListener() {
                    {}@Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(Main.this, DefaultBook.class);
                        Main.this.startActivity(intent);
                    }
                });
            }
        });

    }

}

package Function;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import auspicious.oyl.R;

/**
 * Created by AuspiciousChan on 2016/9/17.
 */
public class MyMessageBox {
    public static void showInformation(String str, final Context context){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(context.getResources().getString(R.string.message_box));
        builder.setMessage(str);
        builder.setPositiveButton(context.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                builder.show().dismiss();
            }
        });
        builder.show();
    }

}

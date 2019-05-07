package sy.project2019.itshow.testokhttp;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String url =
    "http://ec2-52-78-186-63.ap-northeast-2.compute.amazonaws.com/?fbclid=IwAR1tYWUHbhufvTaIpZqldyR4MTYk9XNw5mkxexFPTcTDgXxCCeqaKRvIq_k";
    EditText edit_id;
    EditText edit_pw;
    Button loginBtn;
    String id;
    String pw;
    TextView txt;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_id = findViewById(R.id.id);
        edit_pw = findViewById(R.id.pw);
        loginBtn =findViewById(R.id.loginBtn);
        txt=findViewById(R.id.ok);

        id = edit_id.toString();
        pw = edit_pw.toString();

        loginClass obj = new loginClass(id, pw);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer i = 100;
                connectClass connect = new connectClass(MainActivity.this);
                connect.execute(obj);
//                AsynTest test = new AsynTest(MainActivity.this);
//                test.execute(200);
            }
        });

    }




}

package sy.project2019.itshow.testokhttp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class connectClass extends AsyncTask<loginClass, Integer, Integer> {
    Activity thisAct;
    public connectClass(Activity thisAct){
        this.thisAct = thisAct;
    }

    String url =
    "http://ec2-52-78-186-63.ap-northeast-2.compute.amazonaws.com/?fbclid=IwAR1tYWUHbhufvTaIpZqldyR4MTYk9XNw5mkxexFPTcTDgXxCCeqaKRvIq_k";

    Integer result = new Integer(400);

    @Override
    protected Integer doInBackground(loginClass... object) {
        OkHttpClient client = new OkHttpClient();

        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("실패000000","로그인 실패" );
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.code() == 200){
                    Log.e("로그인 성공 0000000","성공으로 들어옴" );
                    result = 200;
                }else{
                    result = 400;
                }
            }
        };

        try {
            RequestBody body = new FormBody.Builder()
                    .add("email", object[0].getId())
                    .add("password",  object[0].getPw())
                    .build();
            Request request = new Request.Builder()
                    .url(url + "/signin")
                    .post(body)
                    .build();
            client.newCall(request).enqueue(callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    protected void onProgressUpdate (Integer... integer){}

    @Override
    protected void onPostExecute (Integer sign){
            super.onPostExecute(sign);
            if(sign != null){
                switch (sign){
                    case 200:
                        Toast.makeText(thisAct.getApplicationContext(), "로그인 성공" + sign, Toast.LENGTH_SHORT).show();
                        break;
                    case 400:
                        Toast.makeText(thisAct.getApplicationContext(), "로그인 실패" + sign, Toast.LENGTH_SHORT).show();
                        break;
                }
            }else{
                Toast.makeText(thisAct.getApplicationContext(), "이도 저도 아니고 실패,," + sign, Toast.LENGTH_SHORT).show();
            }

    }
}

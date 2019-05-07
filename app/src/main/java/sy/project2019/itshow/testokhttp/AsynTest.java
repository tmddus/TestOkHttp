package sy.project2019.itshow.testokhttp;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class AsynTest extends AsyncTask<Integer, Integer, Integer> {
    Activity a;
    public AsynTest(Activity a){
        this.a = a;
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        return integers[0];
    }

    @Override
    protected void onProgressUpdate (Integer... integer){
        Log.e("onProgressUpdate", integer[0] + "");
    }
    @Override
    protected void onPostExecute (Integer sign){
        Toast.makeText(a.getApplicationContext(), sign + "결과 값", Toast.LENGTH_SHORT).show();

    }

}

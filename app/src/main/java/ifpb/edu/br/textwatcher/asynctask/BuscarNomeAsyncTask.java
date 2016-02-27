package ifpb.edu.br.textwatcher.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;

import ifpb.edu.br.textwatcher.util.HttpService;
import ifpb.edu.br.textwatcher.util.Response;

/**
 * Created by Rhavy on 24/02/2016.
 */
public class BuscarNomeAsyncTask extends AsyncTask<JSONObject, Void, Response> {

    @Override
    protected Response doInBackground(JSONObject... jsons) {

        Response response = null;

        JSONObject json = jsons[0];
        Log.i("EditTextListener", "doInBackground (JSON): " + json);

        try {

            response = HttpService.sendJSONPostResquest("get-byname", json);

        } catch (IOException e) {

            Log.e("EditTextListener", e.getMessage());
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {

        Log.i("EditTextListener", "Código HTTP: " + response.getStatusCodeHttp()
                + " Conteúdo: " + response.getContentValue());
    }
}
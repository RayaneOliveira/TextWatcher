package ifpb.edu.br.textwatcher.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.textwatcher.util.HttpService;
import ifpb.edu.br.textwatcher.util.Response;
import ifpb.edu.br.textwatcher.activity.BuscarNomeActivity;

/**
 * Created by Rhavy on 24/02/2016.
 */
public class BuscarNomeAsyncTask extends AsyncTask<JSONObject, Void, Response> {

    private List<String> nomes;

    BuscarNomeActivity buscar;

    public BuscarNomeAsyncTask(BuscarNomeActivity busca) {

        super();
        this.buscar = buscar;
    }

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

        try {

            JSONArray jsonArray = new JSONArray(response.getContentValue());

            for (int i = 0;i < jsonArray.length(); i++) {

                JSONObject json = jsonArray.getJSONObject(i);
                String nome = json.getString("fullName");
                nomes.add(nome);
            }

            buscar.buscarNome(nomes);

        } catch (JSONException e) {

            Log.e("LoginAsyncTask", "JSONException: " + e.getMessage());

        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Traductor;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.util.Properties;

/**
 *
 * @author MIRKO
 */
public class TraductorImp implements TraductorInt{
    @Override
    public String traducir(String idiomaOrigen, String texto, String idiomaDestino) throws RemoteException {
        try {
            String api_url = "https://api.openai.com/v1/completions";
            URL url = new URL(api_url);
            HttpURLConnection conexion = (HttpURLConnection)url.openConnection();
            
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setRequestProperty("Authorization", "Bearer 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");
            
            conexion.setDoInput(true);
            conexion.setDoOutput(true);
            
            String body =   "{\n" +
                        "  \"model\": \"text-davinci-003\",\n" +
                        "  \"prompt\": \"Traduce el texto: "+texto+". del "+idiomaOrigen+" a "+idiomaDestino+" \",\n" +
                        "  \"temperature\": 0.3,\n" +
                        "  \"max_tokens\": 100,\n" +
                        "  \"top_p\": 1.0,\n" +
                        "  \"frequency_penalty\": 0.0,\n" +
                        "  \"presence_penalty\": 0.0\n" +
                        "}";
            
            DataOutputStream wr = new DataOutputStream(conexion.getOutputStream());
            byte[] body_data = body.getBytes(StandardCharsets.UTF_8);
            wr.write(body_data);
            wr.flush();
            wr.close();
            
            int responseCode = conexion.getResponseCode();
            if(responseCode == 200){
                BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream(), "UTF-8"));
                String linea;
                StringBuilder respuesta = new StringBuilder();
                while((linea = in.readLine()) != null){
                    respuesta.append(linea);
                }
                in.close();
                
                final Gson gson = new Gson();
                OpenAiResponse openai_response = gson.fromJson(respuesta.toString(), OpenAiResponse.class);
                
                return openai_response.getResponse();
            }else{
                return "error: codigo de respuesta " + responseCode;
            }
            
        } catch (Exception ex) {
            return "error :" +ex;
        } 
    }
}

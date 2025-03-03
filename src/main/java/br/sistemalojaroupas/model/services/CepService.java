package br.sistemalojaroupas.model.services;

import br.sistemalojaroupas.model.entities.Address;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CepService {
    
    private final static String SERVICE_URL = "https://brasilapi.com.br/api/cep/v1/";
    private static HttpURLConnection connection;
    
    public static Address findAddress(String cep) throws IOException {
        try {
            connection = (HttpURLConnection) new URL(SERVICE_URL + cep).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json;charset=UTF-8");
            connection.connect();
                        
            if (connection.getResponseCode() != 200) {
                throw new IllegalArgumentException("CEP inválido.");
            }
            
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))) {
                Address address = new Gson().fromJson(br, Address.class);
                connection.disconnect();
                return address;
            }
            
        }
        catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        catch (IllegalStateException | JsonSyntaxException e) {
            throw new IOException("Digite um CEP para poder pesquisar.");
        }
    }
}
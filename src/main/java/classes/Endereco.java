package classes;

import java.util.Scanner;

import com.google.gson.Gson;

import lombok.Data;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Data
public class Endereco {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String complemento;
    private int numero;

    public static Endereco getEnderecoByCep(String cep) {

        Endereco endereco = new Endereco();
        OkHttpClient client = new OkHttpClient();

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                String result = response.body().string();

                // Mapper
                Gson gson = new Gson();
                endereco = gson.fromJson(result, Endereco.class);

            } else {
                System.out.println("Erro ao buscar o CEP: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar o CEP: " + e.getMessage());
        }

        return endereco;
    }

    public static Endereco perguntaEndereco() {

        System.out.println("Digite o CEP: ");
        Scanner sc = new Scanner(System.in);
        String cep = sc.nextLine();

        Endereco endereco = Endereco.getEnderecoByCep(cep);

        System.out.println("Endereço encontrado: ");
        System.out.println("CEP: " + cep);
        System.out.println("Logradouro: " + endereco.getLogradouro());
        System.out.println("Bairro: " + endereco.getBairro());
        System.out.println("Cidade: " + endereco.getLocalidade());
        System.out.println("Estado: " + endereco.getUf());

        System.out.println("Confirma? S/N");
        String resposta = sc.nextLine();

        if (resposta.equalsIgnoreCase("n")) {
            perguntaEndereco();
        } else {
            System.out.println("Digite o complemento: ");
            endereco.setComplemento(sc.nextLine());

            System.out.println("Digite o numero: ");
            endereco.setNumero(sc.nextInt());
        }
        sc.close();
        return endereco;
    }
}
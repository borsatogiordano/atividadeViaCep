package classes;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.web.bind.annotation.RequestBody;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class Cliente {
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    private String nome;
    private String cpf;
    private Endereco endereco;
    private String telefone;
    private String email;
    private String dataNascimento;

    public static void addCliente() {
        Cliente cliente = new Cliente();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        cliente.setNome(sc.nextLine());

        System.out.println("Digite seu CPF:");
        cliente.setCpf(sc.nextLine());

        System.out.println("Digite seu telefone: ");
        cliente.setTelefone(sc.nextLine());

        cliente.setEndereco(Endereco.perguntaEndereco());

        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
        System.out.println(cliente.toString());

        sc.close(); // Fechar o scanner após o uso
    }
}

package classes;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.Data;
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

    public void setCpf(String cpf) {
        if (cpf.length() == 11) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos.");
        }
    }

    public void setTelefone(String telefone) {
        if (telefone.length() == 8 || telefone.length() == 9) {
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("Telefone deve conter 8/9 dígitos.");
        }
    }

    public static void addCliente() {
        Cliente cliente = new Cliente();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        cliente.setNome(sc.nextLine());

        System.out.println("Digite seu CPF: (11 caracteres)");
        cliente.setCpf(sc.nextLine());

        System.out.println("Digite seu telefone: *Obs: sem o DDD");
        cliente.setTelefone(sc.nextLine());

        cliente.setEndereco(Endereco.perguntaEndereco());

        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
        System.out.println(cliente.toString());

        sc.close(); // Fechar o scanner após o uso
    }

}

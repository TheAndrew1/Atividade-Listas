package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();

        cadastrarPessoa(pessoas);

        mostrarPessoas(pessoas);
    }

    static void cadastrarPessoa(List<Pessoa> pessoas){
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.println("Digite o nome: ");
            String nome = scan.next();
            System.out.println("Digite a idade: ");
            int idade = scan.nextInt();

            List<Endereco> enderecos = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                System.out.println("Endereço " + (j+1) + " :");

                System.out.println("Digite o nome da rua: ");
                String rua = scan.next();
                System.out.println("Digite o numero da residência: ");
                int numero = scan.nextInt();
                enderecos.add(new Endereco(rua, numero));
                System.out.println("");
            }

            pessoas.add(new Pessoa(nome, idade, enderecos));
        }

        scan.close();
    }

    static void mostrarPessoas(List<Pessoa> pessoas){
        for (Pessoa pessoa : pessoas)
        {
            System.out.println(pessoa.getNome() + ", " + pessoa.getIdade() + " anos");
            System.out.println("Endereços:");
            for (int i = 0; i < pessoa.getEnderecos().size(); i++)
            {
                System.out.println(pessoa.getEnderecos().get(i).getRua() + ", " + pessoa.getEnderecos().get(i).getNumero());
            }
            System.out.println("");
        }
    }
}
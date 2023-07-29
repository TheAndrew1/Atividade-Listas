package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            switch (menu(scan)){
                case 1 -> cadastrarPessoa(pessoas, scan);

                case 2 -> mostrarPessoa(pessoas, scan);

                case 3 -> System.exit(0);

                default -> System.out.println("Valor inválido!");
            }
        }
    }

    static void cadastrarPessoa(List<Pessoa> pessoas, Scanner scan){
        System.out.println("Digite o nome: ");
        String nome = scan.next();
        System.out.println("Digite a idade: ");
        int idade = scan.nextInt();

        List<Endereco> enderecos = new ArrayList<>();
        int cont = 1;
        while (true) {
            System.out.println("Endereço " + cont + " : (Digite 0 para sair)");

            System.out.println("Digite o nome da rua: ");
            String rua = scan.next();

            if (rua.equals("0")) {
                break;
            }

            System.out.println("Digite o numero da residência: ");
            int numero = scan.nextInt();
            enderecos.add(new Endereco(rua, numero));

            cont++;
        }

        pessoas.add(new Pessoa(nome, idade, enderecos));
    }

    static void mostrarPessoa(List<Pessoa> pessoas, Scanner scan){
        System.out.println("Digite o nome: ");
        String nome = scan.next();
        boolean find = false;

        for (Pessoa pessoa : pessoas)
        {
            if (pessoa.getNome().equals(nome)){
                System.out.println("");
                System.out.println(pessoa.getNome() + ", " + pessoa.getIdade() + " anos");
                System.out.println("Endereços:");
                for (int i = 0; i < pessoa.getEnderecos().size(); i++)
                {
                    System.out.println(pessoa.getEnderecos().get(i).getRua() + ", " + pessoa.getEnderecos().get(i).getNumero());
                }
                System.out.println("");

                find = true;
            }
        }

        if (!find){
            System.out.println("Pessoa não encontrada!");
            System.out.println("");
        }
    }

    static int menu(Scanner scan){
        System.out.println("");
        System.out.println("1 - Cadastrar pessoa");
        System.out.println("2 - Mostrar pessoa");
        System.out.println("3 - Sair");
        System.out.println("");

        return scan.nextInt();
    }
}
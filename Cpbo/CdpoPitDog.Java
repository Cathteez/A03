import java.util.Scanner;

public class CdpoPitDog {

    static String codigoProduto, nomeProduto;
    static boolean estadoProduto = false;
    static double precoProduto;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("\nMENU:\n1. Cadastro\n2. Excluir\n3. Alterar\n4. Cardapio\n5. Sair\nEscolha: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    excluirProduto();
                    break;
                case 3:
                    alterarProduto();
                    break;
                case 4:
                    listarCardapio();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opçao invalida");
                    break;
            }
        }
    }

    public static void cadastrarProduto() {
        if (estadoProduto) {
            System.out.println("Produto já existente, exclua o produto atual, para depois cadastrar um novo");
            return;
        }
        System.out.print("Código ( 6 caracteres): ");
        codigoProduto = scanner.next();
        if (codigoProduto.length() != 6) {
            System.out.println("Código inválido!");
            return;
        }
        System.out.print("Nome: ");
        scanner.nextLine();  
        nomeProduto = scanner.nextLine().toUpperCase();
        if (nomeProduto.length() < 3 || nomeProduto.length() > 60) {
            System.out.println("Nome invalido!");
            return;
        }
        System.out.print("Preço: ");
        precoProduto = scanner.nextDouble();
        if (precoProduto <= 0) {
            System.out.println("Preço invalido!");
            return;
        }
        estadoProduto = true;
        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void excluirProduto() {
        if (!estadoProduto) {
            System.out.println("Nenhum produto cadastrado para excluir.");
        } else {
            estadoProduto = false;
            System.out.println("Produto excluido com sucesso!");
        }
    }

    public static void alterarProduto() {
        if (!estadoProduto) {
            System.out.println("Nenhum produto cadastrado para alterar.");
            return;
        }
        System.out.print("Novo nome: ");
        scanner.nextLine(); 
        nomeProduto = scanner.nextLine().toUpperCase();
        if (nomeProduto.length() < 3 || nomeProduto.length() > 60) {
            System.out.println("Nome inválido!");
            return;
        }
        System.out.print("Novo preço: ");
        precoProduto = scanner.nextDouble();
        if (precoProduto <= 0) {
            System.out.println("Preço invalido!");
            return;
        }
        System.out.print("Qual o estado do produto? (1 para Sim e 0 para Não): ");
        char estado = scanner.next().charAt(0);
        estadoProduto = (estado == '1');
        System.out.println("Produto alterado com sucesso!");
    }

    public static void listarCardapio() {
        if (!estadoProduto) {
            System.out.println("Nenhum produto em estado ativo no momento");
        } else {
            System.out.println("\nCARDAPIO:\n-------------------------------");
            System.out.printf("%-8s%-45s%.2f\n", codigoProduto, nomeProduto, precoProduto);
        }
    }
}
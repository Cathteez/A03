import java.awt.*;
import javax.swing.*;

public class cdpoCardapio {
    private static final int LIM_REG = 100;
    private static final String[][] produtos = new String[LIM_REG][4];
    private static int totalProdutos = 0;
    private static final int LIM_CLI = 100;
    private static final String[][] clientes = new String[LIM_CLI][14]; // Adicionado para incluir campos adicionais
    private static int totalClientes = 0;

    private static JFrame frame;
    private static JTextArea textArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(cdpoCardapio::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        frame = new JFrame("Sistema de Cadastro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JButton btnCadastroCliente = new JButton("Cadastro de Clientes");
        JButton btnCadastroProduto = new JButton("Cadastro de Produtos");
        JButton btnImprimirCardapio = new JButton("Imprimir Cardápio");
        JButton btnSair = new JButton("Sair");

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(btnCadastroCliente);
        panel.add(btnCadastroProduto);
        panel.add(btnImprimirCardapio);
        panel.add(btnSair);

        frame.add(panel, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);

        btnCadastroCliente.addActionListener(e -> menuCadastroClientes());

        btnCadastroProduto.addActionListener(e -> menuCadastroProduto());

        btnImprimirCardapio.addActionListener(e -> imprimirCardapioProdutos());

        btnSair.addActionListener(e -> {
            System.out.println("Saindo do sistema...");
            System.exit(0);
        });

        frame.setVisible(true);
    }

    private static void menuCadastroClientes() {
        String[] options = {"Incluir Cliente", "Alterar Cliente", "Excluir Cliente", "Listar Clientes", "Voltar"};
        int opcao = JOptionPane.showOptionDialog(frame, "Escolha uma opção:", "Cadastro de Clientes",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (opcao) {
            case 0: incluirCliente(); break;
            case 1: alterarCliente(); break;
            case 2: excluirCliente(); break;
            case 3: listarClientes(); break;
            case 4: break; // Voltar
            default: break;
        }
    }

    private static void incluirCliente() {
        if (totalClientes >= LIM_CLI) {
            JOptionPane.showMessageDialog(frame, "Cadastro de clientes cheio.");
            return;
        }

        String id = JOptionPane.showInputDialog("ID Cliente (11 caracteres):");
        if (id == null || id.length() != 11) {
            JOptionPane.showMessageDialog(frame, "ID inválido! Deve conter exatamente 11 caracteres.");
            return;
        }

        String nome = JOptionPane.showInputDialog("Nome (1 a 60 caracteres):");
        if (nome == null || nome.length() < 1 || nome.length() > 60) {
            JOptionPane.showMessageDialog(frame, "Nome inválido!");
            return;
        }

        String logradouro = JOptionPane.showInputDialog("Logradouro:");
        String numero = JOptionPane.showInputDialog("Número:");
        String bairro = JOptionPane.showInputDialog("Bairro:");
        String cidade = JOptionPane.showInputDialog("Cidade:");
        String cep = JOptionPane.showInputDialog("CEP:");
        String estado = JOptionPane.showInputDialog("Estado:");
        String telefone = JOptionPane.showInputDialog("Telefone:");
        String nascimento = JOptionPane.showInputDialog("Data de Nascimento:");

        // Armazena os dados
        clientes[totalClientes][0] = id;
        clientes[totalClientes][1] = nome;
        clientes[totalClientes][2] = "TRUE"; // Ativo
        clientes[totalClientes][3] = logradouro;
        clientes[totalClientes][4] = numero;
        clientes[totalClientes][5] = bairro;
        clientes[totalClientes][6] = cidade;
        clientes[totalClientes][7] = cep;
        clientes[totalClientes][8] = estado;
        clientes[totalClientes][9] = ""; // Sexo
        clientes[totalClientes][10] = telefone;
        clientes[totalClientes][11] = nascimento;
        totalClientes++;

        JOptionPane.showMessageDialog(frame, "Cliente cadastrado com sucesso.");
    }

    private static void alterarCliente() {
        String id = JOptionPane.showInputDialog("Digite o ID do cliente a alterar:");
        int indice = buscarClientePorId(id);
        if (indice == -1) {
            JOptionPane.showMessageDialog(frame, "Cliente não existe no cadastro.");
            return;
        }

        // Alterar campos
        String novoNome = JOptionPane.showInputDialog("Novo Nome (min 1, max 60 caracteres) [Enter para manter o atual]:", clientes[indice][1]);
        if (novoNome != null && (novoNome.length() < 1 || novoNome.length() > 60)) {
            JOptionPane.showMessageDialog(frame, "Nome inválido! Mantendo o atual.");
            novoNome = clientes[indice][1];
        }
        
        String novoLogradouro = JOptionPane.showInputDialog("Novo Logradouro [Enter para manter o atual]:", clientes[indice][3]);
        String novoNumero = JOptionPane.showInputDialog("Novo Número [Enter para manter o atual]:", clientes[indice][4]);
        String novoBairro = JOptionPane.showInputDialog("Novo Bairro [Enter para manter o atual]:", clientes[indice][5]);
        String novaCidade = JOptionPane.showInputDialog("Nova Cidade [Enter para manter o atual]:", clientes[indice][6]);
        String novoCep = JOptionPane.showInputDialog("Novo CEP [Enter para manter o atual]:", clientes[indice][7]);
        String novoEstado = JOptionPane.showInputDialog("Novo Estado [Enter para manter o atual]:", clientes[indice][8]);
        String novoTelefone = JOptionPane.showInputDialog("Novo Telefone [Enter para manter o atual]:", clientes[indice][10]);
        String novaDataNascimento = JOptionPane.showInputDialog("Nova Data de Nascimento [Enter para manter o atual]:", clientes[indice][11]);

        // Atualizar os dados
        clientes[indice][1] = novoNome != null ? novoNome : clientes[indice][1];
        clientes[indice][3] = novoLogradouro != null ? novoLogradouro : clientes[indice][3];
        clientes[indice][4] = novoNumero != null ? novoNumero : clientes[indice][4];
        clientes[indice][5] = novoBairro != null ? novoBairro : clientes[indice][5];
        clientes[indice][6] = novaCidade != null ? novaCidade : clientes[indice][6];
        clientes[indice][7] = novoCep != null ? novoCep : clientes[indice][7];
        clientes[indice][8] = novoEstado != null ? novoEstado : clientes[indice][8];
        clientes[indice][10] = novoTelefone != null ? novoTelefone : clientes[indice][10];
        clientes[indice][11] = novaDataNascimento != null ? novaDataNascimento : clientes[indice][11];

        JOptionPane.showMessageDialog(frame, "Cliente alterado com sucesso.");
    }

    private static void excluirCliente() {
        String id = JOptionPane.showInputDialog("Digite o ID do cliente a excluir:");
        int indice = buscarClientePorId(id);
        if (indice == -1) {
            JOptionPane.showMessageDialog(frame, "Cliente não existe no cadastro.");
            return;
        }

        for (int i = indice; i < totalClientes - 1; i++) {
            clientes[i] = clientes[i + 1];
        }
        totalClientes--;
        JOptionPane.showMessageDialog(frame, "Cliente excluído com sucesso.");
    }

    private static void listarClientes() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID           Nome                    Logradouro             Telefone\n");
        sb.append("----------------------------------------------------------------------------\n");

        for (int i = 0; i < totalClientes; i++) {
            sb.append(String.format("%-12s %-24s %-20s %-15s\n",
                    clientes[i][0],
                    clientes[i][1],
                    clientes[i][3],
                    clientes[i][10])); // Telefone
        }

        JOptionPane.showMessageDialog(frame, sb.toString(), "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
    }

    private static int buscarClientePorId(String id) {
        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i][0].equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private static void menuCadastroProduto() {
        String[] options = {"Incluir Produto", "Alterar Produto", "Excluir Produto", "Listar Produtos", "Voltar"};
        int opcao = JOptionPane.showOptionDialog(frame, "Escolha uma opção:", "Cadastro de Produtos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (opcao) {
            case 0: incluirProduto(); break;
            case 1: alterarProduto(); break;
            case 2: excluirProduto(); break;
            case 3: listarProdutos(); break;
            case 4: break; // Voltar
            default: break;
        }
    }

    private static void incluirProduto() {
        if (totalProdutos >= LIM_REG) {
            JOptionPane.showMessageDialog(frame, "Cadastro de produtos cheio.");
            return;
        }

        String codigo = JOptionPane.showInputDialog("Código (6 caracteres):");
        if (codigo == null || codigo.length() != 6) {
            JOptionPane.showMessageDialog(frame, "Código inválido! Deve conter exatamente 6 caracteres.");
            return;
        }

        String produto = JOptionPane.showInputDialog("Nome do Produto (min 3, max 60 caracteres):");
        if (produto == null || produto.length() < 3 || produto.length() > 60) {
            JOptionPane.showMessageDialog(frame, "Nome do produto inválido!");
            return;
        }

        double preco;
        do {
            String precoStr = JOptionPane.showInputDialog("Preço (formato 0.00):");
            try {
                preco = Double.parseDouble(precoStr);
                if (preco < 0) {
                    JOptionPane.showMessageDialog(frame, "O preço não pode ser negativo!");
                }
            } catch (NumberFormatException e) {
                preco = -1; // Forçar nova entrada
                JOptionPane.showMessageDialog(frame, "Preço inválido! Insira um número.");
            }
        } while (preco < 0);

        String tipo = JOptionPane.showInputDialog("Tipo:");

        // Armazena os dados
        produtos[totalProdutos][0] = codigo;
        produtos[totalProdutos][1] = produto;
        produtos[totalProdutos][2] = String.valueOf(preco);
        produtos[totalProdutos][3] = tipo;
        totalProdutos++;

        JOptionPane.showMessageDialog(frame, "Produto cadastrado com sucesso.");
    }

    private static void alterarProduto() {
        String codigo = JOptionPane.showInputDialog("Digite o código do produto a alterar:");
        int indice = buscarProdutoPorCodigo(codigo);
        if (indice == -1) {
            JOptionPane.showMessageDialog(frame, "Produto não existe no cadastro.");
            return;
        }

        String novoProduto = JOptionPane.showInputDialog("Novo Nome do Produto (min 3, max 60 caracteres) [Enter para manter o atual]:", produtos[indice][1]);
        if (novoProduto != null && (novoProduto.length() < 3 || novoProduto.length() > 60)) {
            JOptionPane.showMessageDialog(frame, "Nome inválido!");
            return;
        }

        String novoPrecoStr = JOptionPane.showInputDialog("Novo Preço (formato 0.00) [Enter para manter o atual]:");
        double novoPreco = produtos[indice][2] != null ? Double.parseDouble(produtos[indice][2]) : 0;
        if (novoPrecoStr != null && !novoPrecoStr.isEmpty()) {
            try {
                novoPreco = Double.parseDouble(novoPrecoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Preço inválido! Mantendo o atual.");
            }
        }

        String novoTipo = JOptionPane.showInputDialog("Novo Tipo [Enter para manter o atual]:", produtos[indice][3]);

        // Atualizar os dados
        produtos[indice][1] = novoProduto != null ? novoProduto : produtos[indice][1];
        produtos[indice][2] = String.valueOf(novoPreco);
        produtos[indice][3] = novoTipo != null ? novoTipo : produtos[indice][3];

        JOptionPane.showMessageDialog(frame, "Produto alterado com sucesso.");
    }

    private static void excluirProduto() {
        String codigo = JOptionPane.showInputDialog("Digite o código do produto a excluir:");
        int indice = buscarProdutoPorCodigo(codigo);
        if (indice == -1) {
            JOptionPane.showMessageDialog(frame, "Produto não existe no cadastro.");
            return;
        }

        for (int i = indice; i < totalProdutos - 1; i++) {
            produtos[i] = produtos[i + 1];
        }
        totalProdutos--;
        JOptionPane.showMessageDialog(frame, "Produto excluído com sucesso.");
    }

    private static void listarProdutos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código    Nome                   Preço        Tipo\n");
        sb.append("---------------------------------------------------\n");

        for (int i = 0; i < totalProdutos; i++) {
            sb.append(String.format("%-10s %-20s %-10s %-10s\n",
                    produtos[i][0],
                    produtos[i][1],
                    produtos[i][2],
                    produtos[i][3]));
        }

        JOptionPane.showMessageDialog(frame, sb.toString(), "Lista de Produtos", JOptionPane.INFORMATION_MESSAGE);
    }

    private static int buscarProdutoPorCodigo(String codigo) {
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i][0].equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    private static void imprimirCardapioProdutos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cardápio de Produtos\n");
        sb.append("---------------------------------------------------------------\n");

        for (int i = 0; i < totalProdutos; i++) {
            sb.append(String.format("%-10s %-20s %-10s %-10s\n",
                    produtos[i][0],
                    produtos[i][1],
                    produtos[i][2],
                    produtos[i][3]));
        }

        JOptionPane.showMessageDialog(frame, sb.toString(), "Cardápio de Produtos", JOptionPane.INFORMATION_MESSAGE);
    }
}

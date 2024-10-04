import java.util.Scanner; // Importa a classe Scanner para entrada de dados do usuário

public class CdpoPitDog {

    // Declara uma constante que define o número máximo de produtos
    private static final int LIM_REG = 100;

    // Matriz para armazenar os produtos, com 4 colunas: [Código, Produto, Ativo,
    // Preço]
    private static final String[][] produtos = new String[LIM_REG][4];

    // Variável para contar quantos produtos estão cadastrados
    private static int totalProdutos = 0;

    // Declara uma constante que define o número máximo de clientes
    private static final int LIM_CLI = 100;

    // Matriz para armazenar os clientes, com 13 colunas: [Id, Nome, Logradouro,
    // NmrEndereco, Complemento, Bairro, Cidade, Cep, Estado, Sexo, Telefone,
    // Nascimento, Autorizado]
    private static final String[][] clientes = new String[LIM_CLI][13];

    // Variável para contar quantos clientes estão cadastrados
    private static int totalClientes = 0;

    // Scanner para ler as entradas do usuário
    private static Scanner entradaDados = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao; // Variável que armazena a escolha do menu principal

        do {
            // Exibe o menu principal na tela
            exibirMenuPrincipal();
            // Lê a opção digitada pelo usuário
            opcao = entradaDados.nextInt();
            entradaDados.nextLine(); // Consumir a quebra de linha que sobra após o nextInt()

            // Switch para executar ações de acordo com a opção escolhida
            switch (opcao) {
                case 1:
                    menuCadastroClientes(); // Chama a função que imprime o clientes
                    break;
            
                default:
                    System.out.println("Opção inválida! Tente novamente."); // Mensagem de erro para opção inválida
            }
        } while (opcao != 4); // Repete até que o usuário escolha a opção "Sair"
    }

    // Função que exibe o menu principal
    private static void exibirMenuPrincipal() {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Cadastro do Cliente");
        System.out.println("2. Cadastro de Produtos");
        System.out.println("3. Imprimir Cardápio");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Função que exibe o cadastro de clientes
    private static void menuCadastroClientes() {
        System.out.println("\nCadastro de Clientes:");
        System.out.println("1. Incluir Cliente");
        System.out.println("2. Alterar Cliente");
        System.out.println("3. Excluir Cliente");
        System.out.println("4. Consultar Cliente");
        System.out.print("Escolha uma opção: ");
        int opcaoC = entradaDados.nextInt();
        entradaDados.nextLine(); // Consumir a quebra de linha

        // Switch para escolher qual operação do cadastro de clientes
        switch (opcaoC) {
            case 1:
                incluirCliente(); // Chama função para incluir um novo cliente
                break;
            case 2:
                alterarCliente(); // Chama função para alterar um cliente existente
                break;
            case 3:
                excluirCliente(); // Chama função para excluir um cliente
                break;
            case 4:
                consultarCliente(); // Chama função para consultar um cliente pelo código
                break;
            default:
                System.out.println("Opção inválida!"); // Mensagem de erro para opção inválida
        }
    }

    // Função para incluir um novo cliente
    private static void incluirCliente() {
        if (totalClientes >= LIM_CLI) {
            System.out.println("Cadastro de clientes cheio.");
            return; // Sai da função caso não seja possível incluir mais clientes
        }

        String id;
        // Laço para garantir que o código tenha 11 caracteres válidos
        do {
            System.out.print("idCliente (11 caracteres alfanuméricos): ");
            id = entradaDados.nextLine().toUpperCase(); // Converte o código para letras maiúsculas
            if (id.length() != 11) {
                System.out.println("Código inválido! Deve conter exatamente 11 caracteres.");
            }
        } while (id.length() != 11); // Repete até que o código seja válido

        String Nome;
        // Laço para garantir que o nome do cliente tenha entre (1 a 60 caracteres)
        do {
            System.out.print("Nome: ");
            Nome = entradaDados.nextLine().toUpperCase(); // Converte a descrição para letras maiúsculas
            if (Nome.length() < 1 || Nome.length() > 60) {
                System.out.println("Descrição do produto inválida!");
            }
        } while (Nome.length() < 1 || Nome.length() > 60); // Repete até que a descrição seja válida

        String logradouro;
        // Laço para garantir que o logardouro tenha entre (1 a 60 caracteres)
        do {
            System.out.print("Logradouro : ");
            logradouro = entradaDados.nextLine().toUpperCase(); // Converte a descrição para letras maiúsculas
            if (logradouro.length() < 1 || logradouro.length() > 60) {
                System.out.println("Descrição do produto inválida!");
            }
        } while (logradouro.length() < 1 || logradouro.length() > 60); // Repete até que a descrição seja válida

        String NmrEndereco;
        // Laço para garantir que o preço seja positivo
        do {
            System.out.print("Numero do seu endereco: ");
            NmrEndereco = entradaDados.nextLine();
            entradaDados.nextLine(); // Consumir a quebra de linha

            if (NmrEndereco.length() < 0 || NmrEndereco.length() > 5) {
                System.out.println("Deve conter no Máximo 5 numeros.");
            }
        } while (NmrEndereco.length() < 0 || NmrEndereco.length() > 5); // Repete até que o preço seja válido

        String complemento;
        // Laço para garantir que a descrição do produto seja válida (3 a 60 caracteres)
        do {
            System.out.print("complemento: ");
            complemento = entradaDados.nextLine().toUpperCase(); // Converte a descrição para letras maiúsculas
            if (complemento.length() < 1 || complemento.length() > 60) {
                System.out.println("Limite de caracters alingido!");
            }
        } while (complemento.length() < 1 || complemento.length() > 60); // Repete até que a descrição seja válida

        String bairro;
        // Laço para garantir que a descrição do produto seja válida (3 a 60 caracteres)
        do {
            System.out.print("Bairro: ");
            bairro = entradaDados.nextLine().toUpperCase(); // Converte a descrição para letras maiúsculas
            if (bairro.length() < 1 || bairro.length() > 60) {
                System.out.println("Limite de caracters alingido!");
            }
        } while (bairro.length() < 1 || bairro.length() > 60); // Repete até que a descrição seja válida

        String cidade;
        // Laço para garantir que a descrição do produto seja válida (3 a 60 caracteres)
        do {
            System.out.print("Cidade: ");
            cidade = entradaDados.nextLine().toUpperCase(); // Converte a descrição para letras maiúsculas
            if (cidade.length() < 1 || cidade.length() > 60) {
                System.out.println("Limite de caracters alingido!");
            }
        } while (cidade.length() < 1 || cidade.length() > 60); // Repete até que a descrição seja válida

        String cep;
        // Laço para garantir que o preço seja positivo
        do {
            System.out.print("CEP: ");
            cep = entradaDados.nextLine();
            entradaDados.nextLine(); // Consumir a quebra de linha

            if (cep.length() < 0 || cep.length() > 8) {
                System.out.println("Limite de caracters alingido!");
            }
        } while (cep.length() < 0 || cep.length() > 8); // Repete até que o preço seja válido

        String estado;
        // Laço para garantir que a descrição do produto seja válida (3 a 60 caracteres)
        do {
            System.out.print("Estado: ");
            estado = entradaDados.nextLine().toUpperCase(); // Converte a descrição para letras maiúsculas
            if (estado.length() < 2 || estado.length() > 2) {
                System.out.println("Limite de caracters alingido!");
            }
        } while (estado.length() < 2 || estado.length() > 2); // Repete até que a descrição seja válida

        String sexo;
        do {
            System.out.print("Sexo (M para masculino, F para feminino): ");
            sexo = entradaDados.nextLine().toUpperCase();

            if (!sexo.equals("M") && !sexo.equals("F")) {
                System.out.println("Valor inválido! Informe M ou F.");
            }
        } while (!sexo.equals("M") && !sexo.equals("F"));

        String telefone;
        // Numero de telefone
        do {
            System.out.print("Telefone: ");
            telefone = entradaDados.nextLine();
            entradaDados.nextLine(); // Consumir a quebra de linha

            if (telefone.length() < 0 || telefone.length() < 8) {
                System.out.println("Número incorreto! Tente novamente.");
            }
        } while (telefone.length() < 0 || telefone.length() < 8); // Repete até que o preço seja válido

        String nascimento;
        // Laço para garantir a data tenha entre (1 e 10 caracteres)
        do {
            System.out.print("Data de nascimento: ");
            nascimento = entradaDados.nextLine().toUpperCase(); // Converte a descrição para letras maiúsculas
            if (nascimento.length() < 1 || nascimento.length() > 10) {
                System.out.println("Limite de caracters alingido!");
            }
        } while (nascimento.length() < 1 || nascimento.length() > 10); // Repete até que a descrição seja válida

        // Laço Autorização do cliente
        String autorizado;
        do {
            System.out.print("Cliente autorizado? true // false: ");
            autorizado = entradaDados.nextLine().toUpperCase();

            if (!autorizado.equals("TRUE") && !autorizado.equals("FALSE")) {
                System.out.println("Valor inválido! Informe true ou false.");
            }
        } while (!autorizado.equals("TRUE") && !autorizado.equals("FALSE"));

        // Adiciona o produto na matriz, preenchendo os dados
        clientes[totalClientes][0] = id;
        clientes[totalClientes][1] = Nome;
        clientes[totalClientes][2] = autorizado;
        clientes[totalClientes][3] = logradouro;
        clientes[totalClientes][4] = NmrEndereco;
        clientes[totalClientes][5] = complemento;
        clientes[totalClientes][6] = bairro;
        clientes[totalClientes][7] = cidade;
        clientes[totalClientes][8] = cep;
        clientes[totalClientes][9] = estado;
        clientes[totalClientes][10] = sexo;
        clientes[totalClientes][11] = telefone;
        clientes[totalClientes][12] = nascimento;
    
        totalClientes++;

        System.out.println("Cliente cadastrado com sucesso.");
    }

    // Função para alterar um cliente existente, mantendo os valores originais caso
    // o usuário não altere
    private static void alterarCliente() {
        System.out.print("Digite o código do cliente que deseja alterar: ");
        String id = entradaDados.nextLine().toUpperCase(); // Lê o código em letras maiúsculas

        // Busca o cliente pelo código
        int indice = buscarClientePorId(id);
        if (indice == -1) {
            System.out.println("Cliente não existe no cadastro."); // Mensagem caso o produto não seja encontrado
            return; // Sai da função
        }

        // Mostra os valores atuais do produto
        System.out.println("Id atual: " + clientes[indice][0]);
        System.out.println("Nome atual: " + clientes[indice][1]);
        System.out.println("autorizados atual: " + clientes[indice][2]);
        System.out.println("logradouro atual: " + clientes[indice][3]);
        System.out.println("NmrEndereco atual: " + clientes[indice][4]);
        System.out.println("complento atual: " + clientes[indice][5]);
        System.out.println("bairro atual: " + clientes[indice][6]);
        System.out.println("cidade atual: " + clientes[indice][7]);
        System.out.println("cep atual: " + clientes[indice][8]);
        System.out.println("estado atual: " + clientes[indice][9]);
        System.out.println("sexo atual: " + clientes[indice][10]);
        System.out.println("telefone atual: " + clientes[indice][11]);
        System.out.println("nascimento atual: " + clientes[indice][12]);
        System.out.println("estado atual: " + clientes[indice][13]);
        // Pergunta se quer alterar o nome do cliente e valida se for alterado
        String novoCliente;
        do {
            System.out.print("Novo Cliente (min 3, max 60 caracteres) [Enter para manter o atual]: ");
            novoCliente = entradaDados.nextLine().toUpperCase();
            if (novoCliente.isEmpty()) {
                novoCliente = clientes[indice][1]; // Mantém o valor original se não for alterado
            } else if (novoCliente.length() < 3 || novoCliente.length() > 60) {
                System.out.println("Descrição do cliente inválida!");
                novoCliente = null; // Requer nova entrada se for inválido
            }
        } while (novoCliente == null);

        // Pergunta se quer alterar o preço e valida se for alterado
        String novoPrecoStr;
        double novoPreco = 0;
        do {
            System.out.print("Novo Preço (formato 0.00) [Enter para manter o atual]: ");
            novoPrecoStr = entradaDados.nextLine();
            if (!novoPrecoStr.isEmpty()) {
                novoPreco = Double.parseDouble(novoPrecoStr);
                if (novoPreco < 0) {
                    System.out.println("O preço deve ser positivo.");
                    novoPreco = -1; // Requer nova entrada se for inválido
                }
            }
        } while (novoPreco < 0);

        // Pergunta se quer alterar o status de ativo e valida se for alterado
        String novoAtivo;
        do {
            System.out.print("Novo Ativo (true para ativo, false para desativado) [Enter para manter o atual]: ");
            novoAtivo = entradaDados.nextLine().toUpperCase();
            if (novoAtivo.isEmpty()) {
                novoAtivo = produtos[indice][2]; // Mantém o valor original se não for alterado
            } else if (!novoAtivo.equals("TRUE") && !novoAtivo.equals("FALSE")) {
                System.out.println("Valor inválido! Informe true ou false.");
                novoAtivo = null; // Requer nova entrada se for inválido
            }
        } while (novoAtivo == null);

        // Atualiza os dados na matriz
        clientes[indice][1] = novoCliente;
        clientes[indice][3] = String.format("%.2f", novoPreco); // Formata o preço com duas casas decimais
        clientes[indice][2] = novoAtivo.equals("TRUE") ? "TRUE" : "FALSE";

        System.out.println("Produto alterado com sucesso.");
    }

    // Função para excluir um cliente pelo código
    private static void excluirCliente() {
        System.out.print("Digite o ID do produto a excluir: ");
        String id = entradaDados.nextLine().toUpperCase();  // Lê o código em letras maiúsculas
    
        // Busca o produto pelo código
        int indice = buscarClientePorId(id);
        if (indice == -1) {
            System.out.println("cliente não existe no cadastro.");  // Mensagem caso o produto não seja encontrado
            return;
        }
    
        // Desloca todos os produtos após o excluído para "remover" o produto da matriz
        for (int i = indice; i < totalClientes - 1; i++) {
            clientes[i] = clientes[i + 1];  // Desloca os produtos para cima
        }
        totalClientes--;  // Reduz o total de produtos cadastrados
        System.out.println("Produto excluído com sucesso.");
    }
    // Função para consultar o cliente pelo código
    private static void buscarCliente() {
        System.out.print("Digite o código do cliente: ");
        String id = entradaDados.nextLine().toUpperCase(); // Lê o código em letras maiúsculas

        // Busca o cliente pelo código
        int indice = buscarClientePorId(id);
        if (indice == -1) {
            System.out.println("Cliente não existe no cadastro."); // Mensagem caso o produto não seja encontrado
            return;
        }

        // Exibe os dados do clientes encontrado
        System.out.println("Id: " + clientes[indice][0]);
        System.out.println("Nome: " + clientes[indice][1]);
        System.out.println("autorizados: " + clientes[indice][2]);
        System.out.println("logradouro: " + clientes[indice][3]);
        System.out.println("NmrEndereco: " + clientes[indice][4]);
        System.out.println("complento: " + clientes[indice][5]);
        System.out.println("bairro: " + clientes[indice][6]);
        System.out.println("cidade: " + clientes[indice][7]);
        System.out.println("cep: " + clientes[indice][8]);
        System.out.println("estado: " + clientes[indice][9]);
        System.out.println("sexo: " + clientes[indice][10]);
        System.out.println("telefone: " + clientes[indice][11]);
        System.out.println("nascimento: " + clientes[indice][12]);
        System.out.println("estado: " + clientes[indice][13]);
    }

    // Função para buscar um cliente pelo código
    private static int buscarClientePorId(String id) {
        // Percorre a matriz de clientes
        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i][0].equals(id)) {
                return i; // Retorna o índice do cliente se encontrado
            }
        }
        return -1; // Retorna -1 se o cliente não for encontrado
    }

    // Função que imprime o cardápio com os produtos ativos
    private static void consultarCliente() {
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
        System.out.println(
                "ID CLIENTE                                                                             NOME");
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        // Percorre todos os produtos cadastrados e imprime os que estão ativos
        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i][12].equals("TRUE")) { // Verifica se o produto está ativo
                // Formata e imprime o código, a descrição do produto e o preço
                System.out.printf("%-7s %-80s %6s\n", clientes[i][0], clientes[i][1], clientes[i][2], clientes[i][3],clientes[i][4],clientes[i][5],clientes[i][6],clientes[i][7],clientes[i][8],clientes[i][9],clientes[i][10],clientes[i][11],clientes[i][12] );
            }
        }
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
    }

    // Função que exibe o menu de cadastro de produtos e trata as opções
    private static void menuCadastroProduto() {
        System.out.println("\nCadastro de Produtos:");
        System.out.println("1. Incluir Produto");
        System.out.println("2. Alterar Produto");
        System.out.println("3. Excluir Produto");
        System.out.println("4. Consultar Produto");
        System.out.print("Escolha uma opção: ");
        int opcao = entradaDados.nextInt();
        entradaDados.nextLine(); // Consumir a quebra de linha

        // Switch para escolher qual operação do cadastro de produtos será realizada
        switch (opcao) {
            case 1:
                incluirProduto(); // Chama função para incluir um novo produto
                break;
            case 2:
                alterarProduto(); // Chama função para alterar um produto existente
                break;
            case 3:
                excluirProduto(); // Chama função para excluir um produto
                break;
            case 4:
                consultarProduto(); // Chama função para consultar um produto pelo código
                break;
            default:
                System.out.println("Opção inválida!"); // Mensagem de erro para opção inválida
        }
    }

    // Função para incluir um novo produto
    private static void incluirProduto() {
        // Verifica se a capacidade máxima de produtos foi atingida
        if (totalProdutos >= LIM_REG) {
            System.out.println("Cadastro de produtos cheio.");
            return; // Sai da função caso não seja possível incluir mais produtos
        }

        String codigo;
        // Laço para garantir que o código tenha 6 caracteres válidos
        do {
            System.out.print("Código (6 caracteres alfanuméricos): ");
            codigo = entradaDados.nextLine().toUpperCase(); // Converte o código para letras maiúsculas
            if (codigo.length() != 6) {
                System.out.println("Código inválido! Deve conter exatamente 6 caracteres.");
            }
        } while (codigo.length() != 6); // Repete até que o código seja válido

        String produto;
        // Laço para garantir que a descrição do produto seja válida (3 a 60 caracteres)
        do {
            System.out.print("Produto (min 3, max 60 caracteres): ");
            produto = entradaDados.nextLine().toUpperCase(); // Converte a descrição para letras maiúsculas
            if (produto.length() < 3 || produto.length() > 60) {
                System.out.println("Descrição do produto inválida!");
            }
        } while (produto.length() < 3 || produto.length() > 60); // Repete até que a descrição seja válida

        double preco;
        // Laço para garantir que o preço seja positivo
        do {
            System.out.print("Preço (formato 0.00): ");
            preco = entradaDados.nextDouble();
            entradaDados.nextLine(); // Consumir a quebra de linha

            if (preco < 0) {
                System.out.println("O preço deve ser positivo.");
            }
        } while (preco < 0); // Repete até que o preço seja válido

        // Laço para garantir que o valor de ativo seja válido
        String ativo;
        do {
            System.out.print("Ativo (true para ativo, false para desativado): ");
            ativo = entradaDados.nextLine().toUpperCase();

            if (!ativo.equals("TRUE") && !ativo.equals("FALSE")) {
                System.out.println("Valor inválido! Informe true ou false.");
            }
        } while (!ativo.equals("TRUE") && !ativo.equals("FALSE"));

        // Adiciona o produto na matriz, preenchendo os dados
        produtos[totalProdutos][0] = codigo; // Código
        produtos[totalProdutos][1] = produto; // Nome do produto
        produtos[totalProdutos][2] = ativo; // Ativo ou desativado
        produtos[totalProdutos][3] = String.format("%.2f", preco); // Formata o preço com duas casas decimais
        totalProdutos++; // Incrementa o total de produtos cadastrados

        System.out.println("Produto cadastrado com sucesso.");
    }

    // Função para alterar um produto existente, mantendo os valores originais caso
    // o usuário não altere
    private static void alterarProduto() {
        System.out.print("Digite o código do produto a alterar: ");
        String codigo = entradaDados.nextLine().toUpperCase(); // Lê o código em letras maiúsculas

        // Busca o produto pelo código
        int indice = buscarProdutoPorCodigo(codigo);
        if (indice == -1) {
            System.out.println("Produto não existe no cadastro."); // Mensagem caso o produto não seja encontrado
            return; // Sai da função
        }

        // Mostra os valores atuais do produto
        System.out.println("Código atual: " + produtos[indice][0]);
        System.out.println("Produto atual: " + produtos[indice][1]);
        System.out.println("Preço atual: " + produtos[indice][3]);
        System.out.println("Ativo atual: " + produtos[indice][2]);

        // Pergunta se quer alterar o nome do produto e valida se for alterado
        String novoProduto;
        do {
            System.out.print("Novo Produto (min 3, max 60 caracteres) [Enter para manter o atual]: ");
            novoProduto = entradaDados.nextLine().toUpperCase();
            if (novoProduto.isEmpty()) {
                novoProduto = produtos[indice][1]; // Mantém o valor original se não for alterado
            } else if (novoProduto.length() < 3 || novoProduto.length() > 60) {
                System.out.println("Descrição do produto inválida!");
                novoProduto = null; // Requer nova entrada se for inválido
            }
        } while (novoProduto == null);

        // Pergunta se quer alterar o preço e valida se for alterado
        String novoPrecoStr;
        double novoPreco = 0;
        do {
            System.out.print("Novo Preço (formato 0.00) [Enter para manter o atual]: ");
            novoPrecoStr = entradaDados.nextLine();
            if (!novoPrecoStr.isEmpty()) {
                novoPreco = Double.parseDouble(novoPrecoStr);
                if (novoPreco < 0) {
                    System.out.println("O preço deve ser positivo.");
                    novoPreco = -1; // Requer nova entrada se for inválido
                }
            }
        } while (novoPreco < 0);

        // Pergunta se quer alterar o status de ativo e valida se for alterado
        String novoAtivo;
        do {
            System.out.print("Novo Ativo (true para ativo, false para desativado) [Enter para manter o atual]: ");
            novoAtivo = entradaDados.nextLine().toUpperCase();
            if (novoAtivo.isEmpty()) {
                novoAtivo = produtos[indice][2]; // Mantém o valor original se não for alterado
            } else if (!novoAtivo.equals("TRUE") && !novoAtivo.equals("FALSE")) {
                System.out.println("Valor inválido! Informe true ou false.");
                novoAtivo = null; // Requer nova entrada se for inválido
            }
        } while (novoAtivo == null);

        // Atualiza os dados na matriz
        produtos[indice][1] = novoProduto;
        produtos[indice][3] = String.format("%.2f", novoPreco); // Formata o preço com duas casas decimais
        produtos[indice][2] = novoAtivo.equals("TRUE") ? "TRUE" : "FALSE";

        System.out.println("Produto alterado com sucesso.");
    }

    // Função para excluir um produto pelo código
    private static void excluirProduto() {
        System.out.print("Digite o código do produto a excluir: ");
        String codigo = entradaDados.nextLine().toUpperCase(); // Lê o código em letras maiúsculas

        // Busca o produto pelo código 
        int indice = buscarProdutoPorCodigo(codigo);
        if (indice == -1) {
            System.out.println("Produto não existe no cadastro."); // Mensagem caso o produto não seja encontrado
            return;
        }

        // Desloca todos os produtos após o excluído para "remover" o produto da matriz
        for (int i = indice; i < totalProdutos - 1; i++) {
            produtos[i] = produtos[i + 1]; // Desloca os produtos para cima
        }
        totalProdutos--; // Reduz o total de produtos cadastrados
        System.out.println("Produto excluído com sucesso.");
    }

    // Função para consultar um produto pelo código
    private static void consultarProduto() {
        System.out.print("Digite o código do produto: ");
        String codigo = entradaDados.nextLine().toUpperCase(); // Lê o código em letras maiúsculas

        // Busca o produto pelo código
        int indice = buscarProdutoPorCodigo(codigo);
        if (indice == -1) {
            System.out.println("Produto não existe no cadastro."); // Mensagem caso o produto não seja encontrado
            return;
        }

        // Exibe os dados do produto encontrado
        System.out.println("Código: " + produtos[indice][0]);
        System.out.println("Produto: " + produtos[indice][1]);
        System.out.println("Ativo: " + produtos[indice][2]);
        System.out.println("Preço: R$" + produtos[indice][3]);
    }

    // Função para buscar um produto pelo código
    private static int buscarProdutoPorCodigo(String codigo) {
        // Percorre a matriz de produtos
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i][0].equals(codigo)) {
                return i; // Retorna o índice do produto se encontrado
            }
        }
        return -1; // Retorna -1 se o produto não for encontrado
    }

    // Função que imprime o cardápio com os produtos ativos
    private static void imprimirCardapioProdutos() {
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
        System.out.println(
                "CÓDIGO PRODUTO                                                                           VALOR");
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        // Percorre todos os produtos cadastrados e imprime os que estão ativos
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i][2].equals("TRUE")) { // Verifica se o produto está ativo
                // Formata e imprime o código, a descrição do produto e o preço
                System.out.printf("%-7s %-80s %6s\n", produtos[i][0], produtos[i][1], produtos[i][3]);
            }
        }
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
    }
}

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaPessoa {
    public static void main(String[] args) {
        SistemaPessoaApp app = new SistemaPessoaApp();
        app.iniciar();
    }
}

class SistemaPessoaApp {
    private static final String VERSAO_SISTEMA = "12.1.2024";
    private static final String NOME_USUARIO = "denys.silva";
    
    public void iniciar() {
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);

        MenuPrincipal menu = new MenuPrincipal();
        AreaTrabalho areaTrabalho = new AreaTrabalho();
        Rodape rodape = new Rodape(VERSAO_SISTEMA, NOME_USUARIO);
        
        principal.getContentPane().add(BorderLayout.NORTH, menu.criarMenu());
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho.criarAreaTrabalho());
        principal.getContentPane().add(BorderLayout.SOUTH, rodape.criarRodape());
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
}

class MenuPrincipal {
    public JMenuBar criarMenu() {
        JMenuBar menuPrincipal = new JMenuBar();
        
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");
        
        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }

            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) { }

            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) { }
        });

        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);
        
        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);
        
        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);

        return menuPrincipal;
    }
}

class AreaTrabalho {
    public JTextArea criarAreaTrabalho() {
        JTextArea areaTrabalho = new JTextArea();
        return areaTrabalho;
    }
}

class Rodape {
    private String versaoSistema;
    private String nomeUsuario;

    public Rodape(String versaoSistema, String nomeUsuario) {
        this.versaoSistema = versaoSistema;
        this.nomeUsuario = nomeUsuario;
    }

    public JPanel criarRodape() {
        JPanel painelRodape = new JPanel();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        String dataAcesso = dateFormat.format(new Date());
        JLabel labelRodape = new JLabel("Versão: " + versaoSistema + "               Usuário: " + nomeUsuario + "               Data de acesso: " + dataAcesso);
        painelRodape.add(labelRodape);
        return painelRodape;
    }
}

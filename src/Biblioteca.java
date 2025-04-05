import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Material> materiais;
    private Scanner scanner;

    public Biblioteca() {
        materiais = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addMaterial() {
        
        limparTela();

        System.out.println("""
            ------------------------------------
                   ADICIONAR NOVO MATERIAL
            ------------------------------------
            """);

        String tipo, titulo, autor;

        // Obter tipo do material
        while (true) {
            System.out.print("Seu material é 'livro' ou 'revista'? ");
            tipo = scanner.nextLine().trim().toLowerCase();
        
            if (tipo.equals("livro") || tipo.equals("revista")) {
                break;
            } else {
                System.out.println("Tipo inválido. Por favor, digite 'livro' ou 'revista'.");
            }
        }
            
        // Obter o título do material 
        titulo = lerString("Digite o título do " + tipo + ": ");
        
        // Obter o autor do material 
        autor = lerString("Digite o autor do " + tipo + ": ");
            
        // Se for livro
        if (tipo.equals("livro")) {
            String genero = lerString("Digite o gênero do livro: ");

            if (confirmacaoOperacao("adicionar", tipo).equals("N")) {
                System.out.println("Operação cancelada.");
                continuar();
                return;
            }

            Livro livro = new Livro(titulo, autor, genero);
            materiais.add(livro);
            System.out.println("Livro adicionado com sucesso!");
            continuar();

        // Se for revista
        } else {
            int numero = lerInteiro("Digite o número da revista: ");

            if (confirmacaoOperacao("adicionar", tipo).equals("N")) {
                System.out.println("Operação cancelada.");
                continuar();
                return;
            }

            Revista revista = new Revista(titulo, autor, numero);
            materiais.add(revista);
            System.out.println("Revista adicionada com sucesso!");
            continuar();
        }
    }

    public void pesquisarMaterial() {

        limparTela();

        System.out.println("""
        ------------------------------------
          PESQUISAR MATERIAL NA BIBLIOTECA
        ------------------------------------
        """);

        String titulo = lerString("Digite o título do material que deseja pesquisar: ");
        
        Material encontrado = localizarMaterial(titulo);

        if (encontrado != null) {
            System.out.println(encontrado.toString());
        } else {
            System.out.println("Não localizamos o material " + titulo + ", tente novamente!");
        }
        continuar();
    }

    public void excluirMaterial() {

        limparTela();
        
        System.out.println("""
            ------------------------------------
                EXCLUIR MATERIAL DA BIBLIOTECA
            ------------------------------------
            """);

        String titulo = lerString("Digite o título do material que deseja excluir: ");

        Material encontrado = localizarMaterial(titulo);

        if (encontrado != null) {
            if (confirmacaoOperacao("deletar", encontrado instanceof Livro ? "livro" : "revista").equals("S")) {
                materiais.remove(encontrado);
                System.out.println("Material removido com sucesso!");
                continuar();
            } else {
            System.out.println("Operação cancelada.");
            continuar();
            }
        } else {
            System.out.println("Não localizamos o material " + titulo + ", tente novamente!");
            continuar();
        }
    }

    public void listarMateriais() {

        limparTela();
        
        System.out.println("""
        ------------------------------------
              TODOS OS NOSSOS MATERIAIS
        ------------------------------------
        """);

        if (materiais.isEmpty()) {
            System.out.println("Biblioteca vazia!");
            continuar();
            return;
        }

        for (Material m : materiais) {
            if (m instanceof Livro) {
                System.out.println("Livro:");
            } else {
                System.out.println("Revista:");
            }
            System.out.println(m.toString());
        }
        continuar();        
    }
    
    // Método para ler Strings
    private String lerString(String mensagem) {
        String entrada;
        do {
            System.out.print(mensagem);
            entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Leitura vazia. Por favor, tente digitar novamente.");
            }
        } while (entrada.isEmpty());
        return entrada;
    }
    
    // Método para ler inteiros
    private int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } else {
                System.out.println("Gentileza, digite um número inteiro.");
                scanner.nextLine();
            }
        }
    }

    // Método de confirmação
    private String confirmacaoOperacao(String acao, String tipo) {
        String confirmacao;
        do {
            System.out.println("Tem certeza que deseja " + acao + " " + tipo + "? (S/N)");
            confirmacao = scanner.nextLine().toUpperCase();
            if (!(confirmacao.equals("S") || confirmacao.equals("N"))) {
                System.out.println("Opção inválida. Por favor, digite S ou N.");
            }
        } while (!(confirmacao.equals("S") || confirmacao.equals("N")));
        return confirmacao;
    }

    // Método para localizar o material no arrayList
    private Material localizarMaterial(String titulo) {
        for (Material m : materiais) {
            if (m.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                return m;
            }
        }
        return null;
    }

    public void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void continuar() {
        System.out.println("");
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }
}

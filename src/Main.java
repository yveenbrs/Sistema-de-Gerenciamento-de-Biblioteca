import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            biblioteca.limparTela();

            System.out.println("""

                    ------------------------------------
                    SEJA BEM-VINDO À NOSSA BIBLIOTECA!!!
                    ------------------------------------

                              O que deseja?

                    1 - Adicionar um novo material
                    2 - Pesquisar um material pelo título
                    3 - Excluir um material pelo título
                    4 - Listar todos os materiais
                    5 - Encerrar o sistema
                    """);

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    biblioteca.addMaterial();
                    break;
                case 2:
                    biblioteca.pesquisarMaterial();
                    break;
                case 3:
                    biblioteca.excluirMaterial();
                    break;
                case 4:
                    biblioteca.listarMateriais();
                    break;
                case 5:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida");
                    ;
            }

            if (opcao == 5) {
                break;
            }
        }
        scanner.close();
    }
}
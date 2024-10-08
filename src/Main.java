import java.util.Scanner;


class Produto {
    private String nome;
    private int quantidadeEmEstoque;

    public Produto(String nome, int quantidadeEmEstoque) {
        this.nome = nome;
        setQuantidadeEmEstoque(quantidadeEmEstoque);
    }

    public String getNome() {
        return nome;
    }


    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) {
            System.out.println("Erro: A quantidade em estoque não pode ser negativa.");
        } else {
            this.quantidadeEmEstoque = quantidadeEmEstoque;
        }
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade < 0) {
            System.out.println("Erro: Não é possível adicionar uma quantidade negativa.");
        } else {
            this.quantidadeEmEstoque += quantidade;
            System.out.println("Estoque atualizado: " + this.quantidadeEmEstoque);
        }
    }

    public void removerEstoque(int quantidade) {
        if (quantidade < 0) {
            System.out.println("Erro: Não é possível remover uma quantidade negativa.");
        } else if (quantidade > this.quantidadeEmEstoque) {
            System.out.println("Erro: Estoque insuficiente para remover a quantidade desejada.");
        } else {
            this.quantidadeEmEstoque -= quantidade;
            System.out.println("Estoque atualizado: " + this.quantidadeEmEstoque);
        }
    }

    public void exibirInformacoes() {
        System.out.println("Nome do Produto: " + nome);
        System.out.println("Quantidade em Estoque: " + quantidadeEmEstoque);
    }
}

 class Vendas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto produto = null;

        while (true) {
            System.out.println("Sistema de Vendas");
            System.out.println("1. Criar novo produto");
            System.out.println("2. Adicionar ao estoque");
            System.out.println("3. Remover do estoque");
            System.out.println("4. Exibir informações do produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a quantidade em estoque: ");
                    int quantidade = scanner.nextInt();
                    produto = new Produto(nome, quantidade);
                    System.out.println("Produto criado com sucesso.");
                    break;

                case 2:
                    if (produto != null) {
                        System.out.print("Digite a quantidade a ser adicionada: ");
                        int quantidadeAdicionar = scanner.nextInt();
                        produto.adicionarEstoque(quantidadeAdicionar);
                    } else {
                        System.out.println("Erro: Nenhum produto foi criado.");
                    }
                    break;

                case 3:
                    if (produto != null) {
                        System.out.print("Digite a quantidade a ser removida: ");
                        int quantidadeRemover = scanner.nextInt();
                        produto.removerEstoque(quantidadeRemover);
                    } else {
                        System.out.println("Erro: Nenhum produto foi criado.");
                    }
                    break;

                case 4:
                    if (produto != null) {
                        produto.exibirInformacoes();
                    } else {
                        System.out.println("Erro: Nenhum produto foi criado.");
                    }
                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}


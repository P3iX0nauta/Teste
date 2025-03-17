// Representa um item simples do cardápio
class ItemMenu {
    private String nome;
    private double preco;

    public ItemMenu(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void exibir() {
        System.out.println("Item: " + nome + " - Preço: R$ " + preco);
    }
}

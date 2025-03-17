package ComComposite;

class MenuItem extends MenuComponent {
    private String nome;
    private double preco;

    public MenuItem(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void display() {
        System.out.println("Item: " + getNome() + ", Preco: " + getPreco());
    }
}

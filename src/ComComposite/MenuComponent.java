package ComComposite;


abstract class MenuComponent {
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remover(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getNome() {
        throw new UnsupportedOperationException();
    }

    public double getPreco() {
        throw new UnsupportedOperationException();
    }

    public void display() {
        throw new UnsupportedOperationException();
    }
}


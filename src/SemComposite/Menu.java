import java.util.ArrayList;
import java.util.List;

// Representa um menu que pode conter itens ou submenus
class Menu {
    private String nome;
    private List<ItemMenu> itens; // Lista de itens simples
    private List<Menu> subMenus; // Lista de submenus

    public Menu(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
        this.subMenus = new ArrayList<>();
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
    }

    public void adicionarSubMenu(Menu subMenu) {
        subMenus.add(subMenu);
    }

    public void exibir() {
        System.out.println("Menu: " + nome);

        // Exibindo itens simples
        for (ItemMenu item : itens) {
            item.exibir();
        }

        // Exibindo submenus
        for (Menu subMenu : subMenus) {
            subMenu.exibir();
        }
    }
}


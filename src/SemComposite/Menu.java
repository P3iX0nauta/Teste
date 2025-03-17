import java.util.ArrayList;
import java.util.List;


class Menu {
    private String nome;
    private List<ItemMenu> itens; 
    private List<Menu> subMenus; 

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

        for (ItemMenu item : itens) {
            item.exibir();
        }

        for (Menu subMenu : subMenus) {
            subMenu.exibir();
        }
    }
}


public class RestauranteSemComposite {
    public static void main(String[] args) {
        // Criando o menu principal
        Menu menuPrincipal = new Menu("Menu Principal");

        // Criando itens simples
        ItemMenu item1 = new ItemMenu("Hambúrguer", 15.00);
        ItemMenu item2 = new ItemMenu("Refrigerante", 5.00);

        // Criando um submenu de sobremesas
        Menu sobremesas = new Menu("Sobremesas");
        ItemMenu item3 = new ItemMenu("Sorvete", 8.00);
        sobremesas.adicionarItem(item3);

        // Montando a estrutura do menu
        menuPrincipal.adicionarItem(item1);
        menuPrincipal.adicionarItem(item2);
        menuPrincipal.adicionarSubMenu(sobremesas);

        // Exibindo todo o menu
        menuPrincipal.exibir();
    }
}

public class RestauranteSemComposite {
    public static void main(String[] args) {

        Menu menuPrincipal = new Menu("Menu Principal");

        ItemMenu item1 = new ItemMenu("Hamburguer", 15.00);
        ItemMenu item2 = new ItemMenu("Refrigerante", 5.00);
        ItemMenu item3 = new ItemMenu("Cheeseburger", 17.00);
        ItemMenu item4 = new ItemMenu("Hot Dog", 12.00);
        ItemMenu item5 = new ItemMenu("Batata Frita", 10.00);
        ItemMenu item6 = new ItemMenu("Suco Natural", 7.00);

        Menu sobremesas = new Menu("Sobremesas");
        ItemMenu item7 = new ItemMenu("Sorvete", 8.00);
        ItemMenu item8 = new ItemMenu("Bolo de Chocolate", 10.00);
        ItemMenu item9 = new ItemMenu("Pudim", 6.00);
        ItemMenu item10 = new ItemMenu("Torta de Limao", 9.00);

        sobremesas.adicionarItem(item7);
        sobremesas.adicionarItem(item8);
        sobremesas.adicionarItem(item9);
        sobremesas.adicionarItem(item10);

        menuPrincipal.adicionarItem(item1);
        menuPrincipal.adicionarItem(item2);
        menuPrincipal.adicionarItem(item3);
        menuPrincipal.adicionarItem(item4);
        menuPrincipal.adicionarItem(item5);
        menuPrincipal.adicionarItem(item6);
        menuPrincipal.adicionarSubMenu(sobremesas);

        menuPrincipal.exibir();
    }
}
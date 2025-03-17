package ComComposite;


// Código cliente
public class RestauranteComComposite {
    public static void main(String[] args) {
        MenuComponent menuPrincipal = new Menu("Menu Principal");

        MenuComponent hamburguer = new MenuItem("Hambúrguer", 15.00);
        MenuComponent refrigerante = new MenuItem("Refrigerante", 5.00);

        MenuComponent sobremesas = new Menu("Sobremesas");
        sobremesas.add(new MenuItem("Sorvete", 8.00));
        sobremesas.add(new MenuItem("Bolo de Chocolate", 10.00));

        menuPrincipal.add(hamburguer);
        menuPrincipal.add(refrigerante);
        menuPrincipal.add(sobremesas);

        // O cliente trata tudo como MenuComponent, sem diferença
        menuPrincipal.display();
    }
}

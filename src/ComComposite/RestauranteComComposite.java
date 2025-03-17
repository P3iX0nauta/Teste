package ComComposite;

public class RestauranteComComposite {

    public static void main(String[] args) {

        MenuComponent menuPrincipal = new Menu("Menu Principal");
        System.out.println("--------------------------------------");

        MenuComponent lanches = new Menu("Lanches");
        lanches.add(new MenuItem("Hamburguer", 15.00));
        lanches.add(new MenuItem("Cheeseburger", 17.00));
        lanches.add(new MenuItem("Hot Dog", 12.00));
        menuPrincipal.add(lanches);

        System.out.println("--------------------------------------");

        MenuComponent bebidas = new Menu("Bebidas");
        bebidas.add(new MenuItem("Refrigerante", 5.00));
        bebidas.add(new MenuItem("Suco Natural", 7.00));
        menuPrincipal.add(bebidas);

        System.out.println("--------------------------------------");

        MenuComponent fritos = new Menu("Fritos");
        fritos.add(new MenuItem("Batata Frita", 10.00));
        fritos.add(new MenuItem("Onion Rings", 9.00));
        fritos.add(new MenuItem("Nachos", 11.00));
        menuPrincipal.add(fritos);

        System.out.println("--------------------------------------");

        MenuComponent sobremesas = new Menu("Sobremesas");
        sobremesas.add(new MenuItem("Sorvete", 8.00));
        sobremesas.add(new MenuItem("Bolo de Chocolate", 10.00));
        sobremesas.add(new MenuItem("Pudim", 6.00));
        sobremesas.add(new MenuItem("Torta de Limao", 9.00));
        menuPrincipal.add(sobremesas);

        System.out.println("--------------------------------------");

        menuPrincipal.display();
    }
}

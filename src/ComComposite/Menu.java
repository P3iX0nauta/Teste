package ComComposite;
// Composite: Menu que pode ter MenuItems ou outros Menus
import java.util.ArrayList;
import java.util.List;
class Menu extends MenuComponent {
    private List<MenuComponent> components = new ArrayList<>();
    private String name;

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        components.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        components.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return components.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display() {
        System.out.println("Menu: " + getName());
        for (MenuComponent component : components) {
            component.display();
        }
    }
}

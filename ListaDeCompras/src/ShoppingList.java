import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ShoppingList {
    private  List<String> shoppingList ;
    private  List<String> boughtItems;
    private String listName;
    Scanner scanner = new Scanner(System.in);

    public ShoppingList(String listName){
        this.listName = listName;
        shoppingList = new ArrayList<>();
        boughtItems = new ArrayList<>();
    }

    public List<String> getShoppingList() {
        return shoppingList;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListName() {
        return listName;
    }

    public void setShoppingList(List<String> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<String> getBoughtItems() {
        return boughtItems;
    }

    public void setBoughtItems(List<String> boughtItems) {
        this.boughtItems = boughtItems;
    }

    public void addElementShoppingList(String element){
        shoppingList.add(element);
    }
    public void deletElementShoppingList(){

        try {
            this.showElementsList();
            System.out.println("Type the number of the element that you want to delet  : ");
            int indexElement = scanner.nextInt() - 1 ;
            String elementDel = shoppingList.get(indexElement);
            shoppingList.remove(shoppingList.get(indexElement));
            System.out.println("The element "+elementDel+" was deleted.");

        }catch (IndexOutOfBoundsException exception){
            System.out.println("The number of the element dont exist on the list. ");
        }


    }

    public void getInformation(){
        System.out.println("O nome da lista : "+ listName+ ". Quantidade de elementos : "+shoppingList.size()+
                " Quantidade de elementos comprados :"+ boughtItems.size() );
    }

    public void showElementsList(){
        for (int i = 0; i < shoppingList.size() ; i++) {
            System.out.println("Element ("+(i + 1)+") : "+shoppingList.get(i));
        }
    }
}

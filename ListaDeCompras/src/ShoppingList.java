import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private  List<String> shoppingList ;
    private  List<String> boughtItems;
    private String listName;

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
    public void deletElementShoppingList(String element){
        String boughtElement = " ";
        for (int i = 0; i < shoppingList.size(); i++) {
            if (element.equals(shoppingList.get(i))){
                boughtElement =  shoppingList.get(i);
            }
            else{
                System.out.print("The element is not in the list" );
                break;
            }
            shoppingList.remove(element);
            this.boughtItems.add(boughtElement);
            break;
        }
    }

    public void getInformation(){
        System.out.println("O nome da lista : "+ listName+ ". Quantidade de elementos : "+shoppingList.size()+
                " Quantidade de elementos comprados :"+ boughtItems.size() );
    }



}

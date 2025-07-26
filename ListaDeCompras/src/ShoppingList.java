import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class ShoppingList {
    private  List<String> shoppingList ;
    private String listName;
    private String bought  =  " [Bought] ";
    private String notBought = " [Not Bought] ";
    Scanner scanner = new Scanner(System.in);

    public ShoppingList(String listName){
        this.listName = listName;
        shoppingList = new ArrayList<>();
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


    public void addElementShoppingList(String element){
        shoppingList.add(element);
    }

    public String searchElementOfTheList(int index){
        try {
            return shoppingList.get(index);
        }catch (IndexOutOfBoundsException exception){
            System.out.println("This index  dont exist");
            return null;
        }
    }

    public void setShoppingListByIndex(int index, String element){
        if (index >= 0 && index < shoppingList.size()) {
            shoppingList.set(index, element);
        } else {
            System.out.println("Invalid index. Cannot update the item.");
        }
    }

    public void setAsBoughtOrNotBought() {
        //Read the index
        int index;
        this.simpleShowElementsList();
        while (true) {
            try {
                System.out.print("Type the number of the element : ");
                String input = scanner.next();
                index = Integer.parseInt(input) - 1;
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Please type a valid number : ");
            }
        }

        //Read the status Bought or not
        System.out.print("Is this item Bought ? : [yes/no]");
        //IndexOutOfBoundsException
        String inputYesOrNot = scanner.next();
        Boolean boughOrNot = null;
        //Take the item by the index
        String item = this.searchElementOfTheList(index);
        if (item == null ) {
            System.out.println("This item dont exist in the list");
        } else {
            //Decide if is bought or not bought
            while(boughOrNot == null) {
                if (inputYesOrNot.equalsIgnoreCase("yes")) {
                    boughOrNot = true;
                } else if (inputYesOrNot.equalsIgnoreCase("no")) {
                    boughOrNot = false;
                }
                else{
                    System.out.print("Invalid answer, please type yes or no  :   ");
                    inputYesOrNot = scanner.next();
                }

            }
            //Add the status in the item


            if (boughOrNot) {
                if (item.contains(bought)) {
                    System.out.println("This item is already marked as " + bought);
                } else if (item.contains(notBought)) {
                    item = item.replace(notBought, bought);
                } else {
                    item += bought;
                }
            } else {
                if (item.contains(notBought)) {
                    System.out.println("This item is already marked as " + notBought);
                } else if (item.contains(bought)) {
                    item = item.replace(bought, notBought);
                } else {
                    item += notBought;
                }

            }

            //Put the item with status in the list
            this.setShoppingListByIndex(index, item);

        }

    }

    public void deletElementShoppingList(){;
        if (this.shoppingList.size() == 0 ){
            System.out.println("Nothing here yet.");
        }else {
            try {
                System.out.println("Type any number wich is not on the list to go back");
                this.simpleShowElementsList();
                System.out.println("Type the number of the element that you want to delet  : ");
                int indexElement = scanner.nextInt() - 1;
                String elementDel = shoppingList.get(indexElement);
                shoppingList.remove(indexElement);
                System.out.println("The element " + elementDel + " was deleted.");

            } catch (IndexOutOfBoundsException exception) {
                System.out.println("The number of the element dont exist on the list. ");
            }catch (InputMismatchException exception){
                System.out.println("Please , type a valid mensage. ");
            }
        }

    }

    public  void simpleShowElementsList(){
        for (int i = 0; i < shoppingList.size() ; i++) {
            System.out.println("Element ("+(i + 1)+") : "+shoppingList.get(i));
        }
    }

    public void showElementsList(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < shoppingList.size() ; i++) {
            System.out.println("Element ("+(i + 1)+") : "+shoppingList.get(i));
        }
        System.out.println("Type whatever you want to continue");
        String whatever = sc.next();

    }

    public void finalMensageOfTheList(){
        System.out.println("The " + listName  + " was ended with " + shoppingList.size()  + " elements." );
    }
}

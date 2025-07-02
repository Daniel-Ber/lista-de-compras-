import java.util.Scanner;
//USE GIT STATUS AND GIT LOG BEFORE WORK ON IT
public class Main {

    static void print(String content){
        System.out.print(content);
    }
    static void printLn(String content){
        System.out.println(content);
    }

    public static void main(String[] args)  {
     Scanner sc = new Scanner(System.in);
     boolean stopWhile = false;

        print("Hello user , would you like to create a list? [yes/no]");
        String read = sc.nextLine();
        Boolean yesOrNo = null;
        int optionForSwitch;

        if (read.equals("yes")){
            yesOrNo = true;
        }else if(read.equals("no")) {
            yesOrNo = false;
        }
        while(yesOrNo == null) {
            try {
                throw new NullPointerException("Invalid mensage");
            }
            catch (NullPointerException e) {
                printLn("Please provide a valid text message : ");
                read = sc.nextLine();
                if (read.equals("yes")) {
                    yesOrNo = true;
                } else if (read.equals("no")) {
                    yesOrNo = false;
                }
            }
        }

            if (yesOrNo){
                //Process to create a list
                print("Type the name of your list");
                String nameList = sc.nextLine();
                ShoppingList shoppingList = new ShoppingList(nameList);
                printLn(" The "+ shoppingList.getListName()+ " was created " );
                //List was created

                //Using the list
                //Here have to be recursive
                //We have to add a new function: See the list[x], made like a to-do (Bought itens).
                while (!stopWhile){
                    print("Press 1 to add a new item, 2 to delete an item (item was bought),3 to see the list or 4 to close the program: ");
                    optionForSwitch = sc.nextByte();
                    sc.nextLine();
                    switch (optionForSwitch) {
                        case 1 :
                            print("Type the item : "  );
                            String newItem = sc.nextLine();
                            shoppingList.addElementShoppingList(newItem);
                            printLn("The item " + newItem + " was aditioned on the list");
                            break;
                        case 2 :
                            print("Type the item that you want to delet: ");
                            String delItem = sc.nextLine();
                            shoppingList.deletElementShoppingList(delItem);
                            printLn("The item" + delItem + "was deleted on the list");
                            break;
                        case 3 :
                            shoppingList.showElementsList();
                            break;
                        case 4 :
                            print("Ok, good to see you =)");
                            stopWhile = true;
                            break;
                    }
                }


            }
            else if (!yesOrNo){
                print("Good to see you, user =)");
            }

    }
}
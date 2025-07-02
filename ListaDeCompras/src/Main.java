import java.util.Scanner;
//USE GIT STATUS AND GIT LOG BEFORE WORK ON IT
public class Main {

    static void print(String content){
        System.out.print(content);
    }
    static void printLn(String content){
        System.out.println(content);
    }

    public static void main(String[] args) throws Exception {
     Scanner sc = new Scanner(System.in);

        print("Hello user , would you like to create a list? [yes/no]");
        String read = sc.nextLine();
        Boolean yesOrNo = null;

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
                sc.nextLine();
                ShoppingList shoppingList = new ShoppingList(nameList);
                print(" The "+ shoppingList.getListName()+ " was created " );

                //Using the list
                print("Press 1 to add a new item, 2 to delete an item (item was bought), or 3 to close the program: ");
                int option = sc.nextByte();
                switch (option) {
                    case 3 :
                        print("Ok, good to see you =)");
                        break;

                    case 1 :
                        print("Type the item : "  );
                        String newItem = sc.nextLine();
                        sc.nextLine();
                        shoppingList.addElementShoppingList(newItem);
                        print("The item" + newItem + "was aditioned on the list");

                        break;

                    case 2 :
                        print("Type the item that you want to delet: ");
                        String delItem = sc.nextLine();
                        shoppingList.deletElementShoppingList(delItem);
                        print("The item" + delItem + "was deleted on the list");
                        break;
                }

            }
            else if (!yesOrNo){
                print("Good to see you, user =)");
            }

    }
}
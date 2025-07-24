import java.util.Scanner;
//USE GIT STATUS AND GIT LOG BEFORE WORK ON IT
public class Main {

    static void print(String content){
        System.out.print(content);
    }
    static void printLn(String content){
        System.out.println(content);
    }
    static  void cls(){
        for (int i = 0 ; i <= 50; i++ ){
            printLn(" ");
        }
    }

    public static void main(String[] args)  {
     Scanner sc = new Scanner(System.in);
     boolean stopWhile = false;
     Boolean yesOrNo = null;
     int optionForSwitch = 0;

        print("Hello user , would you like to create a list? [yes/no]  : ");
        String read = sc.nextLine();


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
                print("Type the name of your list : ");
                String nameList = sc.nextLine();
                ShoppingList shoppingList = new ShoppingList(nameList);
                printLn(" The "+ shoppingList.getListName()+ " was created " );
                //List was created

                //Using the list

                while (!stopWhile){

                        print("Press 1 to add a new item, 2 to " +
                                "delete an item (item was bought),3 to see the list,4 to add status of bought or not" +
                                " and  5 to " +
                                "close the program: ");
                        try {
                            String input = sc.nextLine();
                            optionForSwitch = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                          printLn("Please enter a valid number. ");
                        }


                        switch (optionForSwitch) {
                            case 1 :
                                cls();
                                print("Type the item [or type exit to go back] : "  );
                                String newItem = sc.nextLine();
                                if(newItem.equalsIgnoreCase("exit")){
                                    break;
                                }else {
                                shoppingList.addElementShoppingList(newItem);
                                printLn("The item " + newItem + " was aditioned on the list");
                                break;
                                }
                            case 2 :
                                cls();
                                shoppingList.deletElementShoppingList();
                                break;

                            case 3 :
                                cls();
                                shoppingList.showElementsList();
                                break;
                            case 4 :
                                cls();
                                print("Are you sure ? [yes/no]: ");
                                String sureAboutThat = sc.nextLine();
                                if (sureAboutThat.equalsIgnoreCase("yes")){
                                    shoppingList.setAsBoughtOrNotBought();
                                    break;
                                } else if (sureAboutThat.equalsIgnoreCase("no")) {
                                    //Just go back to menu
                                }
                                optionForSwitch = 0;
                                break;

                            case 5 :
                                //Bug in that case , if u put 'no' so the output mensage is gonna be ugly
                                cls();
                                print("Are you sure ? [yes/no]: ");
                                String sure = sc.nextLine();
                                if (sure.equalsIgnoreCase("yes")){
                                print("Ok, good to see you =)");
                                stopWhile = true;
                                break;
                                }else if (sure.equalsIgnoreCase("no")){
                                    optionForSwitch = 0;
                                }
                                break;
                            default:
                                printLn("Invalid option ! ");

                        }
                }
            }
            else if (!yesOrNo){
                print("Good to see you, user =)");
            }

    }
}
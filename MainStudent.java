package TestModule2;

import java.io.Serializable;
import java.util.Scanner;

public class MainStudent implements Serializable {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StudentManager manager=new StudentManager();
        do {
            System.out.println("_________________Ｍ-Ｅ-Ｎ-Ｕ____________________");
            System.out.println("✎﹏[1]. display                               ┊");
            System.out.println("✎﹏[2]. add                                   ┊");
            System.out.println("✎﹏[3]. edit by id                            ┊");
            System.out.println("✎﹏[4]. delete by id                          ┊");
            System.out.println("✎﹏[5]. Sort up  >> acessding                 ┊");
            System.out.println("✎﹏[6]. read file                             ┊");
            System.out.println("✎﹏[7]. write file                            ┊");
            System.out.println("✎﹏[0]. Exit________________________  ________┊");
            System.out.println("Enter Your Selection : ");
            int choice = -1;
            try {
                choice=Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println(" ");
            }
            switch (choice){
                case 1: manager.display();
                    break;

                case 2:  manager.add(scanner);
                    break;

                case 3:manager.edit(scanner);
                    break;

                case 4:
                    manager.delete(scanner);
                    break;
                case 5:;
                    int choice1=-1;
                    do {
                        System.out.println("1.sort up acessding");
                        System.out.println("2. sort up decrease");
                        System.out.println("0.exit");
                        try {
                            choice1=Integer.parseInt(scanner.nextLine());
                        }catch (Exception e){
                            System.out.println(" ");
                        }
                        if (choice1==1){
                            manager.sortUpByScore1();
                            manager.display();

                        }
                        if (choice1==2){
                            manager.sortUpByScore2();
                            manager.display();

                    }
                        if (choice1==0){
                            main(new String[0]);
                            break;
                        }
            }while (true);

                case 6:
                    manager.readFile();
                    break;
                case 7:
                    manager.writeFile();
                    break;

                case 0:
                    System.exit(0);
            }
            }while (true);

    }


}

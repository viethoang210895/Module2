package TestModule2;

import CaseStudy.Phone;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Pattern;

public class StudentManager implements Serializable,Comparable {
    private ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    public void add(Scanner scanner) {
        try {
            System.out.println(" enter id ");
            String id = scanner.nextLine();
            System.out.println("enter name");
            String name = scanner.nextLine();
            System.out.println("enter age");
            Integer age = Integer.parseInt(scanner.nextLine());
            System.out.println("enter gender");
            String gender = scanner.nextLine();
            System.out.println("enter address");
            String address = scanner.nextLine();
            System.out.println("enter mediumscore");
            Long mediumscore = Long.parseLong(scanner.nextLine());
            students.add(new Student(id, name, age, gender, address, mediumscore));
        } catch (Exception e) {
            System.out.println("re-Enter");
        }
    }

    public int checkExit(String id) {
        {
            for (Student student : students) {
                if (student.getId().equals(id)) {
                    return students.indexOf(student);
                }
            }
        }
        return -1;
    }

    public void edit(Scanner scanner) {
            try {
                System.out.println(" enter id to edit");
                String idEdit = scanner.nextLine();

                int index;
                    if ((index = checkExit(idEdit)) != -1) {
                        System.out.println("enter new id");
                        String id = scanner.nextLine();
                        if (!id.equals("")) {
                            students.get(index).setId(id);
                        }
                        System.out.println("enter new name");
                        String name = scanner.nextLine();
                        if (!name.equals("")) {
                            students.get(index).setName(name);
                        }
                        System.out.println("enter new age");
                        Integer age = Integer.parseInt(scanner.nextLine());
                        if (!age.equals("")) {
                            students.get(index).setAge(age);
                        }
                        System.out.println("enter new gender");
                        String gender = scanner.nextLine();
                        if (!gender.equals("")) {
                            students.get(index).setGender(gender);
                        }
                        System.out.println("enter new address");
                        String address = scanner.nextLine();
                        if (!address.equals("")) {
                            students.get(index).setAddress(address);
                        }
                        System.out.println("enter new mediumscore");
                        Long mediumscore = Long.parseLong(scanner.nextLine());
                        if (!mediumscore.equals("")) {
                            students.get(index).setMediumscore(mediumscore);
                        }

                    } else {
                        System.out.println("ID not exist");
                    }

            } catch (Exception e) {
                System.err.println("re-Enter");
            }
        }


    public void delete(Scanner scanner) {
        Pattern p2 = Pattern.compile("(?:Y|N)");
        try {
            System.out.println("enter id to delete");
            String id = scanner.nextLine();
            int index;
            if (-1 != (index = checkExit(id))) {
                String answer;
                while (true) {
                    System.out.println("    Enter Y to delete . N to back MENU ");
                    answer = scanner.nextLine();
                    if (answer.matches(String.valueOf(p2))) {
                        if (answer.equals("Y")) {
                            students.remove(index);
                            break;
                        } else if (answer.equals("N")) {
                            break;
                        }

                    }
                }

            } else {
                System.out.println("not exist");
            }
        } catch (Exception e) {
            System.err.println(" re-enter");
        }
    }

    public void display() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void sortUpByScore1() {
        Collections.sort(this.students, new Comparator<Student>() {
            @Override
            public int compare(Student p1, Student p2) {
                if (p1.getMediumscore() < p2.getMediumscore()) {
                    return -1;
                } else if (p1.getMediumscore() > p2.getMediumscore()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void sortUpByScore2() {
        Collections.sort(this.students, new Comparator<Student>() {
            @Override
            public int compare(Student p1, Student p2) {
                if (p1.getMediumscore() < p2.getMediumscore()) {
                    return 1;
                } else if (p1.getMediumscore() > p2.getMediumscore()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    public void writeFile() {
        try {
            File path = new File("src/TestModule2/sinhvien");
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readFile() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("src/TestModule2/sinhvien");
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentArrayList = (ArrayList<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            System.out.println("");
        }
        students = studentArrayList;
    }


}


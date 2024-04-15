package org.example.MontyHallGame;

import java.util.*;

public class MontyHallGame {
    List<String> doors;
    HashMap <Boolean, String> gameResult;
    HashMap <String, Integer> allGameResults;
    Random random;
    Scanner scanner;
    Integer carDoorNum;
    Integer userChoice;

    public MontyHallGame() {
        random = new Random();
        allGameResults = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void runGame () {
        gameResult = new HashMap<>();
        hideGift();
//        printDoors();
        boolean addWork;
        addWork = true;
        root: while (addWork){
            try {
                userChoiceStepOne();
                if (carDoorNum == 1) {
                    if (userChoice.equals(carDoorNum)) {
                        Integer rand = random.nextInt(2, 4);
                        System.out.println("За дверью " + rand + " находится коза.");
                        Boolean stepTwo = userChoiceStepTwo();
                        if (stepTwo) {
                            if (rand == 2){
                                userChoice = 3;
                            }
                            if (rand == 3){
                                userChoice = 2;
                            }
                        }
                        saveResults(stepTwo);
                    }
                    else stepTwo();
                }


                if (carDoorNum == 2) {
                    if (userChoice.equals(carDoorNum)) {
                        Integer rand;
                        do {
                            rand = random.nextInt(1, 4);
                        }
                        while (rand == 2);
                        System.out.println("За дверью " + rand + " находится коза.");
                        Boolean stepTwo = userChoiceStepTwo();
                        if (stepTwo) {
                            if (rand == 1){
                                userChoice = 3;
                            }
                            if (rand == 3){
                                userChoice = 1;
                            }
                        }
                        saveResults(stepTwo);
                    }
                    else stepTwo();
                }


                if (carDoorNum == 3) {
                    if (userChoice.equals(carDoorNum)) {
                        Integer rand = random.nextInt(1, 3);
                        System.out.println("За дверью " + rand + " находится коза.");
                        Boolean stepTwo = userChoiceStepTwo();
                        if (stepTwo) {
                            if (rand == 1){
                                userChoice = 2;
                            }
                            if (rand == 2){
                                userChoice = 1;
                            }
                        }
                        saveResults(stepTwo);
                    }
                    else stepTwo();
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue root;
            }
            addWork = false;
        }
    }

    private void hideGift () {
        doors = new ArrayList<>();
        carDoorNum = random.nextInt(1, 4);
        for (int i = 0; i < 3; i++) {
            if (i + 1 == carDoorNum) {
                doors.add("машина");
            }
            else {
                doors.add("коза");
            }
        }
    }

    private void printDoors () {
        System.out.println(doors);
    }

    private void userChoiceStepOne () {
        boolean addWork;
        addWork = true;
        Integer userChoice = null;
        root: while (addWork) {
            try {
                System.out.println("Выберите дверь");
                userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice == null) throw new UserInterClassException("Воспользуйтесь цифрами");
                if (userChoice < 1 || userChoice > 3)
                    throw new UserInterClassException("Воспользуйтесь цифрами от 1 до 3");
            } catch (Exception e) {
                e.printStackTrace();
                continue root;
            }
            addWork = false;
        }
        this.userChoice = userChoice;
    }

    private Boolean userChoiceStepTwo () {
        boolean addWork;
        addWork = true;
        Integer userChoice = null;
        root: while (addWork) {
            try {
                System.out.println("Вы хотите изменить свой выбор? (1 - да, 2 - нет)");
                userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice == null) throw new UserInterClassException("Воспользуйтесь цифрами");
                if (userChoice < 1 || userChoice > 2)
                    throw new UserInterClassException("Воспользуйтесь цифрами от 1 до 2");
            } catch (Exception e) {
                e.printStackTrace();
                continue root;
            }
            addWork = false;
        }
        return userChoice == 1;
    }

    private void putResulToAllGameResults (String prise) {
        if (allGameResults.containsKey(prise)) {
            Integer count = allGameResults.get(prise) + 1;
            allGameResults.put(prise, count);
        }
        else {
            allGameResults.put(prise, 1);
        }
    }

    private void saveResults (Boolean stepTwo) {
        System.out.println("Ваш приз: " + doors.get(userChoice - 1));
        gameResult.put(stepTwo, doors.get(userChoice - 1));
        putResulToAllGameResults(doors.get(userChoice - 1));
    }

    public void printAllGameResults () {
        System.out.println(allGameResults);
    }

    public String getAllGameResults () {
        return allGameResults.toString();
    }

    private void stepTwo() {
        List<Integer> toExclude = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("За дверью " + toExclude.stream().filter(n -> n != userChoice & n != carDoorNum).toList() + " находится коза.");
        Boolean stepTwo = userChoiceStepTwo();
        if (stepTwo) {
            userChoice = carDoorNum;
        }
        saveResults(stepTwo);
    }
}

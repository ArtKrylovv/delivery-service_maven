package com.solvd.deliveryservice.person;

public enum Position {
    DIRECTOR(1),
    MANAGER(2),
    SUPERVISOR(3),
    SPECIALIST(4),
    TRAINEE(5);

    int positionGrade;

    Position(int positionGrade){
        this.positionGrade =positionGrade;
    }

    public int getPositionGrade() {
        return positionGrade;
    }

    public String gradeToString(){
        String grade = null;
        switch(positionGrade){
            case 1:
                grade = "One";
                break;
            case 2:
                grade = "Two";
                break;

            case 3:
                grade = "Three";
                break;

            case 4:
                grade = "Four";
                break;

            case 5:
                grade = "Five";
                break;
        }
        return grade;
    }
}

package com.solvd.deliveryservice.address;

public enum State {
    CA("California"),
    NY("New-York"),
    FL("Florida"),
    TX("Texas"),
    IL("Illinois"),
    PA("Pennsylvania"),
    OH("Ohio"),
    GA("Georgia");

    String name;

    State(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFullName(){
        return "State of "+name;
    }
}

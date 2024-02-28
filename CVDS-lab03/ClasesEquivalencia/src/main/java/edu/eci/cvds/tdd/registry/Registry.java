package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
    /**
     * the identification number of the people that already voted vote
     */
    ArrayList<Integer> idPersonas = new ArrayList<Integer>(); 
    
    public RegisterResult registerVoter(Person p) {
        if(!p.isAlive()){
            return RegisterResult.DEAD;
        }
        else if(p.getAge() < 18 && p.getAge() >= 0){
            return RegisterResult.UNDERAGE;
        }
        else if(p.getAge() < 0 || p.getAge() > 120){
            return RegisterResult.INVALID_AGE;
        }
        else if(idPersonas.contains(p.getId())){
            return RegisterResult.DUPLICATED;
        }
        else{
            idPersonas.add(p.getId());
            return RegisterResult.VALID;
        }
    }
}


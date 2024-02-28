package edu.eci.cvds.tdd.registry;
import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person("Alejandro",1122334455,30,Gender.FEMALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void NegativeAgeRegistry(){
        Person person = new Person("Alejandro",1122334455,-30,Gender.FEMALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void ImposibleAgeRegistry(){
        Person person = new Person("Nicolas",778899003,200,Gender.FEMALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void DeadPersonRegistry(){
        Person person = new Person("Alejandra",778899003,200,Gender.FEMALE,false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void UnderAgeRegistry(){
        Person person = new Person("Maria",778899003,13,Gender.FEMALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void DupiclateRegistry(){
        Person person = new Person("Maria",1234567890,23,Gender.FEMALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);

        Person person2 = new Person("Maria",1234567890,23,Gender.FEMALE,true);
        RegisterResult result2 = registry.registerVoter(person2);

        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }

    @Test 
    public void PeopleCorrectRegistry(){
        Person person = new Person("Maria",1234567890,20,Gender.FEMALE,true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);

        Person person2 = new Person("David",1234567892,30,Gender.MALE,true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.VALID, result2);

        Person person3 = new Person("Laura",1234567842,35,Gender.FEMALE,true);
        RegisterResult result3 = registry.registerVoter(person3);
        Assert.assertEquals(RegisterResult.VALID, result3);
    }
}
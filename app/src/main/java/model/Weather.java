package model;

/**
 * Created by matite on 9/11/17.
 */

//this is our hub class since its going to consist of all the other classes
public class Weather {
    public Place place;
    public String iconData;
    // Here we're just instatiating our CurrentCondition and Temperature classes respectively
    public CurrentCondition currentCondition = new CurrentCondition();
    public Temperature temperature = new Temperature();


}

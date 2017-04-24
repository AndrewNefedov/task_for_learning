package lesson2;

import java.util.Comparator;

/**
 * Created by комп on 12.04.17.
 */

class Comparation implements Comparator <PersonInformation>
{
    public int compare (PersonInformation o1, PersonInformation o2)
    {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}

class Comparation2 implements Comparator <PersonInformation>
{
    public int compare (PersonInformation o1, PersonInformation o2)
    {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}

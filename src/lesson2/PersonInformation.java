package lesson2;

/**
 * Created by комп on 12.04.17.
 */

class PersonInformation // класс для хранения вводимых данных о человеке
{
    private String firstName; // оьъявляет атрибут "имя"
    private String lastName; // оьъявляет атрибут "фамилия"
    private Integer age; // оьъявляет атрибут "возраст"
    private String email; // оьъявляет атрибут "емэйл"

    public PersonInformation() // хз!!!!!!!!
    {

    }

    public PersonInformation(String[] mas) //метод-конструктор для задания значений полям. Принимает массив
    {
        this.firstName = mas[0]; // имя берётся из переданного в метод массива mas с индексом 0
        this.lastName = mas[1]; // фамилия берётся из переданного в метод массива mas с индексом 1
        this.age = Integer.parseInt(mas[2]); // возраст берётся из массива mas с индексом 2 и преобразует в целочисленный тип
        this.email = mas[3]; //емэйл берётся из переданного в метод массива mas с индексом 3

    }

        public String getFirstName()//геттер для
        {
            return this.firstName;
        }

        public void setFirstName(final String firstName)
        {
            this.firstName = firstName;
        }

        public String getLastName()
        {
            return this.lastName;
        }

        public void setLastName(final String lastName)
        {
            this.lastName = lastName;
        }

        public Integer getAge()
        {
            return this.age;
        }

        public void setAge(final Integer age)
        {
            this.age = age;
        }

        public String getEmail()
        {
            return this.email;
        }

        public void setEmail(final String email)
        {
            this.email = email;
        }

    @Override //объявление о переопределении метода toString
    public String toString() // метод toString даст нам представление об объекте. Но его надо переопределить для лучшей читаемости
    {
        return this.firstName + '\t' + this.lastName + '\t' + this.age + '\t' + this.email; // так нам станет понятен объект
    }
}

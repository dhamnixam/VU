package Person;

public class Student extends Person{
    public Student() {
        super();
        setRole(student_role);
    }

    public boolean setID_number(String ID_number) {
        if (Utils.stuIsEduNumberValid(ID_number)) { 
            this.ID_number = ID_number;
            return true;
        }
        else 
            return false;
    }
}
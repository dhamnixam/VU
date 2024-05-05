package Person;

public class Student extends Person{
    // protected Teacher[] teachers;   //teachers of this student

    public Student() {
        super();
        setRole(student_role);
        // teachers = new Teacher[10];
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
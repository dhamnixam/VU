package Person;

public class Teacher extends Person{
    public Teacher() {
        super();
        setRole(teacher_role);
    }

    public boolean setID_number(String ID_number) {
        if (Utils.TeacherIsEduNumberValid(ID_number)) { 
            this.ID_number = ID_number;
            return true;
        }
        else
            return false;
    }
}

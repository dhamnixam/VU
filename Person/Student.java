package Person;

import Exceptions.InvalidIDException;

public class Student extends Person{
    protected Teacher[] teachers;   //teachers of this student

    public Student() {
        super();
        setRole(student_role);
        teachers = new Teacher[10];
    }

    @Override 
    public String toString() {
        String str = "Username: " + getUsername() + "\n" + "Role: Teacher";
        return str;
    }

    @Override
    public  boolean equals(Object obj) {
        if (obj instanceof Student) {
            if (((Student)obj).getUsername().equals(this.getUsername()) || ((Student)obj).getPassword().equals(this.getPassword()))
                return true;
            else 
                return false;
        }
        else 
            return false;
    }

    public boolean setID_number(String ID_number) throws InvalidIDException {
        if (Utils.stuIsEduNumberValid(ID_number)) { 
            this.ID_number = ID_number;
            return true;
        }
        else 
            return false;
    }

    public void addTeacher(Teacher tchr) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = tchr;
            }
        }
    }

    public Teacher getValueAt_teachers(int i) {
        if (i < teachers.length && i >= 0) {
            return teachers[i];
        }
        return null;
    }
}
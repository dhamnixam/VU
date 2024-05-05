package Person;

public class Admin extends Person{
    private Person[] users;
    private int userCount = 0;

    public Admin() {
        super();
        setRole(admin_role);
        addUserToSystem(this);  //add admin in system :)
    }

    public boolean setID_number(String ID_number) {
        if (Utils.adminIsEduNumberValid(ID_number)) { 
            this.ID_number = ID_number;
            return true;
        }
        else 
            return false;
    }

    public void addStudent_for_teacher(Student std, Teacher tchr) {
        boolean sw = true;
        for (int i = 0; tchr.students.length > i ; i++) {
            if (tchr.students[i].getID_number().equals(std.getID_number()) && tchr.students[i].getFullName().equals(std.getFullName())) {
                System.out.println("Teacher have this student already!");
                sw = false;
                break;
            }
            if (tchr.students[i] == null) {
                tchr.students[i] = std;
                System.out.println("Student added successfuly!");
                sw = false;
                break;
            }
        }
        if (sw) {
            System.out.println("This teacher can't have another student anymore.");
        }
    }

    // public void addTeacher_for_student(Teacher tchr, Student std) {
    //     boolean sw = true;
    //     for (int i = 0; std.teachers.length > i ; i++) {
    //         if (std.teachers[i].getID_number().equals(tchr.getID_number()) && std.teachers[i].getFullName().equals(tchr.getFullName())) {
    //             System.out.println("Student have this teacher already!");
    //             sw = false;
    //             break;
    //         }
    //         if (std.teachers[i] == null) {
    //             std.teachers[i] = tchr;
    //             System.out.println("Teacher added successfuly!");
    //             sw = false;
    //             break;
    //         }
    //     }
    //     if (sw) {
    //         System.out.println("This student can't have another teacher anymore.");
    //     }
    // }

    public void addUserToSystem(Person new_user) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getFullName().equals(new_user.getFullName()) && users[i].getID_number().equals(new_user.getID_number())) {
                System.out.println("This user have an account in portal.");
                return;
            }
        }

        users[userCount] = new_user;
        userCount++;
        System.out.println("User added to systme successfuly");
    }

    public void removeUserFromSystem(Person user) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getFullName().equals(user.getFullName()) && users[i].getID_number().equals(user.getID_number())) {
                for (int j = i; j < userCount; j++) {
                    users[j] = users[j+1];
                }
                System.out.println("User removed successfuly");
                userCount--;
                return;
            }
        }

        System.out.println("User doesn't found");
    }
}


    

public class TeacherMember extends LibraryMember {

    public TeacherMember(String memberID, String name,
                         String password) {

        super(memberID, name, password, 5);
    }

    @Override
    public String getMemberType() {
        return "Teacher";
    }
}


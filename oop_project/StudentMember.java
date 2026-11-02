
    
public class StudentMember extends LibraryMember {

    public StudentMember(String memberID, String name,
                         String password) {

        super(memberID, name, password, 3);
    }

    @Override
    public String getMemberType() {
        return "Student";
    }
}





public class GuestMember extends LibraryMember {

    public GuestMember(String memberID, String name,
                       String password) {

        super(memberID, name, password, 1);
    }

    @Override
    public String getMemberType() {
        return "Guest";
    }
}


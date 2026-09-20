class Member {
	 private int memberId;
	    private String name;
	    private String email;
	    private String phone;
	    
	    public Member(int memberId, String name, String email, String phone) {
	        this.memberId = memberId;
	        this.name = name;
	        this.email = email;
	        this.phone = phone;
	    }

	    public int getMemberId() {
	        return memberId;
	    }

	    @Override
	    public String toString() {
	        return "Member ID: " + memberId +
	               ", Name: " + name +
	               ", Email: " + email +
	               ", Phone: " + phone;
	    }
}

class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    // Конструкторы
    public Name(String firstName) {
        this.firstName = firstName;
    }

    public Name(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    // Методы
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (lastName != null && !lastName.isEmpty()) {
            result.append(lastName);
        }

        if (firstName != null && !firstName.isEmpty()) {
            if (result.length() > 0) result.append(" ");
            result.append(firstName);
        }

        if (middleName != null && !middleName.isEmpty()) {
            if (result.length() > 0) result.append(" ");
            result.append(middleName);
        }

        return result.toString();
    }
}
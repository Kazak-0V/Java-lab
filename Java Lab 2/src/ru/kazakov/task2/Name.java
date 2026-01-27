package ru.kazakov.task2;

public class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
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
package com.bunnybistrocafe.enumerations.drinkcustomizations;

public enum TeaType {
    GREEN ("G", "Green Tea"), BLACK ("B", "Black Tea"), OOLONG ("O", "Oolong Tea"),
    THAI ("T", "Thai Tea"), WHITE ("W", "White Tea");

    private final String abbreviation;
    private final String name;

    TeaType(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public static TeaType fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (TeaType option : TeaType.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }
}

package com.fesva;

public class Monthly {
    public String MonStudents(String m){

        String stsql ="SELECT * FROM Students s \n" +
                "\n" +
                "WHERE MONTH(s.registration_date ) = m;\n" +
                "\n";

        return stsql;
    }

}

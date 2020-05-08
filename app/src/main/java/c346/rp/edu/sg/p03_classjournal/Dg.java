package c346.rp.edu.sg.p03_classjournal;

import java.io.Serializable;

public class Dg implements Serializable {
    private String grade;

    public Dg(String grade){
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
}

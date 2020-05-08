package c346.rp.edu.sg.p03_classjournal;

import java.io.Serializable;
import java.util.ArrayList;

import javax.crypto.spec.DHGenParameterSpec;

public class Module {
    private String code;
    private String moduleName;
    private ArrayList<Dg> dg;

    public Module(String code, String moduleName, ArrayList<Dg> dg ){
        this.code = code;
        this.moduleName = moduleName;
        this.dg = dg;
    }

    public String getCode() {
        return code;
    }
    public String getModuleName() {return moduleName;}
    public ArrayList<Dg> getDg(){
        return dg;
    }
}

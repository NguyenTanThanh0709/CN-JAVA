public class Student {
    private String mssv;
    private  String name;
    private  String gtinh;
    private  int age;
    private float dtb;

    public Student(String mssv, String name, String gtinh, int age, float dtb) {
        this.mssv = mssv;
        this.name = name;
        this.gtinh = gtinh;
        this.age = age;
        this.dtb = dtb;
    }

    public  Student(){
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public String getGtinh() {
        return gtinh;
    }

    public int getAge() {
        return age;
    }

    public float getDtb() {
        return dtb;
    }



    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGtinh(String gtinh) {
        this.gtinh = gtinh;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDtb(float dtb) {
        this.dtb = dtb;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mssv='" + mssv + '\'' +
                ", name='" + name + '\'' +
                ", gtinh='" + gtinh + '\'' +
                ", age=" + age +
                ", dtb=" + dtb +
                '}';
    }
}

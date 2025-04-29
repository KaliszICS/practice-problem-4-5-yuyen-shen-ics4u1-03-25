class Student{
    private String name;
    private int age;
    private String studentNumber;

    public Student(String name, int age, String studentNumber){
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getStudentNumber(){
        return this.studentNumber;
    }

    @Override
    public String toString(){
        return name + ", " + age + " - " + studentNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        return this.studentNumber == other.studentNumber;
    }

}
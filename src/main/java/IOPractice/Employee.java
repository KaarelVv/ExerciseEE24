package IOPractice;

 class Employee {
    private String name;
    private Integer age;
    private double salary;
    private boolean active;

    public Employee(String name, Integer age, double salary, boolean active) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", active=" + active +
                '}';
    }
}


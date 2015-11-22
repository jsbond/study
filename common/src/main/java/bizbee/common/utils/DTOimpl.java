package bizbee.common.utils;

import bizbee.common.model.Company;

/**
 *
 */
@DTO(entity = bizbee.common.model.Company.class)
public class DTOimpl {
    private String name;
    private int age;

    public DTOimpl(Company company) {
        this.name = "Ivan";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

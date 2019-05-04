package org.spring.test;


import org.spring.annotation.FieldTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class UserEntity {
    @FieldTest
    private String name;
    @FieldTest
    private String email;
    @FieldTest
    private String address;

    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static void main(String[] args) {
        Class cls = UserEntity.class;
        Field[] fields = cls.getDeclaredFields();
        for(Field field : fields){

            System.out.println(field.getName());
            Annotation[] annotations = field.getDeclaredAnnotations();
            System.out.println(annotations.length);
            for(Annotation annotation : annotations){
                System.out.println(annotation.annotationType().getName());
            }

            //field.getDeclaredAnnotationsByType()
            //System.out.println(field.getDeclaredAnnotations());
        }

    }
}

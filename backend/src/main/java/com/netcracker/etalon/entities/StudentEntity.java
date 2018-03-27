package com.netcracker.etalon.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "test_base", catalog = "")
public class StudentEntity {
    private int id;
    private String group;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "group")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id &&
                Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, group);
    }
}

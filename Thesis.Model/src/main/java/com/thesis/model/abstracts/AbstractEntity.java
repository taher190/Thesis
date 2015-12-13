package com.thesis.model.abstracts;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@MappedSuperclass
public abstract class AbstractEntity<T extends Serializable> implements IEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    private String lastChangedUser;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastChangedUser() {
        return lastChangedUser;
    }

    public void setLastChangedUser(String lastChangedUser) {
        this.lastChangedUser = lastChangedUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                '}';
    }
}

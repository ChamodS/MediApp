package com.example.mediapp.sport;

//import com.example.mediapp.user.User;

import javax.persistence.*;
//import java.util.List;
//import java.util.Set;


@Entity
public class Sport {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;
   

   /*@ManyToMany(cascade = CascadeType.ALL)
    private Set<User> user;*/

    public Sport() {
    }

    public String toString() {
		return "Sport [id=" + id + ", name=" + name + "]";
	}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /* public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }*/
}

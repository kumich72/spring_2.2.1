package hiber.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.*;


//@Component
@Entity(name = "Car")
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    //@OneToOne(mappedBy = "preCandidatRejet", cascade = CascadeType.ALL, fetch = FetchType.ALL)
    private Long id;

//    @OneToOne(mappedBy = "car")
//    private User user;

    @Column(name = "name")
    String name;
    @Column(name = "series")
    int series;

    public Car() {
    }

    public Car(String name, int series) {
        this.name = name;
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", series=" + series +
                '}';
    }
}

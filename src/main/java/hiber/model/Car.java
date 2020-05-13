package hiber.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;


//@Component
@Entity
@Table (name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@OneToOne(mappedBy = "preCandidatRejet", cascade = CascadeType.ALL, fetch = FetchType.ALL)
    private Long id;

    @OneToOne(mappedBy = "car")
    private User user;

    @Column(name = "name")
    String name;
    @Column(name = "series")
    int series;

    public Car() {}

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
}

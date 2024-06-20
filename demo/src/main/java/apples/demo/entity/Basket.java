package apples.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Apple> list = new ArrayList<>();

    public int getSize(){
        return list.size();
    }

    public void addApple(Apple apple){
        list.add(apple);
    }

    public boolean removeApple(Apple apple){
        return list.
                remove(apple);
    }


}

package web.pet.web_surveys.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_name", nullable = false)
    private String name;

    @Column(name = "c_gender", nullable = false)
    private Boolean gender;

    @Column(name = "c_registretedDate")
    private Date registeredDate;

    public String getGenderAsString() {
        return gender ? "мужской" : "женский";
    }

    public String getRegisteredDateAsString() {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                return formatter.format(registeredDate);
    }
}

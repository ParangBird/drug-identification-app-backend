package sotree.dia.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "member")
@Entity
@Getter
@RequiredArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String personalNumber;
    private String address;
    public Member(String name, String username, String password, String personalNumber, String address){
        this.name = name;
        this.username = username;
        this.password = password;
        this.personalNumber = personalNumber;
        this.address = address;
    }
}

package sotree.dia.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "member")
@Entity
@Getter
@RequiredArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String personalNumber;
    @NotNull
    private String address;
    @Builder
    public Member(String name, String username, String password, String personalNumber, String address){
        this.name = name;
        this.username = username;
        this.password = password;
        this.personalNumber = personalNumber;
        this.address = address;
    }
    public Member updatePassword(String password){
        this.password = password;
        return this;
    }
    public Member updateAddress(String newAddress){
        this.address = newAddress;
        return this;
    }
}

package testest.testest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String reason; // 지원 동기

    private String after; // 추후

    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus; // 지원 상태

    private int count;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Lesson lesson;
}

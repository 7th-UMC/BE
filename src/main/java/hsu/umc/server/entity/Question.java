package hsu.umc.server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question extends BaseEntity{

    @Id
    @GeneratedValue
    private Long QuestionId;

    private Category category;

    private String title;

    private String content;

    private Boolean isAnswered;

}

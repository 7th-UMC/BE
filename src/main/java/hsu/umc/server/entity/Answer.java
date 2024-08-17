package hsu.umc.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "answer_id")
    private Long answerId;

    private String content;
}

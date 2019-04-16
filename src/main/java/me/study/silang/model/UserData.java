package me.study.silang.model;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserData {

    private String videoNum;

    private String postNum;

    private String readNum;

    private String replyNum;

}

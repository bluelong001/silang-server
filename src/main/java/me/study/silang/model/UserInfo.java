package me.study.silang.model;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo {

    private Integer id;

    private String displayname;

    private String headIcon;

    private Integer role;
}

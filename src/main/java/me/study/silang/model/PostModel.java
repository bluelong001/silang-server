package me.study.silang.model;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Me
 * @since 2019-03-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Builder.Default
    private Integer id=0;
    @Builder.Default
    private String title="";
    @Builder.Default
    private String content="";
    @Builder.Default
    private String gmtCreate="2018-01-01 00:00:00";
    @Builder.Default
    private String gmtUpdate="2018-01-01 00:00:00";

    private UserInfo userInfo;
    @Builder.Default
    private Integer replyNum=0;
}

package org.wanbang.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.wanbang.util.anno.Name;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserReq1 implements Serializable {

    @Name
    private String name;

}

package org.dongfu.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.dongfu.util.anno.Name;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserReq1 implements Serializable {

    @Name
    private String name;

}

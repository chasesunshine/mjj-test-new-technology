package org.wanbang.dto.req;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * (SpringWord)实体类
 *
 * @author makejava
 * @since 2022-06-16 10:17:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadDataReq implements Serializable {
    private static final long serialVersionUID = -83513220652821879L;

    private String srcFile;

}


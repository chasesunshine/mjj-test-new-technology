package org.wanbang.study.allDesignMode.behaviorMode.brokeMode.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 14:27
* @version 1.0
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XNode {

    private String namespace;
    private String id;
    private String parameterType;
    private String resultType;
    private String sql;
    private Map<Integer, String> parameter;

}
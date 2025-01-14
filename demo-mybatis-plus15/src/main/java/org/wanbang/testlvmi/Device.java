package org.wanbang.testlvmi;

import lombok.Data;

@Data
public class Device {

    private String[] dids;

    private String positionId;

    private Integer pageNum;

    private Integer pageSize;

}

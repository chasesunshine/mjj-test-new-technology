package org.wanbang.entity.operationcenter;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 家庭管理列表详情 出参 - 2.5
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HomeManageListDetailVO {
    /**
     * 家庭地址
     */
    @ApiModelProperty(value = "家庭地址")
    private String homeAddress;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /**
     * 家庭成员
     */
    @ApiModelProperty(value = "家庭成员")
    private List<HomeManageListDetailMemberVO> memberList;


    /**
     * 房间信息
     */
    @ApiModelProperty(value = "房间信息")
    private List<HomeManageListDetailRoomVO> roomList;

}

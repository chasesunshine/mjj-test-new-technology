package org.wanbang.study.designMode.decorator;

/**
 * MusicPhoneDecorate
 * 给手机添加播放视频功能
 * @author MoXingJian
 * @email 939697374@qq.com
 * @date 2016年12月11日 下午9:29:04
 * @version 1.0
 */
public class PlayPhoneDecorate extends PhoneDecorate{
    public PlayPhoneDecorate(Phone p) {
        super(p);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("手机可以播放视频了");
    }
}

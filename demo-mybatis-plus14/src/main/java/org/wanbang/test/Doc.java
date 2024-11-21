package org.wanbang.test;

public class Doc {
    /**
     * {
     *   "data":[
     *     {
     *       "model":"lumi.weather.v1",                         项目管理-设备管理-设备模型值
     *       "resourceId":"0.1.85",                             设备模型下-设备资源-输入设备名称-资源名称（比如温度）-ResourceId
     *       "statusCode":0,                                    状态变更结果，成功或失败，具体查看以下“触发结果”说明： 0 成功执行
     *       "subjectId":"lumi.158d000a966751",                 对象id，如：设备id 或场景自动化id - 去个人账号下，设备资源，设备DID
     *       "time":"1730447377937",                            对象的属性变更时间戳，单位毫秒
     *       "triggerSource":{                                  消息触发原因
     *         "time":"1730447377",                             导致消息变更原因的触发时间，单位秒
     *         "type":10                                        消息触发类型，具体查看以下“触发类型”说明：10 设备自身触发上报
     *       },
     *       "value":"2756"                                     对象的属性变更到的值
     *     }
     *   ],
     *   "msgId":"AC12239E001D18B4AAC203656A059CD34",           消息唯一id标识
     *   "msgType":"resource_report",                           消息类型，resource_report：属性上报消息
     *   "openId":"932705586971299029521945432065",             用户唯一标识 : 项目管理-授权管理-openId
     *   "time":"1730447378034"                                 消息产生的时间戳，单位毫秒
     * }
     */

    /**
     * {
     *   "data":[
     *     {
     *       "model":"lumi.weather.v1",
     *       "resourceId":"0.1.85",
     *       "statusCode":0,
     *       "subjectId":"lumi.158d000a966751",
     *       "time":"1730447398257",
     *       "triggerSource":{
     *         "time":"1730447398",
     *         "type":10
     *       },
     *       "value":"2842"
     *     },
     *     {
     *       "model":"lumi.weather.v1",
     *       "resourceId":"0.2.85",
     *       "statusCode":0,
     *       "subjectId":"lumi.158d000a966751",
     *       "time":"1730447398277",
     *       "triggerSource":{
     *         "time":"1730447398",
     *         "type":10
     *       },
     *       "value":"6747"
     *     }
     *   ],
     *   "msgId":"AC12239E001D18B4AAC20365BA47ACE52",
     *   "msgType":"resource_report",
     *   "openId":"932705586971299029521945432065",
     *   "time":"1730447398529"
     * }
     */

    /**
     * 查询设备信息
     * 请求入参：
     * {
     *   "intent": "query.device.info",
     *   "data": {
     *     "dids": [
     *       "virtual2.07737309957642",
     *       "virtual2.07639066475218"
     *     ],
     *     "positionId": "",
     *     "pageNum": 1,
     *     "pageSize": 50
     *    }
     *  }
     * 返回结果：
     * "code": 0,
     *   "requestId": "803216b76ef44b79a54b25c4136fa3c9.42644.17304498043615811",
     *   "message": "Success",
     *   "msgDetails": null,
     *   "result": {
     *     "data": [
     *       {
     *         "parentDid": "lumi1.54ef446a0a98",
     *         "positionId": "real2.1301211262666452992",
     *         "createTime": 1730274148706,
     *         "timeZone": "GMT+08:00",
     *         "model": "lumi.weather.v1",
     *         "updateTime": 1730274578671,
     *         "modelType": 3,
     *         "state": 1,
     *         "firmwareVersion": "0.0.0_0005",
     *         "deviceName": "温湿度传感器-Weather",
     *         "did": "lumi.158d000a966751"
     *       }
     *     ],
     *     "totalCount": 1
     *   }
     * }
     *
     */


}

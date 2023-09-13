package org.dongfu.test1;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.CaseFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestGuava {
	
	@Test
	public void test(){
		System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));//testData
	}


	@Test
	public void test1(){
		String s = "1|";
		String s1 = "12068|12070|";
		String s2 = "1|118|11801|";

		String[] split = s.split("\\|");
		String[] split1 = s1.split("\\|");
		String[] split2 = s2.split("\\|");

		System.out.println(split[split.length-1]);
		System.out.println(split1[split1.length-1]);
		System.out.println(split2[split2.length-1]);
	}

	@Test
	public void test1x(){
		String a = "id=null, materialBaseinfoId=DS00320, materialBaseinfoName=七叶洋地黄双苷滴眼液, isMedicinal=1, medicinalId=131105, medicinalSubname=qyydh, medicinalEngName=, medicinalCurrencyName=七叶洋地黄双苷滴眼液, manufacturer=德国视都灵药品有限责任公司, placeoforigin=德国视都灵药品有限责任有限公司, barcode=null, brand=null, status=2, gmtModifiedUser=018611, classification=1|118|11808|, gmtCreate=null, gmtModified=null, manufacturerCode=null, manufacturerUniqueCode=null, reason=null, fsMaterialBaseinfo=FsMaterialBaseinfo(id=null, fsMaterialId=null, specifications=0.4ml*10支/盒, commodityTaxType=13%增值税, defaultTax=13, inventoryUnit=981, isVirtualProduct=0, isCrossBorder=0, quality=null, qualityUnit=null, roughWeight=null, roughWeightUnit=null, longer=null, longerUnit=null, widther=null, widtherUnit=null, higther=null, higtherUnit=null, volume=null, volumeUnit=null, prePurchasePrice=null, caseQty=200, retailPrice=45, isTraditionalChineseMedicine=0, isTapparatus=0, isRefrigeratedDrugs=0, isEphedrineContaining=0, isImportedDrugs=0, isSpecialGoods=null, isPoNewProducts=null, freshIdentification=null, valuablesIdentification=null, storageConditionsKey=null, drugSupervisionCodeIdentification=0, drugSupervisionCode=null, isGift=0, curingCycle=0, isSerialNumberControlRequired=null, isShelfLifeControlRequired=null, batchRuleId=null, validityOfApproval=null, minimumSafetyStock=null, maximumSafetyStock=null, temperatureRange=null, humidityRange=null, netWeight=null, netWeightUnit=null), certificatesList=null, fsMaterialBaseinfoDrugs=com.fosunhealth.scm.materialdrugs.entity.FsMaterialBaseinfoDrugs@7ec2657d";
		String s = JSONObject.toJSONString(a);
		System.out.println(s);
	}

}

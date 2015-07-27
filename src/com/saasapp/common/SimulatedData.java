package com.saasapp.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.saasapp.pojo.Department;
import com.saasapp.pojo.DeptAndDocType;
import com.saasapp.pojo.Hospital;
import com.saasapp.pojo.RegionOfAddress;
import com.saasapp.ui.R;

public class SimulatedData {
	private List<Map<String, Object>> list;
	/**
	 * 我的医生数据
	 */
	public List<Map<String, Object>> GetMyDocData() {
		list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("Pic", ""+R.drawable.zrf);
		map1.put("Name", "周润发");
		map1.put("Title", "小马哥");
		map1.put("Introduction", "周润发（Chow Yun Fat），1955年5月18日出生在香港南丫岛，籍贯广东开平，中国影视演员、摄影家，国家一级演员。");
		list.add(map1);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("Pic", "" + R.drawable.zbs);
		map2.put("Name", "赵本山");
		map2.put("Title", "本山大叔");
		map2.put("Introduction", "赵本山，1957年10月2日出生于辽宁省开原市，喜剧表演艺术家、国家一级演员，东北二人转教授，全国政协委员、中国曲艺家协会会员、全国青联委员、辽宁大学本山艺术学院院长，本山传媒集团董事长。");
		list.add(map2);
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("Pic", "" + R.drawable.ldh);
		map3.put("Name", "刘德华");
		map3.put("Title", "刀仔");
		map3.put("Introduction", "刘德华（Andy Lau），1961年9月出生于香港，演员、歌手、词作人、制片人、电影人，影视歌多栖发展的代表艺人之一。");
		list.add(map3);
		
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("Pic", "" + R.drawable.lufei);
		map4.put("Name", "蒙其·D·路飞");
		map4.put("Title", "草帽");
		map4.put("Introduction", "草帽海贼团船长。由于他的标志性特征是一顶草帽，因此常被直接称呼为草帽。梦想是找到传说中的ONE PIECE，成为海贼王。");
		list.add(map4);
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("Pic", "" + R.drawable.suolong);
		map5.put("Name", "罗罗亚·索隆");
		map5.put("Title", "绿藻头");
		map5.put("Introduction", "草帽海贼团中的战斗员，能够自由操纵三把刀战斗。梦想是成为世界第一大剑豪。");
		list.add(map5);
		
		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put("Pic", "" + R.drawable.luobin);
		map6.put("Name", "妮可·罗宾");
		map6.put("Title", "恶魔之子");
		map6.put("Introduction", "草帽海贼团的考古学家，出生在西海的考古学之岛“奥哈拉”。目标是找到真正的历史正文。");
		list.add(map6);
		
		Map<String, Object> map7 = new HashMap<String, Object>();
		map7.put("Pic", "" + R.drawable.mingren);
		map7.put("Name", "漩涡鸣人");
		map7.put("Title", "吊车尾");
		map7.put("Introduction", "火之国木叶隐村的忍者，六道仙人次子阿修罗转世。忍道:“我一直都是有话直说，这就是我的忍道。”");
		list.add(map7);
		
		Map<String, Object> map8 = new HashMap<String, Object>();
		map8.put("Pic", "" + R.drawable.zuozhu);
		map8.put("Name", "宇智波佐助");
		map8.put("Title", "复仇者");
		map8.put("Introduction", "宇智波一族的天才忍者，六道仙人长子因陀罗的转世，拥有六道中的阴之力。");
		list.add(map8);
		
		Map<String, Object> map9 = new HashMap<String, Object>();
		map9.put("Pic", "");
		map9.put("Name", "测试");
		map9.put("Title", "读取默认图片");
		map9.put("Introduction", "");
		list.add(map9);
		
		return list;
	}
	/**
	 * 发现——公告
	 */
	public List<Map<String, Object>> GetSearchNoticeData() {
		list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("title", "银联国际加快创新支付 助力粤港澳");
		map1.put("context",
				"中国游客的出境游目的地正越来越广泛，随着去年以来欧元汇率走低和签证简化，欧洲已成为国人"
						+ "出游仅次于亚洲的第二洲际选择。如果带上银联卡（卡号以62开头）出行，不仅能方便、顺畅地在欧洲38个国家和地区刷卡取"
						+ "现，更可在热门目的地享受银联卡专属优惠。<br />     今年以来，法国、意大利、瑞士依然是传统热门欧洲旅游目的地，"
						+ "捷克、土耳其、俄罗斯等则日益受到中国游客的青睐。根据近日汇率匡算，兑换1万欧元花费约6.9万元人民币，而去年此时则"
						+ "需花费约8.5万元，相当于在欧洲购物直接再打八折。同时，意大利、德国、英国、比利时等国家相继推出包括简化签证程序"
						+ "、缩短办理时间等在内针对中国游客的签证新政。<br/>     目前，在游客最常光顾的欧洲机场免税店、百货商场、折扣村"
						+ "等都有银联卡专属优惠，不仅覆盖伦敦、巴黎、米兰、罗马、阿姆斯特丹、马德里、巴塞罗那、尼斯八大机场，还有伦敦、巴黎"
						+ "、米兰、法兰克福、慕尼黑、马德里、巴塞罗那、布鲁塞尔、都柏林九大城市的名品折扣村，以及法国春天百货、巴黎BHV "
						+ "Marais百货、意大利米兰Brian & Barry百货、文艺复兴百货等欧洲四大百货店，折扣力度一般为九折左右，普遍持续到"
						+ "10月下旬，覆盖暑期、国庆等国人出游高峰时段。    意大利是今夏出游人数增长最快的欧洲国家之一，除了传统旅游项目，举"
						+ "家去参观米兰世博也备受青睐。现在，意大利八成ATM和近三成商户可使用银联卡，随着银联国际与意大利最大收单机构"
						+ "CartaSi合作，7月底就会开通其旗下1.5万家商户。米兰黄金四角商圈、Fidenza Village等知名商圈的50多家商户，"
						+ "为银联卡持卡人提供至少9折优惠。 经典欧洲游当然绕不开法国。今年上半年，法国新增6万多家商户可以刷银联卡消费，巴黎"
						+ "香榭丽舍大街、旺多姆广场等游客最常到的地方都可比较方便地使用银联卡。同时，当地一半以上ATM可用银联卡提取现金。法"
						+ "国优惠商户类型包括了餐饮、珠宝、奢侈品，游客最爱的春天百货、巴黎机场Buy Paris Duty Free、巴黎La Vallée " + "Village折扣村都有银联卡优惠。 ");
		map1.put("time", "2015/1/1");
		list.add(map1);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("title", "中国银联助力2015环青海湖国际");
		map2.put("context",
				"7月3日消息，银联国际已在韩国推出退税即时到账服务，并与主流机构合作发行当地首张银联“闪付”"
						+ "卡，还在商户受理环境优化、丰富用卡权益等多个领域取得新进展。在韩国旅游业受MERS疫情影响的背景下，银联国际致力于在"
						+ "淡季不断提升创新能力和服务水平，支持韩国政府振兴当地经济和旅游业发展。近期，银联国际在明洞、江南、梨泰院等首尔主要"
						+ "观光区检查，以进一步优化受理质量，确保MERS疫情缓解后，游客再次大量涌入韩国时可以享受更优质的银联卡支付服务。推出"
						+ "退税即时到账服务<br />银联国际与韩国最大的退税服务公司Global Tax Free（GTF）合作，首次推出中国境内银联卡"
						+ "（卡号以62开头）持卡人在韩退税即时到账服务，这也是迄今为止当地最快捷的退税服务，标志着韩国的银联卡产品和服务创新"
						+ "又获新进展。<br/>  游客在GTF特约商户购物后，可在市内退税服务台领取退税单，离境时在各大机场和港口海关盖章后，"
						+ "向GTF退税窗口提供姓名、护照号、国籍、银联卡卡号和身份证后6位，即可申请退税，税款即时返还至该银联卡中。<br/>"
						+ "创新支付提升用卡体验<br/>  再次扩大银联“闪付”服务范围。近期，韩国受理银联“闪付”卡的范围进一步扩大。银联卡持"
						+ "卡人已可在首尔东大门斗塔购物中心及8100余家GS25便利店体验快捷、便利、安全的“拍”卡支付。更多便利店、免税店、咖啡"
						+ "厅等将陆续开通。<br/>  本周，银联国际还与韩国主流机构正式合作，发行首张针对韩国人的银联“闪付”卡，近期还将在移动"
						+ "端推出非接产品，支持本地居民在全球500多万台“闪付”终端“拍”卡支付。<br/>携手T-money创新交通支付。为了解决游客赴"
						+ "韩后购买韩国T-Money交通卡的不便，银联国际还与韩国智能卡公司合作，9月中旬开始，中国境内银联“闪付”卡持卡人便可通过"
						+ "手机，在韩国使用T-Money交通卡的服务。此举为即将到来的国庆出游高峰提供了更便利的解决方案。");
		map2.put("time", "2015/3/1");
		list.add(map2);

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("title", "银联国际在韩持续发力 创新服务提");
		map3.put("context",
				"7月3日消息，银联国际已在韩国推出退税即时到账服务，并与主流机构合作发行当地首张银联“闪付”"
						+ "卡，还在商户受理环境优化、丰富用卡权益等多个领域取得新进展。在韩国旅游业受MERS疫情影响的背景下，银联国际致力于在"
						+ "淡季不断提升创新能力和服务水平，支持韩国政府振兴当地经济和旅游业发展。近期，银联国际在明洞、江南、梨泰院等首尔主要"
						+ "观光区检查，以进一步优化受理质量，确保MERS疫情缓解后，游客再次大量涌入韩国时可以享受更优质的银联卡支付服务。推出"
						+ "退税即时到账服务<br />银联国际与韩国最大的退税服务公司Global Tax Free（GTF）合作，首次推出中国境内银联卡"
						+ "（卡号以62开头）持卡人在韩退税即时到账服务，这也是迄今为止当地最快捷的退税服务，标志着韩国的银联卡产品和服务创新"
						+ "又获新进展。<br/>  游客在GTF特约商户购物后，可在市内退税服务台领取退税单，离境时在各大机场和港口海关盖章后，"
						+ "向GTF退税窗口提供姓名、护照号、国籍、银联卡卡号和身份证后6位，即可申请退税，税款即时返还至该银联卡中。<br/>"
						+ "创新支付提升用卡体验<br/>  再次扩大银联“闪付”服务范围。近期，韩国受理银联“闪付”卡的范围进一步扩大。银联卡持"
						+ "卡人已可在首尔东大门斗塔购物中心及8100余家GS25便利店体验快捷、便利、安全的“拍”卡支付。更多便利店、免税店、咖啡"
						+ "厅等将陆续开通。<br/>  本周，银联国际还与韩国主流机构正式合作，发行首张针对韩国人的银联“闪付”卡，近期还将在移动"
						+ "端推出非接产品，支持本地居民在全球500多万台“闪付”终端“拍”卡支付。<br/>携手T-money创新交通支付。为了解决游客赴"
						+ "韩后购买韩国T-Money交通卡的不便，银联国际还与韩国智能卡公司合作，9月中旬开始，中国境内银联“闪付”卡持卡人便可通过"
						+ "手机，在韩国使用T-Money交通卡的服务。此举为即将到来的国庆出游高峰提供了更便利的解决方案。");
		map3.put("time", "2015/4/7");
		list.add(map3);

		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("title", "2015年互联网金融支付安全论坛");
		map4.put("context",
				"7月3日消息，银联国际已在韩国推出退税即时到账服务，并与主流机构合作发行当地首张银联“闪付”"
						+ "卡，还在商户受理环境优化、丰富用卡权益等多个领域取得新进展。在韩国旅游业受MERS疫情影响的背景下，银联国际致力于在"
						+ "淡季不断提升创新能力和服务水平，支持韩国政府振兴当地经济和旅游业发展。近期，银联国际在明洞、江南、梨泰院等首尔主要"
						+ "观光区检查，以进一步优化受理质量，确保MERS疫情缓解后，游客再次大量涌入韩国时可以享受更优质的银联卡支付服务。推出"
						+ "退税即时到账服务<br />银联国际与韩国最大的退税服务公司Global Tax Free（GTF）合作，首次推出中国境内银联卡"
						+ "（卡号以62开头）持卡人在韩退税即时到账服务，这也是迄今为止当地最快捷的退税服务，标志着韩国的银联卡产品和服务创新"
						+ "又获新进展。<br/>  游客在GTF特约商户购物后，可在市内退税服务台领取退税单，离境时在各大机场和港口海关盖章后，"
						+ "向GTF退税窗口提供姓名、护照号、国籍、银联卡卡号和身份证后6位，即可申请退税，税款即时返还至该银联卡中。<br/>"
						+ "创新支付提升用卡体验<br/>  再次扩大银联“闪付”服务范围。近期，韩国受理银联“闪付”卡的范围进一步扩大。银联卡持"
						+ "卡人已可在首尔东大门斗塔购物中心及8100余家GS25便利店体验快捷、便利、安全的“拍”卡支付。更多便利店、免税店、咖啡"
						+ "厅等将陆续开通。<br/>  本周，银联国际还与韩国主流机构正式合作，发行首张针对韩国人的银联“闪付”卡，近期还将在移动"
						+ "端推出非接产品，支持本地居民在全球500多万台“闪付”终端“拍”卡支付。<br/>携手T-money创新交通支付。为了解决游客赴"
						+ "韩后购买韩国T-Money交通卡的不便，银联国际还与韩国智能卡公司合作，9月中旬开始，中国境内银联“闪付”卡持卡人便可通过"
						+ "手机，在韩国使用T-Money交通卡的服务。此举为即将到来的国庆出游高峰提供了更便利的解决方案。");
		map4.put("time", "2015/5/1");
		list.add(map4);

		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("title", "欧洲多国推银联卡专属优惠 全面覆");
		map5.put("context",
				"7月3日消息，银联国际已在韩国推出退税即时到账服务，并与主流机构合作发行当地首张银联“闪付”"
						+ "卡，还在商户受理环境优化、丰富用卡权益等多个领域取得新进展。在韩国旅游业受MERS疫情影响的背景下，银联国际致力于在"
						+ "淡季不断提升创新能力和服务水平，支持韩国政府振兴当地经济和旅游业发展。近期，银联国际在明洞、江南、梨泰院等首尔主要"
						+ "观光区检查，以进一步优化受理质量，确保MERS疫情缓解后，游客再次大量涌入韩国时可以享受更优质的银联卡支付服务。推出"
						+ "退税即时到账服务<br />银联国际与韩国最大的退税服务公司Global Tax Free（GTF）合作，首次推出中国境内银联卡"
						+ "（卡号以62开头）持卡人在韩退税即时到账服务，这也是迄今为止当地最快捷的退税服务，标志着韩国的银联卡产品和服务创新"
						+ "又获新进展。<br/>  游客在GTF特约商户购物后，可在市内退税服务台领取退税单，离境时在各大机场和港口海关盖章后，"
						+ "向GTF退税窗口提供姓名、护照号、国籍、银联卡卡号和身份证后6位，即可申请退税，税款即时返还至该银联卡中。<br/>"
						+ "创新支付提升用卡体验<br/>  再次扩大银联“闪付”服务范围。近期，韩国受理银联“闪付”卡的范围进一步扩大。银联卡持"
						+ "卡人已可在首尔东大门斗塔购物中心及8100余家GS25便利店体验快捷、便利、安全的“拍”卡支付。更多便利店、免税店、咖啡"
						+ "厅等将陆续开通。<br/>  本周，银联国际还与韩国主流机构正式合作，发行首张针对韩国人的银联“闪付”卡，近期还将在移动"
						+ "端推出非接产品，支持本地居民在全球500多万台“闪付”终端“拍”卡支付。<br/>携手T-money创新交通支付。为了解决游客赴"
						+ "韩后购买韩国T-Money交通卡的不便，银联国际还与韩国智能卡公司合作，9月中旬开始，中国境内银联“闪付”卡持卡人便可通过"
						+ "手机，在韩国使用T-Money交通卡的服务。此举为即将到来的国庆出游高峰提供了更便利的解决方案。");
		map5.put("time", "2015/7/10");
		list.add(map5);
		return list;
	}
	/**
	 * 发现——个人
	 */
	public List<Map<String, Object>> GetSearchIndividualData() {
		list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("title", "银医在线App,挂号预约缴费更便捷");
		map1.put("context", "7月10日推广银医在线App，医院最新时况一手掌握，就诊再也不用担心排队啦！支付更便捷，努力提高生活体检，为广大人民服务是我们的宗旨！");
		map1.put("time", "2015/07/10");
		list.add(map1);
		return list;
	}
	/**
	 * 医院选择数据 
	 */
	public List<RegionOfAddress> GetRegionData() {
		List<RegionOfAddress> list = new ArrayList<RegionOfAddress>();

		List<Hospital> fslist = new ArrayList<Hospital>();
		fslist.add(new Hospital("佛山市第一人民医院"));
		fslist.add(new Hospital("乐从医院"));
		fslist.add(new Hospital("大沥医院"));
		fslist.add(new Hospital("南海人民医院"));
		list.add(new RegionOfAddress("佛山市", fslist));

		List<Hospital> gzlist = new ArrayList<Hospital>();
		gzlist.add(new Hospital("广东省人民医院"));
		gzlist.add(new Hospital("广州市妇女儿童医院"));
		gzlist.add(new Hospital("广州市第一人民医院"));
		list.add(new RegionOfAddress("广州市", gzlist));

		List<Hospital> whlist = new ArrayList<Hospital>();
		whlist.add(new Hospital("武汉111111"));
		whlist.add(new Hospital("武汉222222"));
		whlist.add(new Hospital("武汉333333"));
		whlist.add(new Hospital("武汉444444"));
		whlist.add(new Hospital("武汉555555"));
		list.add(new RegionOfAddress("武汉市", whlist));

		List<Hospital> bjlist = new ArrayList<Hospital>();
		bjlist.add(new Hospital("北京111"));
		bjlist.add(new Hospital("北京222"));
		bjlist.add(new Hospital("北京333"));
		bjlist.add(new Hospital("北京444"));
		list.add(new RegionOfAddress("北京市", bjlist));

		List<Hospital> shlist = new ArrayList<Hospital>();
		shlist.add(new Hospital("上海11111"));
		shlist.add(new Hospital("上海22222"));
		shlist.add(new Hospital("上海33333"));
		shlist.add(new Hospital("上海44444"));
		shlist.add(new Hospital("上海55555"));
		shlist.add(new Hospital("上海66666"));
		shlist.add(new Hospital("上海77777"));
		shlist.add(new Hospital("上海88888"));
		shlist.add(new Hospital("上海99999"));
		list.add(new RegionOfAddress("上海市", shlist));
		
		return list;
	}
	/**
	 * 科室名和医生名数据
	 */
	public Map<String,String> GetDeptNameAndDocName(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("周润发","Doctor");
		map.put("刘德华","Doctor");
		map.put("赵本山","Doctor");
		map.put("蒙其·D·路飞","Doctor");
		map.put("罗罗亚·索隆","Doctor");
		map.put("妮可·罗宾","Doctor");
		map.put("漩涡鸣人","Doctor");
		map.put("宇智波佐助","Doctor");
		map.put("测试111","Doctor");
		map.put("测试222","Doctor");
		map.put("33测试3","Department");
		map.put("4测试44","Department");
		map.put("555测试","Department");
		map.put("测试111测试","Department");
		map.put("侏罗纪世界","Department");
		map.put("新神奇四侠","Department");
		map.put("末日之战2","Department");
		map.put("泰迪熊2","Department");
		map.put("花千骨","Department");
		map.put("盗墓笔记","Department");
		map.put("火影忍者","Department");
		map.put("海贼王","Department");
		return map;
	}
	/**
	 * 科室列表数据
	 */
	public List<Department> GetDeptList(){
		
		List<Department> list=new ArrayList<Department>();
		list.add(new Department("电影","0"));
		list.add(new Department("侏罗纪世界","电影"));
		list.add(new Department("新神奇四侠","电影"));
		list.add(new Department("末日之战2","电影"));
		list.add(new Department("连续剧","0"));
		list.add(new Department("花千骨","连续剧"));
		list.add(new Department("盗墓笔记","连续剧"));
		list.add(new Department("动漫","0"));
		list.add(new Department("火影忍者","动漫"));
		list.add(new Department("海贼王","动漫"));
		return list;
	}
	/**挂号时间段数据
	 */
	public List<Map<String,Object>> GetRegTimeList(){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Map<String,Object> map1=new HashMap<String,Object>();
		map1.put("Period", "上午");
		map1.put("Time", "08:30-09:00");
		map1.put("Surplus", "3");
		list.add(map1);
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("Period", "上午");
		map2.put("Time", "09:00-09:30");
		map2.put("Surplus", "2");
		list.add(map2);
		Map<String,Object> map3=new HashMap<String,Object>();
		map3.put("Period", "上午");
		map3.put("Time", "09:30-10:00");
		map3.put("Surplus", "5");
		list.add(map3);
		Map<String,Object> map4=new HashMap<String,Object>();
		map4.put("Period", "上午");
		map4.put("Time", "10:00-10:30");
		map4.put("Surplus", "3");
		list.add(map4);
		Map<String,Object> map5=new HashMap<String,Object>();
		map5.put("Period", "上午");
		map5.put("Time", "10:30-11:00");
		map5.put("Surplus", "4");
		list.add(map5);
		Map<String,Object> map6=new HashMap<String,Object>();
		map6.put("Period", "上午");
		map6.put("Time", "11:00-11:30");
		map6.put("Surplus", "9");
		list.add(map6);
		Map<String,Object> map7=new HashMap<String,Object>();
		map7.put("Period", "上午");
		map7.put("Time", "11:30-12:00");
		map7.put("Surplus", "9");
		list.add(map7);
		return list;
	}
}

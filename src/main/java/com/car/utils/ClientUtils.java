package com.car.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.car.domain.MonitorTips;
import com.car.redis.JedisUtil6800;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author : mmy
 * @Creat Time : 2020/3/3  18:29
 * @Description
 */
public class ClientUtils {

    public static HashMap geoCoordMap = null;
    static Random r = new Random();

    static {
        geoCoordMap = new HashMap();
        geoCoordMap.put("海门市", "121.15,31.89");
        geoCoordMap.put("鄂尔多斯市", "109.781327,39.608266");
        geoCoordMap.put("招远市", "120.38,37.35");
        geoCoordMap.put("舟山市", "122.207216,29.985295");
        geoCoordMap.put("齐齐哈尔市", "123.97,47.33");
        geoCoordMap.put("盐城市", "120.13,33.38");
        geoCoordMap.put("赤峰市", "118.87,42.28");
        geoCoordMap.put("青岛市", "120.33,36.07");
        geoCoordMap.put("乳山市", "121.52,36.89");
        geoCoordMap.put("金昌市", "102.188043,38.520089");
        geoCoordMap.put("泉州市", "118.58,24.93");
        geoCoordMap.put("莱西市", "120.53,36.86");
        geoCoordMap.put("日照市", "119.46,35.42");
        geoCoordMap.put("胶南市", "119.97,35.88");
        geoCoordMap.put("南通市", "121.05,32.08");
        geoCoordMap.put("拉萨市", "91.11,29.97");
        geoCoordMap.put("云浮市", "112.02,22.93");
        geoCoordMap.put("梅州市", "116.1,24.55");
        geoCoordMap.put("文登市", "122.05,37.2");
        geoCoordMap.put("上海市", "121.48,31.22");
        geoCoordMap.put("攀枝花市", "101.718637,26.582347");
        geoCoordMap.put("威海市", "122.1,37.5");
        geoCoordMap.put("承德市", "117.93,40.97");
        geoCoordMap.put("厦门市", "118.1,24.46");
        geoCoordMap.put("汕尾市", "115.375279,22.786211");
        geoCoordMap.put("潮州市", "116.63,23.68");
        geoCoordMap.put("丹东市", "124.37,40.13");
        geoCoordMap.put("太仓市", "121.1,31.45");
        geoCoordMap.put("曲靖市", "103.79,25.51");
        geoCoordMap.put("烟台市", "121.39,37.52");
        geoCoordMap.put("福州市", "119.3,26.08");
        geoCoordMap.put("瓦房店市", "121.979603,39.627114");
        geoCoordMap.put("即墨市", "120.45,36.38");
        geoCoordMap.put("抚顺市", "123.97,41.97");
        geoCoordMap.put("玉溪市", "102.52,24.35");
        geoCoordMap.put("张家口市", "114.87,40.82");
        geoCoordMap.put("阳泉市", "113.57,37.85");
        geoCoordMap.put("莱州市", "119.942327,37.177017");
        geoCoordMap.put("湖州市", "120.1,30.86");
        geoCoordMap.put("汕头市", "116.69,23.39");
        geoCoordMap.put("昆山市", "120.95,31.39");
        geoCoordMap.put("宁波市", "121.56,29.86");
        geoCoordMap.put("湛江市", "110.359377,21.270708");
        geoCoordMap.put("揭阳市", "116.35,23.55");
        geoCoordMap.put("荣成市", "122.41,37.16");
        geoCoordMap.put("连云港市", "119.16,34.59");
        geoCoordMap.put("葫芦岛市", "120.836932,40.711052");
        geoCoordMap.put("常熟市", "120.74,31.64");
        geoCoordMap.put("东莞市", "113.75,23.04");
        geoCoordMap.put("河源市", "114.68,23.73");
        geoCoordMap.put("淮安市", "119.15,33.5");
        geoCoordMap.put("泰州市", "119.9,32.49");
        geoCoordMap.put("南宁市", "108.33,22.84");
        geoCoordMap.put("营口市", "122.18,40.65");
        geoCoordMap.put("惠州市", "114.4,23.09");
        geoCoordMap.put("江阴市", "120.26,31.91");
        geoCoordMap.put("蓬莱市", "120.75,37.8");
        geoCoordMap.put("韶关市", "113.62,24.84");
        geoCoordMap.put("嘉峪关市", "98.289152,39.77313");
        geoCoordMap.put("广州市", "113.23,23.16");
        geoCoordMap.put("延安市", "109.47,36.6");
        geoCoordMap.put("太原市", "112.53,37.87");
        geoCoordMap.put("清远市", "113.01,23.7");
        geoCoordMap.put("中山市", "113.38,22.52");
        geoCoordMap.put("昆明市", "102.73,25.04");
        geoCoordMap.put("寿光市", "118.73,36.86");
        geoCoordMap.put("盘锦市", "122.070714,41.119997");
        geoCoordMap.put("长治市", "113.08,36.18");
        geoCoordMap.put("深圳市", "114.07,22.62");
        geoCoordMap.put("珠海市", "113.52,22.3");
        geoCoordMap.put("宿迁市", "118.3,33.96");
        geoCoordMap.put("咸阳市", "108.72,34.36");
        geoCoordMap.put("铜川市", "109.11,35.09");
        geoCoordMap.put("平度市", "119.97,36.77");
        geoCoordMap.put("佛山市", "113.11,23.05");
        geoCoordMap.put("海口市", "110.35,20.02");
        geoCoordMap.put("江门市", "113.06,22.61");
        geoCoordMap.put("章丘市", "117.53,36.72");
        geoCoordMap.put("肇庆市", "112.44,23.05");
        geoCoordMap.put("大连市", "121.62,38.92");
        geoCoordMap.put("临汾市", "111.5,36.08");
        geoCoordMap.put("吴江市", "120.63,31.16");
        geoCoordMap.put("石嘴山市", "106.39,39.04");
        geoCoordMap.put("沈阳市", "123.38,41.8");
        geoCoordMap.put("苏州市", "120.62,31.32");
        geoCoordMap.put("茂名市", "110.88,21.68");
        geoCoordMap.put("嘉兴市", "120.76,30.77");
        geoCoordMap.put("长春市", "125.35,43.88");
        geoCoordMap.put("胶州市", "120.03336,36.264622");
        geoCoordMap.put("银川市", "106.27,38.47");
        geoCoordMap.put("张家港市", "120.555821,31.875428");
        geoCoordMap.put("三门峡市", "111.19,34.76");
        geoCoordMap.put("锦州市", "121.15,41.13");
        geoCoordMap.put("南昌市", "115.89,28.68");
        geoCoordMap.put("柳州市", "109.4,24.33");
        geoCoordMap.put("三亚市", "109.511909,18.252847");
        geoCoordMap.put("自贡市", "104.778442,29.33903");
        geoCoordMap.put("吉林市", "126.57,43.87");
        geoCoordMap.put("阳江市", "111.95,21.85");
        geoCoordMap.put("泸州市", "105.39,28.91");
        geoCoordMap.put("西宁市", "101.74,36.56");
        geoCoordMap.put("宜宾市", "104.56,29.77");
        geoCoordMap.put("呼和浩特市", "111.65,40.82");
        geoCoordMap.put("成都市", "104.06,30.67");
        geoCoordMap.put("大同市", "113.3,40.12");
        geoCoordMap.put("镇江市", "119.44,32.2");
        geoCoordMap.put("桂林市", "110.28,25.29");
        geoCoordMap.put("张家界市", "110.479191,29.117096");
        geoCoordMap.put("宜兴市", "119.82,31.36");
        geoCoordMap.put("北海市", "109.12,21.49");
        geoCoordMap.put("西安市", "108.95,34.27");
        geoCoordMap.put("金坛市", "119.56,31.74");
        geoCoordMap.put("东营市", "118.49,37.46");
        geoCoordMap.put("牡丹江市", "129.58,44.6");
        geoCoordMap.put("遵义市", "106.9,27.7");
        geoCoordMap.put("绍兴市", "120.58,30.01");
        geoCoordMap.put("扬州市", "119.42,32.39");
        geoCoordMap.put("常州市", "119.95,31.79");
        geoCoordMap.put("潍坊市", "119.1,36.62");
        geoCoordMap.put("重庆市", "106.54,29.59");
        geoCoordMap.put("台州市", "121.420757,28.656386");
        geoCoordMap.put("南京市", "118.78,32.04");
        geoCoordMap.put("滨州市", "118.03,37.36");
        geoCoordMap.put("贵阳市", "106.71,26.57");
        geoCoordMap.put("无锡市", "120.29,31.59");
        geoCoordMap.put("本溪市", "123.73,41.3");
        geoCoordMap.put("克拉玛依市", "84.77,45.59");
        geoCoordMap.put("渭南市", "109.5,34.52");
        geoCoordMap.put("马鞍山市", "118.48,31.56");
        geoCoordMap.put("宝鸡市", "107.15,34.38");
        geoCoordMap.put("焦作市", "113.21,35.24");
        geoCoordMap.put("句容市", "119.16,31.95");
        geoCoordMap.put("北京市", "116.46,39.92");
        geoCoordMap.put("徐州市", "117.2,34.26");
        geoCoordMap.put("衡水市", "115.72,37.72");
        geoCoordMap.put("包头市", "110,40.58");
        geoCoordMap.put("绵阳市", "104.73,31.48");
        geoCoordMap.put("乌鲁木齐市", "87.68,43.77");
        geoCoordMap.put("枣庄市", "117.57,34.86");
        geoCoordMap.put("杭州市", "120.19,30.26");
        geoCoordMap.put("淄博市", "118.05,36.78");
        geoCoordMap.put("鞍山市", "122.85,41.12");
        geoCoordMap.put("溧阳市", "119.48,31.43");
        geoCoordMap.put("库尔勒", "86.06,41.68");
        geoCoordMap.put("安阳市", "114.35,36.1");
        geoCoordMap.put("开封市", "114.35,34.79");
        geoCoordMap.put("济南市", "117,36.65");
        geoCoordMap.put("德阳市", "104.37,31.13");
        geoCoordMap.put("温州市", "120.65,28.01");
        geoCoordMap.put("九江市", "115.97,29.71");
        geoCoordMap.put("邯郸市", "114.47,36.6");
        geoCoordMap.put("临安市", "119.72,30.23");
        geoCoordMap.put("兰州市", "103.73,36.03");
        geoCoordMap.put("沧州市", "116.83,38.33");
        geoCoordMap.put("临沂市", "118.35,35.05");
        geoCoordMap.put("南充市", "106.110698,30.837793");
        geoCoordMap.put("天津市", "117.2,39.13");
        geoCoordMap.put("富阳市", "119.95,30.07");
        geoCoordMap.put("泰安市", "117.13,36.18");
        geoCoordMap.put("诸暨市", "120.23,29.71");
        geoCoordMap.put("郑州市", "113.65,34.76");
        geoCoordMap.put("哈尔滨市", "126.63,45.75");
        geoCoordMap.put("聊城市", "115.97,36.45");
        geoCoordMap.put("芜湖市", "118.38,31.33");
        geoCoordMap.put("唐山市", "118.02,39.63");
        geoCoordMap.put("平顶山市", "113.29,33.75");
        geoCoordMap.put("邢台市", "114.48,37.05");
        geoCoordMap.put("德州市", "116.29,37.45");
        geoCoordMap.put("济宁市", "116.59,35.38");
        geoCoordMap.put("荆州市", "112.239741,30.335165");
        geoCoordMap.put("宜昌市", "111.3,30.7");
        geoCoordMap.put("义乌市", "120.06,29.32");
        geoCoordMap.put("丽水市", "119.92,28.45");
        geoCoordMap.put("洛阳市", "112.44,34.7");
        geoCoordMap.put("秦皇岛", "119.57,39.95");
        geoCoordMap.put("株洲市", "113.16,27.83");
        geoCoordMap.put("石家庄", "114.48,38.03");
        geoCoordMap.put("莱芜市", "117.67,36.19");
        geoCoordMap.put("常德市", "111.69,29.05");
        geoCoordMap.put("保定市", "115.48,38.85");
        geoCoordMap.put("湘潭市", "112.91,27.87");
        geoCoordMap.put("金华市", "119.64,29.12");
        geoCoordMap.put("岳阳市", "113.09,29.37");
        geoCoordMap.put("长沙市", "113,28.21");
        geoCoordMap.put("衢州市", "118.88,28.97");
        geoCoordMap.put("廊坊市", "116.7,39.53");
        geoCoordMap.put("菏泽市", "115.480656,35.23375");
        geoCoordMap.put("合肥市", "117.27,31.86");
        geoCoordMap.put("武汉市", "114.31,30.52");
        geoCoordMap.put("大庆市", "125.03,46.58");
        geoCoordMap.put("阿坝藏族羌族自治州", "102.231415,31.905512");
        geoCoordMap.put("阿克苏地区", "80.266943,41.17503");
        geoCoordMap.put("阿拉善盟", "105.735377,38.858276");
        geoCoordMap.put("阿勒泰地区", "88.147926,47.850728");
        geoCoordMap.put("阿里地区", "80.112777,32.506866");
        geoCoordMap.put("安康市", "109.035601,32.690513");
        geoCoordMap.put("安庆市", "117.063604,30.530957");
        geoCoordMap.put("安顺市", "105.954417,26.259252");
        geoCoordMap.put("巴彦淖尔市", "107.394398,40.749359");
        geoCoordMap.put("巴音郭楞蒙古自治州", "86.151714,41.770287");
        geoCoordMap.put("巴中市", "106.751585,31.872889");
        geoCoordMap.put("白城市", "122.845591,45.625504");
        geoCoordMap.put("白山市", "126.42963,41.939627");
        geoCoordMap.put("白银市", "104.144451,36.550825");
        geoCoordMap.put("百色市", "106.624589,23.908186");
        geoCoordMap.put("蚌埠市", "117.395513,32.921524");
        geoCoordMap.put("保山市", "99.177273,25.139039");
        geoCoordMap.put("毕节地区", "105.300492,27.302612");
        geoCoordMap.put("博尔塔拉蒙古自治州", "82.072915,44.912196");
        geoCoordMap.put("昌都地区", "97.185582,31.140576");
        geoCoordMap.put("昌吉回族自治州", "87.315002,44.016854");
        geoCoordMap.put("巢湖市", "117.88049,31.608733");
        geoCoordMap.put("朝阳市", "120.457499,41.579821");
        geoCoordMap.put("郴州市", "113.02146,25.776683");
        geoCoordMap.put("池州市", "117.498421,30.670884");
        geoCoordMap.put("崇左市", "107.37152,22.383117");
        geoCoordMap.put("滁州市", "118.339406,32.261271");
        geoCoordMap.put("楚雄彝族自治州", "101.534412,25.051774");
        geoCoordMap.put("达州市", "107.474594,31.214308");
        geoCoordMap.put("大理白族自治州", "100.274583,25.612128");
        geoCoordMap.put("大兴安岭地区", "124.152928,50.420026");
        geoCoordMap.put("德宏傣族景颇族自治州", "98.591359,24.438011");
        geoCoordMap.put("迪庆藏族自治州", "99.70953,27.825185");
        geoCoordMap.put("定西市", "104.63242,35.586833");
        geoCoordMap.put("鄂州市", "114.901607,30.396572");
        geoCoordMap.put("恩施土家族苗族自治州", "109.494593,30.27794");
        geoCoordMap.put("防城港市", "108.360419,21.693005");
        geoCoordMap.put("抚州市", "116.364539,27.954892");
        geoCoordMap.put("阜新市", "121.676408,42.028022");
        geoCoordMap.put("阜阳市", "115.820436,32.896061");
        geoCoordMap.put("甘南州", "102.917585,34.98914");
        geoCoordMap.put("甘孜藏族自治州", "101.968547,30.055279");
        geoCoordMap.put("赣州市", "114.940503,25.835176");
        geoCoordMap.put("固原市", "106.248577,36.021617");
        geoCoordMap.put("广安市", "106.639553,30.461746");
        geoCoordMap.put("广元市", "105.850423,32.441616");
        geoCoordMap.put("贵港市", "109.60552,23.117448");
        geoCoordMap.put("果洛藏族自治州", "100.251592,34.477194");
        geoCoordMap.put("哈密地区", "93.528355,42.858596");
        geoCoordMap.put("海北藏族自治州", "100.907434,36.960663");
        geoCoordMap.put("海东地区", "102.085207,36.51761");
        geoCoordMap.put("海南藏族自治州", "100.626621,36.292102");
        geoCoordMap.put("海西蒙古族藏族自治州", "97.376299,37.38275");
        geoCoordMap.put("汉中市", "107.02943,33.0738");
        geoCoordMap.put("毫州市", "115.78,33.85");
        geoCoordMap.put("和田地区", "79.928507,37.120446");
        geoCoordMap.put("河池市", "108.0915,24.698912");
        geoCoordMap.put("贺州市", "111.573526,24.409451,");
        geoCoordMap.put("鹤壁市", "114.303594,35.752357");
        geoCoordMap.put("鹤岗市", "130.304433,47.356056");
        geoCoordMap.put("黑河市", "127.53549,50.251272");
        geoCoordMap.put("衡阳市", "112.578447,26.899576,");
        geoCoordMap.put("红河哈尼族彝族自治州", "103.381549,23.369996");
        geoCoordMap.put("呼伦贝尔市", "119.77237,49.218446");
        geoCoordMap.put("怀化市", "110.008514,27.575161");
        geoCoordMap.put("淮北市", "116.804537,33.961656");
        geoCoordMap.put("淮南市", "117.006389,32.631847");
        geoCoordMap.put("黄冈市", "114.87849,30.459359");
        geoCoordMap.put("黄南藏族自治州", "102.022428,35.525805");
        geoCoordMap.put("黄山市", "118.345437,29.72189");
        geoCoordMap.put("黄石市", "115.045533,30.205208");
        geoCoordMap.put("鸡西市", "130.975619,45.300872");
        geoCoordMap.put("吉安市", "115.000511,27.119727");
        geoCoordMap.put("佳木斯市", "130.327359,46.80569");
        geoCoordMap.put("晋城市", "112.858578,35.496285");
        geoCoordMap.put("晋中市", "112.759595,37.692839");
        geoCoordMap.put("荆门市", "112.206393,31.041733");
        geoCoordMap.put("景德镇市", "117.184576,29.274248");
        geoCoordMap.put("酒泉市", "98.500685,39.738469");
        geoCoordMap.put("喀什地区", "75.996391,39.476097");
        geoCoordMap.put("克孜勒苏柯尔克孜自治州", "76.174309,39.720471");
        geoCoordMap.put("来宾市", "109.227458,23.756547");
        geoCoordMap.put("乐山市", "103.772538,29.557941");
        geoCoordMap.put("丽江市", "100.232465,26.860657");
        geoCoordMap.put("凉山彝族自治州", "102.273503,27.887752");
        geoCoordMap.put("辽阳市", "123.243366,41.274161");
        geoCoordMap.put("辽源市", "125.150425,42.894055");
        geoCoordMap.put("林芝地区", "94.349985,29.666941");
        geoCoordMap.put("临沧市", "100.09544,23.890469");
        geoCoordMap.put("临夏州", "103.216391,35.607562");
        geoCoordMap.put("六安市", "116.52641,31.741451");
        geoCoordMap.put("六盘水市", "104.837555,26.598833");
        geoCoordMap.put("龙岩市", "117.023448,25.08122");
        geoCoordMap.put("陇南市", "104.928575,33.40662");
        geoCoordMap.put("娄底市", "112.001503,27.703209");
        geoCoordMap.put("吕梁市", "111.15045,37.524498");
        geoCoordMap.put("漯河市", "114.023421,33.587711");
        geoCoordMap.put("眉山市", "103.856563,30.082526");
        geoCoordMap.put("内江市", "105.064588,29.585887");
        geoCoordMap.put("那曲地区", "92.067018,31.48068");
        geoCoordMap.put("南平市", "118.18437,26.647773");
        geoCoordMap.put("南阳市", "112.534501,32.996562");
        geoCoordMap.put("宁德市", "119.554511,26.672242");
        geoCoordMap.put("怒江傈僳族自治州", "98.863288,25.823707");
        geoCoordMap.put("平凉市", "106.671442,35.549232");
        geoCoordMap.put("萍乡市", "113.861496,27.628393");
        geoCoordMap.put("莆田市", "119.014521,25.459865");
        geoCoordMap.put("濮阳市", "115.035597,35.767593");
        geoCoordMap.put("普洱市", "100.97257,22.830979");
        geoCoordMap.put("七台河市", "131.011545,45.7763");
        geoCoordMap.put("黔东南苗族侗族自治州", "107.989446,26.589703");
        geoCoordMap.put("黔南布依族苗族自治州", "107.528403,26.260616");
        geoCoordMap.put("黔西南布依族苗族自治州", "104.912492,25.093967");
        geoCoordMap.put("钦州市", "108.66058,21.986594");
        geoCoordMap.put("秦皇岛市", "119.608531,39.941748");
        geoCoordMap.put("庆阳市", "107.649386,35.715216");
        geoCoordMap.put("日喀则地区", "88.893703,29.275658");
        geoCoordMap.put("三明市", "117.645521,26.269737");
        geoCoordMap.put("山南地区", "91.750644,29.229027");
        geoCoordMap.put("商洛市", "109.924418,33.878634");
        geoCoordMap.put("商丘市", "115.662449,34.420202");
        geoCoordMap.put("上饶市", "117.94946,28.460626");
        geoCoordMap.put("邵阳市", "111.474433,27.24527");
        geoCoordMap.put("十堰市", "110.80453,32.635062");
        geoCoordMap.put("石家庄市", "114.521532,38.048312");
        geoCoordMap.put("双鸭山市", "131.165342,46.653186");
        geoCoordMap.put("朔州市", "112.439371,39.337108");
        geoCoordMap.put("四平市", "124.356482,43.171994");
        geoCoordMap.put("松原市", "124.831482,45.147404");
        geoCoordMap.put("宿州市", "116.970544,33.652095");
        geoCoordMap.put("绥化市", "126.975357,46.660032");
        geoCoordMap.put("随州市", "113.38945,31.696517");
        geoCoordMap.put("遂宁市", "105.599422,30.539098");
        geoCoordMap.put("塔城地区", "82.987236,46.750948");
        geoCoordMap.put("天水市", "105.731417,34.587412");
        geoCoordMap.put("铁岭市", "123.732365,42.229948");
        geoCoordMap.put("通化市", "125.946606,41.733816");
        geoCoordMap.put("通辽市", "122.250522,43.65798");
        geoCoordMap.put("铜陵市", "117.818477,30.951233");
        geoCoordMap.put("铜仁市", "109.168558,27.674903");
        geoCoordMap.put("吐鲁番地区", "89.181595,42.96047");
        geoCoordMap.put("文山壮族苗族自治州", "104.222569,23.405994");
        geoCoordMap.put("乌海市", "106.800391,39.662006");
        geoCoordMap.put("乌兰察布市", "113.139468,41.000748");
        geoCoordMap.put("吴忠市", "106.205371,38.003713");
        geoCoordMap.put("梧州市", "111.285517,23.482745");
        geoCoordMap.put("武威市", "102.644554,37.934378");
        geoCoordMap.put("西双版纳傣族自治州", "100.803447,22.013601");
        geoCoordMap.put("锡林郭勒盟", "116.054391,43.939423");
        geoCoordMap.put("咸宁市", "114.328519,29.847056");
        geoCoordMap.put("湘西土家族苗族自治州", "109.745577,28.317369");
        geoCoordMap.put("襄樊市", "112.176326,32.094934");
        geoCoordMap.put("孝感市", "113.92251,30.930689");
        geoCoordMap.put("忻州市", "112.740624,38.422383");
        geoCoordMap.put("新乡市", "113.9336,35.30964");
        geoCoordMap.put("新余市", "114.923535,27.823579");
        geoCoordMap.put("信阳市", "114.097483,32.153015");
        geoCoordMap.put("兴安盟", "122.044365,46.088464");
        geoCoordMap.put("许昌市", "113.858476,34.041432");
        geoCoordMap.put("宣城市", "118.765534,30.946602");
        geoCoordMap.put("雅安市", "103.049543,30.016793");
        geoCoordMap.put("延边朝鲜族自治州", "129.477376,42.915743");
        geoCoordMap.put("伊春市", "128.847546,47.733318");
        geoCoordMap.put("伊犁哈萨克自治州", "81.330538,43.922723");
        geoCoordMap.put("宜春市", "114.423564,27.820856");
        geoCoordMap.put("益阳市", "112.361516,28.559711");
        geoCoordMap.put("鹰潭市", "117.075575,28.265787");
        geoCoordMap.put("永州市", "111.619455,26.425864");
        geoCoordMap.put("榆林市", "109.741616,38.290884");
        geoCoordMap.put("玉林市", "110.188453,22.659831");
        geoCoordMap.put("玉树藏族自治州", "97.013181,33.01098");
        geoCoordMap.put("运城市", "111.013389,35.032707");
        geoCoordMap.put("张掖市", "100.456411,38.932066");
        geoCoordMap.put("漳州市", "117.653576,24.51893");
        geoCoordMap.put("昭通市", "103.723512,27.344084");
        geoCoordMap.put("中卫市", "105.203571,37.505701");
        geoCoordMap.put("周口市", "114.703483,33.631829");
        geoCoordMap.put("驻马店市", "114.028471,33.017842");
        geoCoordMap.put("资阳市", "104.634435,30.134957");

    }

    ;

// 330

    /**
     * @param     MinLon：最小经度  MaxLon：最大经度
     *                    MinLat：最小纬度
     *                    MaxLat：最大纬度
     * @return @throws
     * @Description: 在矩形内随机生成经纬度
     */
    public static Map<String, String> randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat) {
        BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();// 小数后6位
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        Map<String, String> map = new HashMap<String, String>();
        map.put("J", lon);
        map.put("W", lat);
        return map;
    }


    private static String getIMEI() {// calculator IMEI
        int r1 = 1000000 + new java.util.Random().nextInt(9000000);
        int r2 = 1000000 + new java.util.Random().nextInt(9000000);
        String input = r1 + "" + r2;
        char[] ch = input.toCharArray();
        int a = 0, b = 0;
        for (int i = 0; i < ch.length; i++) {
            int tt = Integer.parseInt(ch[i] + "");
            if (i % 2 == 0) {
                a = a + tt;
            } else {
                int temp = tt * 2;
                b = b + temp / 10 + temp % 10;
            }
        }
        int last = (a + b) % 10;
        if (last == 0) {
            last = 0;
        } else {
            last = 10 - last;
        }
        return input + last;
    }

    private static String getImsi() {
        // 460022535025034
        String title = "4600";
        int second = 0;
        do {
            second = new java.util.Random().nextInt(8);
        } while (second == 4);
        int r1 = 10000 + new java.util.Random().nextInt(90000);
        int r2 = 10000 + new java.util.Random().nextInt(90000);
        return title + "" + second + "" + r1 + "" + r2;
    }

    private static String getMac() {
        char[] char1 = "abcdef".toCharArray();
        char[] char2 = "0123456789".toCharArray();
        StringBuffer mBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int t = new java.util.Random().nextInt(char1.length);
            int y = new java.util.Random().nextInt(char2.length);
            int key = new java.util.Random().nextInt(2);
            if (key == 0) {
                mBuffer.append(char2[y]).append(char1[t]);
            } else {
                mBuffer.append(char1[t]).append(char2[y]);
            }

            if (i != 5) {
                mBuffer.append(":");
            }
        }
        return mBuffer.toString();
    }

    /**
     * @param longitude 经度
     * @param latitude  纬度
     * @param distince  距离（千米）
     * @return String 格式：经度最小值-经度最大值-纬度最小值-纬度最大值
     * @Description 计算给定经纬度附近相应公里数的经纬度范围
     * @Data 2018.10.26
     **/
    public static String getNearbyByLongitudeAndLatitudeAndDistince(BigDecimal longitude, BigDecimal latitude, Integer distince) {
        double r = 6371.393; // 地球半径千米
        double lng = longitude.doubleValue();
        double lat = latitude.doubleValue();
        double dlng = 2 * Math.asin(Math.sin(distince / (2 * r)) / Math.cos(lat * Math.PI / 180));
        dlng = dlng * 180 / Math.PI;// 角度转为弧度
        double dlat = distince / r;
        dlat = dlat * 180 / Math.PI;
        double minlat = lat - dlat;
        double maxlat = lat + dlat;
        double minlng = lng - dlng;
        double maxlng = lng + dlng;

        return minlng + "-" + maxlng + "-" + minlat + "-" + maxlat;

    }

    // /**
    // * @Description 计算距离远近并按照距离排序
    // * @param longitude 经度
    // * @param latitude 纬度
    // * @param nearbyStoreList 附近门店
    // * @return 按照距离由近到远排序之后List
    // */
    // public List<PickStoreOfflineDto> getNearbyStoreByDistinceAsc(BigDecimal
    // longitude, BigDecimal latitude, List<PickStoreOfflineModel>
    // nearbyStoreList) {
    // List<PickStoreOfflineDto> list = new ArrayList<>();
    // nearbyStoreList.forEach(pickStoreOfflineModel -> {
    // PickStoreOfflineDto pickStoreOfflineDto = new PickStoreOfflineDto();
    // BeanUtils.copyProperties(pickStoreOfflineModel, pickStoreOfflineDto);
    // Double distince = getDistince(longitude, latitude,
    // pickStoreOfflineModel.getLongitude(),
    // pickStoreOfflineModel.getLatitude());
    // pickStoreOfflineDto.setDistince(distince.longValue());
    // list.add(pickStoreOfflineDto);
    // });
    // Collections.sort(list,
    // Comparator.comparing(PickStoreOfflineDto::getDistince));
    // return list;
    // }

    // /**
    // * @Description 根据经纬度获取两点之间的距离
    // * @param longitude1 地点1经度
    // * @param latitude1 地点1纬度
    // * @param longitude2 地点2经度
    // * @param latitude2 地点2纬度
    // * @return 距离：单位 米
    // */
    // public static Double getDistince(BigDecimal longitude1, BigDecimal
    // latitude1, BigDecimal longitude2, BigDecimal latitude2) {
    // double r = 6371.393; // 地球半径千米
    // double lat1 = latitude1.doubleValue();
    // double lng1 = longitude1.doubleValue();
    // double lat2 = latitude2.doubleValue();
    // double lng2 = longitude2.doubleValue();
    // double radLat1 = rad(lat1);
    // double radLat2 = rad(lat2);
    // double a = radLat1 - radLat2;
    // double b = rad(lng1) - rad(lng2);
    // double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
    // Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
    // s = s * r;
    // s = Math.round(s * 1000);
    // return s;
    // }

    private static double EARTH_RADIUS = 6371.393;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算两个经纬度之间的距离
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return //公里
     * System.out.println(GetDistance(29.490295,106.486654,29.615467,106.581515));
     */
    public static double GetDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.abs(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2))));
        s = s * EARTH_RADIUS;
        s = Math.round(s); // 公里
        return s;
    }

    public static int getRandom(int min, int max) {
        Random random = new Random();
        int i = random.nextInt(max) % (max - min + 1) + min;
        return i;
    }

    /**
     * @param MinLon：最新经度 MaxLon：
     *                    最大经度 MinLat：最新纬度 MaxLat：最大纬度 type：设置返回经度还是纬度 @return @throws
     * @Title: randomLonLat @Description: 在矩形内随机生成经纬度
     */
    public String randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat, String type) {
        Random random = new Random();
        BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();// 小数后6位
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        if (type.equals("Lon")) {
            return lon;
        } else {
            return lat;
        }
    }


    public static void generate36900() {
        JedisUtil6800.flushDB1();
        Iterator iterator = geoCoordMap.entrySet().iterator(); //330
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            float lat = Float.parseFloat(((String) entry.getValue()).split(",")[1]);
            float lng = Float.parseFloat(((String) entry.getValue()).split(",")[0]);
            for (int i = 0; i < 100; i++) {
                // double MinLon, double MaxLon, double MinLat, double MaxLat
                /*
                 *３３０个城市，每个城市随机１００个地方．
                 */
                Map<String, String> jw = randomLonLat(lng - 2, lng + 2, lat - 2, lat + 2);
                System.out.println(jw.get("J") + "," + jw.get("W")); // 北纬LAT // 39度

                String devicelng = jw.get("J");
                String devicelat = jw.get("W");

                lat = Float.parseFloat(devicelat);
                lng = Float.parseFloat(devicelng);

                /*
                 * 随机找到下一个目标城市
                 */
                Map.Entry entry2 = (Map.Entry) geoCoordMap.entrySet().toArray()[r.nextInt(geoCoordMap.size() - 1)];

                float deslat2 = Float.parseFloat(((String) entry2.getValue()).split(",")[1]);
                float deslng2 = Float.parseFloat(((String) entry2.getValue()).split(",")[0]);

                Map<String, String> jwdest = randomLonLat(deslng2 - 2, deslng2 + 2, deslat2 - 2, deslat2 + 2);
                String devicelngdest = jwdest.get("J");
                String devicelatdest = jwdest.get("W");

                deslat2 = Float.parseFloat(devicelatdest);
                deslng2 = Float.parseFloat(devicelngdest);

                System.out.println("HashMap start : " + entry.getKey() + " - " + entry.getValue());
                System.out.println("HashMap end   : " + entry2.getKey() + " - " + entry2.getValue());

                System.out.println(lat + " " + lng + "  --> " + deslat2 + " " + deslng2 + "  -->" + GetDistance(lat, lng, deslat2, deslng2));

                /*
                 * 生成２个城市之间１０个经纬度，因为中国再大 １０天也到了。 到站点后停留
                 */
                ArrayList al = generate10(deslat2, deslng2, lat, lng);

                String IMEI = getIMEI();
                String IMSI = getImsi();

                String ICCID = "89860" + getIMEI();

//                MonitorTips MonitorTips = new MonitorTips("", 0, 0, "", "", "", "", "", "", "", "", "", "", "", new Date().getTime(), new Date().getTime(), new Date().getTime(), 0, 0, 0, 0, 0, 0, 0, 0, 0, "", "", "", "", "", "zh-cn", "");
                MonitorTips monitorTips = new MonitorTips();
                monitorTips.setIMSI(IMSI);
                monitorTips.setICCID(ICCID);
                monitorTips.setDeviceName(IMEI);
                monitorTips.setDeviceNumber(IMEI);
                monitorTips.setLat((devicelat));
                monitorTips.setLng((devicelng));

                monitorTips.setIP("60.2.213.22");
                monitorTips.setPort("61019");
                monitorTips.setSpeed("123");
                int num = (int) (Math.random() * 50 + 50);
                monitorTips.setOuterVoltage(num + "");

                JSONArray JsonArray = JSON.parseArray(JSONObject.toJSONString(al));

                monitorTips.setLatlngarraylist(JsonArray.toJSONString());
                monitorTips.setLatlngdest(devicelatdest + "," + devicelngdest);
                JedisUtil6800.setString1(IMEI, JSON.toJSONString(monitorTips));
                // 在经线上，纬度每差1度,实地距离大约为111千米；
                // 在纬线上，经度每差1度,实际距离为111×cosθ千米
            }
        }
    }

    public static ArrayList generate10(float deslat2, float deslng2, float lat, float lng) {
        ArrayList al = new ArrayList();

        float lattemp = lat;
        float lngtemp = lng;

        for (int qi = 0; qi < 10; qi++) {

            if (deslat2 > lat) {
                lattemp = lat + (deslat2 - lat) / 9 * qi;
            } else {
                lattemp = lat - (lat - deslat2) / 9 * qi;
            }

            if (deslng2 > lng) {
                lngtemp = lng + (deslng2 - lng) / 9 * qi;
            } else {
                lngtemp = lng - (lng - deslng2) / 9 * qi;
            }

            //System.out .println(lattemp + " " + lngtemp + " --- > " + GetDistance(lattemp, lngtemp, deslat2, deslng2));
            al.add(lattemp + "," + lngtemp);
        }

        al.add(deslat2 + "," + deslng2);

        return al;
    }

    public static String generateTRVAP00(String IMEI) {
        //TRVAP00353456789012345#
        return "TRVAP00" + IMEI + "#";
    }

    public static String generateTRVYP02(String imis, String iccid) {
        //TRVYP02,460023136470163,898602B1191550255484#
        return "TRVYP02," + imis + "," + iccid + "#";
    }

    public static String generateTRVAP01(String imis, String iccid) {
        //TRVAP01   080524   A   2232.9806  N   11404.9355   E  000.1   061830323.87   06000908000102,   460,0,9520,3671#
        return "TRVYP02," + imis + "," + iccid + "#";
    }


    public static void main(String[] args) {

        /*
         * 格式化数据库１并且生成３６９００初始化数据
         */
        generate36900();
        ConcurrentHashMap<String, MonitorTips> ha = JedisUtil6800.getDeviceMonitorTipsMapBy1();

        while (1 == 1) {  //一条一条　无限循环，生成数据报文
            Random r = new Random();
            Iterator iterator = ha.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                MonitorTips monitorTips = (MonitorTips) entry.getValue();
                System.out.println(monitorTips.getDeviceName());
                //System.out.println(MonitorTips.getLatlngarraylist());

                String home = monitorTips.getLatlngdest();
                // MonitorTips.setLatlngdest(devicelatdest +","+devicelngdest );
                float lat = Float.parseFloat(home.split(",")[0]);
                float lng = Float.parseFloat(home.split(",")[1]);

                String aa = monitorTips.getLatlngarraylist();
                JSONArray aJSONArray = JSONArray.parseArray(aa);

                if (aJSONArray.size() > 0) {
                    String jw = (String) aJSONArray.get(0);
                    if (aJSONArray.size() == 1) {
                        monitorTips.setLatlngdest(jw);
                        monitorTips.setLat((jw.split(",")[0]));
                        monitorTips.setLng((jw.split(",")[1]));
                    }

                    //开始通信　　 注册

                    String TRVAP00 = generateTRVAP00(monitorTips.getDeviceName());

                    // 开始通信　　 注册
                    // 2.使用此协议的时间点：登录包AP00发送完、并得到平台BP00
                    // 的响应之后，紧接着就发送 YP02。

                    Float Lat = (Float.parseFloat(jw.split(",")[0]));
                    Float Lng = (Float.parseFloat(jw.split(",")[1]));

                    String TRVYP02 = generateTRVYP02(monitorTips.getIMSI(), monitorTips.getICCID());

                    //TRVAP01080524A2232.9806N11404.9355E000.1061830323.8706000908000102,460,0,9520,3671#

                    ////通信完毕

                    aJSONArray.remove(0);

                    System.out.println(monitorTips.getDeviceName() + "-->" + jw + "-->" + aJSONArray.size());
                    monitorTips.setLatlngarraylist(aJSONArray.toJSONString());
                    /*
                     * 位置取走了一个，要存储的
                     */

                    JedisUtil6800.setString1(monitorTips.getDeviceName(), JSON.toJSONString(monitorTips));
                    ha.put(monitorTips.getDeviceName(), monitorTips);
                }

                if (aJSONArray.size() == 0) {//生成路线数据

                    Map.Entry entry2 = (Map.Entry) geoCoordMap.entrySet().toArray()[r.nextInt(geoCoordMap.size() - 1)];
                    float deslat2 = Float.parseFloat(((String) entry2.getValue()).split(",")[1]);
                    float deslng2 = Float.parseFloat(((String) entry2.getValue()).split(",")[0]);

                    Map<String, String> jwdest = randomLonLat(deslng2 - 2, deslng2 + 2, deslat2 - 2, deslat2 + 2);
                    String devicelngdest = jwdest.get("J");
                    String devicelatdest = jwdest.get("W");

                    deslat2 = Float.parseFloat(devicelatdest);
                    deslng2 = Float.parseFloat(devicelngdest);

                    ArrayList al = generate10(deslat2, deslng2, lat, lng);

                    monitorTips.setLatlngarraylist(JSON.toJSONString(al));
                    monitorTips.setLatlngdest(devicelatdest + "," + devicelngdest);

                    JedisUtil6800.setString1(monitorTips.getDeviceName(), JSON.toJSONString(monitorTips));
                    ha.put(monitorTips.getDeviceName(), monitorTips);
                }

            }

        }


    }


}

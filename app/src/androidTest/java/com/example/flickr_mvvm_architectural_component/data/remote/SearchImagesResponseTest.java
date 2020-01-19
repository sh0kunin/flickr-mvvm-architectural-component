package com.example.flickr_mvvm_architectural_component.data.remote;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

import static junit.framework.TestCase.assertEquals;

public class SearchImagesResponseTest {

	private SearchImagesResponse searchImagesResponse;

	@Before
	public void setup() {
		searchImagesResponse = new SearchImagesResponse();
	}

    @Test
    public void testSuccessSearchResultsResponse() throws JSONException {


		String json = "{\"photos\":{\"page\":1,\"pages\":777,\"perpage\":100,\"total\":\"77660\",\"photo\":[{\"id\":\"49408481066\",\"owner\":\"183727554@N08\",\"secret\":\"b0d29fb802\",\"server\":\"65535\",\"farm\":66,\"title\":\"Wolf Moon 2020 January\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49408372356\",\"owner\":\"38017226@N05\",\"secret\":\"8daaeffe29\",\"server\":\"65535\",\"farm\":66,\"title\":\"Escalator woman.\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49408530312\",\"owner\":\"185804691@N02\",\"secret\":\"23abdd5181\",\"server\":\"65535\",\"farm\":66,\"title\":\"Title: How Do I Make Money From Home? 3 Ways Baby Boomers Can Make Money With Article Marketing\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49402866656\",\"owner\":\"33950163@N03\",\"secret\":\"d3c8b60a8a\",\"server\":\"65535\",\"farm\":66,\"title\":\"A6-EBA 2 Boeing 777-31HER Emirates Airline MAN 04OCT05\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"6766057157\",\"owner\":\"33950163@N03\",\"secret\":\"2f9ec0de35\",\"server\":\"65535\",\"farm\":66,\"title\":\"A6-EBA 3 Boeing 777-31HER Emirates Airline MAN 04OCT05\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49408207391\",\"owner\":\"151806460@N05\",\"secret\":\"129045b4af\",\"server\":\"65535\",\"farm\":66,\"title\":\"TITLES\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407693328\",\"owner\":\"10655856@N04\",\"secret\":\"c3ec20eb28\",\"server\":\"65535\",\"farm\":66,\"title\":\"Paul Mounet\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49408122901\",\"owner\":\"151661925@N08\",\"secret\":\"8f941e980a\",\"server\":\"65535\",\"farm\":66,\"title\":\"GIFT FOR GUEST IDEAS: 10 GIFTS TREND| Personal Creations Gifts Favors Your Guests Will Actually Want\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407627068\",\"owner\":\"151661925@N08\",\"secret\":\"2281df9065\",\"server\":\"65535\",\"farm\":66,\"title\":\"GIFT FOR GUEST IDEAS: 10 GIFTS TREND| Personal Creations Gifts Favors Your Guests Will Actually Want\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407574748\",\"owner\":\"182939405@N08\",\"secret\":\"9ba5f764e4\",\"server\":\"65535\",\"farm\":66,\"title\":\"\\ud83d\\udd34All open Kabaddi - Jabar Kamboh VS Waseem Kamboh 30 chak Super Final Kabaddi Match Kabaddi videos\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49408191272\",\"owner\":\"186550623@N06\",\"secret\":\"f5179d5234\",\"server\":\"65535\",\"farm\":66,\"title\":\"Professional and Unique Business Card\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49408190987\",\"owner\":\"186550623@N06\",\"secret\":\"39ee80c921\",\"server\":\"65535\",\"farm\":66,\"title\":\"Professional and Unique Business Card\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49408159347\",\"owner\":\"69833473@N02\",\"secret\":\"a0dc0ea288\",\"server\":\"65535\",\"farm\":66,\"title\":\"Prison Break\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407948046\",\"owner\":\"36509327@N04\",\"secret\":\"da8a0330f3\",\"server\":\"65535\",\"farm\":66,\"title\":\"Lazy Like Sunday Morning\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407892541\",\"owner\":\"130828646@N02\",\"secret\":\"d152a17f07\",\"server\":\"65535\",\"farm\":66,\"title\":\"Normandie Horse Show : P\\u00e9n\\u00e9lope Le Pr\\u00e9vost\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407838216\",\"owner\":\"16400798@N04\",\"secret\":\"2b02163956\",\"server\":\"65535\",\"farm\":66,\"title\":\"Title Page of a Masseeley Type Specimen, circa 1935\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407807731\",\"owner\":\"11436011@N03\",\"secret\":\"a90a73fe5f\",\"server\":\"65535\",\"farm\":66,\"title\":\"A Short Life\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407318783\",\"owner\":\"16400798@N04\",\"secret\":\"ebd2657c9f\",\"server\":\"65535\",\"farm\":66,\"title\":\"Masseeley Type Specimen, pre-WW2\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407982807\",\"owner\":\"96892477@N08\",\"secret\":\"d92b49a299\",\"server\":\"65535\",\"farm\":66,\"title\":\"sms marketing 2020 | SMS Marketing app for android | Marketing Tutorial in Pakistan\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407961647\",\"owner\":\"185003476@N02\",\"secret\":\"13609a9e7e\",\"server\":\"65535\",\"farm\":66,\"title\":\"Title 38\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407181388\",\"owner\":\"182081535@N06\",\"secret\":\"c363be7bf7\",\"server\":\"65535\",\"farm\":66,\"title\":\"Thank you for selecting this one as a group cover photo of 'SL-Shameless Butt Shots'\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407603146\",\"owner\":\"157365331@N05\",\"secret\":\"587ff0a61e\",\"server\":\"65535\",\"farm\":66,\"title\":\"6 Ways Working With A Professional Home Buyer Will Save Your Money in Dallas\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407781542\",\"owner\":\"14937725@N03\",\"secret\":\"ea21ca0b59\",\"server\":\"65535\",\"farm\":66,\"title\":\"Santa Cruz Map Brookdale 1910 ct002169\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407089893\",\"owner\":\"14937725@N03\",\"secret\":\"4ba881aa0d\",\"server\":\"65535\",\"farm\":66,\"title\":\"Salinas_9066_Child p[ending removal\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407717072\",\"owner\":\"91619997@N04\",\"secret\":\"da6e3b99ba\",\"server\":\"65535\",\"farm\":66,\"title\":\"El XYZ de Son Bent Braam\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407466486\",\"owner\":\"158321478@N08\",\"secret\":\"173263b97c\",\"server\":\"65535\",\"farm\":66,\"title\":\"A Ghost in the West\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407631012\",\"owner\":\"150864049@N04\",\"secret\":\"41f9d3d928\",\"server\":\"65535\",\"farm\":66,\"title\":\"Harry and Meghan drop royal duties and HRH titles\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407429706\",\"owner\":\"150864049@N04\",\"secret\":\"4e5c55842a\",\"server\":\"65535\",\"farm\":66,\"title\":\"Harry and Meghan drop royal duties and HRH titles\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407630772\",\"owner\":\"150864049@N04\",\"secret\":\"b7536c1fcd\",\"server\":\"65535\",\"farm\":66,\"title\":\"Harry and Meghan drop royal duties and HRH titles\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49023720436\",\"owner\":\"67087571@N00\",\"secret\":\"3e2c35bbfc\",\"server\":\"65535\",\"farm\":66,\"title\":\"Jan 2020 ... MAD Month ... #19\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407406741\",\"owner\":\"184436126@N02\",\"secret\":\"bbd8b7a5b2\",\"server\":\"65535\",\"farm\":66,\"title\":\"Nitco Marble Title\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407509812\",\"owner\":\"185921689@N02\",\"secret\":\"eff48504c7\",\"server\":\"65535\",\"farm\":66,\"title\":\"Sitting Brightly\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49406586853\",\"owner\":\"186319878@N07\",\"secret\":\"9064d6fce4\",\"server\":\"65535\",\"farm\":66,\"title\":\"Prince Harry and Meghan Markle to drop HRH titles, repay \\u00a32.4m spent on their house and won&#39;t receive any more taxpayers&#39; cash - Buckingham Palace announces\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49406972951\",\"owner\":\"186298134@N02\",\"secret\":\"99ba7469a1\",\"server\":\"65535\",\"farm\":66,\"title\":\"Why I want to create awareness about cancer \\u2013Joy Ebhodaghe, beauty queen\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49407049982\",\"owner\":\"183727554@N08\",\"secret\":\"3382d3c538\",\"server\":\"65535\",\"farm\":66,\"title\":\"Missouri Buttes + Devil's Tower\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49406571591\",\"owner\":\"91499534@N00\",\"secret\":\"9f403fbc81\",\"server\":\"65535\",\"farm\":66,\"title\":\"Walk Don't Walk\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405902638\",\"owner\":\"35175693@N07\",\"secret\":\"15b88147c3\",\"server\":\"65535\",\"farm\":66,\"title\":\"Woo, Woo, Aroo!\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49406538712\",\"owner\":\"98880902@N03\",\"secret\":\"d946da1747\",\"server\":\"65535\",\"farm\":66,\"title\":\"C-GKVU Boeing 737-86N at CYYZ\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49406488617\",\"owner\":\"186582309@N08\",\"secret\":\"18ccbced85\",\"server\":\"0\",\"farm\":0,\"title\":\"Hithumathe Jeewithe Teaser 2 normal title\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405736153\",\"owner\":\"183727554@N08\",\"secret\":\"c0b1923e19\",\"server\":\"65535\",\"farm\":66,\"title\":\"Best Buddies Facing Off\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49406293277\",\"owner\":\"13771916@N07\",\"secret\":\"14ed58c415\",\"server\":\"65535\",\"farm\":66,\"title\":\"Ravensburger 625 5 244 1 Sheep in the Meadow - jigsaw\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49406292922\",\"owner\":\"13771916@N07\",\"secret\":\"59a281b8cc\",\"server\":\"65535\",\"farm\":66,\"title\":\"Ravensburger 625 5 244 1 Sheep in the Meadow - box\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405611548\",\"owner\":\"13771916@N07\",\"secret\":\"0fe8cc03e2\",\"server\":\"65535\",\"farm\":66,\"title\":\"Falcon 4573\\/2 Courier - jigsaw\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49406288742\",\"owner\":\"13771916@N07\",\"secret\":\"2aeb125c79\",\"server\":\"65535\",\"farm\":66,\"title\":\"Falcon 4573\\/2 Courier - box\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405587048\",\"owner\":\"143249115@N04\",\"secret\":\"f91e935133\",\"server\":\"65535\",\"farm\":66,\"title\":\"Oddfellows Home Hotel\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405586878\",\"owner\":\"143249115@N04\",\"secret\":\"96a7918b39\",\"server\":\"65535\",\"farm\":66,\"title\":\"Plumb's Chambers\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49406066867\",\"owner\":\"155666086@N07\",\"secret\":\"a4fff31071\",\"server\":\"65535\",\"farm\":66,\"title\":\"image-placeholder-title (1)\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49406066257\",\"owner\":\"155666086@N07\",\"secret\":\"07fa9ececf\",\"server\":\"65535\",\"farm\":66,\"title\":\"image-placeholder-title\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405367318\",\"owner\":\"166627299@N03\",\"secret\":\"9a1372fc37\",\"server\":\"65535\",\"farm\":66,\"title\":\"no title\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405366508\",\"owner\":\"166627299@N03\",\"secret\":\"2e9d45bef1\",\"server\":\"65535\",\"farm\":66,\"title\":\"no title\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405785941\",\"owner\":\"135321326@N06\",\"secret\":\"99ff738e4f\",\"server\":\"0\",\"farm\":0,\"title\":\"South32 CEO Graham Kerr Mike Henry BHP CEO are stock fraud criminals frauds Shysters Crooks liars thiefs criminals Stock Fraud\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405622926\",\"owner\":\"183727554@N08\",\"secret\":\"cddd9368d6\",\"server\":\"65535\",\"farm\":66,\"title\":\"Sunrise Side Show Borderland\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405790027\",\"owner\":\"185942321@N08\",\"secret\":\"84811e1791\",\"server\":\"65535\",\"farm\":66,\"title\":\"Big Idea Edition Physical Release Coming to Switch in Spring 2020\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405789897\",\"owner\":\"185942321@N08\",\"secret\":\"396f73dd84\",\"server\":\"65535\",\"farm\":66,\"title\":\"Yakuza Series Soundtracks Now Available on Spotify\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405773537\",\"owner\":\"44274506@N08\",\"secret\":\"90933e2243\",\"server\":\"65535\",\"farm\":66,\"title\":\"TC-SBJ B737 8AS Ex Anadolu Jet\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405565927\",\"owner\":\"158645126@N03\",\"secret\":\"f7b33df878\",\"server\":\"65535\",\"farm\":66,\"title\":\"How Car Title Loans in Toronto Works?\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404887188\",\"owner\":\"185902055@N02\",\"secret\":\"8d6556cf58\",\"server\":\"65535\",\"farm\":66,\"title\":\"Land for sale\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404875293\",\"owner\":\"58984118@N05\",\"secret\":\"b2e65cd98d\",\"server\":\"65535\",\"farm\":66,\"title\":\"Dream Of Lover\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405517407\",\"owner\":\"127846745@N05\",\"secret\":\"3c12f03c8f\",\"server\":\"65535\",\"farm\":66,\"title\":\"Tiptoe Through A Field of Wildflowers\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404785198\",\"owner\":\"96596962@N08\",\"secret\":\"40dc5604d9\",\"server\":\"65535\",\"farm\":66,\"title\":\"D-AEAS Airbus A300B4-622RF European Air Transport (DHL Colours) Bryan Adams Shin A Light World Tour 2019 Titles Heathrow 01st June 2019\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49023876212\",\"owner\":\"67087571@N00\",\"secret\":\"fdae3c8dac\",\"server\":\"65535\",\"farm\":66,\"title\":\"Jan 2020 ... MAD Month ... #18\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405322017\",\"owner\":\"133257039@N03\",\"secret\":\"880534a728\",\"server\":\"65535\",\"farm\":66,\"title\":\"Gold & Glory - Gifts for Eternity - 05 \\/ ##\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404991111\",\"owner\":\"186120071@N03\",\"secret\":\"d4bd11d9a2\",\"server\":\"65535\",\"farm\":66,\"title\":\"Viavi - Food Delivery Script\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49405072257\",\"owner\":\"183727554@N08\",\"secret\":\"d627c2c59f\",\"server\":\"65535\",\"farm\":66,\"title\":\"Icy Wolf Moon Set\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404937362\",\"owner\":\"8740272@N04\",\"secret\":\"521f2781f8\",\"server\":\"65535\",\"farm\":66,\"title\":\"\\\"Hasta La Vista, Baby!\\\"\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404975522\",\"owner\":\"166796028@N08\",\"secret\":\"2c4dd6b47e\",\"server\":\"65535\",\"farm\":66,\"title\":\"50th anniversary of an iconic car, and a story about sewing machines, bikes and cars\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404190088\",\"owner\":\"186448935@N08\",\"secret\":\"fdbba76757\",\"server\":\"65535\",\"farm\":66,\"title\":\"Tech Reviews: Treblab X5 - Truly Wireless Bluetooth Noise Cancelling Earbuds | AirPods Alternatives\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404851487\",\"owner\":\"91964767@N07\",\"secret\":\"f0b2e29200\",\"server\":\"65535\",\"farm\":66,\"title\":\"SU-GCP - B-737 - Egyptair [MXP 1.20] 'World Youth Forum' nose title\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404851352\",\"owner\":\"91964767@N07\",\"secret\":\"aaaefa43b6\",\"server\":\"65535\",\"farm\":66,\"title\":\"SU-GDB - B-737 - Egyptair [MXP 1.20] 'World Youth Forum' nose title\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404173073\",\"owner\":\"91964767@N07\",\"secret\":\"84282511a6\",\"server\":\"65535\",\"farm\":66,\"title\":\"SU-GDD - B-737 - Egyptair [MXP 1.20] 'World Youth Forum' nose title\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404651581\",\"owner\":\"91964767@N07\",\"secret\":\"76ae77eb9c\",\"server\":\"65535\",\"farm\":66,\"title\":\"SU-GDY - B-737 - Egyptair [MXP 1.20] 'World Youth Forum' nose title\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404788192\",\"owner\":\"80184464@N05\",\"secret\":\"2245cbfef9\",\"server\":\"65535\",\"farm\":66,\"title\":\"Kings Lynn minster\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49403903833\",\"owner\":\"10655856@N04\",\"secret\":\"9c693d9bf6\",\"server\":\"65535\",\"farm\":66,\"title\":\"Sybille Schmitz and Siegfried Sch\\u00fcrenberg in Der Herr der Welt (1934)\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404579827\",\"owner\":\"10655856@N04\",\"secret\":\"f030f758ba\",\"server\":\"65535\",\"farm\":66,\"title\":\"Willy Fritsch and K\\u00e4the von Nagy in Die T\\u00f6chter ihrer Exzellenz (1934)\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404498806\",\"owner\":\"58984118@N05\",\"secret\":\"f6a17a2b72\",\"server\":\"65535\",\"farm\":66,\"title\":\"Golden Silence\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404621197\",\"owner\":\"184632360@N02\",\"secret\":\"503a7b89ee\",\"server\":\"65535\",\"farm\":66,\"title\":\"Reflecto\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49403943403\",\"owner\":\"159837864@N08\",\"secret\":\"9ef24a7eba\",\"server\":\"65535\",\"farm\":66,\"title\":\"I Will Design Amazon Product Infographic, Comparison Chart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404620402\",\"owner\":\"159837864@N08\",\"secret\":\"9aefcc559c\",\"server\":\"65535\",\"farm\":66,\"title\":\"I Will Design Amazon Product Infographic, Comparison Chart\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49403885343\",\"owner\":\"53158134@N02\",\"secret\":\"87d56cf9db\",\"server\":\"65535\",\"farm\":66,\"title\":\"TF-AMN (MAGMA Aviation)\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404522652\",\"owner\":\"58984118@N05\",\"secret\":\"ee6ae6047a\",\"server\":\"65535\",\"farm\":66,\"title\":\"Following The Stone Path\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404520387\",\"owner\":\"58984118@N05\",\"secret\":\"7c9a7b220b\",\"server\":\"65535\",\"farm\":66,\"title\":\"Following The Stone Path\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404309431\",\"owner\":\"58984118@N05\",\"secret\":\"32a111ab91\",\"server\":\"65535\",\"farm\":66,\"title\":\"Lonely Stone\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49403832293\",\"owner\":\"58984118@N05\",\"secret\":\"8d22ffa25d\",\"server\":\"65535\",\"farm\":66,\"title\":\"Lonely Stone\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49403808133\",\"owner\":\"53158134@N02\",\"secret\":\"16f2625629\",\"server\":\"65535\",\"farm\":66,\"title\":\"TF-AMN (MAGMA Aviation)\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404190501\",\"owner\":\"183727554@N08\",\"secret\":\"58570842bd\",\"server\":\"65535\",\"farm\":66,\"title\":\"Moo Moon Club House\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49403677093\",\"owner\":\"186308088@N06\",\"secret\":\"02e9cb9c5a\",\"server\":\"65535\",\"farm\":66,\"title\":\"Title of your masterpiece 1\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404118762\",\"owner\":\"128423979@N04\",\"secret\":\"f635ea771d\",\"server\":\"65535\",\"farm\":66,\"title\":\"Chinatown 2020\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404118447\",\"owner\":\"128423979@N04\",\"secret\":\"09045055a2\",\"server\":\"65535\",\"farm\":66,\"title\":\"Chinatown 2020\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404108787\",\"owner\":\"16400798@N04\",\"secret\":\"77dfcbd3cd\",\"server\":\"65535\",\"farm\":66,\"title\":\"The Tail of a Mouse\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49403892556\",\"owner\":\"142999387@N07\",\"secret\":\"7bf46c0084\",\"server\":\"65535\",\"farm\":66,\"title\":\"wedding clip arts\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49403418028\",\"owner\":\"142999387@N07\",\"secret\":\"9d3b32b64d\",\"server\":\"65535\",\"farm\":66,\"title\":\"wedding clip arts\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404091912\",\"owner\":\"142999387@N07\",\"secret\":\"936c3f110e\",\"server\":\"65535\",\"farm\":66,\"title\":\"wedding clip arts\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49403892181\",\"owner\":\"142999387@N07\",\"secret\":\"3b25c5cc95\",\"server\":\"65535\",\"farm\":66,\"title\":\"wedding clip arts\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404091647\",\"owner\":\"142999387@N07\",\"secret\":\"1358419d3d\",\"server\":\"65535\",\"farm\":66,\"title\":\"wedding clip arts\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404091572\",\"owner\":\"142999387@N07\",\"secret\":\"9f05e2cabd\",\"server\":\"65535\",\"farm\":66,\"title\":\"wedding clip arts\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49403891901\",\"owner\":\"142999387@N07\",\"secret\":\"00f3f3c325\",\"server\":\"65535\",\"farm\":66,\"title\":\"wedding clip arts\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49403891776\",\"owner\":\"142999387@N07\",\"secret\":\"84a4d4f09b\",\"server\":\"65535\",\"farm\":66,\"title\":\"wedding clip arts\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"49404091217\",\"owner\":\"142999387@N07\",\"secret\":\"dd1c989af9\",\"server\":\"65535\",\"farm\":66,\"title\":\"wedding clip arts\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0}]},\"stat\":\"ok\"}";
		JSONObject jsonObject = new JSONObject(json);

		List<ImageEntity> searchResultsResponse = searchImagesResponse.getSearchResultsResponse(jsonObject);

        assertEquals(10, searchResultsResponse.size());
    }

	@Test
	public void testSuccessEmptySearchResultsResponse() throws JSONException {
		String emptyResponse = "";
		JSONObject emptyJsonResponse= new JSONObject(emptyResponse);

		try {
			searchImagesResponse.getSearchResultsResponse(emptyJsonResponse);
			Assert.fail("Parsing failed");
		} catch (JSONException e) {
		}
	}

	@Test
	public void testEmptyPhotosSearchResultsResponse() throws JSONException {
		String emptyPhotoResponse = "{\"photos\": {}";
		JSONObject emptyJsonResponse= new JSONObject(emptyPhotoResponse);

		try {
			searchImagesResponse.getSearchResultsResponse(emptyJsonResponse);
			Assert.fail("Parsing failed");
		} catch (JSONException e) {
		}
	}

}

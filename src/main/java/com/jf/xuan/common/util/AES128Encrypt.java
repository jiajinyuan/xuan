package com.jf.xuan.common.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * <p> Title(文件名): AESEncrypt.java </p>
 * <p> Description(描述): AES-128加密类 </p>
 * <p> Copyright(版权): Copyright (c) 2012 </p>
 * <p> Company(公司): 成都四方信息技术有限公司 </p>
 * <p> CreateTime(生成日期)：2012-5-22 下午08:22:23 </p>
 * @author 华为提供
 * @version Tools_wad
 */
@SuppressWarnings("restriction")
public class AES128Encrypt {
	/**
	 * Decode password.
	 * 
	 * @param input password
	 * @throws NoSuchAlgorithmException
	 *             NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 *             NoSuchPaddingException
	 * @throws InvalidKeyException
	 *             InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 *             InvalidAlgorithmParameterException
	 * @throws IOException
	 *             IOException
	 * @throws IllegalBlockSizeException
	 *             IllegalBlockSizeException
	 * @throws BadPaddingException
	 *             BadPaddingException
	 * @return password
	 */
	public String decrypt(String input) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IOException,
            IllegalBlockSizeException, BadPaddingException {
		return decrypt(input, createSecretKey());
	}
	
	/**
	 * Decode password.(2012-9-8 zhangyan add,用户自行指定密钥)
	 * 
	 * @param input password
	 * @param keyValue 密文
	 * 
	 * @throws NoSuchAlgorithmException
	 *             NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 *             NoSuchPaddingException
	 * @throws InvalidKeyException
	 *             InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 *             InvalidAlgorithmParameterException
	 * @throws IOException
	 *             IOException
	 * @throws IllegalBlockSizeException
	 *             IllegalBlockSizeException
	 * @throws BadPaddingException
	 *             BadPaddingException
	 * @return password
	 */
	public String decrypt(String input, byte[] keyValue)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException,
            IOException, IllegalBlockSizeException, BadPaddingException {
		SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key);
//		BASE64Decoder decoder = new BASE64Decoder();
//		byte[] data = decoder.decodeBuffer(input);
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] data = decoder.decode(input);
		byte[] decryptData = cipher.doFinal(data, 0, data.length);

		return new String(decryptData,"UTF-8");
	}

	/**
	 * Encode password.
	 * 
	 * @param input password
	 * @throws NoSuchAlgorithmException
	 *             NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 *             NoSuchPaddingException
	 * @throws InvalidKeyException
	 *             InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 *             InvalidAlgorithmParameterException
	 * @throws IOException
	 *             IOException
	 * @throws IllegalBlockSizeException
	 *             IllegalBlockSizeException
	 * @throws BadPaddingException
	 *             BadPaddingException
	 * @return password
	 */
	public String encrypt(String input) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IOException,
            IllegalBlockSizeException, BadPaddingException {
		return encrypt(input, createSecretKey());
	}

	/**
	 * Encode password.(2012-9-8 zhangyan add,用户自行指定密钥)
	 * 
	 * @param input password
	 * @param keyValue 密钥
	 * 
	 * @throws NoSuchAlgorithmException
	 *             NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 *             NoSuchPaddingException
	 * @throws InvalidKeyException
	 *             InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 *             InvalidAlgorithmParameterException
	 * @throws IOException
	 *             IOException
	 * @throws IllegalBlockSizeException
	 *             IllegalBlockSizeException
	 * @throws BadPaddingException
	 *             BadPaddingException
	 * @return password
	 */
	public String encrypt(String input, byte[] keyValue)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException,
            IOException, IllegalBlockSizeException, BadPaddingException {
		SecretKeySpec key = new SecretKeySpec(keyValue, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bs = cipher.doFinal(input.getBytes("UTF-8"));

//		return new sun.misc.BASE64Encoder().encode(bs);
		return Base64.getEncoder().encodeToString(bs);
	}

	/**
	 * 
	 * Create AES-128 encrypt key. 2012-9-8
	 * zhangyan add 此方法，目的是将AES-128加密的密钥修改为可读的字符串huawei_cdsf_pass
	 * 
	 * @return AES-128 key
	 */
	public byte[] createSecretKey() {
		return new byte[] { 104, 117, 97, 119, 101, 105, 95, 99, 100, 115, 102,
				95, 112, 97, 115, 115 };
	}

	/**
	 * Create AES-128 encrypt key.
	 * 
	 * @return AES-128 key
	 */
	public byte[] createKey() {
		char[] key = new char[512];
		key[0] = 0x8b;
		key[1] = 0xe9;
		key[2] = 0x1b;
		key[3] = 0x2a;
		key[4] = 0x2a;
		key[5] = 0xac;
		key[6] = 0xdd;
		key[7] = 0x97;
		key[8] = 0xd2;
		key[9] = 0xd1;
		key[10] = 0xab;
		key[11] = 0x70;
		key[12] = 0xf4;
		key[13] = 0x84;
		key[14] = 0x53;
		key[15] = 0xf4;
		key[16] = 0x4a;
		key[17] = 0xa6;
		key[18] = 0xe9;
		key[19] = 0x42;
		key[20] = 0x28;
		key[21] = 0xa6;
		key[22] = 0xe5;
		key[23] = 0xc9;
		key[24] = 0x3e;
		key[25] = 0xc1;
		key[26] = 0x91;
		key[27] = 0x95;
		key[28] = 0xdd;
		key[29] = 0x54;
		key[30] = 0x74;
		key[31] = 0x0b;
		key[32] = 0x62;
		key[33] = 0x8b;
		key[34] = 0xe9;
		key[35] = 0x1b;
		key[36] = 0x2a;
		key[37] = 0xac;
		key[38] = 0xdd;
		key[39] = 0x97;
		key[40] = 0xd2;
		key[41] = 0xd1;
		key[42] = 0xab;
		key[43] = 0x70;
		key[44] = 0xf4;
		key[45] = 0x84;
		key[46] = 0x53;
		key[47] = 0xf4;
		key[48] = 0x4a;
		key[49] = 0xa6;
		key[50] = 0xe9;
		key[51] = 0x42;
		key[52] = 0x28;
		key[53] = 0xa6;
		key[54] = 0xe5;
		key[55] = 0xc9;
		key[56] = 0x3e;
		key[57] = 0xc1;
		key[58] = 0x91;
		key[59] = 0x95;
		key[60] = 0xdd;
		key[61] = 0x54;
		key[62] = 0x74;
		key[63] = 0x0b;
		key[64] = 0x62;
		key[65] = 0x8b;
		key[66] = 0xe9;
		key[67] = 0x1b;
		key[68] = 0x2a;
		key[69] = 0xac;
		key[70] = 0xdd;
		key[71] = 0x97;
		key[72] = 0xd2;
		key[73] = 0xd1;
		key[74] = 0xab;
		key[75] = 0x70;
		key[76] = 0xf4;
		key[77] = 0x84;
		key[78] = 0x53;
		key[79] = 0xf4;
		key[80] = 0x4a;
		key[81] = 0xa6;
		key[82] = 0xe9;
		key[83] = 0x42;
		key[84] = 0x28;
		key[85] = 0xa6;
		key[86] = 0xe5;
		key[87] = 0xc9;
		key[88] = 0x3e;
		key[89] = 0xc1;
		key[90] = 0x91;
		key[91] = 0x95;
		key[92] = 0xdd;
		key[93] = 0x54;
		key[94] = 0x74;
		key[95] = 0x0b;
		key[96] = 0x62;
		key[97] = 0x8b;
		key[98] = 0xe9;
		key[99] = 0x1b;
		key[100] = 0x2a;
		key[101] = 0xac;
		key[102] = 0xdd;
		key[103] = 0x97;
		key[104] = 0xd2;
		key[105] = 0xd1;
		key[106] = 0xab;
		key[107] = 0x70;
		key[108] = 0xf4;
		key[109] = 0x84;
		key[110] = 0x53;
		key[111] = 0xf4;
		key[112] = 0x4a;
		key[113] = 0xa6;
		key[114] = 0xe9;
		key[115] = 0x42;
		key[116] = 0x28;
		key[117] = 0xa6;
		key[118] = 0xe5;
		key[119] = 0xc9;
		key[120] = 0x3e;
		key[121] = 0xc1;
		key[122] = 0x91;
		key[123] = 0x95;
		key[124] = 0xdd;
		key[125] = 0x54;
		key[126] = 0x74;
		key[127] = 0x0b;
		key[128] = 0x62;
		key[129] = 0x8b;
		key[130] = 0xe9;
		key[131] = 0x1b;
		key[132] = 0x2a;
		key[133] = 0xac;
		key[134] = 0xdd;
		key[135] = 0x97;
		key[136] = 0xd2;
		key[137] = 0xd1;
		key[138] = 0xab;
		key[139] = 0x70;
		key[140] = 0xf4;
		key[141] = 0x84;
		key[142] = 0x53;
		key[143] = 0xf4;
		key[144] = 0x4a;
		key[145] = 0xa6;
		key[146] = 0xe9;
		key[147] = 0x42;
		key[148] = 0x28;
		key[149] = 0xa6;
		key[150] = 0xe5;
		key[151] = 0xc9;
		key[152] = 0x3e;
		key[153] = 0xc1;
		key[154] = 0x91;
		key[155] = 0x95;
		key[156] = 0xdd;
		key[157] = 0x54;
		key[158] = 0x74;
		key[159] = 0x0b;
		key[160] = 0x62;
		key[161] = 0x8b;
		key[162] = 0xe9;
		key[163] = 0x1b;
		key[164] = 0x2a;
		key[165] = 0xac;
		key[166] = 0xdd;
		key[167] = 0x97;
		key[168] = 0xd2;
		key[169] = 0xd1;
		key[170] = 0xab;
		key[171] = 0x70;
		key[172] = 0xf4;
		key[173] = 0x84;
		key[174] = 0x53;
		key[175] = 0xf4;
		key[176] = 0x4a;
		key[177] = 0xa6;
		key[178] = 0xe9;
		key[179] = 0x42;
		key[180] = 0x28;
		key[181] = 0xa6;
		key[182] = 0xe5;
		key[183] = 0xc9;
		key[184] = 0x3e;
		key[185] = 0xc1;
		key[186] = 0x91;
		key[187] = 0x95;
		key[188] = 0xdd;
		key[189] = 0x54;
		key[190] = 0x74;
		key[191] = 0x0b;
		key[192] = 0x62;
		key[193] = 0x8b;
		key[194] = 0xe9;
		key[195] = 0x1b;
		key[196] = 0x2a;
		key[197] = 0xac;
		key[198] = 0xdd;
		key[199] = 0x97;
		key[200] = 0xd2;
		key[201] = 0xd1;
		key[202] = 0xab;
		key[203] = 0x70;
		key[204] = 0xf4;
		key[205] = 0x84;
		key[206] = 0x53;
		key[207] = 0xf4;
		key[208] = 0x4a;
		key[209] = 0xa6;
		key[210] = 0xe9;
		key[211] = 0x42;
		key[212] = 0x28;
		key[213] = 0xa6;
		key[214] = 0xe5;
		key[215] = 0xc9;
		key[216] = 0x3e;
		key[217] = 0xc1;
		key[218] = 0x91;
		key[219] = 0x95;
		key[220] = 0xdd;
		key[221] = 0x54;
		key[222] = 0x74;
		key[223] = 0x0b;
		key[224] = 0x62;
		key[225] = 0x8b;
		key[226] = 0xe9;
		key[227] = 0x1b;
		key[228] = 0x2a;
		key[229] = 0xac;
		key[230] = 0xdd;
		key[231] = 0x97;
		key[232] = 0xd2;
		key[233] = 0xd1;
		key[234] = 0xab;
		key[235] = 0x70;
		key[236] = 0xf4;
		key[237] = 0x84;
		key[238] = 0x53;
		key[239] = 0xf4;
		key[240] = 0x4a;
		key[241] = 0xa6;
		key[242] = 0xe9;
		key[243] = 0x42;
		key[244] = 0x28;
		key[245] = 0xa6;
		key[246] = 0xe5;
		key[247] = 0xc9;
		key[248] = 0x3e;
		key[249] = 0xc1;
		key[250] = 0x91;
		key[251] = 0x95;
		key[252] = 0xdd;
		key[253] = 0x54;
		key[254] = 0x74;
		key[255] = 0x0b;
		key[256] = 0x62;
		key[257] = 0x8b;
		key[258] = 0xe9;
		key[259] = 0x1b;
		key[260] = 0x2a;
		key[261] = 0xac;
		key[262] = 0xdd;
		key[263] = 0x97;
		key[264] = 0xd2;
		key[265] = 0xd1;
		key[266] = 0xab;
		key[267] = 0x70;
		key[268] = 0xf4;
		key[269] = 0x84;
		key[270] = 0x53;
		key[271] = 0xf4;
		key[272] = 0x4a;
		key[273] = 0xa6;
		key[274] = 0xe9;
		key[275] = 0x42;
		key[276] = 0x28;
		key[277] = 0xa6;
		key[278] = 0xe5;
		key[279] = 0xc9;
		key[280] = 0x3e;
		key[281] = 0xc1;
		key[282] = 0x91;
		key[283] = 0x95;
		key[284] = 0xdd;
		key[285] = 0x54;
		key[286] = 0x74;
		key[287] = 0x0b;
		key[288] = 0x62;
		key[289] = 0x8b;
		key[290] = 0xe9;
		key[291] = 0x1b;
		key[292] = 0x2a;
		key[293] = 0xac;
		key[294] = 0xdd;
		key[295] = 0x97;
		key[296] = 0xd2;
		key[297] = 0xd1;
		key[298] = 0xab;
		key[299] = 0x70;
		key[300] = 0xf4;
		key[301] = 0x84;
		key[302] = 0x53;
		key[303] = 0xf4;
		key[304] = 0x4a;
		key[305] = 0xa6;
		key[306] = 0xe9;
		key[307] = 0x42;
		key[308] = 0x28;
		key[309] = 0xa6;
		key[310] = 0xe5;
		key[311] = 0xc9;
		key[312] = 0x3e;
		key[313] = 0xc1;
		key[314] = 0x91;
		key[315] = 0x95;
		key[316] = 0xdd;
		key[317] = 0x54;
		key[318] = 0x74;
		key[319] = 0x0b;
		key[320] = 0x62;
		key[321] = 0x8b;
		key[322] = 0xe9;
		key[323] = 0x1b;
		key[324] = 0x2a;
		key[325] = 0xac;
		key[326] = 0xdd;
		key[327] = 0x97;
		key[328] = 0xd2;
		key[329] = 0xd1;
		key[330] = 0xab;
		key[331] = 0x70;
		key[332] = 0xf4;
		key[333] = 0x84;
		key[334] = 0x53;
		key[335] = 0xf4;
		key[336] = 0x4a;
		key[337] = 0xa6;
		key[338] = 0xe9;
		key[339] = 0x42;
		key[340] = 0x28;
		key[341] = 0xa6;
		key[342] = 0xe5;
		key[343] = 0xc9;
		key[344] = 0x3e;
		key[345] = 0xc1;
		key[346] = 0x91;
		key[347] = 0x95;
		key[348] = 0xdd;
		key[349] = 0x54;
		key[350] = 0x74;
		key[351] = 0x0b;
		key[352] = 0x62;
		key[353] = 0x8b;
		key[354] = 0xe9;
		key[355] = 0x1b;
		key[356] = 0x2a;
		key[357] = 0xac;
		key[358] = 0xdd;
		key[359] = 0x97;
		key[360] = 0xd2;
		key[361] = 0xd1;
		key[362] = 0xab;
		key[363] = 0x70;
		key[364] = 0xf4;
		key[365] = 0x84;
		key[366] = 0x53;
		key[367] = 0xf4;
		key[368] = 0x4a;
		key[369] = 0xa6;
		key[370] = 0xe9;
		key[371] = 0x42;
		key[372] = 0x28;
		key[373] = 0xa6;
		key[374] = 0xe5;
		key[375] = 0xc9;
		key[376] = 0x3e;
		key[377] = 0xc1;
		key[378] = 0x91;
		key[379] = 0x95;
		key[380] = 0xdd;
		key[381] = 0x54;
		key[382] = 0x74;
		key[383] = 0x0b;
		key[384] = 0x62;
		key[385] = 0x8b;
		key[386] = 0xe9;
		key[387] = 0x1b;
		key[388] = 0x2a;
		key[389] = 0xac;
		key[390] = 0xdd;
		key[391] = 0x97;
		key[392] = 0xd2;
		key[393] = 0xd1;
		key[394] = 0xab;
		key[395] = 0x70;
		key[396] = 0xf4;
		key[397] = 0x84;
		key[398] = 0x53;
		key[399] = 0xf4;
		key[400] = 0x4a;
		key[401] = 0xa6;
		key[402] = 0xe9;
		key[403] = 0x42;
		key[404] = 0x28;
		key[405] = 0xa6;
		key[406] = 0xe5;
		key[407] = 0xc9;
		key[408] = 0x3e;
		key[409] = 0xc1;
		key[410] = 0x91;
		key[411] = 0x95;
		key[412] = 0xdd;
		key[413] = 0x54;
		key[414] = 0x74;
		key[415] = 0x0b;
		key[416] = 0x62;
		key[417] = 0x8b;
		key[418] = 0xe9;
		key[419] = 0x1b;
		key[420] = 0x2a;
		key[421] = 0xac;
		key[422] = 0xdd;
		key[423] = 0x97;
		key[424] = 0xd2;
		key[425] = 0xd1;
		key[426] = 0xab;
		key[427] = 0x70;
		key[428] = 0xf4;
		key[429] = 0x84;
		key[430] = 0x53;
		key[431] = 0xf4;
		key[432] = 0x4a;
		key[433] = 0xa6;
		key[434] = 0xe9;
		key[435] = 0x42;
		key[436] = 0x28;
		key[437] = 0xa6;
		key[438] = 0xe5;
		key[439] = 0xc9;
		key[440] = 0x3e;
		key[441] = 0xc1;
		key[442] = 0x91;
		key[443] = 0x95;
		key[444] = 0xdd;
		key[445] = 0x54;
		key[446] = 0x74;
		key[447] = 0x0b;
		key[448] = 0x62;
		key[449] = 0x8b;
		key[450] = 0xe9;
		key[451] = 0x1b;
		key[452] = 0x2a;
		key[453] = 0xac;
		key[454] = 0xdd;
		key[455] = 0x97;
		key[456] = 0xd2;
		key[457] = 0xd1;
		key[458] = 0xab;
		key[459] = 0x70;
		key[460] = 0xf4;
		key[461] = 0x84;
		key[462] = 0x53;
		key[463] = 0xf4;
		key[464] = 0x4a;
		key[465] = 0xa6;
		key[466] = 0xe9;
		key[467] = 0x42;
		key[468] = 0x28;
		key[469] = 0xa6;
		key[470] = 0xe5;
		key[471] = 0xc9;
		key[472] = 0x3e;
		key[473] = 0xc1;
		key[474] = 0x91;
		key[475] = 0x95;
		key[476] = 0xdd;
		key[477] = 0x54;
		key[478] = 0x74;
		key[479] = 0x0b;
		key[480] = 0x62;
		key[481] = 0x8b;
		key[482] = 0xe9;
		key[483] = 0x1b;
		key[484] = 0x2a;
		key[485] = 0xac;
		key[486] = 0xdd;
		key[487] = 0x97;
		key[488] = 0xd2;
		key[489] = 0xd1;
		key[490] = 0xab;
		key[491] = 0x70;
		key[492] = 0xf4;
		key[493] = 0x84;
		key[494] = 0x53;
		key[495] = 0xf4;
		key[496] = 0x4a;
		key[497] = 0xa6;
		key[498] = 0xe9;
		key[499] = 0x42;
		key[500] = 0x28;
		key[501] = 0xa6;
		key[502] = 0xe5;
		key[503] = 0xc9;
		key[504] = 0x3e;
		key[505] = 0xc1;
		key[506] = 0x91;
		key[507] = 0x95;
		key[508] = 0xdd;
		key[509] = 0x54;
		key[510] = 0x74;
		key[511] = 0x0b;

		byte[] aes_key = new byte[16];
		for (int i = 0, k = 1; i < aes_key.length; i++) {
			k += i * 3;
			aes_key[i] = (byte) key[k];
		}
		return aes_key;
	}
	
	/**
	 * 
	 * 方法描述:打成pwd.jar包后执行main方法
	 *
	 * @creator 张艳 
	 * @param args
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException    设定文件
	 * @return void    返回类型 
	 * @throws
	 */
	public static void main(String[] args) throws InvalidKeyException,
            NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException,
            BadPaddingException, IOException {
		AES128Encrypt aes = new AES128Encrypt();
		int i = 3;
		BufferedReader reader = null;
		do {
			pln("************************************");
			pln("Please input your password:");
			String s = "";
			reader = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
			s = reader.readLine();
			if (s != null && !"".equals(s.trim())) {
				pln((new StringBuilder("The AES128 code is: ")).append(
						aes.encrypt(s.trim())).toString());
				break;
			}
			pln((new StringBuilder("You input error data!Only ")).append(--i)
					.append(" times!").toString());
		} while (i != 0);
		reader.close();
		pln("************************************\nQuit Now!");
		return;

	}

	private static void pln(String s) {
		System.out.println(s);
	}
}

public void testLuhm() {
		String cardNo = "6212262201023557228";
		BankCardUtils.checkBankCard(cardNo);
		if(StringUtils.isNoneBlank(cardNo) && cardNo.matches("\\d+")) {
			char[] chs = cardNo.substring(0, cardNo.length() - 1).trim().toCharArray();
			int luhmNum = 0;
			for(int i = chs.length - 1, j = 0; i >=0; i--, j++) {
				
				int k = chs[i] - '0';
				
				if(j % 2 == 0 ) {
					k *= 2;
					k = k/10 + k%10;
				}
				
				luhmNum += k;
			}
			char c = luhmNum%10 == 0 ? '0' :(char)((10 - luhmNum%10) + '0');
			char endChar = cardNo.charAt(cardNo.length() - 1);
			assertTrue( c == endChar);
		}
	}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0] > 5) {
            return false;
        }
        int count5 = 1;
        int count10 = 0;
        for(int i = 1;i < bills.length;i++) {
            if(bills[i] == 10) {
                count5--;
                count10++;
                if(count5 < 0) {
                    return false;
                }
            }else if(bills[i] == 20) {
                if(count10 != 0 && count5 != 0) {
                    count10--;
                    count5--;
                }else if(count10 == 0 && count5 != 0) {
                    count5 -= 3;
                    if(count5 < 0) {
                        return false;
                    }
                }else{
                    return false;
                }
            }else {
                count5++;
            }
        }
        return true;
    }
}

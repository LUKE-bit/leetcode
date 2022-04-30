public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int n = sequence.length;
        if(n==0) return false;
        return check(sequence,0,n-1);
    }
    public boolean check(int[] sequence,int l,int r){
        if(l>=r)return true;
        int root = sequence[r];
        int j = r - 1;
        while(j >= 0 && sequence[j] > sequence[r]) {
            j--;//划分右子树
        }
        for(int i = l;i <= j;i++){
            if(sequence[i] > root) return false;
        }
        return check(sequence,l,j) && check(sequence,j+1,r-1);
    }
}

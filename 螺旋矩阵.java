class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList result = new LinkedList();
        if(matrix==null || matrix.length==0) {
            return result;
        }
        int left = 0,right = matrix[0].length - 1;
        int top = 0,bottom = matrix.length - 1;
        int num = matrix.length * matrix[0].length;
        while(num >= 1) {
            for(int i = left;i <= right && num >= 1;i++) {
                result.add(matrix[top][i]);
                num--;
            }
            top++;
            for(int i = top;i <= bottom && num >= 1;i++) {
                result.add(matrix[i][right]);
                num--;
            }
            right--;
            for(int i = right;i >= left && num >= 1;i--) {
                result.add(matrix[bottom][i]);
                num--;
            }
            bottom--;
            for(int i = bottom;i >= top && num >= 1;i--) {
                result.add(matrix[i][left]);
                num--;
            }
            left++;
        }
        return result;
    }
}

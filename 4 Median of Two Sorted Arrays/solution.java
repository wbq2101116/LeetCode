class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (n < m) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int temp = m;
            m = n;
            n = temp;
        }

        int min = 0, max = m;

        while (true) {
            int i = (min + max) / 2;
            int j = (m + n) / 2 - i;
//            System.out.println("i : " + i + " \tj : " + j + " \tm : " + m + " \tn : " + n);

            if (i < m && nums2[j - 1] > nums1[i]) {
                min = i + 1;
            }
            else if (i > 0 && nums1[i - 1] > nums2[j]) {
                max = i - 1;
            }
            else {
                int maxLeft, minRight;

                if (i == m) {
                    minRight = nums2[j];
                }
                else if (j == n) {
                    minRight = nums1[i];
                }
                else{
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                if ((m + n) % 2 != 0) {
                    return minRight;
                }

                if (i == 0) {
                    maxLeft = nums2[j - 1];
                }
                else if (j == 0) {
                    maxLeft = nums1[i - 1];
                }
                else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
//                System.out.println("maxLeft : " + maxLeft + " \tminRight : " + minRight);

                return (maxLeft + minRight) / 2.0;
            }
        }
    }
}

